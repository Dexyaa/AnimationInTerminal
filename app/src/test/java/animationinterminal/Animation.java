package animationinterminal;

import java.io.File;
import java.util.Scanner;
public class Animation{
    private int frames;
    private File animation = new File("resources/animation.txt");
    public Animation(int frame){
        frames = frame;
        System.out.println(animation.getPath());
    }
    public void animate(){
        System.out.println("Reading from " + animation);
        try{
            if(animation.canRead()){
                try (Scanner reader = new Scanner(animation)) {
                    while(reader.hasNextLine()){
                        String data = reader.nextLine();
                        System.out.println(data);
                        Thread.sleep(1000/frames); //wait 1/frame th of a second
                        //System.out.println("\033[H\033[2J"); //clear screen
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