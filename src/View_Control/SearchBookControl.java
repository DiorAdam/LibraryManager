package View_Control;

import Model.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookControl implements ActionListener {
    NavPanel nPanel;

    public SearchBookControl(NavPanel nPanel_){
        nPanel = nPanel_;
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();

        if (cmd == "Search Book"){
            String title = nPanel.uiPanel.search_.getText();
            Book b = new Book(title);
            if (b.setBook()){
                nPanel.biPanel = new BookInfoPanel(b);
                nPanel.add(b.title, nPanel.biPanel);
            }
            else{
                nPanel.uiPanel.notFound.setText("Book Not Found");
                System.out.println("Book not found");
            }
        }
        else if (cmd == "Borrow"){

        }
    }
}
