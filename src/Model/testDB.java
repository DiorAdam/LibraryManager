package Model;
import java.util.HashMap;
import java.util.Vector;

public class testDB {
    public static void main(String args[]){
        //Loans l = new Loans();
        /*
        HashMap<String, Object > params = new HashMap<String, Object>();
        params.put("loanID", 2); params.put("userID", 9); params.put("bookID", 13);
        params.put("start", "2020-5-100"); params.put("end", "2020-7-120");
        l.add(params);
        */

        // Testing selectLoansPerUser
        /*
        Vector<String[]> mb = l.selectLoansPerUser(9);
        for (String[] b : mb ){
            System.out.println(b[0] + "\t" + b[1] + "\t" + b[2]);
        }
         */


        //Testing selectLoansPerBook
        /*
        Vector<String[]> mb = l.selectLoansPerBook(93);
        for (String[] b : mb ){
            System.out.println(b[0] + "\t" + b[1] + "\t" + b[2] + "\t" + b[3]);
        }
        */

        //Testing Loans.del
        //l.del(6);
        /*
        Users u = new Users();
        int[] ID = {1,2,3,4,9,11,13,19,23,200,201};

        for(int userID: ID){
            HashMap<String,Object> params = u.select(userID);
            params.put("isAdmin", false);
            params.put("userID", userID);
            u.edit(params);
        }

         */
    }
}
