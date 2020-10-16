package Model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class Users {
    String url;
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

    public void add(Integer UserId, String name, String firstName, String email) {
        String sql = "INSERT INTO UsersTab(userId, name, firstName, email) VALUES(?,?,?,?)";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, UserId);
            stmt.setString(2, name);
            stmt.setString(3, firstName);
            stmt.setString(4, email);
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

    public void del (int i){
        String sql = "Delete from UsersTab where UserID = ?";

        try ( Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, i);
            stmt.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String[] select (String email){
        String sql = "Select name, firstName, birthDay from UsersTab where email = ?";
        String[] ans = new String[3];

        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            ans[0] = rs.getString("name");
            ans[1] = rs.getString("firstName");
            ans[2] = rs.getString("birthDay");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return ans;
    }

    public void edit(String email, int UserId, String name, String firstName, String password, String birthday){
        String sql = "Update UsersTab Set UserId = ? , name = ? , firstName = ?, password = ? , birthday = ? Where email = ?";

        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, UserId);
            stmt.setString(2, name);
            stmt.setString(3, firstName);
            stmt.setString(4, password);
            stmt.setString(5, birthday);
            stmt.setString(6, email);

            stmt.executeUpdate();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        /*
        Users a = new Users();
        //a.add(2, "ab", "ccc", "ab.ccc@email.com");
        String[] name ;
        //System.out.println(name[0] + "  " + name[1]);
        //a.del(2);

        a.edit("ab.ccc@email.com", 19, null, "byJoystick", "XxunknownxX", "2000-9-30");
        name = a.select("ab.ccc@email.com");
        System.out.println(name[0] + "  " + name[1] + "  " + name[2]);
        */

    }
}
