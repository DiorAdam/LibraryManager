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

public class LogInSignUpPanel extends JSplitPane{
    JPanel left, right;
    JButton logIn, signUp;
    JLabel emailLeft, emailRight, name, firstName, passwordLeft, passwordRight, birthday, wrongInputLeft, wrongInputRight;
    JPasswordField passwordLeft_, passwordRight_;
    JTextField emailLeft_, emailRight_, name_, firstName_, birthday_;
    public LogInSignUpPanel(){

        this.setDividerSize(20); this.setDividerLocation(300);
        this.setOneTouchExpandable(true);
        left = new basicPanel(); right = new basicPanel();


        emailLeft = new basicLabel(" Email "); emailLeft_ = new basicTextField();
        passwordLeft = new basicLabel(" Password "); passwordLeft_ = new JPasswordField();
        passwordLeft_.setBackground(new Color(240,240,240));
        logIn = new basicButton("Log In");
        wrongInputLeft = new basicLabel(""); wrongInputLeft.setForeground(Color.RED);

        name = new basicLabel(" Name "); name_ = new basicTextField();
        firstName = new basicLabel(" First Name "); firstName_ = new basicTextField();
        birthday = new basicLabel(" Birthday (YYYY-MM-DD) "); birthday_ = new basicTextField();
        emailRight = new basicLabel(" Email "); emailRight_ = new basicTextField();
        passwordRight = new basicLabel(" Password "); passwordRight_ = new JPasswordField();
        passwordRight_.setBackground(new Color(240,240,240));
        signUp = new basicButton("Sign Up");
        wrongInputRight = new basicLabel(""); wrongInputRight.setForeground(Color.RED);



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
        right.add(signUp);  right.add(wrongInputRight);
    }


}
