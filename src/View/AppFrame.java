package View;

import basicGUI.basicFrame;

import javax.swing.JPanel;
import java.awt.*;

public class AppFrame extends basicFrame{
    JPanel big;
    LogSignInPanel log;

    public AppFrame(){
        this.getContentPane().setBackground(new Color(150,150,150));
        big = new JPanel();
        log = new LogSignInPanel();
        big.add(log);
    }

    public static void main(String[] a){
        AppFrame af = new AppFrame();
        af.getContentPane().add(af.log);
        af.display();
    }
}
