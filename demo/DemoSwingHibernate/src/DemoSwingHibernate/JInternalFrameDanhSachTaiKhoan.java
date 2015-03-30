package DemoSwingHibernate;

import dao.*;
import entities.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JInternalFrameDanhSachTaiKhoan extends javax.swing.JInternalFrame {

    private final TaiKhoanDao tkd = new TaiKhoanDao();

    private void loadData() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Ten Dang Nhap");
        dtm.addColumn("Ho Ten");
        dtm.addColumn("Email");
        for (Taikhoan tk : this.tkd.findAll()) {
            dtm.addRow(new Object[]{tk.getUsername(), tk.getHoten(), tk.getEmail()});
        }
        this.jTableTaiKhoan.setModel(dtm);
        this.jTableTaiKhoan.repaint();
        this.jTableTaiKhoan.revalidate();
        
    }

    public JInternalFrameDanhSachTaiKhoan() {
        initComponents();
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTaiKhoan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldHoTen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDienThoai = new javax.swing.JTextField();
        jTextFieldCongTy = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButtonLuu = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Danh Sach Tai Khoan");

        jTableTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTaiKhoan);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thong Tin Tai Khoan"));

        jLabel1.setText("Ten dang nhap:");

        jLabel2.setText("Mat khau:");

        jLabel7.setText("Ho Ten:");

        jLabel8.setText("Email:");

        jLabel9.setText("Dien Thoai:");

        jLabel11.setText("Cong Ty:");

        jLabel12.setText("Dia Chi:");

        jButtonLuu.setText("Luu");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jButtonXoa.setText("Xoa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonLuu)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonXoa))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldUsername)
                        .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(jTextFieldHoTen)
                        .addComponent(jTextFieldEmail)
                        .addComponent(jTextFieldDienThoai)
                        .addComponent(jTextFieldCongTy)
                        .addComponent(jTextFieldDiaChi)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldCongTy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLuu)
                    .addComponent(jButtonXoa))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTaiKhoanMouseClicked
        String username = this.jTableTaiKhoan.getValueAt(this.jTableTaiKhoan.getSelectedRow(), 0).toString();

        Taikhoan tk = tkd.find(username);
        //System.out.println( "username..............." + tk);
        this.jTextFieldCongTy.setText(tk.getCongty());
        this.jTextFieldDiaChi.setText(tk.getDiachi());
        this.jTextFieldDienThoai.setText(String.valueOf(tk.getDienthoai()));
        this.jTextFieldEmail.setText(tk.getEmail());
        this.jTextFieldHoTen.setText(tk.getHoten());
        this.jTextFieldUsername.setText(tk.getUsername());
    }//GEN-LAST:event_jTableTaiKhoanMouseClicked

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        int cf = JOptionPane.showConfirmDialog(null, "Ban co chac xoa hay khong", "Xac nhan", JOptionPane.YES_NO_OPTION);
        if (cf == JOptionPane.YES_OPTION) {
            String username = this.jTableTaiKhoan.getValueAt(this.jTableTaiKhoan.getSelectedRow(), 0).toString();
            Taikhoan tk = tkd.find(username);
            if(tkd.delete(tk))
            {
                JOptionPane.showMessageDialog(null, "Xoa thanh cong!");
                loadData();
            }
            else{
                JOptionPane.showMessageDialog(null, "Xoa that bai!");
            }
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        Taikhoan tk = new Taikhoan();
        tk.setCongty(this.jTextFieldCongTy.getText());
        tk.setDiachi(this.jTextFieldDiaChi.getText());
        tk.setDienthoai(Double.valueOf(this.jTextFieldDienThoai.getText()));
        tk.setEmail(this.jTextFieldEmail.getText());
        tk.setHoten(this.jTextFieldHoTen.getText());
        if(this.jPasswordFieldPassword!=null){
            tk.setPassword(String.valueOf(this.jPasswordFieldPassword.getPassword()));
        }   
        tk.setUsername(this.jTextFieldUsername.getText());
        if(tkd.update(tk)){
            JOptionPane.showMessageDialog(null,"cap nhat thanh cong!");
            loadData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Cap nhat that bai!");
        }
    }//GEN-LAST:event_jButtonLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTaiKhoan;
    private javax.swing.JTextField jTextFieldCongTy;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldDienThoai;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldHoTen;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
