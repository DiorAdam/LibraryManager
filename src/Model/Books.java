package Model;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class Books {
    String url;

    public Books(){
        this.url = "jdbc:sqlite:"+"D:\\k1gilo\\ST5_capteurs\\TP_DB\\TP_DB.db";
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

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, (Integer) params.get("bookId"));
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

    public void del(int bookId){
        String sql = "Delete from BooksTab where bookId = ?";

        try ( Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public String[] select (String title){
        String sql = "Select author, year, remaining From BooksTab where title = ?";

        String[] ans = new String[3];

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();

            ans[0] = rs.getString("author")  ;
            ans[1] = rs.getString("year") ;
            ans[2] = rs.getString("remaining") ;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }

    public void edit(HashMap<String, Object> params){
        String sql = "Update BooksTab Set title = ? , author = ? , year = ?, remaining = ? Where bookId = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1,  params.get("title") + "");
            stmt.setString(2, params.get("author") + "");
            stmt.setString(3,  params.get("year") + "");
            stmt.setString(4, params.get("remaining") + "");

            stmt.setInt(5, (Integer) params.get("bookId"));

            stmt.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }


    public static void main(String[] args){
        /*
        Books b = new Books();

        HashMap<String, Object> hm = new HashMap<String, Object>();

        hm.put("title", "Cosmos"); hm.put("bookId", 67); hm.put("year", 1987 ); hm.put("author", "Neil DeGrasse"); hm.put("remaining", 5);
        b.add(hm);

        String[] inf = b.select("Cosmos");
        System.out.println(inf[0] + "\t" + inf[1] + "\t" + inf[2] + "\t");

        hm = new HashMap<String, Object>();
        hm.put("title", "TAOCP"); hm.put("bookId", 93); hm.put("year", 1997 ); hm.put("remaining", 9);
        //b.add(hm);
        inf = b.select("TAOCP");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);

        //hm = new HashMap<String, Object>();
        hm.put("author", "D.Knuth"); hm.put("bookId", 93);
        b.edit(hm);
        inf = b.select("TAOCP");
        System.out.println("TAOCP" + "   " + inf[0] + "\t" + inf[1] + "\t" + inf[2] );



        hm.put("bookId", 21); hm.put("title", "OOA");
        b.add(hm);
        inf = b.select("OOA");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);
        hm.put("author", "P.Coad");
        b.edit(hm);
        inf = b.select("OOA");
        System.out.println(hm.get("title") + "\t" + inf[0] + "\t" + inf[1] + "\t" + inf[2]);
        */
    }

}
