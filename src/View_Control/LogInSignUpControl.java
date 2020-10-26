package View_Control;

import Model.User;
import Model.Users;

import java.util.HashMap;

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
            else {
                bp.logSign.wrongInputLeft.setText("Wrong Input");
            }
        }
        else if ( cmd == "Sign Up"){
            Users uTable = new Users();
            HashMap<String, Object> params = new HashMap<String, Object>();

            params.put("name", bp.logSign.name_.getText());
            params.put("firstName", bp.logSign.firstName_.getText());
            params.put("birthday", bp.logSign.birthday_.getText());
            params.put("email", bp.logSign.emailRight_.getText());

            char[] password = bp.logSign.passwordRight_.getPassword();
            StringBuilder psw = new StringBuilder(password.length);
            for (char c : password) psw.append(c);
            params.put("password", psw.toString());

            try {
                uTable.add(params);
            }
            catch(Exception e){
                System.err.println(e);
            }

            loggedUser = new User(params.get("email")+"", params.get("password")+"");
            if (loggedUser.setUser()){
                cl.removeLayoutComponent(bp.userInfo);
                bp.userInfo = new UserInfoPanel(bp, loggedUser);
                bp.add(bp.userInfo, "UserInfo");
                cl.show(bp, "UserInfo");
            }
            else {
                bp.logSign.wrongInputRight.setText("Wrong Input");
            }
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
