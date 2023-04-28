package animationinterminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Date;
public class Animation{
    private int frames;
    private File animation = new File("C:\\Users\\Geo\\Desktop\\AnimationInTerminal\\app\\src\\main\\java\\animationinterminal\\animation.txt");
    public Animation(int frame){
        frames = frame;
        System.out.println(animation.getPath());
    }

    //TODO: Make new read function
    public void read

    public void animate(){
        String separator = System.lineSeparator();
        System.out.println("Reading from " + animation);
        try{
            try (BufferedReader reader = new BufferedReader(new FileReader(animation))) {
                String data = "";
                while(data.equals(null)){
                    BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
                    long startTime = System.currentTimeMillis();
                    long elaspedTime = 0L;
                    while(!data.equals(separator) && elaspedTime < 1000/frames){
                        data = reader.readLine();
                        log.write(data);
                        elaspedTime = (new Date()).getTime() - startTime;
                            
                    }
                    System.out.flush();
                    if(elaspedTime < 1000){
                        Thread.sleep(1000/frames - elaspedTime);
                    }
                    System.out.println("\033[H\033[2J");
                }
            }
        } catch (NullPointerException f){
            System.out.println(f + ". Something is wrong with your file");
        } catch (Exception e){
            System.out.println(e);
        }
    }
} 