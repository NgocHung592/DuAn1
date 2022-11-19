package views;

import models.Diem;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import services.DiemService;
import java.awt.Image;

import javax.swing.JOptionPane;
import utilis.Validation;

public class FormDiem extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DiemService diemService;

    private FormDiem() {
        initComponents();
        this.diemService = new DiemService();
        this.addIcon();
        this.loadTable();
        btn_firstActionPerformed(null);
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_diem.getModel();
        defaultTableModel.setRowCount(0);
        for (Diem diem : this.diemService.getdata()) {
            getData(diem);
        }
    }

    public void showdata(ArrayList<Diem> lists) {
        defaultTableModel = (DefaultTableModel) tb_diem.getModel();
        defaultTableModel.setRowCount(0);
        for (Diem diem : lists) {
            getData(diem);
        }
    }

    public void addIcon() {
        Icon iconSave = new ImageIcon("src/image/save.png");
        this.btn_save.setIcon(iconSave);
        Icon iconNew = new ImageIcon("src/image/plus.png");
        this.btn_new.setIcon(iconNew);
        Icon iconDelete = new ImageIcon("src/image/delete.png");
        this.btn_delete.setIcon(iconDelete);
        Icon iconUpdate = new ImageIcon("src/image/exchange.png");
        this.btn_update.setIcon(iconUpdate);
        Icon iconSearch = new ImageIcon("src/image/search.png");
        this.btn_search.setIcon(iconSearch);
        Icon iconNext = new ImageIcon("src/image/next.png");
        this.btn_next.setIcon(iconNext);
        Icon iconPre = new ImageIcon("src/image/pre.png");
        this.btn_pre.setIcon(iconPre);
        Icon iconLast = new ImageIcon("src/image/last.png");
        this.btn_last.setIcon(iconLast);
        Icon iconFirst = new ImageIcon("src/image/first.png");
        this.btn_first.setIcon(iconFirst);
    }

    public void showdetial(Diem diem) {
        txt_hoten.setText(diem.getHoTen());
        txt_masv1.setText(diem.getMaSV());
        txt_diemta.setText(String.valueOf(diem.getTiengAnh()));
        txt_diemth.setText(String.valueOf(diem.getTinHoc()));
        txt_diemgdtc.setText(String.valueOf(diem.getGDTC()));
        lbl_diemtb.setText(String.valueOf((diem.getGDTC() + diem.getTiengAnh() + diem.getTinHoc()) / 3));
    }

    public Boolean ValidateForm() {
        if (!Validation.isEmpty(txt_hoten, "Ho ten khong duoc de trong", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmpty(txt_masv1, "Ma sinh vien khong duoc de trong", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isEmpty(txt_diemta, "Diem tieng anh khong duoc de trong", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isDiem(txt_diemta)) {
            return false;
        }
        if (!Validation.isEmpty(txt_diemth, "Diem tin hoc khong duoc de trong", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isDiem(txt_diemth)) {
            return false;
        }
        if (!Validation.isEmpty(txt_diemgdtc, "Diem gdtc khong duoc de trong", "Error", JOptionPane.ERROR_MESSAGE)) {
            return false;
        }
        if (!Validation.isDiem(txt_diemgdtc)) {
            return false;
        }
        return true;
    }

    public Diem getFormData() {

        String masv = txt_masv1.getText().trim();
        String tensv = txt_hoten.getText().trim();
        String diemtaStr = txt_diemta.getText().trim();
        String diemthStr = txt_diemth.getText().trim();
        String diemgdtcStr = txt_diemgdtc.getText().trim();

        double diemta = Double.parseDouble(diemtaStr);
        double diemth = Double.parseDouble(diemthStr);
        double diemgdtc = Double.parseDouble(diemgdtcStr);

        Diem diem = new Diem(WIDTH, masv, tensv, diemta, diemth, diemgdtc);

        return diem;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_masv = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        txt_masv1 = new javax.swing.JTextField();
        txt_diemta = new javax.swing.JTextField();
        txt_diemth = new javax.swing.JTextField();
        txt_diemgdtc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lbl_diemtb = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_pre = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_diem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lí điểm sinh viên\n");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lí Điểm Sinh Viên");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel2.setText("Mã SV:");

        btn_search.setText("Search");
        btn_search.setMinimumSize(new java.awt.Dimension(71, 15));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_masv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Họ tên SV:");

        jLabel4.setText("Mã SV:");

        jLabel5.setText("Tiếng anh:");

        jLabel6.setText("Tin học:");

        jLabel7.setText("Giáo dục TC:");

        jLabel8.setText("Điểm TB:");

        lbl_diemtb.setText("diem");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_masv1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_diemth, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txt_diemta)
                            .addComponent(txt_diemgdtc))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_diemtb)
                        .addGap(11, 11, 11)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_masv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_diemta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_diemtb)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_diemth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_diemgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_pre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_preActionPerformed(evt);
            }
        });

        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        tb_diem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Mã SV", "Họ tên", "Tiếng anh", "Tin học", "GDTC", "Điểm TB"
            }
        ));
        tb_diem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_diemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_diem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_pre)
                                .addGap(18, 18, 18)
                                .addComponent(btn_next)
                                .addGap(18, 18, 18)
                                .addComponent(btn_last)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_first, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_next)
                    .addComponent(btn_last)
                    .addComponent(btn_pre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void clearForm() {
        txt_hoten.setText("");
        txt_masv1.setText("");
        txt_diemta.setText("");
        txt_diemth.setText("");
        txt_diemgdtc.setText("");
        lbl_diemtb.setText("");
    }

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (ValidateForm()) {
            Diem diem = this.getFormData();
            this.diemService.insert(diem);
            lbl_diemtb.setText(String.valueOf((diem.getTiengAnh() + diem.getTinHoc() + diem.getGDTC()) / 3));
            this.loadTable();
            this.clearForm();
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int i = tb_diem.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Hay chon sinh vien can xoa !");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Ban co muon xoa hay khong ?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            String idStr = tb_diem.getValueAt(i, 0).toString();
            int id = Integer.parseInt(idStr);
            this.diemService.delete(id);
            this.loadTable();
            this.clearForm();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int i = tb_diem.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Hay chon sinh vien can update !");
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Ban co muon update hay khong ?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (ValidateForm()) {
                String idStr = tb_diem.getValueAt(i, 0).toString();
                int id = Integer.parseInt(idStr);
                Diem diem = this.getFormData();
                this.diemService.update(id, diem);
                this.loadTable();
                this.clearForm();
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tb_diemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_diemMouseClicked
        int i = tb_diem.getSelectedRow();
        txt_hoten.setText(tb_diem.getValueAt(i, 2).toString());
        txt_masv1.setText(tb_diem.getValueAt(i, 1).toString());
        txt_diemta.setText(tb_diem.getValueAt(i, 3).toString());
        txt_diemth.setText(tb_diem.getValueAt(i, 4).toString());
        txt_diemgdtc.setText(tb_diem.getValueAt(i, 5).toString());
        lbl_diemtb.setText(tb_diem.getValueAt(i, 6).toString());

    }//GEN-LAST:event_tb_diemMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String idStr = txt_masv.getText().trim();
        int id = Integer.parseInt(idStr);
        this.showdata(this.diemService.Search(id));
    }//GEN-LAST:event_btn_searchActionPerformed

    private void getData(Diem diem) {
        defaultTableModel.addRow(new Object[]{
            diem.getId(),
            diem.getMaSV(),
            diem.getHoTen(),
            diem.getTiengAnh(),
            diem.getTinHoc(),
            diem.getGDTC(),
            (diem.getTiengAnh() + diem.getTinHoc() + diem.getGDTC()) / 3
        });
    }

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        diemService.first();
        Diem diem = diemService.getIndexDiem();
        showdetial(diem);
        tb_diem.setRowSelectionInterval(diemService.getIndex(), diemService.getIndex());
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_preActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_preActionPerformed
        diemService.previous();
        Diem diem = diemService.getIndexDiem();
        showdetial(diem);
        tb_diem.setRowSelectionInterval(diemService.getIndex(), diemService.getIndex());
    }//GEN-LAST:event_btn_preActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        diemService.next();
        Diem diem = diemService.getIndexDiem();
        //showdetial(diem);
        tb_diem.setRowSelectionInterval(diemService.getIndex(), diemService.getIndex());
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        diemService.last();
        Diem diem = diemService.getIndexDiem();
        showdetial(diem);
        tb_diem.setRowSelectionInterval(diemService.getIndex(), diemService.getIndex());
    }//GEN-LAST:event_btn_lastActionPerformed

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
            java.util.logging.Logger.getLogger(FormDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_pre;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_diemtb;
    private javax.swing.JTable tb_diem;
    private javax.swing.JTextField txt_diemgdtc;
    private javax.swing.JTextField txt_diemta;
    private javax.swing.JTextField txt_diemth;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_masv;
    private javax.swing.JTextField txt_masv1;
    // End of variables declaration//GEN-END:variables
}
