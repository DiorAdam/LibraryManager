package Model;

import java.sql.*;
import java.util.Vector;
import java.util.HashMap;


public class Loans {
    final private String url;

    public Loans(){
        url = "jdbc:sqlite:"+"D:\\k1gilo\\ST5_capteurs\\TP_DB\\TP_DB.db";
    }

    private Connection connect() {
        Connection conn = null;
        try {
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void add( HashMap<String, Object> params){

        if (!params.containsKey("loanID")){
            String sqlID = "Select Max(loanID) from LoansTab";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlID)){

                params.put("loanID", rs.getInt(1)+1);
            }
            catch(Exception e){
                System.err.println(e);
            }
        }

        String sql = "INSERT INTO LoansTab(LoanID, UserID, start, end, BookID) Values (?,?,?,?,?) ";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Inserting row Into Loans");
            stmt.setInt(1, (Integer) params.get("loanID"));
            stmt.setInt(2, (Integer) params.get("userID"));
            stmt.setInt(5, (Integer) params.get("bookID"));
            stmt.setString(3, params.get("start") + "");
            stmt.setString(4, params.get("end") + "");

            stmt.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public Vector<String[]> selectLoansPerBook(int BookID){
        String sql = "select firstName, name, start, end " +
                        "FROM LoansTab JOIN UsersTab ON LoansTab.userID = UsersTab.userID " +
                        "Join BooksTab ON LoansTab.bookID = BooksTab.bookID " +
                        "WHERE LoansTab.bookID = ?";

        Vector<String[]> ans = new Vector<String[]>();

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,BookID);
            ResultSet rs = stmt.executeQuery();
            String[] UserLoan;
            while (rs.next()){
                UserLoan = new String[4];
                UserLoan[0] = rs.getString("firstName");
                UserLoan[1] = rs.getString("name");
                UserLoan[2] = rs.getString("start");
                UserLoan[3] = rs.getString("end");
                ans.add(UserLoan);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }

    public Vector<String[]> selectLoansPerUser(int userID){
        String sql = "select title, start, end " +
                "FROM LoansTab join UsersTab ON LoansTab.userID = UsersTab.userID " +
                "Join BooksTab ON BooksTab.bookID = LoansTab.bookID " +
                "WHERE LoansTab.userID = ?";

        Vector<String[]> ans = new Vector<String[]>();

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1,userID);
            ResultSet rs = stmt.executeQuery();
            String[] bookLoan;
            while (rs.next()){
                bookLoan = new String[3];
                bookLoan[0] = rs.getString("title");
                bookLoan[1] = rs.getString("start");
                bookLoan[2] = rs.getString("end");
                ans.add(bookLoan);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }

    public void del(int LoanID){
        String sql = "DELETE from LoansTab where LoanID = ?";

        try(Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Deleting Loan(LoanID = " + LoanID + " ) from LoansTab");
            stmt.setInt(1, LoanID);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void edit(HashMap<String, Object> params){
        String sql = "Update LoansTab Set UserID = ? , start = ? , end = ?, BookID = ? Where LoanID = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Editing table LoansTab");

            stmt.setInt(1, (Integer) params.get("UserID"));
            stmt.setString(2, params.get("start") + "");
            stmt.setString(3,  params.get("end") + "");
            stmt.setInt(4, (Integer) params.get("BookID"));

            stmt.setInt(5, (Integer) params.get("LoanID"));

            stmt.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
