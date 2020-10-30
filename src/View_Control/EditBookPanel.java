package View_Control;

import Model.Book;
import basicGUI.*;

import java.awt.*;

public class EditBookPanel extends basicPanel{
    basicTextField title_, author_, year_, remaining_;
    basicLabel feedBack;
    basicButton editBook, delBook, addBook;
    public EditBookPanel(NavPanel nPanel, Book b){
        this.setLayout(new GridLayout(6,2));

        title_ = new basicTextField();
        author_ = new basicTextField();
        year_ = new basicTextField();
        remaining_ = new basicTextField();

        this.add(new basicLabel("Title")); this.add(title_);
        this.add(new basicLabel("Author")); this.add(author_);
        this.add(new basicLabel("Year")); this.add(year_);
        this.add(new basicLabel("Remaining")); this.add(remaining_);
        this.add(feedBack); this.add(new basicLabel(""));

        if (b != null){
            title_.setText(b.title); author_.setText(b.author);
            year_.setText(b.year+""); remaining_.setText(b.remaining+"");
            this.add(editBook); this.add(delBook);
        }
        else{
            this.add(addBook);
        }

        addBook.addActionListener(nPanel.sbControl);
        editBook.addActionListener(nPanel.sbControl);
        delBook.addActionListener(nPanel.sbControl);
    }
}
