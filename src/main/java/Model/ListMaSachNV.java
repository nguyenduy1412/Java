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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ListMaSachNV {
    private String ma;

    public ListMaSachNV(String ma) {
        this.ma = ma;
    }

    public ListMaSachNV() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }
    public Connect cn = new Connect();
    public List<String> getDataSach() throws SQLException {
        List<String> lst = new ArrayList<>();
        String sql = "SELECT Sach.MaSach FROM Sach";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String masach = rs.getString("MaSach");
                lst.add(masach);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lst;
    }
    public List<String> getDataNV() throws SQLException {
        List<String> lst = new ArrayList<>();
        String sql = "SELECT NhanVien.MaNV FROM NhanVien";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String manv = rs.getString("MaNV");
                lst.add(manv);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lst;
    }
}
