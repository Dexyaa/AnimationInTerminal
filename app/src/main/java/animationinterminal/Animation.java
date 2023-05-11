package animationinterminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Animation{
    private int frames;
    private File animation = new File("resources/animation.txt");
    public Animation(int frame){
        frames = frame;
        try {
            System.out.println(animation.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(){
        System.out.println("Reading from " + animation);
        ArrayList<String> keyFrames = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader(animation))){
            String buffer = "";
            while(true) {
                String line = reader.readLine();
                if(line == null){
                    if(!buffer.equals("")){
                        keyFrames.add(buffer);
                    }
                    break;
                }
                if(line.equals("")){
                    keyFrames.add(buffer);
                    buffer = "";
                }
                buffer += line + "\n";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        if(keyFrames.size() == 0){
            System.out.println("An reading error has occured");
        }
        return keyFrames;
    }

    public int recursively(int n){
        if(n <= 1)
            return n;
        
        return n + recursively(n-2);
        
    }

    public void animate() throws InterruptedException{
        ArrayList<String> keyFrames = readFile();
        Thread.sleep(2000);
        //Animation Loop
        try {
            for (String s : keyFrames) {
                System.out.println("\033[H\033[2J");
                System.out.println(s);
                Thread.sleep(1000/frames);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

} 