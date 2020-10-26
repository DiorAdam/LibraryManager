package View_Control;

import Model.User;
import basicGUI.*;

import javax.swing.*;
import java.awt.*;

public class NavPanel extends JTabbedPane {
    UserInfoPanel uiPanel;
    BookInfoPanel biPanel;

    public NavPanel(){}
    public NavPanel(BigPanel bp, User u){
        uiPanel = new UserInfoPanel(bp, u);
        this.add("Account", uiPanel);
    }
}
