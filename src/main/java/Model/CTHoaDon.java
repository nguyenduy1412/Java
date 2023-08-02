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
public class CTHoaDon {
    private String maHD;
    private String maKhach;
    private String tenKhach;
    private String maNV;
    private String maSach;
    private int soLuong;
    private String ngayLap;
    private float thanhTien;
    public CTHoaDon() {
    }

    public CTHoaDon( String maHD, String maKhach, String tenKhach, String maNV, String maSach, int soLuong,  String ngayLap,float thanhTien) {
        this.maHD = maHD;
        this.maKhach = maKhach;
        this.tenKhach = tenKhach;
        this.maNV = maNV;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }
   
    public Connect cn = new Connect();
// lay san pham tu sql sang java
    public List<CTHoaDon> getCTHoaDon() throws SQLException {
        List<CTHoaDon> cthoadon = new ArrayList<>();
        String sql = "select ChiTietHoaDon.*,HoaDon.*,Sach.Gia,KhachHang.TenKhach from ChiTietHoaDon,HoaDon,Sach,KhachHang\n" +
                    "where ChiTietHoaDon.MaHD=HoaDon.MaHD and ChiTietHoaDon.MaSach=Sach.MaSach\n" +
                    "and HoaDon.makhach=KhachHang.MaKhach";

        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String mahd= rs.getString("MaHD");
                String makhach=rs.getString("MaKhach");
                String tenkhach = rs.getString("TenKhach");
                String manv = rs.getString("MaNV");
                String masach = rs.getString("MaSach");
                int soluong = rs.getInt("SoLuong");
                String ngaylap = rs.getString("NgayLap");
                float tien = rs.getFloat("Tien");
                CTHoaDon ct = new CTHoaDon(mahd,makhach,tenkhach,manv,masach,soluong,ngaylap,tien);
                cthoadon.add(ct);
            }
        } catch (SQLException e) {
            throw e;
        }
        return cthoadon;
    }
  public List<CTHoaDon> getData(String name) throws SQLException {
        List<CTHoaDon> cthoadon = new ArrayList<>();
        String sql = """
                     select ChiTietHoaDon.*,HoaDon.*,Sach.Gia,KhachHang.TenKhach from ChiTietHoaDon,HoaDon,Sach,KhachHang
                        where ChiTietHoaDon.MaHD=HoaDon.MaHD and ChiTietHoaDon.MaSach=Sach.MaSach
                        and HoaDon.makhach=KhachHang.MaKhach AND KhachHang.TenKhach like ?""";
        String like="%"+name+"%";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, like);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd= rs.getString("MaHD");
                String makhach=rs.getString("MaKhach");
                String tenkhach = rs.getString("TenKhach");
                String manv = rs.getString("MaNV");
                String masach = rs.getString("MaSach");
                int soluong = rs.getInt("SoLuong");
                String ngaylap = rs.getString("NgayLap");
                float tien = rs.getFloat("Tien");
                CTHoaDon ct = new CTHoaDon(mahd,makhach,tenkhach,manv,masach,soluong,ngaylap,tien);
                cthoadon.add(ct);
            }
        } catch (SQLException e) {
            throw e;
        }
        return cthoadon;
    }
}
