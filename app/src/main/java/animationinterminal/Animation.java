package animationinterminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class Animation{
    private int frames;
    private File animation = new File("src/resources/animation.txt");
    public Animation(int frame){
        frames = frame;
        System.out.println(animation.getPath());
    }
    public void animate(){
        String separator = System.lineSeparator();
        System.out.println("Reading from " + animation);
        try{
            if(animation.canRead()){
                try (BufferedReader reader = new BufferedReader(new FileReader(animation))) {
                    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
                    while(!reader.readLine().equals(separator) || reader.readLine() != null){
                        String data = reader.readLine();
                        log.write(data);
                        Thread.sleep(1000/frames);
                        if(!reader.readLine().equals(separator)){
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                        }
                    }
                }
            } else {
                System.out.println("This doesn't work...");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
} 