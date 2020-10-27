package Model;

import java.util.HashMap;
import java.util.Vector;

public class Book {
    public Integer bookID;
    public String title, author;
    public Integer remaining, year;
    Books bTable;

    public Book(String title_){
        this.title = title_;
        bTable = new Books();
    }

    public boolean setBook(){
        HashMap<String, Object> hm = bTable.select(this.title);
        if (hm.size()==0) return false;
        this.author = hm.get("author") + ""; this.remaining = Integer.parseInt(hm.get("remaining") + "");
        this.year = Integer.parseInt(hm.get("year") + ""); this.bookID = (Integer) hm.get("bookID");
        return true;
    }

    private void setBook(int bookID_){
        HashMap<String, Object> hm = bTable.select(this.bookID);
        this.author = hm.get("author") + ""; this.remaining = Integer.parseInt(hm.get("remaining") + "");
        this.year = Integer.parseInt(hm.get("year") + ""); this.title =  hm.get("title") + "";
    }

    public void editBook(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("bookID", this.bookID); params.put("title", this.title);
        params.put("author", this.author); params.put("remaining", this.remaining+""); params.put("year", this.year + "");
        bTable.edit(params);
        //this.setBook(this.bookID);
    }

     public void delBook(){
        bTable.del(this.bookID);
     }

     public Vector<String[]> getLoans(){
        Loans lTable = new Loans();
        return lTable.selectLoansPerBook(this.bookID);
    }
}
