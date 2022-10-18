package animationinterminal;
import java.io.File;
import java.util.Scanner;
public class Animation{
    private int frames;
    private String txt;
    private File animation = new File(txt);
    public Animation(int frame, String text){
        frame = frames;
        text = txt;
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
        } catch (Exception e){
            System.out.println(e);
        }
    }
}