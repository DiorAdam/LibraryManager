package Model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Users {
    String url;
    Connection conn;
    private Users() {
        url = "jdbc:sqlite:"+"D:\\k1gilo\\ST5_capteurs\\TP_DB\\TP_DB.db";
        try {
            //Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(Integer UserId, String name, String firstName, String email) {
        String sql = "INSERT INTO UsersTab(userId, name, firstName, email) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, UserId);
            pstmt.setString(2, name);
            pstmt.setString(3, firstName);
            pstmt.setString(4, email);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        Users a = new Users();
        a.add(1, "xy", "zzz", "xy.zzz@email.com");
    }
}
