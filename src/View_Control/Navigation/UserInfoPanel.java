package View_Control.Navigation;

import java.util.Vector;
import Model.User;
import View_Control.BigPanel;
import View_Control.LogInOut.LogOutPanel;
import basicGUI.*;

import java.awt.*;

public class UserInfoPanel extends basicPanel {
    basicPanel info, loans;
    basicLabel name, firstName, birthday, borrowed;
    basicLabel name_, firstName_, birthday_, BookNotFound, UserNotFound;
    basicTextField searchBook_, searchUser_;
    basicButton searchBook, searchUser;
    BigPanel bp;

    public UserInfoPanel(){}
    public UserInfoPanel(BigPanel bp_, User u){
        bp = bp_;
        info = new basicPanel(); loans = new basicPanel();

        name = new basicLabel("Name : "); name_ = new basicLabel("None");
        firstName = new basicLabel("firstName : "); firstName_ = new basicLabel("None");
        birthday = new basicLabel("Birthday : "); birthday_ = new basicLabel("None");

        if (u.admin){
            info.setLayout(new GridLayout(5, 2));
            info.add(firstName);
            info.add(firstName_);
            info.add(name);
            info.add(name_);
            info.add(birthday);
            info.add(birthday_);
            searchUser_ = new basicTextField(); searchUser = new basicButton("Search User");
            UserNotFound = new basicLabel(""); UserNotFound.setForeground(Color.RED);
            info.add(searchUser_); info.add(searchUser);
            info.add(UserNotFound);
        }
        else {
            info.setLayout(new GridLayout(3, 2));
            info.add(firstName);
            info.add(firstName_);
            info.add(name);
            info.add(name_);
            info.add(birthday);
            info.add(birthday_);
        }

        name_.setText(u.name); firstName_.setText(u.firstName);
        birthday_.setText(u.birthday);
        Vector<String[]> v = u.getLoans();
        loans.setLayout(new GridLayout(v.size()+5, 3));
        borrowed = new basicLabel("Borrowed books : ");
        loans.add(borrowed); loans.add(new basicLabel("")); loans.add(new basicLabel(""));
        loans.add(new basicLabel("Book Title"));
        loans.add(new basicLabel("Borrowing date")); loans.add(new basicLabel("Return Date"));
        for (int i=0; i<v.size(); i++){
            loans.add(new basicLabel(v.get(i)[0]));
            loans.add(new basicLabel(v.get(i)[1]));
            loans.add(new basicLabel(v.get(i)[2]));
        }
        searchBook_ = new basicTextField();
        if (u.admin) searchBook = new basicButton("Search/Add Book");
        else searchBook = new basicButton("Search Book");
        BookNotFound = new basicLabel(""); BookNotFound.setForeground(Color.RED);

        loans.add(searchBook_); loans.add(searchBook); loans.add(BookNotFound);
        loans.add(new basicLabel("")); loans.add(new basicLabel("")); loans.add(new basicLabel(""));
        loans.add(new LogOutPanel(bp));


        this.setLayout(new GridLayout(2,1));
        this.add(info);
        this.add(loans);

    }
}
