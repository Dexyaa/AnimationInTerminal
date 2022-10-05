import java.io.File;
import java.util.Scanner;
public class Animation{
    private File animation = new File("animation.txt");
    private int frames;
    public Animation(int frame, File animationFile){
        frame = frames;
        animationFile = animation;
    }
    public void animate(){
        try{
            Scanner reader = new Scanner(animation);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
                Thread.sleep(1000/frames); //wait 1/60th of a second
                System.out.println("\033[H\033[2J"); //clear screen
            }
        }
    }
}