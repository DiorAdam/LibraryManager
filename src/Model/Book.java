package Model;

import java.util.HashMap;
import java.util.Vector;

public class Book {
    Integer bookID;
    String title, author;
    Integer remaining, year;
    Books bTable;

    public Book(String title_){
        this.title = title_;
        bTable = new Books();
    }

    public boolean setBook(){
        HashMap<String, Object> hm = bTable.select(this.title);
        if (hm.size()==0) return false;
        this.author = hm.get("author") + ""; this.remaining = Integer.parseInt(hm.get("remaining") + "");
        this.year = Integer.parseInt(hm.get("year") + ""); this.bookID = (Integer) hm.get("userID");
        return true;
    }

    private void setBook(int bookID_){
        HashMap<String, Object> hm = bTable.select(this.bookID);
        this.author = hm.get("author") + ""; this.remaining = Integer.parseInt(hm.get("remaining") + "");
        this.year = Integer.parseInt(hm.get("year") + ""); this.title =  hm.get("title") + "";
    }

    public void editBook(HashMap<String, Object> params){
        bTable.edit(params);
        this.setBook(this.bookID);
    }

     public void delBook(HashMap<String, Object> params){
        bTable.del(this.bookID);
     }

     public Vector<String[]> getLoans(){
        Loans lTable = new Loans();
        return lTable.selectLoansPerBook(this.bookID);
    }
}
