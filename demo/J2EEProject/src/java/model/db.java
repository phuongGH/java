package model;

import java.sql.*;
public class db {
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","jee","jee");
        } catch (Exception e) {
        }
        return con;
    }
}
