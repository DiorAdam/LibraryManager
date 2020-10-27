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
        String title = nPanel.uiPanel.search_.getText();
        Book b = new Book(title);
        if (cmd == "Search Book"){

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
            if (b.remaining == 0){
                nPanel.biPanel.borrow_.setText("Out of Stock");
            }
            else{

                String[] ret = nPanel.biPanel.returnDate_.getText().split("-");
                String[] currDate = java.time.LocalDateTime.now().toString().split("T")[0].split("-");
                Integer[] ret_ = new Integer[3], currDate_ = new Integer[3];
                for (int i=0; i<3; i++) currDate_[i] = Integer.parseInt(currDate[i]);
                try{
                    ret_[0] = Integer.parseInt(ret[0]);
                    ret_[1] = Integer.parseInt(ret[1]);
                    ret_[2] = Integer.parseInt(ret[2]);

                    String cur = ""+currDate_[0] + currDate_[1] + currDate_[2];
                    String re = "" + ret_[0] + ret_[1] + ret_[2];
                    if (re.compareTo(cur) <= 0){
                        nPanel.biPanel.borrow_.setText("Return Date must be after today");
                        throw new Exception("Return Date must be after today");
                    }

                    b.remaining--; b.editBook();
                    nPanel.biPanel.remaining_.setText(b.remaining+"");
                    nPanel.biPanel.borrow_.setText("Successfully borrowed");
                    //nPanel.uiPanel = new UserInfoPanel(nPanel.bp, nPanel.u);
                }
                catch (Exception e){
                    System.err.println("e");
                    nPanel.biPanel.borrow_.setText("Invalid Return Date");
                }

            }
        }
    }
}
