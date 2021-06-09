package asciiDots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AsciiDots {

    private int width;
    private final List<HashMap<Integer,Character>> asciiDotsProgram;
    private final HashMap<Integer, Period> periods;
    private boolean running;

    public AsciiDots(int width, String asciiDotsFile) throws Exception {
        this.width = width;
        this.asciiDotsProgram = new ArrayList<>();
        this.periods = new HashMap<>();
        this.running = true;
        int row = 0, col = 0;

        try{
            BufferedReader r = new BufferedReader(new FileReader(asciiDotsFile));
            String line = r.readLine();
            while(line != null){
                this.asciiDotsProgram.add(new HashMap<>());
                for(char asciiChar : line.toCharArray()){
                    if(col > this.width){
                        throw new Exception("{ERROR} : The file width id greater than the screen width...");
                    }
                    if(asciiChar != ' '){
                        if(asciiChar == '.'){
                            Period period = new Period(row, col);
                            this.periods.put(period.getID(), period);
                        }
                        this.asciiDotsProgram.get(row).put(col, asciiChar);
                    }
                    col += 1;
                }
                col = 0;
                line = r.readLine();
                row += 1;
            }
            r.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void update(){
        System.out.println("Updating");
        for(Integer periodID : this.periods.keySet()){
            this.periods.get(periodID).updatePosition(this);
        }
    }

    public void run(){
        int count = 0;
        int maxCount = 3;
        while(this.running){
            this.update();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if((++count > maxCount)){
                this.running = false;
            }
        }
    }

    public void changeWidth(int width){
        this.width = width;
    }

    public void deletePeriod(int periodID){
        this.periods.remove(periodID);
    }

    public void repr(){
        // System.out.println(this.asciiDotsProgram);
        int row = 0;
        for(HashMap<Integer,Character> line : this.asciiDotsProgram){
            System.out.println(row + " : " + line);
            row += 1;
        }
    }

}
