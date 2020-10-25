package View;

import java.util.Vector;
import Model.User;
import basicGUI.*;

import java.awt.*;

public class UserInfoPanel extends basicPanel {
    basicPanel info, loans;
    basicLabel name, firstName, birthday, borrowed;
    basicLabel name_, firstName_, birthday_;
    basicButton search;

    public UserInfoPanel(){
        info = new basicPanel(); loans = new basicPanel();

        name = new basicLabel("Name : "); name_ = new basicLabel("None");
        firstName = new basicLabel("firstName : "); firstName_ = new basicLabel("None");
        birthday = new basicLabel("Birthday : "); birthday_ = new basicLabel("None");

        info.setLayout(new GridLayout(3,2));
        info.add(firstName); info.add(firstName_);
        info.add(name); info.add(name_);
        info.add(birthday); info.add(birthday_);
        /*
        loans.setLayout(new GridLayout(3,3));
        borrowed = new basicLabel("Borrowed books : ");
        loans.add(borrowed); loans.add(new basicLabel("")); loans.add(new basicLabel(""));
        loans.add(new basicLabel("Book Title"));
        loans.add(new basicLabel("Borrowing date")); loans.add(new basicLabel("Return Date"));
        for (int i=0; i<3; i++){
            loans.add(new basicLabel("title"));
            loans.add(new basicLabel("YYYY-MM-DD")); loans.add(new basicLabel("YYYY-MM-DD"));
        }
        */

        this.setLayout(new GridLayout(2,1));
        this.add(info);
        this.add(loans);

    }

    public void setInfo(User u){
        name_.setText(u.name); firstName_.setText(u.firstName);
        birthday_.setText(u.birthday);
        Vector<String[]> v = u.getLoans();
        loans.setLayout(new GridLayout(v.size()+3, 3));
        borrowed = new basicLabel("Borrowed books : ");
        loans.add(borrowed); loans.add(new basicLabel("")); loans.add(new basicLabel(""));
        loans.add(new basicLabel("Book Title"));
        loans.add(new basicLabel("Borrowing date")); loans.add(new basicLabel("Return Date"));
        for (int i=0; i<v.size(); i++){
            loans.add(new basicLabel(v.get(i)[0]));
            loans.add(new basicLabel(v.get(i)[1]));
            loans.add(new basicLabel(v.get(i)[2]));
        }
        search = new basicButton("Search a Book");
        loans.add(new basicLabel("")); loans.add(search);
    }
}
