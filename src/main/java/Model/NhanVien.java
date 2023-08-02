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
public class NhanVien {
    private String maNV;
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private String tenDangNhap;
    private String anh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String ngaySinh, String gioiTinh, String diaChi, String soDienThoai, String tenDangNhap,  String anh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tenDangNhap = tenDangNhap;
        this.anh = anh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
       public Connect cn = new Connect();
// lay san pham tu sql sang java
    public List<NhanVien> getNhanVien() throws SQLException {
        List<NhanVien> nhanvien = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";

        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNV");
                String ngaysinh = rs.getString("NgaySinh");
                String gioitinh = rs.getString("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SoDienThoai");
                String tdn = rs.getString("TenDangNhap");
                String img = rs.getString("Anh");

                NhanVien nv = new NhanVien(ma, ten,ngaysinh,gioitinh,diachi,sdt,tdn,img);
                nhanvien.add(nv);
            }
        } catch (SQLException e) {
            throw e;
        }
        return nhanvien;
    }
    // them du lieu 
    public boolean insertData(NhanVien obj) throws SQLException {
        String sql = "INSERT INTO NhanVien VALUES (?, ?,?,?,?,?,?,?)";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getMaNV());
            ps.setString(2, obj.getHoTen());
            ps.setString(3, obj.getNgaySinh());
            ps.setString(4, obj.getGioiTinh());
            ps.setString(5, obj.getDiaChi());
            ps.setString(6, obj.getSoDienThoai());
            ps.setString(7, obj.getTenDangNhap());
            ps.setString(8, obj.getAnh());
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
    // sua
    public boolean updateData(NhanVien obj) throws SQLException {
        String sql = "update NhanVien set TenNV= ? , NgaySinh= ?,GioiTinh=?,DiaChi=?,SoDienThoai=?,TenDangNhap=?,Anh=? where MaNV=?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {

            
            ps.setString(1, obj.getHoTen());
            ps.setString(2, obj.getNgaySinh());
            ps.setString(3, obj.getGioiTinh());
            ps.setString(4, obj.getDiaChi());
            ps.setString(5, obj.getSoDienThoai());
            ps.setString(6, obj.getTenDangNhap());
            ps.setString(7, obj.getAnh());
            ps.setString(8, obj.getMaNV());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return false;
    }
    public boolean deleteData(String ma) throws SQLException {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw e;          
        }
    }
    public List<NhanVien> searchData(String name) throws SQLException {
        List<NhanVien> nhanvien = new ArrayList<>();
        String sql = "select * from NhanVien where TenNV like ?";
        String like="%"+name+"%";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, like);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               
                String ma = rs.getString("MaNV");
                String ten = rs.getString("TenNV");
                String ngaysinh = rs.getString("NgaySinh");
                String gioitinh = rs.getString("GioiTinh");
                String diachi = rs.getString("DiaChi");
                String sdt = rs.getString("SoDienThoai");
                String tdn = rs.getString("TenDangNhap");
                String img = rs.getString("Anh");
                NhanVien nv = new NhanVien(ma, ten,ngaysinh,gioitinh,diachi,sdt,tdn,img);
                nhanvien.add(nv);
            }
        } catch (SQLException e) {
            throw e;          
        }
        return nhanvien;
    }
}
