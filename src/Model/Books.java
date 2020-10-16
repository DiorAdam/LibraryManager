package Model;


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


}
