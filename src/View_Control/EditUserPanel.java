package View_Control;

import Model.User;
import basicGUI.*;

import java.awt.*;

public class EditUserPanel extends basicPanel{
    User u;
    basicTextField email_, name_, firstName_, birthday_;
    basicButton edit, delete;
    basicLabel feedBack;
    public EditUserPanel(User u_, SearchUserControl suControl){
        u = u_;
        email_ = new basicTextField(); email_.setText(u.email);
        name_ = new basicTextField(); name_.setText(u.name);
        firstName_ = new basicTextField(); firstName_.setText(u.firstName);
        birthday_ = new basicTextField(); birthday_.setText(u.birthday);
        feedBack = new basicLabel(""); feedBack.setForeground(Color.BLUE);
        edit = new basicButton("Edit"); delete = new basicButton("Delete");

        edit.addActionListener(suControl); delete.addActionListener(suControl);
        this.setLayout(new GridLayout(6,2));

        this.add(new basicLabel("Email")); this.add(email_);
        this.add(new basicLabel("First Name")); this.add(firstName_);
        this.add(new basicLabel("Name")); this.add(name_);
        this.add(new basicLabel("Birthday")); this.add(birthday_);
        this.add(new basicLabel("")); this.add(feedBack);

        this.add(edit); this.add(delete);

    }
}
