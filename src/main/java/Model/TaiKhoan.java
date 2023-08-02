/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;

    public TaiKhoan() {
    }
    
    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTaiKhoan(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public Connect cn = new Connect();
    public boolean insertData(TaiKhoan obj) throws SQLException {
        String sql = "INSERT INTO TaiKhoan VALUES (?,?)";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getTenDangNhap());
            ps.setString(2, obj.getMatKhau());
           
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return false;
    }
     public boolean updateData(TaiKhoan obj) throws SQLException {
        String sql = "update TaiKhoan set MatKhau= ? where TenDangNhap=?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {     
            ps.setString(1, obj.getMatKhau());
            ps.setString(2, obj.getTenDangNhap());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
    public boolean deleteData(String tendn) throws SQLException {
        String sql = "DELETE FROM TaiKhoan WHERE TenDangNhap = ?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tendn);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw e;          
        }
    }
    public String getPass(String tdn)
    {
        String pass=null;
        String sql = "SELECT matkhau FROM TaiKhoan WHERE TenDangNhap=?";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {     
            ps.setString(1, tdn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pass = rs.getString("matkhau");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pass;
    }
}
