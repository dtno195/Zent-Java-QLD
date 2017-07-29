/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DiemDAO;
import Model.Diem;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc
 */
public class Cu_Diem extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;
    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new customizer Cu_Diem
     */
    public Cu_Diem() {
        initComponents();
         loadDuLieuLenLuoi();
         LoadComboBox();
    }

    public void setObject(Object bean) {
        this.bean = bean;
    }
     private void loadDuLieuLenLuoi() {
        dtm = new DefaultTableModel();
        //dtm.addColumn("Tên Sinh Viên");
        dtm.addColumn("Mã Sinh Viên");
        dtm.addColumn("Mã Môn Học");
        dtm.addColumn("Điểm Giữa Kỳ");
        dtm.addColumn("Điểm Cuối Kỳ");
    //    dtm.addColumn("Điểm Tổng Kết");

        DiemDAO diemDAO = new DiemDAO();
        List<Diem> diemList = diemDAO.selectAll();
        for (Diem diem : diemList) {
            Vector vt = new Vector();
            vt.add(diem.getMaSinhVien());
            vt.add(diem.getMaMonHoc());

            vt.add(diem.getDiemGiuaKy());
            vt.add(diem.getDiemCuoiKy());
           // vt.add(diem.getDiemTongKet());
            dtm.addRow(vt);
        }
        tbl_Diem.setModel(dtm);
    }
     private void LoadComboBox() {
//    LopDAO lopDAO = new LopDAO();
//        List<Lop> lopList = lopDAO.selectAll();
//        Vector v = new Vector(lopList);
//        DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
//        cbxMaLop.setModel(dcb);
//        cbxMaLop.setRenderer(new MaLopRender());
        DiemDAO diemDAO = new DiemDAO();
        List<Diem> diemList = diemDAO.selectAll();
        Vector v = new Vector(diemList);
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
//        cbxMaMonHoc.setModel(dcb);
//        cbxMaMonHoc.setRenderer(new DiemRender());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtMaSinhVien = new javax.swing.JTextField();
        txtDiemGiuaKy = new javax.swing.JTextField();
        txtDiemCuoiKy = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        txtMaMonHoc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Diem = new javax.swing.JTable();

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Mã Môn Học");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Điểm Giữa Kỳ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Điểm Cuối Kỳ");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ADD.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnReset.setText("Xóa Trắng");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)), "TÌM KIẾM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(btnTimKiem)
                .addGap(42, 42, 42))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnTimKiem)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtDiemGiuaKy, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtDiemCuoiKy, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtMaMonHoc))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiemGiuaKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiemCuoiKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông Tin Điểm", jPanel1);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 2));

        tbl_Diem.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Diem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Diem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaMonHoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa chọn Mã Môn Học");
        } else if (txtMaSinhVien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Mã Sinh Viên");
        } else if (txtDiemGiuaKy.getText().isEmpty() && txtDiemGiuaKy.getText() != null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Điểm Giữa Kỳ");
        } else if (txtDiemCuoiKy.getText().isEmpty() && txtDiemCuoiKy.getText() != null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Điểm Cuối Kỳ");
        }
        DiemDAO diemD = new DiemDAO();
        Diem diem = new Diem();
        diem.setMaMonHoc(txtMaMonHoc.getText());
        // diem.setMaMonHoc(((Diem) cbxMaMonHoc.getSelectedItem()).getMaMonHoc());
        diem.setMaSinhVien(txtMaSinhVien.getText());
        diem.setDiemGiuaKy(Float.parseFloat(txtDiemGiuaKy.getText()));
        diem.setDiemCuoiKy(Float.parseFloat(txtDiemCuoiKy.getText()));
        //  diem.setDiemTongKet(Float.parseFloat(txtDiemTongKet.getText()));
        boolean result = diemD.insert(diem);
        reset();
        loadDuLieuLenLuoi();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xóa Không ", "Thông Báo", OK_CANCEL_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int row = tbl_Diem.getSelectedRow();
            String maDiem = (String) tbl_Diem.getValueAt(row, 0);
            DiemDAO diemD = new DiemDAO();
            Diem diem = new Diem(maDiem);
            boolean result = diemD.delete(diem);
            if (result == false) {
                JOptionPane.showMessageDialog(this, "Xóa Thành Công !");
            }
            reset();
            loadDuLieuLenLuoi();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (txtMaSinhVien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Mã Sinh Viên");
        } else if (txtMaMonHoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Mã Môn Học");
        } else if (txtDiemGiuaKy.getText().isEmpty() && txtDiemGiuaKy.getText() != null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Điểm Giữa Kỳ");
        } else if (txtDiemCuoiKy.getText().isEmpty() && txtDiemCuoiKy.getText() != null) {
            JOptionPane.showMessageDialog(this, "Bạn Chưa Nhập Điểm Cuối Kỳ");
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Cập Nhật Không ", "Thông Báo", OK_CANCEL_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {

            DiemDAO diemDAO = new DiemDAO();
            Diem diem = new Diem();
            diem.setMaMonHoc(txtMaMonHoc.getText());
            //diem.setMaMonHoc(((Diem) cbxMaMonHoc.getSelectedItem()).getMaMonHoc());
            diem.setMaSinhVien(txtMaSinhVien.getText());
            diem.setDiemGiuaKy(Float.parseFloat(txtDiemGiuaKy.getText()));
            diem.setDiemCuoiKy(Float.parseFloat(txtDiemCuoiKy.getText()));
            // diem.setDiemTongKet(Float.parseFloat(txtDiemTongKet.getText()));
            boolean result = diemDAO.update(diem);
            if (result == false) {
                JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công!");
            }
            reset();
            loadDuLieuLenLuoi();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        //        dtm = new DefaultTableModel();
        //        dtm.addColumn("Mã Sinh Viên");
        //        dtm.addColumn("Mã Môn Học");
        //        dtm.addColumn("Điểm Giữa Kỳ");
        //        dtm.addColumn("Điểm Cuối Kỳ");
        //        dtm.addColumn("Điểm Tổng Kết");
        //
        //        DiemDAO diemDAO = new DiemDAO();
        //
        //
        // Diem d = new Diem(txtMaSinhVien.getText(), txtMaDiem.getText(),  d.setDiemGiuaKy(Float.parseFloat(txtDiemGiuaKy.getText())),d.setDiemCuoiKy(Float.parseFloat(txtDiemCuoiKy.getText())),d.setDiemTongKet(Float.parseFloat(txtDiemTongKet.getText())));

        //     List<Diem> diemList = diemDAO.search(d);
        //        for (Diem diem : diemList) {
        //            Vector vt = new Vector();
        //            vt.add(diem.getMaSinhVien());
        //            vt.add(diem.getMaDiem());
        //            vt.add(diem.getDiemGiuaKy());
        //            vt.add(diem.getDiemCuoiKy());
        //            vt.add(diem.getDiemTongKet());
        //            dtm.addRow(vt);
        //        }
        //        tbl_Diem.setModel(dtm);
        DiemDAO diemD = new DiemDAO();
        String input = txtTimKiem.getText();
        // diemD.search1(input);
    }//GEN-LAST:event_btnTimKiemMouseClicked
    public void reset() {
        txtDiemCuoiKy.setText("");
        txtDiemGiuaKy.setText("");
        //   txtDiemTongKet.setText("");
        txtMaSinhVien.setText("");
        txtMaMonHoc.setText("");
//        cbxMaMonHoc.setSelectedItem(null);
        txtTimKiem.setText("");
        btnThem.setEnabled(true);
        btnXoa.setEnabled(false);
        //  txtMaDiem.setEnabled(true);

    }

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String input = txtTimKiem.getText();
        dtm = new DefaultTableModel();

        dtm.addColumn("Mã Sinh Viên");
        dtm.addColumn("Mã Môn Học");
        dtm.addColumn("Điểm Giữa Kỳ");
        dtm.addColumn("Điểm Cuối Kỳ");
        DiemDAO diemDAO = new DiemDAO();
        List<Diem> diemList = diemDAO.search(input);
        for (Diem diem : diemList) {
            Vector vt = new Vector();
            vt.add(diem.getMaSinhVien());
            vt.add(diem.getMaMonHoc());
            vt.add(diem.getDiemGiuaKy());
            vt.add(diem.getDiemCuoiKy());
            vt.add(diem.getDiemTongKet());
            dtm.addRow(vt);
        }
        tbl_Diem.setModel(dtm);
        //Diem mh = new Diem();
        // Diem mh = new Diem(txtTenDiem.getText(), Integer.parseInt(txtTinChi.getText()), Float.parseFloat(txtHeSo_GiuaKy.getText()), Float.parseFloat(txtHeSo_CuoiKy.getText()));
        //Diem mh = new Diem(txtMaDiem.getText(), txtTenDiem.getText(), Integer.parseInt(txtTinChi.getText()), Float.parseFloat(txtHeSo_GiuaKy.getText()), Float.parseFloat(txtHeSo_CuoiKy.getText()));

        //   Diem mh = new Diem(txtMaDiem.getText(), txtMaSinhVien.getText(), Integer.parseInt(txtDiemGiuaKy.getText()));
        //        List<Diem> diemList = diemDAO.search(mh);
        //
        //        for (Diem diem : diemList) {
        //            Vector vt = new Vector();
        //            vt.add(diem.getMaDiem());
        //            vt.add(diem.getTenDiem());
        //            vt.add(diem.getTinChi());
        //            vt.add(diem.getHeSoGiuaKy());
        //            vt.add(diem.getHeSoCuoiKy());
        //            dtm.addRow(vt);
        //        }
        //        tbl_Diem.setModel(dtm);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbl_DiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DiemMouseClicked
        int row = tbl_Diem.getSelectedRow();

        String maSinhVien = (String) tbl_Diem.getValueAt(row, 0);
        String maMonHoc = (String) tbl_Diem.getValueAt(row, 1);
        Float diemGiuaKy = (Float) tbl_Diem.getValueAt(row, 2);
        Float diemCuoiKy = (Float) tbl_Diem.getValueAt(row, 3);
        //  Float diemTongKet = (Float) tbl_Diem.getValueAt(row, 4);

        txtMaSinhVien.setText(maSinhVien);
        DiemDAO diemDAO = new DiemDAO();
        txtMaMonHoc.setText(maMonHoc);
        //cbxMaMonHoc.setSelectedItem(diemDAO.getMaMonHocID(maMonHoc));
        txtDiemGiuaKy.setText(diemGiuaKy.toString());
        txtDiemCuoiKy.setText(diemCuoiKy.toString());
        // txtDiemTongKet.setText(diemTongKet.toString());
        btnThem.setEnabled(false);
        btnXoa.setEnabled(true);

    }//GEN-LAST:event_tbl_DiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_Diem;
    private javax.swing.JTextField txtDiemCuoiKy;
    private javax.swing.JTextField txtDiemGiuaKy;
    private javax.swing.JTextField txtMaMonHoc;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
