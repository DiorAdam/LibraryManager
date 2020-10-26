package View;


import basicGUI.*;

import java.awt.*;

public class BigPanel extends basicPanel{
    LogInSignUpPanel logSign;
    UserInfoPanel userInfo;
    LogInSignUpControl logSignControl;

    public BigPanel(){
        this.setLayout(new CardLayout());
        logSign = new LogInSignUpPanel();
        userInfo = new UserInfoPanel();
        //userInfo.add(new LogOutPanel());
        //userInfo.loans.add(new basicLabel("")); userInfo.loans.add(new basicLabel("")); userInfo.loans.add(new basicLabel(""));
        //userInfo.loans.add(new LogOutPanel(this));
        logSignControl = new LogInSignUpControl(this);

        this.logSign.logIn.addActionListener(logSignControl);
        this.logSign.signUp.addActionListener(logSignControl);

        this.add(logSign, "LogInSignUp");
        this.add(userInfo, "UserInfo");
    }

}
