package View_Control;

import Model.User;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchUserControl implements ActionListener{
    NavPanel nPanel;
    User loggedUser;
    EditUserPanel edUser;
    User u;
    public SearchUserControl(NavPanel nPanel_, User u_){
        nPanel = nPanel_;
        loggedUser = u_;
    }

    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        String email = nPanel.uiPanel.searchUser_.getText();
        if (cmd.equals("Search User")){
            u = new User(email);
            if (u.setUser(loggedUser)){
                edUser = new EditUserPanel(u, nPanel.suControl);
                int idx = nPanel.indexOfTab("Edit User");
                if (idx >=0) nPanel.setComponentAt(idx, edUser);
                else nPanel.add("Edit User", edUser);
                nPanel.uiPanel.UserNotFound.setText("User page Successfully Opened ");
            }
            else {
                nPanel.uiPanel.UserNotFound.setText("User Not Found");
            }
        }

        else if (cmd.equals("Delete")){
            try {
                u.delUser();
                edUser.feedBack.setText("User successfully deleted from the database");
            }
            catch(Exception e){
                System.err.println(e);
                edUser.feedBack.setText("Error while deleting user");
            }
        }
        else if (cmd.equals("Edit")){
            try {
                u.email = edUser.email_.getText();
                u.name = edUser.name_.getText();
                u.firstName = edUser.firstName_.getText();
                u.birthday = edUser.birthday_.getText();
                u.editUser();
                edUser.feedBack.setText("Successfully updated User");
            }
            catch(Exception e){
                System.err.println(e);
                edUser.feedBack.setText("Error while editing User");
            }
        }
    }
}
