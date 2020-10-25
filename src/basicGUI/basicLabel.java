package basicGUI;

import javax.swing.JLabel;
import java.awt.*;

public class basicLabel extends JLabel {

    public basicLabel(String text){
        this.setText("  " + text + "  ");
        //this.setBackground(Color.LIGHT_GRAY);
        this.setForeground(new Color(109,7,26));
    }
}
