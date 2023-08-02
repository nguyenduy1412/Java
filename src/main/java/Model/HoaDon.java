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
public class HoaDon {
    private String maHD;
    private String maNV;
    private String ngayLap;
    private float thanhTien;
    private String maKhach;

    public HoaDon() {
    }

    public HoaDon(String maHD, String maNV, String ngayLap, float thanhTien, String maKhach) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.thanhTien = thanhTien;
        this.maKhach = maKhach;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(String maKhach) {
        this.maKhach = maKhach;
    }
    public Connect cn =new Connect();
    public List<HoaDon> getData() throws SQLException {
        List<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String manv = rs.getString("MaNV");
                String ngaylap = rs.getString("NgayLap");
                Float thanhtien = rs.getFloat("ThanhTien");
                String makhach = rs.getString("MaKhach");
                HoaDon hd = new HoaDon(mahd,manv,ngaylap,thanhtien,makhach);
                lst.add(hd);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }
     public List<HoaDon> getData(int thang,int nam) throws SQLException {
        List<HoaDon> lst = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon where MONTH(NgayLap) =? and YEAR(NgayLap)=? ";
        try (Connection conn = cn.connectSQL();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("MaHD");
                String manv = rs.getString("MaNV");
                String ngaylap = rs.getString("NgayLap");
                Float thanhtien = rs.getFloat("ThanhTien");
                String makhach = rs.getString("MaKhach");
                HoaDon hd = new HoaDon(mahd,manv,ngaylap,thanhtien,makhach);
                lst.add(hd);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lst;
    }
    public boolean insertData(HoaDon obj) throws SQLException{
        String sql="Insert into HoaDon VALUES(?,?,?,?,?)";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, obj.getMaHD());
            ps.setString(2, obj.getMaNV());
            ps.setString(3, obj.getNgayLap());
            ps.setFloat(4, obj.getThanhTien());
            ps.setString(5, obj.getMaKhach());
            int row=ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        } 
        catch (Exception e) {
            throw e;
        }
        return false;
    }
    public boolean updateData(HoaDon obj) throws SQLException{
        String sql="Update HoaDon set MaNV=?, NgayLap=? ,ThanhTien=?, MaKhach=? where MaHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, obj.getMaNV());
            ps.setString(2, obj.getNgayLap());
            ps.setFloat(3, obj.getThanhTien());
            ps.setString(4, obj.getMaKhach());
            ps.setString(5, obj.getMaHD());
            int row=ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        } 
        catch (Exception e) {
            throw e;
        }
        return false;
    }
    public boolean deleteData(String mahd) throws SQLException{
        String sql="delete HoaDon where MaHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, mahd);
            int row=ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            throw e;
        }
        return false;
    }
    public boolean updateTien(float tien,String ma) throws SQLException{
        String sql="Update HoaDon set ThanhTien=? where MaHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setFloat(1, tien);
            ps.setString(2, ma);
            int row=ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        } 
        catch (Exception e) {
            throw e;
        }
        return false;
    }
    public float getTien(String mahd)
    {
        float tien=0;
        String sql="select  SUM(Tien) as TongTien FROM SACH,ChiTietHoaDon where Sach.MaSach=ChiTietHoaDon.MaSach and MAHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, mahd);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                tien=rs.getFloat("TongTien");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return tien;
    }
    
}
