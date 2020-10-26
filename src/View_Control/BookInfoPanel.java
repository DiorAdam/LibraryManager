package View_Control;

import java.awt.*;

import Model.Book;
import basicGUI.*;

public class BookInfoPanel extends basicPanel{
    basicLabel borrow_;
    public BookInfoPanel(Book b){
        this.setLayout(new GridLayout(6, 2));

        this.add(new basicLabel("Title")); this.add(new basicLabel(b.title));
        this.add(new basicLabel("Author")); this.add(new basicLabel(b.author));
        this.add(new basicLabel("Year")); this.add(new basicLabel(b.year+""));
        this.add(new basicLabel("Remaining")); this.add(new basicLabel(b.remaining+""));
        this.add(new basicLabel("")); this.add(new basicLabel(""));
        basicButton borrow = new basicButton("Borrow"); borrow_ = new basicLabel("");
        this.add(borrow); this.add(borrow_);
    }
}
