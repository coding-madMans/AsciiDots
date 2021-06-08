package Main;

import asciiDots.AsciiDots;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        System.out.println("Configuring the terminal window width : ");
        int width = 100, inc = 0;
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String line = "*";
        while(!flag){
            System.out.println(line.repeat(width));
            System.out.println("If the width is correct press 0, else press how much to increases");
            inc = scanner.nextInt();
            if(inc == 0) {
                flag = true;
            }else{
                width += inc;
            }
        }
        scanner.close();
        line = line.repeat(width);
        System.out.println(line);
        AsciiDots asciiDots = new AsciiDots(width, "res/asciiDots1.ascd");
        asciiDots.repr();
        asciiDots = new AsciiDots(width, "res/asciiDots2.ascd");
        asciiDots.repr();
    }
}
