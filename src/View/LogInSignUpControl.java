package View;

import Model.User;

import java.awt.*;
import java.awt.event.*;



public class LogInSignUpControl implements ActionListener{
    BigPanel bp;
    User loggedUser;

    public LogInSignUpControl(BigPanel bp_){
        bp = bp_;
        loggedUser = null;
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        CardLayout cl = (CardLayout) bp.getLayout();

        if (cmd == "Log In"){

            String email = bp.logSign.emailLeft_.getText().strip();
            //System.out.println(email);
            char[] password = bp.logSign.passwordLeft_.getPassword();
            StringBuilder psw = new StringBuilder(password.length);
            for (char c : password) psw.append(c);
            loggedUser = new User(email, psw.toString());

            if (loggedUser.setUser()){
                //bp.userInfo.setInfo(loggedUser);
                cl.removeLayoutComponent(bp.userInfo);
                bp.userInfo = new UserInfoPanel(bp, loggedUser);
                bp.add(bp.userInfo, "UserInfo");
                cl.show(bp, "UserInfo");
            }
        }
        else if ( cmd == "Sign Up"){

        }

        else if (cmd == "Log Out"){
            bp.logSign.passwordLeft_.setText("");
            bp.logSign.passwordRight_.setText("");
            cl.show(bp, "LogInSignUp");
        }

        else{
            System.err.println("Error in logInSignUpControl");
        }
    }
}
