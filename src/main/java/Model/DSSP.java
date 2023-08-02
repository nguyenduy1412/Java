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
public class DSSP {
    private String tenSach;
    private int soLuong;
    private float gia;
    private float tong;

    public DSSP() {
    }

    public DSSP(String tenSach, int soLuong, float gia, float tong) {
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tong = tong;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }
    public Connect cn=new Connect();
    public List<DSSP> getData(String ma) throws SQLException
    {
        List<DSSP> lst =new ArrayList();
        String sql = "select Sach.TenSach,Sach.Gia,ChiTietHoaDon.SoLuong,ChiTietHoaDon.Tien FROM SACH,ChiTietHoaDon where Sach.MaSach=ChiTietHoaDon.MaSach and MAHD=? ";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ten = rs.getString("TenSach");
                float price = rs.getFloat("Gia");
                int soluong = rs.getInt("SoLuong");
                float tien=rs.getFloat("Tien");
                DSSP ds = new DSSP(ten,soluong,price,tien);
                lst.add(ds);
            }
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        return lst;
    }
}
