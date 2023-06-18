package App;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App extends javax.swing.JFrame {
    private Statement statement;
    private Connection connect;
    private ResultSet set;
    private String sql = "";

    private void koneksiDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sisfo");
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("Koneksi Gagal" + e.getMessage());
        }
    }
    
  
    public void clear(){
        tfNamaBarang.setText("");
        tfHargaBarang.setText("");
        tfJumlahBarang.setText("");
        tfNamaBarang.requestFocus();
    }
    
    public void insertData(){
        DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();
        int row = tabelBarang.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            tfNamaBarang.getText(),
            tfHargaBarang.getText(),
            tfJumlahBarang.getText()
        });
    }
    
    public double hitungTotal(){
        DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();
        int rowCount = model.getRowCount();
        double total = 0.0;
        
        for(int i = 0; i< rowCount; i++){
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i,3).toString());
            total += harga*jumlah;
        }
        return total;
    }
    
    public App() {
        initComponents();   
        koneksiDatabase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelNamaBrand = new javax.swing.JPanel();
        labelNamaBrand = new javax.swing.JLabel();
        panelBawah = new javax.swing.JPanel();
        labelNamaBarang = new javax.swing.JLabel();
        labelHargaBarang = new javax.swing.JLabel();
        labelJumlahBarang = new javax.swing.JLabel();
        tfNamaBarang = new javax.swing.JTextField();
        tfJumlahBarang = new javax.swing.JTextField();
        tfHargaBarang = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        panelTotal = new javax.swing.JPanel();
        labelTotal = new javax.swing.JLabel();
        labelTunai = new javax.swing.JLabel();
        labelKembali = new javax.swing.JLabel();
        tfTunai = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        tfKembali = new javax.swing.JTextField();
        buttonHitung = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(229, 224, 255));
        setResizable(false);

        panelNamaBrand.setBackground(new java.awt.Color(96, 150, 200));

        labelNamaBrand.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        labelNamaBrand.setForeground(new java.awt.Color(255, 255, 255));
        labelNamaBrand.setText("S-Mart");

        javax.swing.GroupLayout panelNamaBrandLayout = new javax.swing.GroupLayout(panelNamaBrand);
        panelNamaBrand.setLayout(panelNamaBrandLayout);
        panelNamaBrandLayout.setHorizontalGroup(
            panelNamaBrandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNamaBrandLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelNamaBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNamaBrandLayout.setVerticalGroup(
            panelNamaBrandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNamaBrandLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNamaBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        panelBawah.setBackground(new java.awt.Color(96, 150, 200));

        javax.swing.GroupLayout panelBawahLayout = new javax.swing.GroupLayout(panelBawah);
        panelBawah.setLayout(panelBawahLayout);
        panelBawahLayout.setHorizontalGroup(
            panelBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBawahLayout.setVerticalGroup(
            panelBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        labelNamaBarang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelNamaBarang.setText("Nama Barang");

        labelHargaBarang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelHargaBarang.setText("Harga Barang");

        labelJumlahBarang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelJumlahBarang.setText("Jumlah Barang");

        tfNamaBarang.setBackground(new java.awt.Color(147, 191, 207));
        tfNamaBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfJumlahBarang.setBackground(new java.awt.Color(147, 191, 207));
        tfJumlahBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfHargaBarang.setBackground(new java.awt.Color(147, 191, 207));
        tfHargaBarang.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHargaBarangActionPerformed(evt);
            }
        });

        buttonTambah.setBackground(new java.awt.Color(39, 55, 77));
        buttonTambah.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonTambah.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonEdit.setBackground(new java.awt.Color(82, 109, 130));
        buttonEdit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonEdit.setForeground(new java.awt.Color(255, 255, 255));
        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setBackground(new java.awt.Color(141, 160, 172));
        buttonDelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttonDelete.setText("Delete");
        buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonClear.setBackground(new java.awt.Color(159, 178, 224));
        buttonClear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(255, 255, 255));
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        panelTotal.setBackground(new java.awt.Color(189, 205, 214));

        labelTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTotal.setText("Total");

        labelTunai.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTunai.setText("Tunai");

        labelKembali.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelKembali.setText("Kembali");

        tfTunai.setEditable(false);
        tfTunai.setBackground(new java.awt.Color(238, 233, 218));
        tfTunai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(238, 233, 218));
        tfTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTotal.setText("Rp");

        tfKembali.setEditable(false);
        tfKembali.setBackground(new java.awt.Color(238, 233, 218));
        tfKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfKembali.setText("Rp");

        buttonHitung.setBackground(new java.awt.Color(130, 148, 196));
        buttonHitung.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonHitung.setText("Hitung");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });

        buttonSimpan.setBackground(new java.awt.Color(219, 223, 234));
        buttonSimpan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTotalLayout = new javax.swing.GroupLayout(panelTotal);
        panelTotal.setLayout(panelTotalLayout);
        panelTotalLayout.setHorizontalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTotalLayout.createSequentialGroup()
                        .addComponent(buttonHitung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSimpan))
                    .addComponent(labelTotal)
                    .addGroup(panelTotalLayout.createSequentialGroup()
                        .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelKembali)
                            .addComponent(labelTunai))
                        .addGap(29, 29, 29)
                        .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(tfTunai)
                            .addComponent(tfKembali))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTotalLayout.setVerticalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTunai)
                    .addComponent(tfTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKembali)
                    .addComponent(tfKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonHitung)
                    .addComponent(buttonSimpan))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Harga", "Jumlah"
            }
        ));
        jScrollPane2.setViewportView(tabelBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBawah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNamaBarang)
                            .addComponent(labelHargaBarang)
                            .addComponent(labelJumlahBarang))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfHargaBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(tfNamaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfJumlahBarang, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(panelNamaBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNamaBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNamaBarang)
                            .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelHargaBarang)
                            .addComponent(tfHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelJumlahBarang)
                            .addComponent(tfJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTambah)
                            .addComponent(buttonEdit)
                            .addComponent(buttonDelete)
                            .addComponent(buttonClear))
                        .addGap(18, 18, 18)
                        .addComponent(panelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(panelBawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        if(tfNamaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama barang belum diinput");
        } else if(tfHargaBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga barang belum diinput");
        } else if(tfJumlahBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah barang belum diinput");
        } else{
            insertData();
            clear();
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();
        int rowSelect = tabelBarang.getSelectedRow();
        if(buttonEdit.getText().equals("Edit")){
            buttonTambah.setEnabled(false);
            buttonDelete.setEnabled(false);
            buttonEdit.setText("Update");
            tfNamaBarang.setText(model.getValueAt(rowSelect, 1).toString());
            tfHargaBarang.setText(model.getValueAt(rowSelect, 2).toString());
            tfJumlahBarang.setText(model.getValueAt(rowSelect, 3).toString());
        } else {
            buttonTambah.setEnabled(true);
            buttonDelete.setEnabled(true);
            buttonEdit.setText("Edit");
            
            String namaBarang = tfNamaBarang.getText();
            String hargaBarang = tfHargaBarang.getText();
            String jumlahBarang = tfJumlahBarang.getText();
            
            model.setValueAt(namaBarang, rowSelect, 1);
            model.setValueAt(hargaBarang, rowSelect, 2);
            model.setValueAt(jumlahBarang, rowSelect, 3);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();
        int rowSelect = tabelBarang.getSelectedRow();
        
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini", "Konfirmasi penghapusan data", JOptionPane.ERROR_MESSAGE);
            if(confirm == JOptionPane.YES_OPTION){
                model.removeRow(rowSelect);
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        // TODO add your handling code here:
        tfNamaBarang.setText("");
        tfHargaBarang.setText("");
        tfJumlahBarang.setText("");
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            double total = hitungTotal();
            tfTotal.setText("Rp." + String.valueOf(total));

            String totalText = tfTotal.getText().substring(3);
            double total1 = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(tfTunai.getText());
            double kembali = bayar - total1;
            tfKembali.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        try{
           Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt_produk","root","");
           
           int rowCount = tabelBarang.getRowCount();
           for(int i = 0; i < rowCount; i++){
               String Column1 = tabelBarang.getValueAt(i, 1).toString();
               String Column2 = tabelBarang.getValueAt(i, 2).toString();
               String Column3 = tabelBarang.getValueAt(i, 3).toString();
               String sql = "INSERT INTO tb_barang (NAMA, HARGA, JUMLAH) VALUES (?,?,?)";
               PreparedStatement statement = connect.prepareStatement(sql);
               
               statement.setString(1, Column1);
               statement.setString(2, Column2);
               statement.setString(3, Column3);
               
               statement.executeUpdate();
           }   
           
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database.");
           Con.close();
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke database.");
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void tfHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHargaBarangActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHitung;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelHargaBarang;
    private javax.swing.JLabel labelJumlahBarang;
    private javax.swing.JLabel labelKembali;
    private javax.swing.JLabel labelNamaBarang;
    private javax.swing.JLabel labelNamaBrand;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTunai;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JPanel panelNamaBrand;
    private javax.swing.JPanel panelTotal;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField tfHargaBarang;
    private javax.swing.JTextField tfJumlahBarang;
    private javax.swing.JTextField tfKembali;
    private javax.swing.JTextField tfNamaBarang;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JTextField tfTunai;
    // End of variables declaration//GEN-END:variables
}
