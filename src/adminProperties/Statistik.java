/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminProperties;

import User.Karyawan;
import User.Manager;
import User.direktur;
import User.karyawanMagang;
import backgroundProcess.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dimas Adiyaksa
 */

    
public class Statistik {
    private int jumlahDirektur;
    private int jumlahManager;
    private int jumlahKaryawan;
    private int jumlahMagang;
    ResultSet hasil = null;
    koneksi kon = new koneksi();
    
   
    
    public int getJumlahDirektur() {
        try {
            hasil = kon.connect("SELECT COUNT(jabatan) FROM pegawai WHERE jabatan = 'Direktur'");
            hasil.next();
            jumlahDirektur = Integer.parseInt(hasil.getString("COUNT(Jabatan)"));
        } catch (SQLException ex) {
            Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlahDirektur;
    }

    public int getJumlahManager() {
        try {
            hasil = kon.connect("SELECT COUNT(jabatan) FROM pegawai WHERE jabatan = 'Manager'");
            hasil.next();
            jumlahManager = Integer.parseInt(hasil.getString("COUNT(Jabatan)"));
        } catch (SQLException ex) {
            Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlahManager;
    }

    public int getJumlahKaryawan() {
        try {
            hasil = kon.connect("SELECT COUNT(jabatan) FROM pegawai WHERE jabatan = 'Karyawan'");
            hasil.next();
            jumlahKaryawan = Integer.parseInt(hasil.getString("COUNT(Jabatan)"));
        } catch (SQLException ex) {
            Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlahKaryawan;
    }

    public int getJumlahMagang() {
        try {
            hasil = kon.connect("SELECT COUNT(jabatan) FROM pegawai WHERE jabatan = 'Karyawan Magang'");
            hasil.next();
            jumlahMagang = Integer.parseInt(hasil.getString("COUNT(Jabatan)"));
        } catch (SQLException ex) {
            Logger.getLogger(Statistik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jumlahMagang;
    }
    
    public void tableStatistik(javax.swing.JTable table){
        DefaultTableModel model = new DefaultTableModel();
    }
    
    public void ubahGaji(double gaji,double bonus , int opsi){
        if(opsi == 1){
            direktur.setGajiBersih(gaji);
            direktur.setBonus(bonus);
            kon.exec("UPDATE `jabatan` SET `GAJI`="+gaji+" "
                    + ",`Bonus` = "+bonus+" WHERE `ID`= 'D01'");
        }else if(opsi == 2){
            Manager.setGajiBersih(gaji);
            Manager.setBonus(bonus);
            kon.exec("UPDATE `jabatan` SET `GAJI`="+gaji+" "
                    + ",`bonus` = "+bonus+" WHERE `ID`= 'M01'");
        }else if(opsi == 3){
            Karyawan.setGajiBersih(gaji);
            Karyawan.setBonus(bonus);
            kon.exec("UPDATE `jabatan` SET `GAJI`="+gaji+" "
                    + ",`bonus` = "+bonus+" WHERE `ID`= 'K001'");
        }else{
            karyawanMagang.setGajiBersih(gaji);
            karyawanMagang.setBonus(bonus);
            kon.exec("UPDATE `jabatan` SET `GAJI`="+gaji+" "
                    + ",`bonus` = "+bonus+" WHERE `ID`= 'KM01'");
        }
    }
    
 
}
