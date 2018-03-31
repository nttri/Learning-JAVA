package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thanhtri - 1512605
 */
public class DBConnect {

    Connection conn;
    boolean isConnected = false;

    public Connection getConnectToMySQL(String _port, String _username, String _password) {

        String port = _port;                 // tên port
        String userName = _username;         // tên user
        String password = _password;         // password

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:"+ _port +"/hocsinh", userName, password);
            isConnected = true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Kết nối MySQL Server bị lỗi!");
        }
        return conn;
    }

    public boolean isIsConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = null;
        }
    }
}
