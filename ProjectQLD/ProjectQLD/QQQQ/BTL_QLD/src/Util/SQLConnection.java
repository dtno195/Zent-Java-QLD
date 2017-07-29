/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class SQLConnection {

    private static Connection conn;
    private static final String server = "localhost";
    private static final String port = "1433";
    private static final String instanceName = "SQLEXPRESS";
    private static final String userName = "sa";
    private static final String password = "123456";
    private static final String databaseName = "QLD";

    //jdbc:sqlserver://localhost\SQLEXPRESS:1433;databaseName=QLDIEM
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // if (conn == null || conn.isClosed()){
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + server + "\\" + instanceName + ":" + port + ";" + "databaseName=" + databaseName;
        conn = DriverManager.getConnection(url, userName, password);
        //}
        return conn;
    }

    public static boolean Kiem_Tra_Trung(String table, String colum, String ip) throws ClassNotFoundException,
            SQLException {

        ResultSet rs = null;
        // Lấy ra đối tượng Connection kết nối vào DB.
        conn = getConnection();

        // Tạo đối tượng Statement.
        Statement statement = conn.createStatement();

        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        rs = statement.executeQuery("select COUNT(*) from " + table + " Where " + colum + " = '" + ip + "'");
        int num = 0;
        while (rs.next()) {
            num = (Integer) rs.getInt(1);
        }
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void close() throws SQLException {
        if (conn != null || !conn.isClosed()) {
            conn.close();
        }
    }

}
