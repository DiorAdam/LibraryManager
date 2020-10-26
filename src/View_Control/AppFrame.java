package View_Control;

import basicGUI.basicFrame;

import java.awt.*;

public class AppFrame extends basicFrame{
    BigPanel bp;
    //LogInSignUpPanel log;
    //UserInfoPanel info;
    public AppFrame(){
        this.getContentPane().setBackground(new Color(150,150,150));
        bp = new BigPanel();
        //log = new LogInSignUpPanel();
        //info = new UserInfoPanel();
        //big.add(info);
        this.getContentPane().add(bp);
    }

    public static void main(String[] a){
        AppFrame af = new AppFrame();
        //af.getContentPane().add(af.log);
        af.display();
    }
}
