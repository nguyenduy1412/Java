/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ChucNangCon;
import Form.HeThong;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import Model.NhanVien;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.TaiKhoan;
/**
 *
 * @author ADMIN
 */
public final class QuanLyNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyNhanVien
     */
    private final NhanVien nv = new NhanVien();
    private final TaiKhoan tk = new TaiKhoan();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    String duongdananh="D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\nv.png";
    public QuanLyNhanVien() {
         try {
            initComponents();
            setLocationRelativeTo(null);
            String[] colsName={"Mã Nhân Viên","Tên Nhân Viên","Ngày Sinh","Giới Tính","Địa Chỉ","Số Điện Thoại","Tên Đăng Nhập","Ảnh"};
            tableModel.setColumnIdentifiers(colsName);
            tbNhanVien.setModel(tableModel);
            ShowData();
            setNull();
        } catch (SQLException ex){
             Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ShowData() throws SQLException{
        List<NhanVien> nhanvien= nv.getNhanVien();
        try {
            for (NhanVien a : nhanvien) {
                Object[] row={a.getMaNV(),a.getHoTen(),a.getNgaySinh(),a.getGioiTinh(),a.getDiaChi(),a.getSoDienThoai(),a.getTenDangNhap(),a.getAnh()};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            throw e;
        }
    }
      public void ClearData() throws SQLException{
        int n=tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
            tableModel.removeRow(i);
    }
     private void setNull()
    {
        this.txtMaNV.setText(null);
        this.txtHoTen.setText(null);
        this.txtDiaChi.setText(null);
        this.txtNgaySinh.setText(null);
        this.txtMatKhau.setText(null);
        this.txtTaiKhoan.setText(null);
        this.txtSDT.setText(null);
        rdNam.setSelected(true);
        lblAnh.setIcon(null);
    }
    private void setKhoa(boolean a)
    {
        this.txtMaNV.setEnabled(!a);
        this.txtTaiKhoan.setEnabled(!a);
    }
    private void setButton(boolean a)
    {
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(!a);
        this.btnSua.setEnabled(!a);
    }
    public ImageIcon ResizeImage(String ImagePath) 
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        int targetWidth = 124;
        int targetHeight = 155;
        Image newImg = img.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblAnh = new javax.swing.JLabel();
        btnTaiAnh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNhanVien = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 132, 148));

        btnTaiAnh.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\addimg.png")); // NOI18N
        btnTaiAnh.setText("Tải ảnh lên");
        btnTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiAnhActionPerformed(evt);
            }
        });
        getContentPane().add(btnTaiAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 530, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 25, -1, -1));

        jLabel2.setText("Mã NV");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 354, -1, -1));

        jLabel3.setText("Họ tên");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 412, -1, -1));

        jLabel4.setText("Ngày sinh");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 479, -1, -1));

        jLabel5.setText("Địa chỉ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 350, -1, -1));

        jLabel6.setText("Giới tính");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 539, -1, -1));

        jLabel7.setText("Số điện thoại");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 411, -1, -1));

        jLabel8.setText("Tên đăng nhập");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 478, -1, -1));

        jLabel9.setText("Mật khẩu");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 539, -1, -1));

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");
        getContentPane().add(rdNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 537, -1, -1));

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");
        getContentPane().add(rdNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 537, -1, -1));
        getContentPane().add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 351, 123, -1));
        getContentPane().add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 409, 123, -1));
        getContentPane().add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 476, 121, -1));
        getContentPane().add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 408, 152, -1));
        getContentPane().add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 475, 152, -1));
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 536, 152, -1));
        getContentPane().add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 347, 152, -1));

        tbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbNhanVien);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 68, 820, 200));

        btnLamMoi.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\lammoi.png")); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\addnv.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, -1, -1));

        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\update.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 90, 30));

        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\delete.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, 30));

        btnTim.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\search.png")); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        getContentPane().add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, 90, 30));
        getContentPane().add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 140, 30));

        btnThoat.setBackground(new java.awt.Color(255, 255, 204));
        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\home.png")); // NOI18N
        btnThoat.setText("Trang chủ");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\nen4.jpg")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaiAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiAnhActionPerformed
        // TODO add your handling code here:
        try
        {
            JFileChooser f=new JFileChooser("D:\\Documents\\HK2(2022-2023)\\Java\\Anh");
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File ftenanh=f.getSelectedFile();
            duongdananh = ftenanh.getAbsolutePath();
            if(duongdananh !=null)
            {
                lblAnh.setIcon(ResizeImage(String.valueOf(duongdananh)));
                System.out.println(duongdananh);
            }
            System.out.println("Bạn chưa chọn ảnh");
        }
        catch(Exception e)
        {
            System.out.println("Chưa chọn ảnh");
            System.out.println(duongdananh);
        }
    }//GEN-LAST:event_btnTaiAnhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         String ma=txtMaNV.getText();
         String ten=txtHoTen.getText();
         String ngaysinh=txtNgaySinh.getText();
         String gioitinh=(rdNam.isSelected())? "Nam":"Nữ";
         String diachi=txtDiaChi.getText();
         String sdt=txtSDT.getText();
         String tdn=txtTaiKhoan.getText();
         String img=duongdananh;
         String pass=txtMatKhau.getText();
         NhanVien nv1 = new NhanVien(ma, ten,ngaysinh,gioitinh,diachi,sdt,tdn,img);
        TaiKhoan tk1=new TaiKhoan(tdn,pass);
        try {
            if(!ma.isEmpty() && !ten.isEmpty() && !ngaysinh.isEmpty() && !gioitinh.isEmpty() &&!diachi.isEmpty() && !sdt.isEmpty() &&!tdn.isEmpty() && !img.isEmpty() &&!pass.isEmpty() )
            {
                if( tk.insertData(tk1))
                {
                     if(nv.insertData(nv1))
                    {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        btnLamMoi.doClick();
                        this.txtMaNV.requestFocus(null);
                    }
                     else
                    {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Không được để trống");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        setNull();
        setButton(true);
        setKhoa(false);
        try {      
            ClearData();
            ShowData();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNhanVienMouseClicked
        // TODO add your handling code here:
        setButton(false);
        setKhoa(true);
         int rowIndex = tbNhanVien.getSelectedRow();
         String ma= tbNhanVien.getValueAt(rowIndex, 0).toString();
         String ten= tbNhanVien.getValueAt(rowIndex, 1).toString();
         String ngaysinh= tbNhanVien.getValueAt(rowIndex, 2).toString();
         String gioitinh= tbNhanVien.getValueAt(rowIndex, 3).toString();
         String diachi= tbNhanVien.getValueAt(rowIndex, 4).toString();
         String sdt= tbNhanVien.getValueAt(rowIndex, 5).toString();
         String tdn= tbNhanVien.getValueAt(rowIndex, 6).toString();
         duongdananh= tbNhanVien.getValueAt(rowIndex, 7).toString();
         String pass=tk.getPass(tdn);
         //gán
         txtMaNV.setText(ma);
         txtHoTen.setText(ten);
         txtDiaChi.setText(diachi);
         txtNgaySinh.setText(ngaysinh);
         if(gioitinh.equals("Nam"))
         {
             rdNam.setSelected(true);
         }
         else
         {
             rdNu.setSelected(true);
         }
         txtSDT.setText(sdt);
         txtDiaChi.setText(diachi);
         txtTaiKhoan.setText(tdn);
         lblAnh.setIcon(ResizeImage(String.valueOf(duongdananh)));
         
         txtMatKhau.setText(pass);
    }//GEN-LAST:event_tbNhanVienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         String ma=txtMaNV.getText();
         String ten=txtHoTen.getText();
         String ngaysinh=txtNgaySinh.getText();
         String gioitinh=(rdNam.isSelected())? "Nam":"Nữ";
         String diachi=txtDiaChi.getText();
         String sdt=txtSDT.getText();
         String tdn=txtTaiKhoan.getText();
         String img=duongdananh;
         String pass=txtMatKhau.getText();
         TaiKhoan tk1=new TaiKhoan(tdn, pass);
         NhanVien nv1 = new NhanVien(ma, ten,ngaysinh,gioitinh,diachi,sdt,tdn,img);
         try {
            if(!ma.isEmpty() && !tdn.isEmpty())
            {
                if(tk.updateData(tk1) && nv.updateData(nv1))
                {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    btnLamMoi.doClick();
                    this.txtMaNV.requestFocus(null);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Không được để trống");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma=txtMaNV.getText();
        String tdn=txtTaiKhoan.getText();
        try {
            // TODO add your handling code here:
            NhanVien nv1=new NhanVien();
            TaiKhoan tk1=new TaiKhoan();
            
            if(nv1.deleteData(ma) && tk1.deleteData(tdn))
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                btnLamMoi.doClick();
                this.txtMaNV.requestFocus(null);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String ten=txtTim.getText();
        System.out.println(ten);
        
        try {
            ClearData();
            List<NhanVien> nhanvien= nv.searchData(ten);
            System.out.println(nhanvien.size());
            for (NhanVien a : nhanvien) {
                
                Object[] row={a.getMaNV(),a.getHoTen(),a.getNgaySinh(),a.getGioiTinh(),a.getDiaChi(),a.getSoDienThoai(),a.getTenDangNhap(),a.getAnh()};
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        HeThong frm=new HeThong();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed
      
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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaiAnh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
