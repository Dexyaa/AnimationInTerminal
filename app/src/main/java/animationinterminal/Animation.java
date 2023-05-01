package animationinterminal;

import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
public class Animation{
    private int frames;
    private File animation = new File("C:\\Users\\Geo\\Desktop\\AnimationInTerminal\\app\\src\\main\\java\\animationinterminal\\animation.txt");
    public Animation(int frame){
        frames = frame;
        System.out.println(animation.getPath());
    }

    public ArrayList<String> readFile(){
        System.out.println("Reading from " + animation);
        ArrayList<String> frames = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(animation))){
            String buffer = "";
            while(true) {
                String line = reader.readLine();
                if(line == null){
                    break;
                }
                if(line.equals("")){
                    frames.add(buffer);
                    buffer = "";
                }
                buffer += line + "\n";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if(frames.size() == 0){
            System.out.println("An reading error has occured");
        }
        return frames;
    }

    public void animate(){
        ArrayList<String> frame = readFile();
        //Animation Loop
        long startTime = System.currentTimeMillis();
        long elaspedTime = 0L;
        try {
            for (String s : frame) {
                System.out.println(s);
                elaspedTime = (new Date()).getTime() - startTime;
                if (elaspedTime < 1000/frames) {
                    Thread.sleep(1000 / frames - elaspedTime);
                } else {
                    System.out.flush();
                }
                System.out.println("\033[H\033[2J");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

} 