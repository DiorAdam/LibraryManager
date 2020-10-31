package View_Control.LogInOut;

import View_Control.BigPanel;
import View_Control.LogInOut.LogInSignUpControl;
import basicGUI.*;


public class LogOutPanel extends basicPanel{

    BigPanel bp;
    basicButton logOut;

    public LogOutPanel(BigPanel bp_){
        bp = bp_;
        logOut = new basicButton("Log Out");
        this.add(logOut);
        LogInSignUpControl cont = new LogInSignUpControl(bp);
        logOut.addActionListener(cont);
    }
}
