/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uaspbo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class sewa2 extends javax.swing.JFrame {

    int xx, xy;
    Connection con;
    Statement stm;
    ResultSet rs;
    Mobil mobil;
    List<Driver> listDriver;
    Driver driverTerpilih;
    int biayaS, biayaD, totalB;

    public sewa2(Mobil mobil) {
        initComponents();
        koneksi.connect();
        con = koneksi.con;
        stm = koneksi.stm;
        this.mobil = mobil;
        driverTerpilih = null;
        biayaS=0; biayaD=0; totalB = 0;
        

        Tampil_kode();
        tampilDataPemesanan();
    }

    public void tampilDataPemesanan() {
        String id = mobil.getId();
        int bDriver = 0;
        if (id.contains("D")) {
            radioBtnYa.setSelected(true);
            getDriver();
            randomDriver();
            String biayaDriver = "Rp. " + driverTerpilih.getBiaya();
            txtBiayaDriver.setText(biayaDriver);
            bDriver = driverTerpilih.getBiaya();
        } else {
            radioBtnTidak.setSelected(true);

        }
        
        biayaD = bDriver;

        String biayaMobil = "Rp. " + mobil.getHarga();
        biayaS = mobil.getHarga();
        txtBiayaMobil.setText(biayaMobil);

        int jumlah = mobil.getHarga() + bDriver;
        totalB = jumlah;
        String total = "Rp. " + jumlah;
        txtTotalBiaya.setText(total);

    }

    public void randomDriver() {
        Random a = new Random();
        int acakDriver = a.nextInt(listDriver.size());

        System.out.println("hasil acak driver : " + acakDriver);

        driverTerpilih = listDriver.get(acakDriver);
    }

    public void getDriver() {
        listDriver = new ArrayList<>();

        try {
            String sql = "SELECT * FROM supir";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id_supir");
                String nama = rs.getString("nama_supir");
                String telp = rs.getString("nmr_telp");
                String alamat = rs.getString("alamat");
                int biaya = Integer.parseInt(rs.getString("biaya_supir"));

                Driver objDriver = new Driver(id, nama, telp, alamat, biaya);
                listDriver.add(objDriver);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public long hitungDurasi() {

        LocalDate pinjam = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate kembali = jD_tglKembali.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.DAYS.between(pinjam, kembali);
    }

    public void Tampil_kode() {
        try {
            String sql = "SELECT * FROM penyewaan ORDER BY kode_booking DESC LIMIT 1";
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                String nofak = rs.getString("kode_booking").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                tKodeBooking.setText("F" + Nol + AN);
            } else {
                tKodeBooking.setText("F0001");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupDriver = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_nama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_alamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jD_tglKembali = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        radioBtnYa = new javax.swing.JRadioButton();
        radioBtnTidak = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtBiayaMobil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtBiayaDriver = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotalBiaya = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtDurasi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        t_telepon = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        tKodeBooking = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close(4).png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RENT A CAR NOW");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Please enter your details order");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png"))); // NOI18N

        t_nama.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        t_nama.setText("Nama");
        t_nama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_namaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_namaFocusLost(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/email.png"))); // NOI18N

        t_email.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        t_email.setText("Email");
        t_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_emailFocusLost(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home-address.png"))); // NOI18N

        t_alamat.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        t_alamat.setText("Alamat");
        t_alamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_alamatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_alamatFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tanggal Sewa");

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tanggal Pengembalian");

        jD_tglKembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jD_tglKembaliPropertyChange(evt);
            }
        });
        jD_tglKembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jD_tglKembaliKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Metode Pick Up");

        comboMethode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Methode", "Pick up in another place ", "Pick up at the rental office" }));
        comboMethode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMethodeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Driver");

        btnGroupDriver.add(radioBtnYa);
        radioBtnYa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioBtnYa.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnYa.setText("Ya");
        radioBtnYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnYaActionPerformed(evt);
            }
        });

        btnGroupDriver.add(radioBtnTidak);
        radioBtnTidak.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioBtnTidak.setForeground(new java.awt.Color(255, 255, 255));
        radioBtnTidak.setText("Tidak");
        radioBtnTidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnTidakActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Biaya Mobil");

        txtBiayaMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBiayaMobilActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Biaya Driver");

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total Biaya");

        jButton2.setBackground(new java.awt.Color(255, 102, 0));
        jButton2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Continue");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Durasi");

        txtDurasi.setEnabled(false);
        txtDurasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurasiActionPerformed(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/phone-call.png"))); // NOI18N

        t_telepon.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        t_telepon.setText("No.Telepon");
        t_telepon.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_teleponFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_teleponFocusLost(evt);
            }
        });

        tKodeBooking.setEditable(false);
        tKodeBooking.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        tKodeBooking.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kode Booking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)))
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 450, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(t_alamat))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(t_email))
                                .addComponent(jD_tglKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(t_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(t_nama))
                                .addComponent(tKodeBooking))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboMethode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioBtnYa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioBtnTidak))
                            .addComponent(jLabel11)
                            .addComponent(txtBiayaMobil)
                            .addComponent(jLabel12)
                            .addComponent(txtBiayaDriver)
                            .addComponent(jLabel13)
                            .addComponent(txtTotalBiaya)
                            .addComponent(txtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9))))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMethode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioBtnYa)
                            .addComponent(radioBtnTidak))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBiayaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBiayaDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKodeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jD_tglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void t_namaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_namaFocusGained
        String nama = t_nama.getText();
        if (nama.equals("Nama")) {
            t_nama.setText("");
        }
    }//GEN-LAST:event_t_namaFocusGained

    private void t_emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailFocusGained
        String email = t_email.getText();
        if (email.equals("Email")) {
            t_email.setText("");
        }
    }//GEN-LAST:event_t_emailFocusGained

    private void t_alamatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_alamatFocusGained
        String address = t_alamat.getText();
        if (address.equals("Alamat")) {
            t_alamat.setText("");
        }
    }//GEN-LAST:event_t_alamatFocusGained

    private void t_namaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_namaFocusLost
        String Nama = t_nama.getText();
        if (Nama.equals("") || Nama.equals("Nama")) {
            t_nama.setText("Nama");
        }
    }//GEN-LAST:event_t_namaFocusLost

    private void t_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_emailFocusLost
        String email = t_email.getText();
        if (email.equals("") || email.equals("Email")) {
            t_email.setText("Email");
        }
    }//GEN-LAST:event_t_emailFocusLost

    private void t_alamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_alamatFocusLost
        String Address = t_alamat.getText();
        if (Address.equals("") || Address.equals("Alamat")) {
            t_alamat.setText("Alamat");
        }
    }//GEN-LAST:event_t_alamatFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (con != null) {
            try {
                String sql = "INSERT INTO penyewaan (kode_booking, id_mobil, nama_penyewa, no_telepon, email, alamat, tgl_mulai, tgl_selesai, durasi, metode_pickup, driver, id_driver, biaya_sewa, biaya_driver, total_biaya) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                java.sql.PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, tKodeBooking.getText());
                pst.setString(2, mobil.getId());
                pst.setString(3, t_nama.getText());
                pst.setString(4, t_telepon.getText());

                pst.setString(5, t_email.getText());
                pst.setString(6, t_alamat.getText());

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dateM = sdf.format(jDateChooser1.getDate());
                    Date parseDateMulai = sdf.parse(dateM);
                    java.sql.Date dateMulai;
                    dateMulai = new java.sql.Date(parseDateMulai.getTime());
                    pst.setDate(7, dateMulai);

                    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
                    String dateS = sdf3.format(jD_tglKembali.getDate());
                    Date parseDateSelesai = sdf3.parse(dateS);
                    java.sql.Date dateSelesai;
                    dateSelesai = new java.sql.Date(parseDateSelesai.getTime());
                    pst.setDate(8, dateSelesai);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                pst.setString(9, txtDurasi.getText());
                pst.setString(10, (String) comboMethode.getSelectedItem());
                pst.setBoolean(11, radioBtnYa.isSelected());               
                pst.setString(12, driverTerpilih.getId_supir());
                pst.setInt(13, biayaS);
                pst.setInt(14, biayaD);
                pst.setInt(15, totalB);
                

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data has been succesfully saved. Please continue payment!");
                bayar b = new bayar(tKodeBooking.getText(), totalB);
                b.setVisible(true);
                this.dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Data has failed to save: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No database connection!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void t_teleponFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_teleponFocusGained
        String Telepon = t_telepon.getText();
        if (Telepon.equals("No.Telepon")) {
            t_telepon.setText("");
        }
    }//GEN-LAST:event_t_teleponFocusGained

    private void t_teleponFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_teleponFocusLost
        String Telepon = t_telepon.getText();
        if (Telepon.equals("") || Telepon.equals("No.Telepon")) {
            t_telepon.setText("No.Telepon");
        }
    }//GEN-LAST:event_t_teleponFocusLost

    private void txtDurasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurasiActionPerformed

    private void txtBiayaMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBiayaMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBiayaMobilActionPerformed

    private void jD_tglKembaliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jD_tglKembaliKeyPressed

    }//GEN-LAST:event_jD_tglKembaliKeyPressed

    private void jD_tglKembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jD_tglKembaliPropertyChange
        // TODO add your handling code here:
        if (jD_tglKembali.getDate() != null) {
            long hari = hitungDurasi();
            String durasi = hari + " Hari";
            txtDurasi.setText(durasi);
            System.out.println(durasi);
            System.out.println("masuk if tgl kembali");
        }

        System.out.println("button di click");
    }//GEN-LAST:event_jD_tglKembaliPropertyChange

    private void radioBtnYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnYaActionPerformed

    }//GEN-LAST:event_radioBtnYaActionPerformed

    private void radioBtnTidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnTidakActionPerformed

    }//GEN-LAST:event_radioBtnTidakActionPerformed

    private void comboMethodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMethodeActionPerformed

    }//GEN-LAST:event_comboMethodeActionPerformed

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
            java.util.logging.Logger.getLogger(sewa2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sewa2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sewa2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sewa2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sewa2(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupDriver;
    private final javax.swing.JComboBox<String> comboMethode = new javax.swing.JComboBox<>();
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jD_tglKembali;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioBtnTidak;
    private javax.swing.JRadioButton radioBtnYa;
    private javax.swing.JTextField tKodeBooking;
    private javax.swing.JTextField t_alamat;
    private javax.swing.JTextField t_email;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_telepon;
    private javax.swing.JTextField txtBiayaDriver;
    private javax.swing.JTextField txtBiayaMobil;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JTextField txtTotalBiaya;
    // End of variables declaration//GEN-END:variables
}
