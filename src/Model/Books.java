package Model;

import java.sql.*;
import java.util.HashMap;


public class Books {
    private String url;

    public Books(){
        this.url = "jdbc:sqlite:"+"TP_DB.db";
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

    public void add(HashMap<String, Object> params) {
        String sql = "INSERT INTO BooksTab(BookId, title, author, year, remaining) VALUES(?,?,?,?,?)";

        if (!params.containsKey("bookID")){
            String sqlID = "Select Max(bookID) from BooksTab";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlID)){

                params.put("bookID", rs.getInt(1)+1);
            }
            catch(Exception e){
                System.err.println(e);
            }
        }

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Inserting Book " + params.get("title") + " into BooksTab");

            stmt.setInt(1, (Integer) params.get("bookID"));
            stmt.setString(2, (String) params.get("title"));
            stmt.setString(3, (String) params.get("author"));
            stmt.setString(4, params.get("year") + "");
            stmt.setString(5, params.get("remaining") + "");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void del(int bookID){
        String sql = "Delete from BooksTab where bookID = ?";

        try ( Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Deleting Book (bookID = " + bookID + ") From BooksTab");
            stmt.setInt(1, bookID);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public HashMap<String, Object> select (String title){
        String sql = "Select bookID, author, year, remaining From BooksTab where title = ?";

        HashMap<String, Object> ans = new HashMap<String, Object>();

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();

            ans.put("bookID", rs.getInt("bookID"));
            ans.put("author", rs.getString("author")) ;
            ans.put("year", rs.getString("year"));
            ans.put("remaining", rs.getString("remaining")) ;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }

    public HashMap<String, Object> select (int bookID){
        String sql = "Select author, year, remaining From BooksTab where bookID = ?";

        HashMap<String, Object> ans = new HashMap<String, Object>();

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, bookID);
            ResultSet rs = stmt.executeQuery();

            ans.put("title", rs.getString("title"));
            ans.put("author", rs.getString("author")) ;
            ans.put("year", rs.getString("year"));
            ans.put("remaining", rs.getString("remaining")) ;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }



    public void edit(HashMap<String, Object> params){
        String sql = "Update BooksTab Set title = ? , author = ? , year = ?, remaining = ? Where bookID = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){

            System.out.println("Editing Book(bookID = " + params.get("bookID") + " ) in BooksTab");
            stmt.setString(1,  params.get("title") + "");
            stmt.setString(2, params.get("author") + "");
            stmt.setString(3,  params.get("year") + "");
            stmt.setString(4, params.get("remaining") + "");
            stmt.setInt(5, (Integer) params.get("bookID"));

            System.out.println("Updating Books");
            stmt.executeUpdate();

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    /*
    public static void main(String[] args){

        Books b = new Books();

        HashMap<String, Object> hm = new HashMap<String, Object>();

        hm.put("title", "Jazbu"); hm.put("bookID", 1); hm.put("year", 1890 );
        hm.put("author", "C.A.B"); hm.put("remaining", 10);
        b.edit(hm);

        String[] inf = b.select("Cosmos");
        System.out.println(inf[0] + "\t" + inf[1] + "\t" + inf[2] + "\t");

        hm = new HashMap<String, Object>();
        hm.put("title", "TAOCP"); hm.put("bookID", 93); hm.put("year", 1997 ); hm.put("remaining", 9);
        //b.add(hm);
        inf = b.select("TAOCP");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);

        //hm = new HashMap<String, Object>();
        hm.put("author", "D.Knuth"); hm.put("bookID", 93);
        b.edit(hm);
        inf = b.select("TAOCP");
        System.out.println("TAOCP" + "   " + inf[0] + "\t" + inf[1] + "\t" + inf[2] );



        hm.put("bookID", 21); hm.put("title", "OOA");
        b.add(hm);
        inf = b.select("OOA");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);
        hm.put("author", "P.Coad");
        b.edit(hm);
        inf = b.select("OOA");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);

    }
     */
}
