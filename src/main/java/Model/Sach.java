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
public class Sach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private int namXB;
    private String nhaXB;
    private float gia;
    private String anh;
    private String ngayNhap;
    public Sach() {
    }

    public Sach(String maSach, String tenSach, String tacGia, String theLoai, int namXB, String nhaXB, float gia, String anh,String ngayNhap) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.namXB = namXB;
        this.nhaXB = nhaXB;
        this.gia = gia;
        this.anh = anh;
        this.ngayNhap=ngayNhap;
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

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public Connect cn = new Connect();
    public List<Sach> getData() throws SQLException {
        List<Sach> sach = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) 
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                String ma = rs.getString("MaSach");
                String ten = rs.getString("TenSach");
                String tacgia = rs.getString("TacGia");
                String theloai = rs.getString("TheLoai");
                int namxb = rs.getInt("NamXB");
                String nhaxb = rs.getString("NhaXB");
                float tien = rs.getFloat("Gia");      
                String img=rs.getString("Anh");
                String ngaynhap = rs.getString("NgayNhap");
                Sach s = new Sach(ma, ten,tacgia,theloai,namxb,nhaxb,tien,img,ngaynhap);
                sach.add(s);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sach;
    }
    public boolean insertData(Sach obj) throws SQLException 
    {
        String sql = "INSERT INTO Sach VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getMaSach());
            ps.setString(2, obj.getTenSach());
            ps.setString(3, obj.getTacGia());
            ps.setString(4, obj.getTheLoai());
            ps.setInt(5, obj.getNamXB());
            ps.setString(6, obj.getNhaXB());
            ps.setFloat(7, obj.getGia());
            ps.setString(8, obj.getAnh());
            ps.setString(9, obj.getNgayNhap());
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
        public boolean updateData(Sach obj) throws SQLException {
        String sql = "update Sach set TenSach= ? , TacGia= ?,TheLoai=?,NamXB=?,NhaXB=?,Gia=?,Anh=?,NgayNhap=? where MaSach=?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps= conn.prepareStatement(sql)) {
            ps.setString(1, obj.getTenSach());
            ps.setString(2, obj.getTacGia());
            ps.setString(3, obj.getTheLoai());
            ps.setInt(4, obj.getNamXB());
            ps.setString(5, obj.getNhaXB());
            ps.setFloat(6, obj.getGia());
            ps.setString(7, obj.getAnh());
            ps.setString(8, obj.getNgayNhap());
            ps.setString(9, obj.getMaSach());
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
        String sql = "DELETE FROM Sach WHERE MaSach = ?";

        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ma);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw e;          
        }
    }
    public List<Sach> searchData(String tl) throws SQLException {
        List<Sach> sach = new ArrayList<>();
        String sql = "select * from Sach where TheLoai like ?";
        String like="%"+tl+"%";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, like);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("MaSach");
                String ten = rs.getString("TenSach");
                String tacgia = rs.getString("TacGia");
                String theloai = rs.getString("TheLoai");
                int namxb = rs.getInt("NamXB");
                String nhaxb = rs.getString("NhaXB");
                float tien = rs.getFloat("Gia");      
                String img=rs.getString("Anh");
                String ngaynhap = rs.getString("NgayNhap");
                Sach s = new Sach(ma, ten,tacgia,theloai,namxb,nhaxb,tien,img,ngaynhap);
                sach.add(s);
            }
        } catch (SQLException e) {
            throw e;          
        }
        return sach;
    }
}
