package View_Control;

import basicGUI.basicFrame;

import java.awt.Color;

public class AppFrame extends basicFrame{
    BigPanel bp;
    public AppFrame(){
        this.getContentPane().setBackground(new Color(150,150,150));
        bp = new BigPanel();
        this.getContentPane().add(bp);
    }

    public static void main(String[] a){
        AppFrame af = new AppFrame();
        af.display();
    }
}
