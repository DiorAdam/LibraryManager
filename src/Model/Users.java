package Model;


import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class Users {
    final private String url;
    public Users(){
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

    public void add(HashMap<String, Object> params) {
        String sql = "INSERT INTO UsersTab(userID, name, firstName, email, password, birthday) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, (Integer) params.get("userID"));
            stmt.setString(2, params.get("name") + "");
            stmt.setString(3, params.get("firstName") + "");
            stmt.setString(4, params.get("email") + "");
            stmt.setString(5, params.get("password") + "");
            stmt.setString(6, params.get("birthday") + "");
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void del(String email){
        String sql = "Delete from UsersTab where email = ?";

        try ( Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, email);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void del (int userID){
        String sql = "Delete from UsersTab where UserID = ?";

        try ( Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, Object> select (String email){
        String sql = "Select * from UsersTab where email = ?";
        HashMap<String, Object> ans = new HashMap<String, Object>();

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            ans.put("userID", rs.getInt("userID"));
            ans.put("name", rs.getString("name"));
            ans.put("firstName", rs.getString("firstName"));
            ans.put("birthday", rs.getString("birthday"));
            ans.put("password", rs.getString("password"));
            ans.put("isAdmin", rs.getBoolean("isAdmin"));
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }


    public HashMap<String, Object> select (int userID){
        String sql = "Select * from UsersTab where userID = ?";
        HashMap<String, Object> ans = new HashMap<String, Object>();

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            ans.put("email", rs.getString("email"));
            ans.put("name", rs.getString("name"));
            ans.put("firstName", rs.getString("firstName"));
            ans.put("birthday", rs.getString("birthday"));
            ans.put("password", rs.getString("password"));
            ans.put("isAdmin", rs.getBoolean("isAdmin"));
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }


    public void edit(HashMap<String, Object> params){
        String sql = "Update UsersTab Set email = ? , name = ? , firstName = ?, " +
                    "password = ? , birthday = ? , isAdmin = ?  Where userID = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(7, (Integer) params.get("userID"));
            stmt.setString(1, params.get("email") + "");
            stmt.setString(2, params.get("name") + "");
            stmt.setString(3, params.get("firstName") + "");
            stmt.setString(4, params.get("password") + "");
            stmt.setString(5, params.get("birthday") + "");
            stmt.setBoolean(6, (Boolean) params.get("isAdmin"));


            stmt.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    /*
    public static void main(String[] args){
        Users u = new Users();


        HashMap<String, Object > params = new HashMap<String, Object>();
        params.put("userID", 3);
        params.put("name", "Anne"); params.put("firstName", "Raby");

        params.put("password", "joyful"); params.put("birthday", "1986-3-8"); params.put("email", "RabyAnne@joymail.com");
        u.add(params);


    }
    */

}
