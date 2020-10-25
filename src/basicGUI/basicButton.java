package basicGUI;

import javax.swing.JButton;
import java.awt.*;

public class basicButton extends JButton {

    public basicButton(String text){
        this.setText(text);
        this.setBackground(new Color(109,7,26));
        this.setForeground(Color.white);
    }
}
