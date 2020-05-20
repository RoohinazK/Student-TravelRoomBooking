package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "tiger");
            System.out.println("Connection::" + con);
            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
