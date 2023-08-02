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
import javax.naming.spi.ResolveResult;

/**
 *
 * @author ADMIN
 */
public class SanPhamBan {
    private String maSach;
    private String tenSach;
    private String ngayBan;
    private int soLuong;
    private float tongtien;

    public SanPhamBan() {
    }

    public SanPhamBan(String maSach, String tenSach, String ngayBan, int soLuong, float tongtien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.ngayBan = ngayBan;
        this.soLuong = soLuong;
        this.tongtien = tongtien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }

    public Connect getCn() {
        return cn;
    }

    public void setCn(Connect cn) {
        this.cn = cn;
    }

   
    public Connect cn=new Connect();
    public List<SanPhamBan> getData() throws SQLException{
        List<SanPhamBan> lst=new ArrayList();
        String sql="""
                   SELECT Sach.MaSach,Sach.TenSach,Sach.Gia ,SUM(Chitiethoadon.soluong) as SoLuong,Sach.Gia * SUM(Chitiethoadon.soluong) as Tong
                   FROM Sach, ChiTietHoaDon, HoaDon
                   WHERE Sach.MaSach = ChiTietHoaDon.MaSach
                   AND ChiTietHoaDon.MaHD = HoaDon.MaHD 
                   GROUP BY Sach.MaSach, Sach.TenSach,Sach.Gia ORDER BY SOLUONG DESC""";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {    
                String ma = rs.getString("MaSach");
                String ten = rs.getString("TenSach");
                int soluong=rs.getInt("SoLuong");
                String ngayban = "";
                float tong=rs.getFloat("Tong");
                SanPhamBan sp = new SanPhamBan(ma, ten,ngayban,soluong,tong);
                lst.add(sp);
            }
        }
        catch(SQLException e){
            throw e;
        }
        return lst;
    } 
    public List<SanPhamBan> getData(int thang,int nam) throws SQLException{
        List<SanPhamBan> lst=new ArrayList();
        String sql="""
                   SELECT Sach.MaSach,Sach.TenSach,Sach.Gia ,HoaDon.NgayLap,SUM(Chitiethoadon.soluong) as SoLuong,Sach.Gia * SUM(Chitiethoadon.soluong) as Tong
                   FROM Sach, ChiTietHoaDon, HoaDon
                   WHERE Sach.MaSach = ChiTietHoaDon.MaSach
                   AND ChiTietHoaDon.MaHD = HoaDon.MaHD and  MONTH(NgayLap)=? and YEAR(NgayLap)=? 
                   GROUP BY Sach.MaSach, Sach.TenSach,Sach.Gia,HoaDon.NgayLap""";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {    
                String ma = rs.getString("MaSach");
                String ten = rs.getString("TenSach");
                int soluong=rs.getInt("SoLuong");
                String ngayban = rs.getString("NgayLap");
                float tong=rs.getFloat("Tong");
                SanPhamBan sp = new SanPhamBan(ma, ten,ngayban,soluong,tong);
                lst.add(sp);
            }
        }
        catch(SQLException e){
            throw e;
        }
        return lst;
    } 
}
