package View_Control.LogInOut;

import Model.User;
import Model.Users;
import View_Control.BigPanel;
import View_Control.Navigation.NavPanel;

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
            char[] password = bp.logSign.passwordLeft_.getPassword();
            StringBuilder psw = new StringBuilder(password.length);
            for (char c : password) psw.append(c);
            loggedUser = new User(email, psw.toString());

            if (loggedUser.setUser()){
                String adm = bp.logSign.admin_.getText();
                if (adm.equals("yes") && loggedUser.isAdmin) loggedUser.admin = true;
                else loggedUser.admin = false;

                cl.removeLayoutComponent(bp.nPanel);
                bp.nPanel  = new NavPanel(bp, loggedUser);
                bp.add(bp.nPanel, "Nav");
                cl.show(bp, "Nav");
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
                loggedUser.admin = false;
                cl.removeLayoutComponent(bp.nPanel);
                bp.nPanel = new NavPanel(bp, loggedUser);
                bp.add(bp.nPanel, "Nav");
                cl.show(bp, "Nav");
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
