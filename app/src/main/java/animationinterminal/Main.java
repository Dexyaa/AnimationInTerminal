package animationinterminal;
public class Main{
    //TODO: Add recursion and inheritance
    public static void main(String args[]) throws InterruptedException{
        Animation animation = new Animation(3);
        animation.animate();
        Animation sixty = new SixtyFrames();
        sixty.animate();
        animation.recursively(142);
    }
}