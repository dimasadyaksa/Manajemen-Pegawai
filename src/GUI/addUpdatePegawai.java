/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import List.List;
import User.Karyawan;
import User.Manager;
import User.Pegawai;
import User.direktur;
import User.karyawanMagang;
import backgroundProcess.koneksi;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dimas Adiyaksa
 */
public class addUpdatePegawai extends javax.swing.JFrame {

    /**
     * Creates new form addUpdatePegawai
     */
    
    direktur dir = new direktur();
    Manager Man = new Manager();
    Karyawan kar = new Karyawan();
    karyawanMagang mag = new karyawanMagang();
    Pegawai peg = new Pegawai();
    boolean isAdd = false;
    private List data;
    String jabatanOld;
    String jabatanNew;
    
    public addUpdatePegawai() {
        initComponents();
        setLocationRelativeTo(null);
        saveButton.setText("Tambah");
        inisiasiAdd();
        passIcon();
    }

    public addUpdatePegawai(Pegawai peg){
         initComponents();
         setLocationRelativeTo(null);
         this.peg = peg;        
         inisiasi();
         saveButton.setText("Simpan");
         
    }
    
    public void passIcon(){
        BufferedImage img = null;
        try {
              img = ImageIO.read(new File("C://Users/Dimas Adiyaksa/"
                      + "Documents/NetBeansProjects/SistemManajemenPegawai"
                      + "/src/EksternalSource/pass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg;
        dimg = img.getScaledInstance(40, passicn.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        passicn.setIcon(imageIcon);
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
    
    
    public void inisiasi(){
        NIMPeg.setText(peg.getNIP());
        nmPeg.setText(peg.getNama());
        jabBox.setSelectedItem(peg.getJabatan());
        depBox.setSelectedItem(peg.getDept());
        jabatanOld = jabBox.getSelectedItem().toString();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = null;
        try {
           dt = d.parse(peg.getTTL());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        TTL.setDate(dt);
        address.setText(peg.getAlamat());
        
        GDCBox.setSelectedItem(peg.getGoldar());
        statusCBox1.setSelectedItem(peg.getStatus());
        try {
            dt = d.parse(peg.getKontrak());
        } catch (ParseException ex) {
            Logger.getLogger(addUpdatePegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        kontrakDate.setDate(dt);
        gajiLabel.setText(formatUang(peg.getGaji()));
        username.setText(peg.getUsername());
        passfield.setText(peg.getPassword());
        jKel.setSelectedItem(peg.getJenisKelamin());
        if(jabBox.getSelectedItem().equals("Direktur")){
            gajiLabel.setText(Double.toString(direktur.getGajiBersih()));
        }else if(jabBox.getSelectedItem().equals("Manager")){
            gajiLabel.setText(Double.toString(Manager.getGajiBersih()));
        }else if(jabBox.getSelectedItem().equals("Karyawan")){
            gajiLabel.setText(Double.toString(Karyawan.getGajiBersih()));
        }else {
            gajiLabel.setText(Double.toString(karyawanMagang.getGajiBersih()));
        }
        passIcon();
    }
    
    public void inisiasiAdd(){
        if(jabBox.getSelectedItem().equals("Direktur")){
            gajiLabel.setText(Double.toString(direktur.getGajiBersih()));
        }else if(jabBox.getSelectedItem().equals("Manager")){
            gajiLabel.setText(Double.toString(Manager.getGajiBersih()));
        }else if(jabBox.getSelectedItem().equals("Karyawan")){
            gajiLabel.setText(Double.toString(Karyawan.getGajiBersih()));
        }else {
            gajiLabel.setText(Double.toString(karyawanMagang.getGajiBersih()));
        }
    }
    
    public String formatUang(double uang){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        return kursIndonesia.format(uang); 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        statusCBox1 = new javax.swing.JComboBox<>();
        gajiLabel = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jabBox = new javax.swing.JComboBox<>();
        depBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TTL = new org.jdesktop.swingx.JXDatePicker();
        NIMPeg = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        nmPeg = new javax.swing.JTextField();
        GDCBox = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        kontrakDate = new org.jdesktop.swingx.JXDatePicker();
        jLabel33 = new javax.swing.JLabel();
        usrname = new javax.swing.JLabel();
        pass = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        passfield = new javax.swing.JPasswordField();
        passicn = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jKel = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        hakAkses = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        batalButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(661, 704));
        jPanel1.setName(""); // NOI18N

        statusCBox1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        statusCBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Menikah", "Menikah" }));

        gajiLabel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        gajiLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("TTL                   :");

        jabBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jabBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Direktur", "Manager", "Karyawan", "Karyawan Magang" }));
        jabBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jabBoxItemStateChanged(evt);
            }
        });

        depBox.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        depBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produksi", "SDM", "Jaminan Kualitas", "Keuangan", "Logistik", "Marketing", "Humas" }));
        depBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                depBoxItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDIT DATA");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NIP                  :");

        NIMPeg.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Gol Darah      :");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nama             :");

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Alamat          :");

        nmPeg.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        GDCBox.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        GDCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "O", "AB" }));

        jLabel38.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Kontrak         :");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Status            :");

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Jabatan         :");

        address.setColumns(20);
        address.setRows(5);
        jScrollPane5.setViewportView(address);

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Departemen :");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Gaji                :");

        usrname.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        usrname.setForeground(new java.awt.Color(255, 255, 255));
        usrname.setText("Username     :");

        pass.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setText("Password       :");

        username.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        passfield.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        passfield.setText("jPasswordField1");

        passicn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EksternalSource/pass.png"))); // NOI18N
        passicn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passicnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                passicnMouseReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Jenis Kelamin:");

        jKel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jKel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Hak Akses     :");

        hakAkses.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        hakAkses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pegawai", "Admin" }));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        batalButton.setText("BATAL");
        batalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalButtonMouseClicked(evt);
            }
        });

        saveButton.setText("SIMPAN");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jKel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GDCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TTL, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusCBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gajiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(depBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nmPeg, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jabBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(NIMPeg, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(usrname)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(18, 18, 18)
                        .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane5))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(kontrakDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(pass)
                                .addGap(14, 14, 14)
                                .addComponent(passfield, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passicn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIMPeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(nmPeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jabBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(depBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jKel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(TTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(GDCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(statusCBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33)
                            .addComponent(gajiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38)
                                    .addComponent(kontrakDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(usrname)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pass)
                                    .addComponent(passfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(passicn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(hakAkses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batalButton)
                            .addComponent(saveButton))))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_batalButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
        String usernam = username.getText();
        String password = passfield.getText();
        String ttl = null;
        String kontrak = null;
        koneksi kon = new koneksi();
        DateFormat dtform = new SimpleDateFormat("yyyy-MM-dd");
        
        if(!isEmpty()){
                peg.setNIP(NIMPeg.getText());
                peg.setNama(nmPeg.getText());
                peg.setJabatan(jabBox.getSelectedItem().toString());
                peg.setDept(depBox.getSelectedItem().toString());
                peg.setGoldar(GDCBox.getSelectedItem().toString());
                peg.setAlamat(address.getText());
                ttl = dtform.format(TTL.getDate());
                peg.setTTL(ttl);
                kontrak = dtform.format(kontrakDate.getDate());
                peg.setGaji(Double.parseDouble(gajiLabel.getText()));
                peg.setKontrak(kontrak);
                peg.setStatus(statusCBox1.getSelectedItem().toString());
                peg.setUsername(usernam);
                peg.setPassword(password);
                peg.setJenisKelamin(jKel.getSelectedItem().toString());
                peg.setHakAkses(hakAkses.getSelectedItem().toString());
            if(isAdd){
                
                    kon.exec("INSERT INTO `pegawai`(`NIP`, `NAMA`, `JABATAN`, "
                            + "`Departemen`, `TTL`, `Jenis Kelamin`, `Golongan Darah`, "
                            + "`ALAMAT`, `STATUS`, `GAJI`, `Akhir Kontrak`) VALUES "
                            + "("+peg.getNIP()+",'"+peg.getNama()+"','"+peg.getJabatan()+"',"
                            + "'"+peg.getDept()+"','"+peg.getTTL()+"','"+peg.getJenisKelamin()+"',"
                            + "'"+peg.getGoldar()+"','"+peg.getAlamat()+"','"+peg.getStatus()+"',"
                            + " "+peg.getGaji()+",'"+peg.getKontrak()+"')");
                    kon.exec("INSERT INTO `login`(`USERNAME`, `PASSWORD`,"
                            + " `HAK AKSES`, `NIP`) VALUES ('"+peg.getUsername()+"','"+peg.getPassword()+"',"
                            + "'"+peg.getHakAkses()+"',"+peg.getNIP()+")");
                   
                    kon.exec("INSERT INTO `lembur`"
                            + "(`NIP`, `Nama`, `Jumlah Lembur`) "
                            + "VALUES ("+peg.getNIP()+",'"+peg.getNama()+"',"+peg.getLembur()+")");
       
       
                if(jabBox.getSelectedItem().equals("Direktur")){
                    //JOptionPane
                    dir.setNIP(NIMPeg.getText());
                    dir.setNama(nmPeg.getText());
                    dir.setJabatan(jabBox.getSelectedItem().toString());
                    dir.setDept(depBox.getSelectedItem().toString());
                    dir.setGoldar(GDCBox.getSelectedItem().toString());
                    dir.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    dir.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    dir.setKontrak(kontrak);
                    dir.setStatus(statusCBox1.getSelectedItem().toString());
                    dir.setUsername(usernam);
                    dir.setPassword(password);
                    dir.setJenisKelamin(jKel.getSelectedItem().toString());
                    dir.setHakAkses(hakAkses.getSelectedItem().toString());
                    dir.setGaji(direktur.getGajiBersih());
                    data.tambahDirektur(dir);
                    
                }else if(jabBox.getSelectedItem().equals("Manager")){
                    Man.setNIP(NIMPeg.getText());
                    Man.setNama(nmPeg.getText());
                    Man.setJabatan(jabBox.getSelectedItem().toString());
                    Man.setDept(depBox.getSelectedItem().toString());
                    Man.setGoldar(GDCBox.getSelectedItem().toString());
                    Man.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    Man.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    Man.setKontrak(kontrak);
                    Man.setStatus(statusCBox1.getSelectedItem().toString());
                    Man.setUsername(usernam);
                    Man.setPassword(password);
                    Man.setJenisKelamin(jKel.getSelectedItem().toString());
                    Man.setHakAkses(hakAkses.getSelectedItem().toString());
                    Man.setGaji(Manager.getGajiBersih());
                    data.tambahManager(Man);
                }else if(jabBox.getSelectedItem().equals("Karyawan")){
                    kar.setNIP(NIMPeg.getText());
                    kar.setNama(nmPeg.getText());
                    kar.setJabatan(jabBox.getSelectedItem().toString());
                    kar.setDept(depBox.getSelectedItem().toString());
                    kar.setGoldar(GDCBox.getSelectedItem().toString());
                    kar.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    kar.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    kar.setKontrak(kontrak);
                    kar.setStatus(statusCBox1.getSelectedItem().toString());
                    kar.setUsername(usernam);
                    kar.setPassword(password);
                    kar.setJenisKelamin(jKel.getSelectedItem().toString());
                    kar.setHakAkses(hakAkses.getSelectedItem().toString());
                    kar.setGaji(Karyawan.getGajiBersih());
                    data.tambahKaryawan(kar);
                }else if(jabBox.getSelectedItem().equals("Karyawan Magang")){
                    mag.setNIP(NIMPeg.getText());
                    mag.setNama(nmPeg.getText());
                    mag.setJabatan(jabBox.getSelectedItem().toString());
                    mag.setDept(depBox.getSelectedItem().toString());
                    mag.setGoldar(GDCBox.getSelectedItem().toString());
                    mag.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    mag.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    mag.setKontrak(kontrak);
                    mag.setStatus(statusCBox1.getSelectedItem().toString());
                    mag.setUsername(usernam);
                    mag.setPassword(password);
                    mag.setJenisKelamin(jKel.getSelectedItem().toString());
                    mag.setHakAkses(hakAkses.getSelectedItem().toString());
                    mag.setGaji(karyawanMagang.getGajiBersih());
                    data.tambahMagang(mag);
                }
            
            }else{
                if(jabBox.getSelectedItem().equals("Direktur")){
                    //JOptionPane
                    dir.setNIP(NIMPeg.getText());
                    dir.setNama(nmPeg.getText());
                    dir.setJabatan(jabBox.getSelectedItem().toString());
                    dir.setDept(depBox.getSelectedItem().toString());
                    dir.setGoldar(GDCBox.getSelectedItem().toString());
                    dir.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    dir.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    dir.setKontrak(kontrak);
                    dir.setStatus(statusCBox1.getSelectedItem().toString());
                    dir.setUsername(usernam);
                    dir.setPassword(password);
                    dir.setJenisKelamin(jKel.getSelectedItem().toString());
                    dir.setHakAkses(hakAkses.getSelectedItem().toString());
                    dir.setLembur(peg.getLembur());
                    dir.setSlip(peg.getSlip());
                   // dir.setGaji(peg.getGaji());
                    dir.setGaji(direktur.getGajiBersih());
                    kon.exec("UPDATE `pegawai` SET NIP = "+peg.getNIP()+",Nama = '"+peg.getNama()+"',Jabatan = '"+peg.getJabatan()+"',"
                            + "Departemen = '"+peg.getDept()+"',TTL = '"+peg.getTTL()+"', `Jenis Kelamin` = '"+peg.getJenisKelamin()+"',"
                            + "`golongan darah` = '"+peg.getGoldar()+"',Alamat =  '"+peg.getAlamat()+"',status = '"+peg.getStatus()+"',"
                            + " gaji = "+dir.getGaji()+",`Akhir kontrak` = '"+peg.getKontrak()+"'"
                            + " WHERE nip = "+peg.getNIP());
                   // data.hapusDirektur(dir);
                    
                }else if(jabBox.getSelectedItem().equals("Manager")){
                    Man.setNIP(NIMPeg.getText());
                    Man.setNama(nmPeg.getText());
                    Man.setJabatan(jabBox.getSelectedItem().toString());
                    Man.setDept(depBox.getSelectedItem().toString());
                    Man.setGoldar(GDCBox.getSelectedItem().toString());
                    Man.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    Man.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    Man.setKontrak(kontrak);
                    Man.setStatus(statusCBox1.getSelectedItem().toString());
                    Man.setUsername(usernam);
                    Man.setPassword(password);
                    Man.setJenisKelamin(jKel.getSelectedItem().toString());
                    Man.setHakAkses(hakAkses.getSelectedItem().toString());
                    Man.setLembur(peg.getLembur());
                    Man.setGaji(Manager.getGajiBersih());
                    Man.setSlip(peg.getSlip());
                    kon.exec("UPDATE `pegawai` SET NIP = "+peg.getNIP()+",Nama = '"+peg.getNama()+"',Jabatan = '"+peg.getJabatan()+"',"
                            + "Departemen = '"+peg.getDept()+"',TTL = '"+peg.getTTL()+"', `Jenis Kelamin` = '"+peg.getJenisKelamin()+"',"
                            + "`golongan darah` = '"+peg.getGoldar()+"',Alamat =  '"+peg.getAlamat()+"',status = '"+peg.getStatus()+"',"
                            + " gaji = "+Man.getGaji()+",`Akhir kontrak` = '"+peg.getKontrak()+"'"
                            + " WHERE nip = "+peg.getNIP());
                   // data.hapusManager(Man);
                }else if(jabBox.getSelectedItem().equals("Karyawan")){
                    kar.setNIP(NIMPeg.getText());
                    kar.setNama(nmPeg.getText());
                    kar.setJabatan(jabBox.getSelectedItem().toString());
                    kar.setDept(depBox.getSelectedItem().toString());
                    kar.setGoldar(GDCBox.getSelectedItem().toString());
                    kar.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    kar.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    kar.setKontrak(kontrak);
                    kar.setStatus(statusCBox1.getSelectedItem().toString());
                    kar.setUsername(usernam);
                    kar.setPassword(password);
                    kar.setJenisKelamin(jKel.getSelectedItem().toString());
                    kar.setHakAkses(hakAkses.getSelectedItem().toString());
                    kar.setLembur(peg.getLembur());
                    kar.setGaji(Karyawan.getGajiBersih());
                    kar.setSlip(peg.getSlip());
                    kon.exec("UPDATE `pegawai` SET NIP = "+peg.getNIP()+",Nama = '"+peg.getNama()+"',Jabatan = '"+peg.getJabatan()+"',"
                            + "Departemen = '"+peg.getDept()+"',TTL = '"+peg.getTTL()+"', `Jenis Kelamin` = '"+peg.getJenisKelamin()+"',"
                            + "`golongan darah` = '"+peg.getGoldar()+"',Alamat =  '"+peg.getAlamat()+"',status = '"+peg.getStatus()+"',"
                            + " gaji = "+kar.getGaji()+",`Akhir kontrak` = '"+peg.getKontrak()+"'"
                            + " WHERE nip = "+peg.getNIP());
                    //data.hapusKaryawan(kar);
                }else if(jabBox.getSelectedItem().equals("Karyawan Magang")){
                    mag.setNIP(NIMPeg.getText());
                    mag.setNama(nmPeg.getText());
                    mag.setJabatan(jabBox.getSelectedItem().toString());
                    mag.setDept(depBox.getSelectedItem().toString());
                    mag.setGoldar(GDCBox.getSelectedItem().toString());
                    mag.setAlamat(address.getText());
                    ttl = dtform.format(TTL.getDate());
                    mag.setTTL(ttl);
                    kontrak = dtform.format(kontrakDate.getDate());
                    mag.setKontrak(kontrak);
                    mag.setStatus(statusCBox1.getSelectedItem().toString());
                    mag.setUsername(usernam);
                    mag.setPassword(password);
                    mag.setJenisKelamin(jKel.getSelectedItem().toString());
                    mag.setHakAkses(hakAkses.getSelectedItem().toString());
                    mag.setLembur(peg.getLembur());
                    mag.setGaji(karyawanMagang.getGajiBersih());
                    mag.setSlip(peg.getSlip());
                   // data.hapusMagang(mag);
                   kon.exec("UPDATE `pegawai` SET NIP = "+peg.getNIP()+",Nama = '"+peg.getNama()+"',Jabatan = '"+peg.getJabatan()+"',"
                            + "Departemen = '"+peg.getDept()+"',TTL = '"+peg.getTTL()+"', `Jenis Kelamin` = '"+peg.getJenisKelamin()+"',"
                            + "`golongan darah` = '"+peg.getGoldar()+"',Alamat =  '"+peg.getAlamat()+"',status = '"+peg.getStatus()+"',"
                            + " gaji = "+mag.getGaji()+",`Akhir kontrak` = '"+peg.getKontrak()+"'"
                            + " WHERE nip = "+peg.getNIP());
                }
                pindahJabatan();
                kon.exec("UPDATE `pegawai` SET NIP = "+peg.getNIP()+",Nama = '"+peg.getNama()+"',Jabatan = '"+peg.getJabatan()+"',"
                            + "Departemen = '"+peg.getDept()+"',TTL = '"+peg.getTTL()+"', `Jenis Kelamin` = '"+peg.getJenisKelamin()+"',"
                            + "`golongan darah` = '"+peg.getGoldar()+"',Alamat =  '"+peg.getAlamat()+"',status = '"+peg.getStatus()+"',"
                            +"`Akhir kontrak` = '"+peg.getKontrak()+"'"
                            + " WHERE nip = "+peg.getNIP());
                kon.exec("UPDATE `login` SET "
                        + "`PASSWORD` = '"+peg.getPassword()+"' ,`HAK AKSES`= '"+peg.getHakAkses()+"'"+" WHERE nip = "+peg.getNIP());
            }
            JOptionPane.showMessageDialog(null,"Berhasil!");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Lengkapi Data!");
        }
        
        
        
    }//GEN-LAST:event_saveButtonMouseClicked

    private void passicnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passicnMousePressed
        // TODO add your handling code here:
        passfield.setEchoChar((char)0);
    }//GEN-LAST:event_passicnMousePressed

    private void passicnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passicnMouseReleased
        // TODO add your handling code here:
        passfield.setEchoChar('*');
    }//GEN-LAST:event_passicnMouseReleased

    private void depBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_depBoxItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_depBoxItemStateChanged

    private void jabBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jabBoxItemStateChanged
        // TODO add your handling code here:
        if(jabBox.getSelectedItem().equals("Direktur")){
            gajiLabel.setText(Double.toString(direktur.getGajiBersih()));
            //System.out.println(direktur.getGajiBersih());
        }else if(jabBox.getSelectedItem().equals("Manager")){
            gajiLabel.setText(Double.toString(Manager.getGajiBersih()));
            //System.out.println(Manager.getGajiBersih());
        }else if(jabBox.getSelectedItem().equals("Karyawan")){
            gajiLabel.setText(Double.toString(Karyawan.getGajiBersih()));
            //System.out.println(Karyawan.getGajiBersih());
        }else {
            gajiLabel.setText(Double.toString(karyawanMagang.getGajiBersih()));
            //System.out.println(karyawanMagang.getGajiBersih());
        }
    }//GEN-LAST:event_jabBoxItemStateChanged

    public void pindahJabatan(){
        if(jabatanOld.equals("Direktur")){
            data.hapusDirektur(peg.getNama());
        }else if(jabatanOld.equals("Manager")){
            data.hapusManager(peg.getNama());
        }else if(jabatanOld.equals("Karyawan")){
            data.hapusKaryawan(peg.getNama());
        }else if(jabatanOld.equals("Karyawan Magang")){
            data.hapusMagang(peg.getNama());
        }

        if(peg.getJabatan().equals("Direktur")){
            data.tambahDirektur(dir);
        }else if(peg.getJabatan().equals("Manager")){
            data.tambahManager(Man);
        }else if(peg.getJabatan().equals("Karyawan")){
            data.tambahKaryawan(kar);
        }else if(peg.getJabatan().equals("Karyawan Magang")){
            data.tambahMagang(mag);
        }
        
    }
    
    
    public boolean isEmpty(){
        if(NIMPeg.getText().equals("")){
            return true;
        }else if(nmPeg.getText().equals("")){
            return true;
        }else if(address.getText().equals("")){
            return true;
        }else if(TTL.getDate().toString().equals("")){
            return true;
        }else if(kontrakDate.getDate().toString().equals("")){
            return true;
        }
            
        return false;
    }
    
    
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
            java.util.logging.Logger.getLogger(addUpdatePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addUpdatePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addUpdatePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addUpdatePegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addUpdatePegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GDCBox;
    private javax.swing.JTextField NIMPeg;
    private org.jdesktop.swingx.JXDatePicker TTL;
    private javax.swing.JTextArea address;
    private javax.swing.JButton batalButton;
    private javax.swing.JComboBox<String> depBox;
    private javax.swing.JLabel gajiLabel;
    private javax.swing.JComboBox<String> hakAkses;
    private javax.swing.JComboBox<String> jKel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jabBox;
    private org.jdesktop.swingx.JXDatePicker kontrakDate;
    private javax.swing.JTextField nmPeg;
    private javax.swing.JLabel pass;
    private javax.swing.JPasswordField passfield;
    private javax.swing.JLabel passicn;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> statusCBox1;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usrname;
    // End of variables declaration//GEN-END:variables
}
