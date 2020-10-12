package basicGUI;
import javax.swing.JFrame;


public class basicFrame extends JFrame{
    public basicFrame(){
        this.setSize(720,460);
        this.setLocation(0,0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display(){
        this.setVisible(true);
    }
    public void display(String title){
        this.setTitle(title);
        this.setVisible(true);
    }
    public void display(String title, int x, int y){
        this.setTitle(title);
        this.setLocation(x,y);
        this.setVisible(true);
    }
}
