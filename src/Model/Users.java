package Model;


import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class Users {
    final private String url;
    public Users(){
        url = "jdbc:sqlite:"+"TP_DB.db";
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
        String sql = "INSERT INTO UsersTab(userID, name, firstName, email, password, birthday,isAdmin) VALUES(?,?,?,?,?,?,?)";

        if (!params.containsKey("userID")){
            String sqlID = "Select Max(userID) from UsersTab";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sqlID)){

                params.put("userID", rs.getInt(1)+1);
            }
            catch(Exception e){
                System.err.println(e);
            }
        }

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Inserting User " + params.get("email") + " Into UsersTab");

            stmt.setInt(1, (Integer) params.get("userID"));
            stmt.setString(2, params.get("name") + "");
            stmt.setString(3, params.get("firstName") + "");
            stmt.setString(4, params.get("email") + "");
            stmt.setString(5, params.get("password") + "");
            stmt.setString(6, params.get("birthday") + "");
            stmt.setBoolean(7,false);
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

    public HashMap<String, Object> select (String email, String password){
        String sql = "Select * from UsersTab where email = ? AND password = ?";
        HashMap<String, Object> ans = new HashMap<String, Object>();

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, email);
            stmt.setString(2, password);
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


    public void edit(HashMap<String, Object> params){
        String sql = "Update UsersTab Set email = ? , name = ? , firstName = ?, " +
                    "password = ? , birthday = ? , isAdmin = ?  Where userID = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            System.out.println("Editing table UsersTab");

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
}
