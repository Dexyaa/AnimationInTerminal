package animationinterminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Date;
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
                    while(reader.readLine() != null){
                        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
                        long startTime = System.currentTimeMillis();
                        long elaspedTime = 0L;
                        while(!reader.readLine().equals(separator) && elaspedTime < (double) 1000/frames){
                            String data = reader.readLine();
                            log.write(data);
                            elaspedTime = (new Date()).getTime() - startTime;
                            //Thread.sleep(1000/frames);
                        }
                        System.out.flush();
                        if(elaspedTime < 1000){
                            Thread.sleep((double)1000/frames - elaspedTime);
                        }
                        System.out.println("\033[H\033[2J");
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