/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ADMIN
 */
import java.sql.*;
import javax.swing.*;
public class Connect 
{
    public Connection conn = null;
    //Phuong thuc thuc hien ket noi CSDL
    public Connection connectSQL() throws SQLException
    { 
        try {
            String userName = "sa";
            String password =  "123456";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLHieuSach;encrypt=false;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = java.sql.DriverManager.getConnection(url, userName, password);
            System.out.println("Ket noi thanh cong");
            return conn;
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Ket noi CSDL that bai","Thong bao",1);
        }
        return null;
    }
}
