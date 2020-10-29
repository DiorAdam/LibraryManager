package View_Control;

import Model.User;
import Model.Users;

import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchUserControl implements ActionListener{
    NavPanel nPanel;
    User loggedUser;
    public SearchUserControl(NavPanel nPanel_, User u_){
        nPanel = nPanel_;
        loggedUser = u_;
    }

    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        if (cmd.equals("Search User")){
            String email = nPanel.uiPanel.searchUser_.getText();
            User u = new User(email);
            if (u.setUser(loggedUser)){

            }
        }
    }

}
