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
public class CTHD {
    private String maHD;
    private String maSach;
    private int soLuong;
    private float tien;

    public CTHD() {
    }

    public CTHD(String maHD, String maSach, int soLuong, float tien) {
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.tien = tien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTien() {
        return tien;
    }

    public void setTien(float tien) {
        this.tien = tien;
    }
    public Connect cn=new Connect();
    public boolean insertData(CTHD obj) throws SQLException
    {
        String sql="INSERT INTO ChiTietHoaDon values(?,?,?,?)";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps =conn.prepareStatement(sql))
        {
            ps.setString(1,obj.getMaHD());
            ps.setString(2,obj.getMaSach());
            ps.setInt(3,obj.getSoLuong());
            ps.setFloat(4,obj.getTien());
            int row =ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        }catch(SQLException e){
            throw e;
        }
        return false;
    }
    public boolean updateData(CTHD obj) throws SQLException
    {
        String sql="Update ChiTietHoaDon set MaSach=?, SoLuong=?, Tien=? where MaHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps =conn.prepareStatement(sql))
        {
            ps.setString(1,obj.getMaSach());
            ps.setInt(2,obj.getSoLuong());
            ps.setFloat(3,obj.getTien());
            ps.setString(4,obj.getMaHD());
            int row =ps.executeUpdate();
            if(row>0)
            {
                return true;
            }
        }catch(SQLException e){
            throw e;
        }
        return false;
    }
}
