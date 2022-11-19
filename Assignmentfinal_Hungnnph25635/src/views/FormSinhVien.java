package views;

import models.SinhVien;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import services.SinhVienService;
import java.awt.Color;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilis.Validation;


public class FormSinhVien extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private SinhVienService sinhVienService;
    private ButtonGroup group = new ButtonGroup();
    private String hinhAnhStr = null;

    public FormSinhVien() {
        initComponents();
        this.sinhVienService = new SinhVienService();
        loadTable();
        Icon();
        gioiTinh();
    }

    public void gioiTinh() {
        group.add(rd_nu);
        group.add(rd_nam);
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_sinhvien.getModel();
        defaultTableModel.setRowCount(0);

        for (SinhVien sv : this.sinhVienService.getData()) {
            defaultTableModel.addRow(new Object[]{
                sv.getId(),
                sv.getMaSV(),
                sv.getTen(),
                sv.getEmail(),
                sv.getSDT(),
                sv.getGioiTinh()==1?"Nam":"Nữ",
                sv.getDiaChi(),
                sv.getHinhAnh()
            });
        }
    }

    public void Icon() {
        Icon iconSave = new ImageIcon("D:\\FPT_Polytechnic\\Java3\\Assignment_Hungnnph25635\\src\\image\\save.png");
        this.btn_save.setIcon(iconSave);
        Icon iconNew = new ImageIcon("D:\\FPT_Polytechnic\\Java3\\Assignment_Hungnnph25635\\src\\image\\plus.png");
        this.btn_new.setIcon(iconNew);
        Icon iconDelete = new ImageIcon("D:\\FPT_Polytechnic\\Java3\\Assignment_Hungnnph25635\\src\\image\\delete.png");
        this.btn_delete.setIcon(iconDelete);
        Icon iconUpdate = new ImageIcon("D:\\FPT_Polytechnic\\Java3\\Assignment_Hungnnph25635\\src\\image\\exchange.png");
        this.btn_update.setIcon(iconUpdate);
    }

    private Boolean ValidateForm() {
        if (!Validation.isEmpty(txt_masv, "Ma sinh vien ko dc de trong", "ERROR", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmpty(txt_hoten, "Ho ten sinh vien ko dc de trong", "ERROR", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmpty(txt_email, "Email sinh vien ko dc de trong", "ERROR", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmail(txt_email, "Email sai dinh dang", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmpty(txt_sodt, "So dien thoai sinh vien ko dc de trong", "ERROR", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isSDT(txt_sodt, "So dien thoai khong dung dinh dang", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (rd_nam.isSelected() == false && rd_nu.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Gioi tinh ko dc trong", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (txa_diachi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Dia chi ko dc trong", "ERROR", JOptionPane.ERROR_MESSAGE);
            txa_diachi.setBackground(Color.red);
            return false;
        } else {
            txa_diachi.setBackground(Color.white);
        }

        return true;
    }

    public SinhVien getFormdata() {
        String masv = txt_masv.getText().trim();
        String tensv = txt_hoten.getText().trim();
        String email = txt_email.getText().trim();
        String sdt = txt_sodt.getText().trim();

        String diachi = txa_diachi.getText().trim();
        SinhVien sv = new SinhVien(WIDTH, masv, tensv, email, sdt, ABORT, diachi, hinhAnhStr);
        if(rd_nam.isSelected()){
            sv.setGioiTinh(1);
        }else{
            sv.setGioiTinh(0);
        }
        if(masv.length()==0){
            JOptionPane.showMessageDialog(this, "Du lieu ko dc de trong");
            return null;
        }
        sv.setHinhAnh(hinhAnhStr);

        return sv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sodt = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_diachi = new javax.swing.JTextArea();
        lbl_image = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_sinhvien = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lí Sinh Viên\n");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lí Sinh Viên");

        jLabel2.setText("MaSV:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới tính:");

        jLabel7.setText("Địa chỉ: ");

        rd_nam.setText("Nam");

        rd_nu.setText("Nữ");

        txa_diachi.setColumns(20);
        txa_diachi.setRows(5);
        jScrollPane1.setViewportView(txa_diachi);

        lbl_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imageMouseClicked(evt);
            }
        });

        lbl_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lbl_imageLayout = new javax.swing.GroupLayout(lbl_image);
        lbl_image.setLayout(lbl_imageLayout);
        lbl_imageLayout.setHorizontalGroup(
            lbl_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        lbl_imageLayout.setVerticalGroup(
            lbl_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_imageLayout.createSequentialGroup()
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        tb_sinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "MãSV", "Họ tên", "Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"
            }
        ));
        tb_sinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sinhvienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_sinhvien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_delete)
                            .addComponent(btn_new))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_update)
                            .addComponent(btn_save))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_masv)
                            .addComponent(txt_hoten)
                            .addComponent(txt_email)
                            .addComponent(txt_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(rd_nam)
                                .addGap(17, 17, 17)
                                .addComponent(rd_nu)))
                        .addGap(44, 44, 44)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_sodt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_nam)
                    .addComponent(rd_nu)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new)
                            .addComponent(btn_save))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_update)
                            .addComponent(btn_delete))))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        this.ClearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void ClearForm() {
        txt_masv.setText("");
        txt_hoten.setText("");
        txt_sodt.setText("");
        txt_email.setText("");
        group.clearSelection();
        txa_diachi.setText("");
        lbl_img.setIcon(null);
    }

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
//        if (ValidateForm()) {
            SinhVien sv = this.getFormdata();
            if(sv==null){
                return;
            }
            this.sinhVienService.insert(sv);
            this.loadTable();
            this.ClearForm();
//        }
    }//GEN-LAST:event_btn_saveActionPerformed


    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int i = tb_sinhvien.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Ban co muon xoa hay khong ?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            String idStr = tb_sinhvien.getValueAt(i, 0).toString();
            int id = Integer.parseInt(idStr);
            this.sinhVienService.delete(id);
            this.loadTable();
            this.ClearForm();
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int i = tb_sinhvien.getSelectedRow();

        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can sua");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Ban co muon update hay khong ?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            String idStr = tb_sinhvien.getValueAt(i, 0).toString();
            int id = Integer.parseInt(idStr);
            SinhVien sinhVien = this.getFormdata();
            this.sinhVienService.update(id, sinhVien);
            this.loadTable();
            this.ClearForm();
        }

    }//GEN-LAST:event_btn_updateActionPerformed

    private void tb_sinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sinhvienMouseClicked
        int i = tb_sinhvien.getSelectedRow();
        txt_masv.setText(tb_sinhvien.getValueAt(i, 1).toString());
        txt_hoten.setText(tb_sinhvien.getValueAt(i, 2).toString());
        txt_email.setText(tb_sinhvien.getValueAt(i, 3).toString());
        txt_sodt.setText(tb_sinhvien.getValueAt(i, 4).toString());
        txa_diachi.setText(tb_sinhvien.getValueAt(i, 6).toString());
        if (tb_sinhvien.getValueAt(i, 5).toString().equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }

        String hinh = tb_sinhvien.getValueAt(i, 7).toString();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/" + hinh));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        lbl_img.setIcon(imageIcon);

    }//GEN-LAST:event_tb_sinhvienMouseClicked

    private void lbl_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imageMouseClicked


    }//GEN-LAST:event_lbl_imageMouseClicked

    private void lbl_imgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imgMouseClicked
        JFileChooser FileChooser = new JFileChooser("\\src\\image");
        int result = FileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = FileChooser.getSelectedFile();
            hinhAnhStr = file.getName();
            Icon icon = new ImageIcon(file.getAbsolutePath());
            this.lbl_img.setIcon(icon);
        }
    }//GEN-LAST:event_lbl_imgMouseClicked

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
            java.util.logging.Logger.getLogger(FormSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel lbl_image;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_sinhvien;
    private javax.swing.JTextArea txa_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_sodt;
    // End of variables declaration//GEN-END:variables
}
