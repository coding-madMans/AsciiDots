package asciiDots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AsciiDots {

    protected int width;
    protected List<List<Character>> asciiDotsProgram;

    public AsciiDots(int width, String asciiDotsFile){
        this.width = width;
        this.asciiDotsProgram = new ArrayList<>();

        try{
            BufferedReader r = new BufferedReader(new FileReader(asciiDotsFile));
            String line = r.readLine();
            while(line != null){
                for(char asciiChar : line.toCharArray()){
                    System.out.print(asciiChar);
                }
                System.out.println("");
                line = r.readLine();
            }
            r.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
