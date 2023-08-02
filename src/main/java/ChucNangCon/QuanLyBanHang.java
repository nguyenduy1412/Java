/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ChucNangCon;
import Form.HeThong;
import Model.CTHoaDon;
import Model.ListMaSachNV;

import Model.NhanVien;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
import Database.Connect;
import Model.CTHD;
import Model.DSSP;
import Model.HoaDon;
import Model.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public final class QuanLyBanHang extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNhanVien
     */
    Connect cn=new Connect();
    private final CTHoaDon ct=new CTHoaDon();
    private final HoaDon hd=new HoaDon();
    private final CTHD cthd=new CTHD();
    private final KhachHang kh=new KhachHang();
    private final ListMaSachNV lms=new ListMaSachNV();
    private final DSSP ds=new DSSP();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private final DefaultTableModel tableMode2 = new DefaultTableModel();
    public QuanLyBanHang() {
         try {
            initComponents();
            setLocationRelativeTo(null);
            String[] colsName={"Mã Hóa Đơn","Mã Khách","Tên Khách","Mã Nhân Viên","Mã Sách","Số Lượng","Ngày Lập","Tiền"};
            tableModel.setColumnIdentifiers(colsName);
            tbBanHang.setModel(tableModel);
            ShowData();
            getDataSachNV();
        } catch (SQLException ex){
             Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ShowData() throws SQLException{
        List<CTHoaDon> cthoadon= ct.getCTHoaDon();
        try {
            for (CTHoaDon a : cthoadon) {
                Object[] row={a.getMaHD(),a.getMaKhach(),a.getTenKhach(),a.getMaNV(),a.getMaSach(),a.getSoLuong(),a.getNgayLap(),a.getThanhTien()};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            throw e;
        }
    }
     public void ShowData1(String name) throws SQLException{
        List<CTHoaDon> cthoadon= ct.getData(name);
        try {
            for (CTHoaDon a : cthoadon) {
                Object[] row={a.getMaHD(),a.getMaKhach(),a.getTenKhach(),a.getMaNV(),a.getMaSach(),a.getSoLuong(),a.getNgayLap(),a.getThanhTien()};
                tableModel.addRow(row);
            }
        }catch (Exception e) {
            throw e;
        }
    }
    public void getDataSachNV() throws SQLException
    {
        List<String> lst1 =lms.getDataSach();
        cmbMaSach.removeAllItems();
        for (String a : lst1) {
              cmbMaSach.addItem(a);
        }
        List<String> lst2 =lms.getDataNV();
        cmbMaNV.removeAllItems();
        for (String a : lst2) {
              cmbMaNV.addItem(a);
        }
    }
    public void ClearData() throws SQLException{
        int n=tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
            tableModel.removeRow(i);
    }
     public void ClearData1() throws SQLException{
        int n=tableMode2.getRowCount()-1;
        for(int i=n;i>=0;i--)
            tableMode2.removeRow(i);
    }
     private void setNull()
    {
        this.txtMaHD.setText(null);
        this.txtMaKhach.setText(null);
        this.txtNgayLap.setText(null);
        this.txtSoLuong.setText("0");
        this.txtTenKhach.setText(null);
        this.txtThanhTien.setText("0");   
    }
   
    private void setButton(boolean a)
    {
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(!a);
        this.btnSua.setEnabled(!a);
        this.txtMaKhach.setEnabled(a);
        this.txtTenKhach.setEnabled(true);
        this.txtNgayLap.setEnabled(true);
    }
    public void updateThanhTien(String mahd) 
    {
        Float tong=hd.getTien(mahd);
        try {
            hd.updateTien(tong, mahd);
        } catch (SQLException e) {
            
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaKhach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        txtTenKhach = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBanHang = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cmbMaSach = new javax.swing.JComboBox<>();
        cmbMaNV = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        txtMAHD = new javax.swing.JTextField();
        txtMAKHACH = new javax.swing.JTextField();
        txtTENKHACH = new javax.swing.JTextField();
        txtNGAYMUA = new javax.swing.JTextField();
        txtMANV = new javax.swing.JTextField();
        txtTienTra = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("THÔNG TIN BÁN HÀNG");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel3.setText("Mã hóa đơn");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel4.setText("Mã khách");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel5.setText("Mã sách");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jLabel6.setText("Tên khách");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, 20));

        jLabel7.setText("Số lượng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, -1));

        jLabel8.setText("Ngày lập");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, -1, -1));

        jLabel9.setText("Thành tiền");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

        txtMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHDKeyReleased(evt);
            }
        });
        getContentPane().add(txtMaHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 123, -1));

        txtMaKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKhachKeyReleased(evt);
            }
        });
        getContentPane().add(txtMaKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 121, -1));

        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });
        getContentPane().add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 134, -1));
        getContentPane().add(txtNgayLap, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 134, -1));

        btnLamMoi.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\lammoi.png")); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 30));

        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\addbill.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 100, 30));

        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\update.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 90, 30));

        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\delete.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 80, 30));

        btnTim.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\search.png")); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        getContentPane().add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 100, 30));
        getContentPane().add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 110, 30));

        btnBack.setBackground(new java.awt.Color(255, 255, 204));
        btnBack.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\home.png")); // NOI18N
        btnBack.setText("Trang chủ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));
        getContentPane().add(txtTenKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 121, -1));

        txtThanhTien.setEnabled(false);
        getContentPane().add(txtThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 134, -1));

        tbBanHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbBanHang.setToolTipText("");
        tbBanHang.setGridColor(new java.awt.Color(255, 255, 255));
        tbBanHang.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tbBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBanHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbBanHang);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel11.setText("Mã nhân viên");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, -1, -1));

        cmbMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMaSachActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 134, -1));

        getContentPane().add(cmbMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 121, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\n2.jpg")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("THÔNG TIN HÓA ĐƠN");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, 20));

        jLabel13.setText("Mã hóa đơn");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel14.setText("Mã hóa đơn:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, -1));

        jLabel15.setText("Mã khách:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        jLabel16.setText("Tên khách:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        jLabel17.setText("Ngày mua:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, -1));

        jLabel18.setText("Tiền khách phải trả:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, -1, -1));

        jLabel20.setText("Nhân viên bán hàng:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, -1, -1));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên Sách", "Giá", "Số Lượng", "Tổng"
            }
        ));
        tbHoaDon.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jScrollPane2.setViewportView(tbHoaDon);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 410, 80));

        txtMAHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMAHDKeyReleased(evt);
            }
        });
        getContentPane().add(txtMAHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 260, -1));
        getContentPane().add(txtMAKHACH, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 260, -1));
        getContentPane().add(txtTENKHACH, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 260, -1));
        getContentPane().add(txtNGAYMUA, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, 260, -1));
        getContentPane().add(txtMANV, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, 260, -1));
        getContentPane().add(txtTienTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 260, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\n1.jpg")); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 510, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            String mahd=txtMaHD.getText();
            String makhach=txtMaKhach.getText();
            String tenkhach=txtTenKhach.getText();
            String manv = (String) cmbMaNV.getSelectedItem();
            String masach = (String) cmbMaSach.getSelectedItem();
            String ngaylap=txtNgayLap.getText();
            int soluong=Integer.parseInt(txtSoLuong.getText());
            float thanhtien=Float.parseFloat(txtThanhTien.getText());
            CTHD cthd1=new CTHD(mahd,masach,soluong,thanhtien);
            HoaDon hd1=new HoaDon(mahd,manv,ngaylap,thanhtien,makhach);
            KhachHang kh1=new KhachHang(makhach,tenkhach);
            if(!mahd.isEmpty() && !makhach.isEmpty() && !manv.isEmpty() && !masach.isEmpty() && !ngaylap.isEmpty() && !txtSoLuong.getText().isEmpty() && !tenkhach.isEmpty())
            {
                // nghĩa là đã có mã hóa đơn rồi thì thêm cthd
                if(!txtNgayLap.isEnabled())
                {
                    if(cthd.insertData(cthd1) )
                    {
                        updateThanhTien(mahd);
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        btnLamMoi.doClick();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                //chưa có hd 
                else
                {
                    //kiểm tra xem có khách hàng chưa
                   if(txtTenKhach.isEnabled())
                   {
                       if(kh.insertData(kh1) &&hd.insertData(hd1) && cthd.insertData(cthd1) )
                       {
                           updateThanhTien(mahd);
                           JOptionPane.showMessageDialog(this, "Thêm thành công");
                            btnLamMoi.doClick();
                       }
                       else{
                           JOptionPane.showMessageDialog(this, "Thêm thất bại");
                       }
                   }
                   else
                   {
                       if(hd.insertData(hd1) && cthd.insertData(cthd1))
                       {
                           updateThanhTien(mahd);
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                            btnLamMoi.doClick();
                       }
                       else{
                            JOptionPane.showMessageDialog(this, "Thêm thất bại");
                       }
                   }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Không được để trống");
            }
        } 
         catch (Exception e) {
             System.out.println(e);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        setNull();
        setButton(true);
        txtMaHD.setEnabled(true);
        try {      
            ClearData();
            ShowData();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tbBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBanHangMouseClicked
        // TODO add your handling code here:
        setButton(false);
        txtMaHD.setEnabled(false);
        cmbMaNV.setEnabled(true);
         int rowIndex = tbBanHang.getSelectedRow();
         String mahd= tbBanHang.getValueAt(rowIndex, 0).toString();
         String makhach= tbBanHang.getValueAt(rowIndex, 1).toString();
         String tenkhach= tbBanHang.getValueAt(rowIndex, 2).toString();
         String manv= tbBanHang.getValueAt(rowIndex, 3).toString();
         String masach= tbBanHang.getValueAt(rowIndex, 4).toString();
         String soluong= tbBanHang.getValueAt(rowIndex, 5).toString();
         String ngaylap= tbBanHang.getValueAt(rowIndex, 6).toString();
         String tien= tbBanHang.getValueAt(rowIndex, 7).toString();
         //gán
         txtMaHD.setText(mahd);
         txtMaKhach.setText(makhach);
         txtTenKhach.setText(tenkhach);
         cmbMaNV.setSelectedItem(manv);
         cmbMaSach.setSelectedItem(masach);
         txtSoLuong.setText(soluong);
         txtNgayLap.setText(ngaylap);
         txtThanhTien.setText(tien);
    }//GEN-LAST:event_tbBanHangMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         try {
            String mahd=txtMaHD.getText();
            String makhach=txtMaKhach.getText();
            String tenkhach=txtTenKhach.getText();
            String manv = (String) cmbMaNV.getSelectedItem();
            String masach = (String) cmbMaSach.getSelectedItem();
            String ngaylap=txtNgayLap.getText();
            int soluong=Integer.parseInt(txtSoLuong.getText());
            float thanhtien=Float.parseFloat(txtThanhTien.getText());
            CTHD cthd1=new CTHD(mahd,masach,soluong,thanhtien);
            HoaDon hd1=new HoaDon(mahd,manv,ngaylap,thanhtien,makhach);
            KhachHang kh1=new KhachHang(makhach,tenkhach);
            if(hd.updateData(hd1) &&kh.updateData(kh1) && cthd.updateData(cthd1))
            {
                updateThanhTien(mahd);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                btnLamMoi.doClick();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        } 
         catch (Exception e) {
             System.out.println(e);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma=txtMaHD.getText();
        try {
            HoaDon hd1=new HoaDon();
            if(hd1.deleteData(ma))
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                btnLamMoi.doClick();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (Exception e) {
            
        }
        
        
        
       
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        
        String tenkhach=txtTim.getText();
        String[] colsName={"Mã Hóa Đơn","Mã Khách","Tên Khách","Mã Nhân Viên","Mã Sách","Số Lượng","Ngày Lập","Tiền"};
            tableModel.setColumnIdentifiers(colsName);
            tbBanHang.setModel(tableModel);
            
        try {
            ClearData();
            ShowData1(tenkhach);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnTimActionPerformed
    public void getDataDSSP(String ma) throws SQLException{
        
        List<DSSP> dssp= ds.getData(ma);
        try {
            for (DSSP a : dssp) {
                Object[] row={a.getTenSach() ,a.getGia(),a.getSoLuong(),a.getTong()};
                tableMode2.addRow(row);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        // TODO add your handling code here:
         String masach = (String) cmbMaSach.getSelectedItem();
        float gia=0;
        String sql="Select Sach.Gia from Sach where MaSach=?";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, masach);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia = rs.getFloat("Gia");
            }
            int soluong=0;
            soluong=Integer.parseInt(txtSoLuong.getText());
            gia=gia*soluong;
            txtThanhTien.setText(Float.toString(gia));
        } catch (SQLException e) {
             System.out.println(e);;          
        }
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void cmbMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMaSachActionPerformed
        // TODO add your handling code here:
        String masach = (String) cmbMaSach.getSelectedItem();
        float gia=0;
        String sql="Select Sach.Gia from Sach where MaSach=?";
        try (Connection conn = cn.connectSQL(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, masach);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia = rs.getFloat("Gia");
            }
            int soluong=0;
            try {
                if(txtSoLuong.getText().isEmpty())
                {
                    soluong=0;
                }
                else
                {
                    soluong=Integer.parseInt(txtSoLuong.getText());
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            gia=gia*soluong;
            txtThanhTien.setText(Float.toString(gia));
        } catch (SQLException e) {
             System.out.println(e);        
        }
    }//GEN-LAST:event_cmbMaSachActionPerformed

    private void txtMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHDKeyReleased
        // TODO add your handling code here:
         String mahd=txtMaHD.getText();
        String sql="select HoaDon.*,KhachHang.tenkhach from HoaDon,KhachHang where HoaDon.makhach=KhachHang.makhach and mahd=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                txtMaKhach.setText(rs.getString("MaKhach")) ;
                txtTenKhach.setText(rs.getString("TenKhach"));
                txtNgayLap.setText(rs.getString("NgayLap"));
                cmbMaNV.setSelectedItem(rs.getString("MaNV"));
                txtMaKhach.setEnabled(false);
                txtTenKhach.setEnabled(false);
                txtNgayLap.setEnabled(false);
                cmbMaNV.setEnabled(false);
            }
            else
            {
                txtMaKhach.setEnabled(true);
                txtTenKhach.setEnabled(true);
                txtNgayLap.setEnabled(true);
                txtMaKhach.setText("");
                txtTenKhach.setText("");
                txtNgayLap.setText("");
                cmbMaNV.setEnabled(true);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_txtMaHDKeyReleased

    private void txtMaKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKhachKeyReleased
        // TODO add your handling code here:
        String makhach=txtMaKhach.getText();
        String sql="select TenKhach from KhachHang where MaKhach=?";
          try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, makhach);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                txtTenKhach.setText(rs.getString("TenKhach"));
                txtTenKhach.setEnabled(false);
            }
            else
            {
                txtTenKhach.setEnabled(true);
                txtTenKhach.setText("");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_txtMaKhachKeyReleased

    private void txtMAHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMAHDKeyReleased
        // TODO add your handling code here:
        String mahd=txtMAHD.getText();
        String sql="SELECT HoaDon.*,KhachHang.TenKhach from HoaDon,KhachHang where HoaDon.makhach=KhachHang.MaKhach and MaHD=?";
        try(Connection conn=cn.connectSQL(); PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                txtMAKHACH.setText(rs.getString("MaKhach"));
                txtTENKHACH.setText(rs.getString("TenKhach"));
                txtNGAYMUA.setText(rs.getString("NgayLap"));
                txtMANV.setText(rs.getString("MaNV"));
                Float tien=rs.getFloat("ThanhTien");
                txtTienTra.setText(tien.toString());
                String[] colsName={"Tên Sách","Giá","Số lượng","Tổng"};    
                tableMode2.setColumnIdentifiers(colsName);
                tbHoaDon.setModel(tableMode2);
                ClearData1();
                getDataDSSP(mahd);   
            }
            else{
                txtTENKHACH.setText("");
                txtNGAYMUA.setText("");
                txtMANV.setText("");
                ClearData1();
            }
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_txtMAHDKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        HeThong frm=new HeThong();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBanHang().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbMaNV;
    private javax.swing.JComboBox<String> cmbMaSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbBanHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtMAHD;
    private javax.swing.JTextField txtMAKHACH;
    private javax.swing.JTextField txtMANV;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKhach;
    private javax.swing.JTextField txtNGAYMUA;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTENKHACH;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienTra;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
