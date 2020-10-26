package View_Control;


import basicGUI.*;

import java.awt.*;

public class BigPanel extends basicPanel{
    LogInSignUpPanel logSign;
    NavPanel nPanel;
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
