package View;

import basicGUI.*;

/*
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
 */
import javax.swing.*;
import java.awt.*;

public class LogSignInPanel extends JSplitPane{
    JPanel left, right;
    JButton logIn, signIn;
    JLabel emailLeft, emailRight, name, firstName, passwordLeft, passwordRight, birthday, wrongInputLeft, wrongInputRight;
    JPasswordField passwordLeft_, passwordRight_;
    JTextField emailLeft_, emailRight_, name_, firstName_, birthday_;
    public LogSignInPanel(){

        this.setDividerSize(20); this.setDividerLocation(300);
        this.setOneTouchExpandable(true);
        left = new basicPanel(); right = new basicPanel();
        logIn = new basicButton(" log In "); signIn = new basicButton(" Sign In ");


        emailLeft = new basicLabel(" Email "); emailRight = new basicLabel(" Email ");

        name = new basicLabel(" Name "); firstName = new basicLabel(" First Name ");
        passwordLeft = new basicLabel(" Password "); birthday = new basicLabel(" Birthday (YYYY-MM-DD) ");
         passwordRight = new basicLabel(" Password ");
        wrongInputLeft = new basicLabel(""); wrongInputLeft.setForeground(Color.RED);
        wrongInputRight = new basicLabel(""); wrongInputRight.setForeground(Color.RED);

        passwordLeft_ = new JPasswordField(); passwordRight_ = new JPasswordField();
        passwordLeft_.setBackground(new Color(240,240,240));
        passwordRight_.setBackground(new Color(240,240,240));
        emailLeft_ = new basicTextField(); emailRight_ = new basicTextField(); name_ = new basicTextField();
        firstName_ = new basicTextField(); birthday_ = new basicTextField();


        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        this.setLeftComponent(left); this.setRightComponent(right);

        left.setLayout(new GridLayout(6, 2, 20, 20));
        left.add(emailLeft); left.add(emailLeft_);
        left.add(passwordLeft); left.add(passwordLeft_);
        left.add(new JLabel()); left.add(new JLabel());
        left.add(new JLabel()); left.add(new JLabel());
        left.add(new JLabel()); left.add(new JLabel());
        left.add(logIn); left.add(wrongInputLeft);

        right.setLayout(new GridLayout(6,2, 20, 20));
        right.add(name); right.add(name_);
        right.add(firstName); right.add(firstName_);
        right.add(birthday); right.add(birthday_);
        right.add(emailRight); right.add(emailRight_);
        right.add(passwordRight); right.add(passwordRight_);
        right.add(signIn);  right.add(wrongInputRight);
    }


}
