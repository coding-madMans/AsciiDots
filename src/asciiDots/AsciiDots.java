package asciiDots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AsciiDots {

    protected int width;
    protected List<HashMap<Integer,Character>> asciiDotsProgram;

    public AsciiDots(int width, String asciiDotsFile) throws Exception {
        this.width = width;
        this.asciiDotsProgram = new ArrayList<>();
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

    public void repr(){
        // System.out.println(this.asciiDotsProgram);
        int row = 0;
        for(HashMap<Integer,Character> line : this.asciiDotsProgram){
            System.out.println(row + " : " + line);
            row += 1;
        }
    }

}
