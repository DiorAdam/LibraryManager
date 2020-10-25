package View;

import Model.User;

import java.awt.*;
import java.awt.event.*;



public class LogInSignUpControl implements ActionListener{
    BigPanel bp;
    LogInSignUpPanel logSign;
    UserInfoPanel userInfo;

    public LogInSignUpControl(BigPanel bp_){
        bp = bp_;
        this.logSign = bp.logSign;
        this.userInfo = bp.userInfo;
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        CardLayout cl = (CardLayout) bp.getLayout();
        if (cmd == "Log In"){
            String email = logSign.emailLeft_.getText().strip();
            System.out.println(email);
            char[] password = logSign.passwordLeft_.getPassword();
            StringBuilder psw = new StringBuilder(password.length);
            for (char c : password) psw.append(c);
            User loggedUser = new User(email, psw.toString());
            if (loggedUser.setUser()){
                userInfo.setInfo(loggedUser);
                cl.show(bp, "UserInfo");
            }
        }
        else if ( cmd == "Sign Up"){

        }

        else{
            System.err.println("Error in logInSignUpControl");
        }
    }
}
