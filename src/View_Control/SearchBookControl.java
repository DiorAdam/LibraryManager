package View_Control;

import Model.Book;
import Model.Loans;

import java.awt.*;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookControl implements ActionListener {
    NavPanel nPanel;
    EditBookPanel ebPanel;
    Book b;

    public SearchBookControl(NavPanel nPanel_){
        nPanel = nPanel_;
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        String title = nPanel.uiPanel.searchBook_.getText();
        if (cmd.equals("Search Book")){
            b = new Book(title);
            if (b.setBook()){
                nPanel.biPanel = new BookInfoPanel(this.nPanel, b);
                nPanel.add(b.title, nPanel.biPanel);
                nPanel.uiPanel.BookNotFound.setText("Book Page in the last tab");
            }
            else{
                nPanel.uiPanel.BookNotFound.setText("Book Not Found");
                System.out.println("Book not found");
            }
        }

        else if (cmd.equals("Search/Add Book")){
            b = (title.length()>0)? new Book(title) : null;
            if (b == null || b.setBook()){
                ebPanel = new EditBookPanel(this.nPanel, b);
                int idx = nPanel.indexOfTab("Edit Book");
                if ( idx >= 0) {
                    nPanel.add(b.title, ebPanel);
                }
                else{
                    nPanel.setComponentAt(idx, ebPanel);
                }
                nPanel.uiPanel.BookNotFound.setText("Book Page Successfully opened");
            }
            else{
                nPanel.uiPanel.BookNotFound.setText("Book Not Found");
                System.out.println("Book not found");
            }
        }

        else if (cmd.equals("editBook")){
            try {
                b.title = ebPanel.title_.getText();
                b.author = ebPanel.author_.getText();
                b.year = Integer.parseInt(ebPanel.year_.getText());
                b.remaining = Integer.parseInt(ebPanel.remaining_.getText());
                b.editBook();
                ebPanel.feedBack.setText("Book successfully updated");
                ebPanel.setForeground(Color.GREEN);
            }
            catch (Exception e){
                System.err.println(e);
                ebPanel.feedBack.setText("Error While editing book");
                ebPanel.feedBack.setForeground(Color.RED);
            }
        }

        else if (cmd.equals("Borrow")){
            b.setBook();
            if (b.remaining == 0){
                nPanel.biPanel.borrow_.setText("Out of Stock");
            }
            else{
                String ret = nPanel.biPanel.returnDate_.getText();
                String cur = java.time.LocalDateTime.now().toString().split("T")[0];
                String[] retArray = ret.split("-");
                String[] curArray = cur.split("-");

                int[] ret_ = new int[3], cur_ = new int[3];
                for (int i=0; i<3; i++) cur_[i] = Integer.parseInt(curArray[i]);
                try{
                    ret_[0] = Integer.parseInt(retArray[0]);
                    ret_[1] = Integer.parseInt(retArray[1]);
                    ret_[2] = Integer.parseInt(retArray[2]);


                    if (ret_[0] < cur_[0]
                        || (ret_[0] == cur_[0] && ret_[1] < cur_[1])
                        || (ret_[1] == cur_[1] && ret_[2] < cur_[2])
                        || (ret_[1] > 12 || ret_[2] > 31)
                    )
                    {
                        nPanel.biPanel.borrow_.setText("Return Date must be after today");
                        throw new Exception("Return Date must be after today");
                    }
                    b.remaining--; b.editBook();
                    nPanel.biPanel.remaining_.setText(b.remaining+"");
                    nPanel.biPanel.borrow_.setText("Successfully borrowed");
                    Loans lTable = new Loans();
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("userID", nPanel.u.userID); params.put("bookID", b.bookID);
                    params.put("start", cur); params.put("end", ret);
                    lTable.add(params);
                    nPanel.uiPanel = new UserInfoPanel(nPanel.bp, nPanel.u);
                    nPanel.setComponentAt(0,nPanel.uiPanel);

                }
                catch (Exception e){
                    System.err.println(e);
                    nPanel.biPanel.borrow_.setText("Invalid Return Date");
                }
            }
        }
    }
}
