/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backgroundProcess;

import List.List;
import User.Karyawan;
import User.Manager;
import User.Pegawai;
import User.direktur;
import User.karyawanMagang;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimas Adiyaksa
 */
public class loginproses {
    private String username;
    private String password;
    ResultSet hasil = null;
    koneksi kon = new koneksi();   
    List data = new List();
    
    public boolean validasi(String username, String password){
        try {
            hasil = kon.connect("SELECT * FROM login");
        } catch (SQLException ex) {
            Logger.getLogger(loginproses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while(hasil.next()){
                this.username = hasil.getString("username");
                this.password = hasil.getString("password");
                if(this.username.equals(username)&&this.password.equals(password)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginproses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
     
    public String getHakAkses(String username, String password){
        String hkAkses = null;
        try {
            hasil = kon.connect("SELECT `hak akses` FROM login WHERE username = '"+username+
                    "' AND password = '"+password+"'");
            hasil.next();
            hkAkses = hasil.getString("Hak Akses");
        } catch (SQLException ex) {
            Logger.getLogger(loginproses.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return hkAkses;
    }
    
    
    public Pegawai getPeg(String username,String password){
        Pegawai peg = new Pegawai();
            data.read();
            for(int i = 0;i<data.getListDirektur().size();i++){
                if(data.getListDirektur().get(i).getUsername().equals(username)&&
                        data.getListDirektur().get(i).getPassword().equals(password)){
                    peg.setNIP(data.getListDirektur().get(i).getNIP());
                    peg.setSlip(data.getListDirektur().get(i).getSlip());
                    peg.setNama(data.getListDirektur().get(i).getNama());
                    peg.setStatus(data.getListDirektur().get(i).getStatus());
                    peg.setJabatan(data.getListDirektur().get(i).getJabatan());
                    peg.setDept(data.getListDirektur().get(i).getDept());
                    Pegawai.setGajiBersih(direktur.getGajiBersih());
                    Pegawai.setBonus(direktur.getBonus());
                    peg.setLembur(data.getListDirektur().get(i).getLembur());
                    peg.setGaji(data.getListDirektur().get(i).getGaji());
                    return peg;
                }
            }
            
            
            for(int i = 0;i<data.getListManager().size();i++){
                if(data.getListManager().get(i).getUsername().equals(username)&&
                        data.getListManager().get(i).getPassword().equals(password)){
                    peg.setNIP(data.getListManager().get(i).getNIP());
                    peg.setSlip(data.getListManager().get(i).getSlip());
                    peg.setNama(data.getListManager().get(i).getNama());
                    peg.setStatus(data.getListManager().get(i).getStatus());
                    peg.setJabatan(data.getListManager().get(i).getJabatan());
                    peg.setDept(data.getListManager().get(i).getDept());
                    Pegawai.setGajiBersih(Manager.getGajiBersih());
                    Pegawai.setBonus(Manager.getBonus());
                    peg.setLembur(data.getListManager().get(i).getLembur());
                    peg.setGaji(data.getListManager().get(i).getGaji());
                    return peg;
                }
            }
                        
            
            for(int i = 0;i<data.getListKaryawan().size();i++){
                if(data.getListKaryawan().get(i).getUsername().equals(username)&&
                        data.getListKaryawan().get(i).getPassword().equals(password)){
                    peg.setNIP(data.getListKaryawan().get(i).getNIP());
                    peg.setSlip(data.getListKaryawan().get(i).getSlip());
                    peg.setNama(data.getListKaryawan().get(i).getNama());
                    peg.setStatus(data.getListKaryawan().get(i).getStatus());
                    peg.setJabatan(data.getListKaryawan().get(i).getJabatan());
                    peg.setDept(data.getListKaryawan().get(i).getDept());
                    Pegawai.setGajiBersih(Karyawan.getGajiBersih());
                    Pegawai.setBonus(Karyawan.getBonus());
                    peg.setLembur(data.getListKaryawan().get(i).getLembur());
                    peg.setGaji(data.getListKaryawan().get(i).getGaji());
                    return peg;
                }
            }
          
            for(int i = 0;i<data.getListMagang().size();i++){
                if(data.getListMagang().get(i).getUsername().equals(username)&&
                        data.getListMagang().get(i).getPassword().equals(password)){
                    peg.setNIP(data.getListMagang().get(i).getNIP());
                    peg.setSlip(data.getListMagang().get(i).getSlip());
                    peg.setNama(data.getListMagang().get(i).getNama());
                    peg.setStatus(data.getListMagang().get(i).getStatus());
                    peg.setJabatan(data.getListMagang().get(i).getJabatan());
                    peg.setDept(data.getListMagang().get(i).getDept());
                    Pegawai.setGajiBersih(karyawanMagang.getGajiBersih());
                    Pegawai.setBonus(karyawanMagang.getBonus());
                    peg.setLembur(data.getListMagang().get(i).getLembur());
                    peg.setGaji(data.getListMagang().get(i).getGaji());
                    return peg;
                }
            }
        return null;
        
    }
}
