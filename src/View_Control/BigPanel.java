package View_Control;


import View_Control.LogInOut.LogInSignUpControl;
import View_Control.LogInOut.LogInSignUpPanel;
import View_Control.Navigation.NavPanel;
import basicGUI.*;

import java.awt.*;

public class BigPanel extends basicPanel{
    public LogInSignUpPanel logSign;
    public NavPanel nPanel;
    LogInSignUpControl logSignControl;

    public BigPanel(){
        this.setLayout(new CardLayout());
        logSign = new LogInSignUpPanel();
        nPanel = new NavPanel();

        logSignControl = new LogInSignUpControl(this);
        this.logSign.logIn.addActionListener(logSignControl);
        this.logSign.signUp.addActionListener(logSignControl);

        this.add(logSign, "LogInSignUp");
        this.add(nPanel, "Nav");
    }

}
