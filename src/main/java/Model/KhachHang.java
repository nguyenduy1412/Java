/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private String maKhach;
    private String tenKhach;

    public KhachHang() {
    }

    public KhachHang(String maKhach, String tenKhach) {
        this.maKhach = maKhach;
        this.tenKhach = tenKhach;
    }

    public String getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }
    public Connect cn=new Connect();
     public boolean insertData(KhachHang obj) throws SQLException {
        String sql = "INSERT INTO KhachHang VALUES (?,?)";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getMaKhach());
            ps.setString(2, obj.getTenKhach());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
      public boolean updateData(KhachHang obj) throws SQLException {
        String sql = "update KhachHang set TenKhach=? where MaKhach=?";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getTenKhach());
            ps.setString(2, obj.getMaKhach());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
}
