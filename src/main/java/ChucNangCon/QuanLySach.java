/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ChucNangCon;



import Form.HeThong;
import Model.NhanVien;
import Model.Sach;
import Model.TaiKhoan;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ADMIN
 */
public final class QuanLySach extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySach
     */
    private final Sach sach = new Sach();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    String duongdananh="";
    public QuanLySach() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            String[] colsName={"Mã Sách","Tên Sách","Tác giả","Thể loại","Năm xuất bản","Nhà xuất bản","Giá","Ảnh","Ngày nhập"};
            tableModel.setColumnIdentifiers(colsName);
            tbSach.setModel(tableModel);
            ShowData();
            setNull();
            
        } catch (SQLException ex){
             Logger.getLogger(Sach.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
     public void ShowData() throws SQLException{
        List<Sach> listsach= sach.getData();
        try {
            for (Sach a : listsach) {
                 Object[] row={a.getMaSach(),a.getTenSach(),a.getTacGia(),a.getTheLoai(),a.getNamXB(),a.getNhaXB(),a.getGia(),a.getAnh(),a.getNgayNhap()};
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
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        int targetWidth = 124;
        int targetHeight = 155;
        Image newImg = img.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
}
    private void setNull()
    {
        this.txtMaSach.setText(null);
        this.txtTenSach.setText(null);
        this.txtTacGia.setText(null);
        this.txtTheLoai.setText(null);
        
        this.txtNamXB.setText(null);
        this.txtNhaXB.setText(null);
        this.txtGia.setText(null);
        lblAnh.setIcon(null);
    }
    private void setKhoa(boolean a)
    {
        this.txtMaSach.setEnabled(!a);
    }
    private void setButton(boolean a)
    {
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(!a);
        this.btnSua.setEnabled(!a);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAnh = new javax.swing.JLabel();
        txtTaiAnh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        txtNamXB = new javax.swing.JTextField();
        txtNhaXB = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSach);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 75, 819, 199));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("THÔNG TIN SÁCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 21, 166, 36));

        btnLamMoi.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\lammoi.png")); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        btnThem.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\addbook.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        btnSua.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\update.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, -1));

        btnXoa.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\delete.png")); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setEnabled(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        btnTim.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\search.png")); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });
        getContentPane().add(btnTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, -1));
        getContentPane().add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 197, 30));

        jLabel3.setText("Mã Sách");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 351, -1, -1));

        jLabel4.setText("Tên Sách");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 411, -1, -1));

        jLabel5.setText("Tác giả");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 464, -1, -1));

        jLabel6.setText("Thể loại");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 351, -1, -1));
        getContentPane().add(txtMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 348, 152, -1));

        jLabel7.setText("Năm xuất bản");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 411, -1, -1));

        jLabel8.setText("Nhà xuất bản");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 464, -1, -1));

        lblAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 348, 124, 150));

        txtTaiAnh.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\addimg.png")); // NOI18N
        txtTaiAnh.setText("Tải ảnh lên");
        txtTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiAnhActionPerformed(evt);
            }
        });
        getContentPane().add(txtTaiAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, -1, -1));

        jLabel9.setText("Giá");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 515, -1, -1));
        getContentPane().add(txtTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 408, 152, -1));
        getContentPane().add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 461, 152, -1));
        getContentPane().add(txtTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 348, 137, -1));
        getContentPane().add(txtNamXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 408, 137, -1));
        getContentPane().add(txtNhaXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 461, 137, -1));
        getContentPane().add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 512, 152, -1));

        btnThoat.setBackground(new java.awt.Color(255, 255, 204));
        btnThoat.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\home.png")); // NOI18N
        btnThoat.setText("Trang chủ");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel10.setText("Ngày nhập");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 515, -1, -1));
        getContentPane().add(txtNgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 512, 137, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\Documents\\HK2(2022-2023)\\Java\\Anh\\nen5.jpg")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTaiAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTaiAnhActionPerformed
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
    }//GEN-LAST:event_txtTaiAnhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:        
        String ma=txtMaSach.getText();
        String ten=txtTenSach.getText();
        String tacgia=txtTacGia.getText();
        String theloai=txtTheLoai.getText();
        int namxb=Integer.parseInt(txtNamXB.getText());
        String nhaxb=txtNhaXB.getText();
        float tien=Float.parseFloat(txtGia.getText());
        String img=duongdananh;
        String ngaynhap=txtNgayNhap.getText();
        Sach a = new Sach(ma, ten,tacgia,theloai,namxb,nhaxb,tien,img,ngaynhap);
        try {
            if(!ma.isEmpty() )
            {
                if(sach.insertData(a) )
                {
                    Object[] row={a.getMaSach(),a.getTenSach(),a.getTacGia(),a.getTheLoai(),a.getNamXB(),a.getNhaXB(),a.getGia(),a.getAnh(),a.getNgayNhap()};
                    tableModel.addRow(row);
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    this.txtMaSach.requestFocus(null);
                    btnLamMoi.doClick();
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
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tbSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSachMouseClicked
        // TODO add your handling code here:
        setButton(false);
        setKhoa(true);
         int rowIndex = tbSach.getSelectedRow();
         String ma= tbSach.getValueAt(rowIndex, 0).toString();
         String ten= tbSach.getValueAt(rowIndex, 1).toString();
         String tacgia= tbSach.getValueAt(rowIndex, 2).toString();
         String theloai= tbSach.getValueAt(rowIndex, 3).toString();
         String nam= tbSach.getValueAt(rowIndex, 4).toString();
         String nhaxb= tbSach.getValueAt(rowIndex, 5).toString();
         String tien= tbSach.getValueAt(rowIndex, 6).toString();
         duongdananh= tbSach.getValueAt(rowIndex, 7).toString();
         String ngaynhap= tbSach.getValueAt(rowIndex, 8).toString();
         //gán
         txtMaSach.setText(ma);
         txtTenSach.setText(ten);
         txtTacGia.setText(tacgia);
         txtTheLoai.setText(theloai);
         txtNamXB.setText(nam);
         txtNhaXB.setText(nhaxb);
         txtGia.setText(tien);
         lblAnh.setIcon(ResizeImage(String.valueOf(duongdananh)));
         txtNgayNhap.setText(ngaynhap);
    }//GEN-LAST:event_tbSachMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        HeThong frm=new HeThong();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String ma=txtMaSach.getText();
        String ten=txtTenSach.getText();
        String tacgia=txtTacGia.getText();
        String theloai=txtTheLoai.getText();
        int namxb=Integer.parseInt(txtNamXB.getText());
        String nhaxb=txtNhaXB.getText();
        float tien=Float.parseFloat(txtGia.getText());
        String img=duongdananh;
        String ngaynhap=txtNgayNhap.getText();
        Sach a = new Sach(ma, ten,tacgia,theloai,namxb,nhaxb,tien,img,ngaynhap);
         try {
            if(!ma.isEmpty())
            {
                if(sach.updateData(a))
                {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    btnLamMoi.doClick();
                    this.txtMaSach.requestFocus(null);
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
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma=txtMaSach.getText();
        try {
            // TODO add your handling code here:
            Sach s1=new Sach();
            if(s1.deleteData(ma))
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                btnLamMoi.doClick();
                this.txtMaSach.requestFocus(null);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String tl=txtTim.getText();
        System.out.println(tl);
        
        try {
            ClearData();
            List<Sach> listsach= sach.searchData(tl);
            for (Sach a : listsach) {
                
                Object[] row={a.getMaSach(),a.getTenSach(),a.getTacGia(),a.getTheLoai(),a.getNamXB(),a.getNhaXB(),a.getGia(),a.getAnh(),a.getNgayNhap()};
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTable tbSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNamXB;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtNhaXB;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JButton txtTaiAnh;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}