package View_Control;

import Model.User;
//import basicGUI.*;

import javax.swing.*;
//import java.awt.*;

public class NavPanel extends JTabbedPane {
    BigPanel bp;
    User u;
    UserInfoPanel uiPanel;
    BookInfoPanel biPanel;
    SearchUserControl suControl;
    SearchBookControl sbControl;
    public NavPanel(){}
    public NavPanel(BigPanel bp_, User u_){
        bp = bp_; u = u_;
        uiPanel = new UserInfoPanel(bp, u);
        this.add("Account", uiPanel);
        sbControl = new SearchBookControl(this);
        uiPanel.searchBook.addActionListener(sbControl);
        if (u.admin) {
            suControl = new SearchUserControl(this, u);
            uiPanel.searchUser.addActionListener(suControl);
        }
    }
}
