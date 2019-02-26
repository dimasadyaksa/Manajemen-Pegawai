/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import User.*;
import backgroundProcess.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimas Adiyaksa
 */
public class List {
    private ArrayList<Karyawan> ListKaryawan = new ArrayList<>();
    private ArrayList<Manager> ListManager = new ArrayList<>();
    private ArrayList<direktur> ListDirektur = new ArrayList<>();
    private ArrayList<karyawanMagang> ListMagang = new ArrayList<>();
    private ArrayList<Pekerjaan> listPekerjaan = new ArrayList<>();
    private ArrayList<NewsFeed> feed = new ArrayList<>();
    koneksi kon = new koneksi();
    private direktur dir = new direktur();
    private Manager man = new Manager();
    private Karyawan kar = new Karyawan();
    private karyawanMagang mag = new karyawanMagang();
    private Date tgl = new Date();
    private DateFormat dt = new SimpleDateFormat("dd-MMMM-yyyy");
    
    public void tambahDirektur(direktur dir){
        ListDirektur.add(dir);
    }
    
    public void tambahManager(Manager man){
        ListManager.add(man);
    }
    
    public void tambahKaryawan(Karyawan kar){
        ListKaryawan.add(kar);
        System.out.println(kar.getNama());
    }
    
    public void tambahMagang(karyawanMagang Mag){
        ListMagang.add(Mag);
    }
    
    public void hapusDirektur(String dir){
        direktur dr = new direktur();           
        for(int i = 0;i<ListDirektur.size();i++){
            dr = ListDirektur.get(i);
            if(dr.getNama().equals(dir)){
                ListDirektur.remove(i);
                
                System.out.println("Dihapus");
            }
            
            System.out.println(dr.getNama()+"&"+dir);
                //System.out.println(dr.getNama());
        }
        
    }
    
    public void hapusManager(String man){
        Manager mn = new Manager();
        for(int i = 0;i<ListManager.size();i++){
            mn = ListManager.get(i);
            if(mn.getNama().equals(man)){
                ListManager.remove(i);
                
                System.out.println("Dihapus");
            }
              
            
            System.out.println(mn.getNama()+"&"+man);
//  System.out.println(mn.getNama());
        }
        
    }
    
    public void hapusKaryawan(String kar){
        Karyawan kr = new Karyawan();
        for(int i = 0;i<ListKaryawan.size();i++){
            kr = ListKaryawan.get(i);
            if(kr.getNama().equals(kar)){
                ListKaryawan.remove(i);
                System.out.println("Dihapus");
            }
            System.out.println(kr.getNama()+"&"+kar);
            //System.out.println(kr.getNama());
        }
    }
    
    public void hapusMagang(String mag){
        karyawanMagang mg = new karyawanMagang();
        for(int i = 0;i<ListMagang.size();i++){
            mg = ListMagang.get(i);
            if(mg.getNama().equals(mag)){
                ListMagang.remove(i);
                
                System.out.println("Dihapus");
            }
            System.out.println(mg.getNama()+"&"+mag);
   //             System.out.println(mg.getNama());
        }
    }
    
    public ArrayList<Karyawan> getListKaryawan() {
        return ListKaryawan;
    }

    public ArrayList<Manager> getListManager() {
        return ListManager;
    }

    public ArrayList<direktur> getListDirektur() {
        return ListDirektur;
    }

    public ArrayList<karyawanMagang> getListMagang() {
        return ListMagang;
    }
    
    
    
    public void read(){

        try {
            try {
            ResultSet rs = kon.connect("SELECT * FROM jabatan");
            
            rs.next();
            direktur.setGajiBersih(Double.parseDouble(rs.getString("Gaji")));
            direktur.setBonus(Double.parseDouble(rs.getString("Bonus")));
            rs.next();
            Karyawan.setBonus(Double.parseDouble(rs.getString("Bonus")));
            Karyawan.setGajiBersih(Double.parseDouble(rs.getString("gaji")));
            rs.next();
            karyawanMagang.setBonus(Double.parseDouble(rs.getString("Bonus")));
            karyawanMagang.setGajiBersih(Double.parseDouble(rs.getString("Gaji")));
            rs.next();
            Manager.setBonus(Double.parseDouble(rs.getString("Bonus")));
            Manager.setGajiBersih(Double.parseDouble(rs.getString("Gaji")));
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
            ResultSet rs = kon.connect("SELECT * FROM pegawai");
            ResultSet login = null;
            ResultSet slip = null;
            ResultSet gajiJabatan = null;
            ResultSet lembur = null;
            int idxDir = 0;
            int idxMan = 0;
            int idxKar = 0;
            int idxMag = 0;
            
            while(rs.next()){
                
                
                
                
                if(rs.getString("Jabatan").equals("Direktur")){
                    direktur dr = new direktur();
                    
                    dr.setNIP(rs.getString("NIP"));
                    dr.setNama(rs.getString("Nama"));
                    dr.setAlamat(rs.getString("Alamat"));
                    dr.setJenisKelamin(rs.getString("jenis Kelamin"));
                    login = kon.connect("SELECT * FROM login "
                            + "WHERE NIP = "+dr.getNIP());
                    slip = kon.connect("SELECT COUNT(NIP) FROM gajian "
                            + "WHERE NIP = "+dr.getNIP());
                    lembur = kon.connect("SELECT * FROM lembur WHERE NIP = "+dr.getNIP());
                    
                    while (lembur.next()){
                        dr.setLembur(Integer.parseInt(lembur.getString("Jumlah Lembur")));
                    }
                                        
                    slip.next();
                    if(Integer.parseInt(slip.getString("COUNT(NIP)"))!=0){
                        slip = kon.connect("SELECT * FROM gajian WHERE NIP = "+dr.getNIP());
                        
                        while(slip.next()){
                            //tgl = dt.parse(slip.getString("Tanggal"));
                            dr.tambahSlip(slip.getString("ID"),
                                    Integer.parseInt(slip.getString("Gaji")),slip.getString("Tanggal"),
                                    Integer.parseInt(slip.getString("Lembur")));
                        }
                    
                    }
                    
                    
                    
                    login.next();
                    
                    dr.setUsername(login.getString("Username"));
                    dr.setPassword(login.getString("Password"));
                    dr.setHakAkses(login.getString("Hak Akses"));
                    dr.setTTL(rs.getString("TTL"));
                    dr.setStatus(rs.getString("status"));
                    dr.setJabatan(rs.getString("Jabatan"));
                    dr.setDept(rs.getString("Departemen"));
                    dr.setKontrak(rs.getString("Akhir kontrak"));
                    dr.setGaji(Double.parseDouble(rs.getString("Gaji")));
                    ListDirektur.add(dr);
                    
                }else if(rs.getString("Jabatan").equals("Manager")){
                    Manager man = new Manager();
                    man.setNIP(rs.getString("NIP"));
                    man.setNama(rs.getString("Nama"));
                    man.setAlamat(rs.getString("Alamat"));
                    man.setJenisKelamin(rs.getString("jenis Kelamin"));
                    login = kon.connect("SELECT * FROM login "
                            + "WHERE NIP = "+man.getNIP());
                    slip = kon.connect("SELECT COUNT(NIP) FROM gajian "
                            + "WHERE NIP = "+man.getNIP());
                    lembur = kon.connect("SELECT * FROM lembur WHERE NIP = "+man.getNIP());
                    
                    while (lembur.next()){
                        man.setLembur(Integer.parseInt(lembur.getString("Jumlah Lembur")));
                    }
                    slip.next();
                    if(Integer.parseInt(slip.getString("COUNT(NIP)"))!=0){
                        slip = kon.connect("SELECT * FROM gajian WHERE NIP = "+man.getNIP());
                        
                        while(slip.next()){
                          //  tgl = dt.parse(rs.getString("Tanggal"));
                            man.tambahSlip(slip.getString("ID"),
                                    Integer.parseInt(slip.getString("Gaji")),slip.getString("Tanggal"),
                                    Integer.parseInt(slip.getString("Lembur")));
                        }
                    
                    }
                    
                    login.next();
                    man.setUsername(login.getString("Username"));
                    man.setPassword(login.getString("Password"));
                    man.setHakAkses(login.getString("Hak Akses"));
                    man.setTTL(rs.getString("TTL"));
                    man.setStatus(rs.getString("status"));
                    man.setJabatan(rs.getString("Jabatan"));
                    man.setDept(rs.getString("Departemen"));
                    man.setKontrak(rs.getString("Akhir kontrak"));
                    man.setGaji(Double.parseDouble(rs.getString("Gaji")));
                    //man.setGaji();
                    ListManager.add(man);
                }else if(rs.getString("Jabatan").equals("Karyawan")){
                    Karyawan kar = new Karyawan();
                    kar.setNIP(rs.getString("NIP"));
                    kar.setNama(rs.getString("Nama"));
                    kar.setAlamat(rs.getString("Alamat"));
                    kar.setJenisKelamin(rs.getString("jenis Kelamin"));
                    login = kon.connect("SELECT * FROM login "
                            + "WHERE NIP = "+kar.getNIP());
                    slip = kon.connect("SELECT COUNT(NIP) FROM gajian "
                            + "WHERE NIP = "+kar.getNIP());
                    lembur = kon.connect("SELECT * FROM lembur WHERE NIP = "+kar.getNIP());
                    
                    while (lembur.next()){
                        kar.setLembur(Integer.parseInt(lembur.getString("Jumlah Lembur")));
                    }
                    slip.next();
                    if(Integer.parseInt(slip.getString("COUNT(NIP)"))!=0){
                        slip = kon.connect("SELECT * FROM gajian WHERE NIP = "+kar.getNIP());
                        
                        while(slip.next()){
                          //  tgl = dt.parse(rs.getString("Tanggal"));
                            kar.tambahSlip(slip.getString("ID"),
                                    Integer.parseInt(slip.getString("Gaji")),slip.getString("Tanggal"),
                                    Integer.parseInt(slip.getString("Lembur")));
                        }
                    
                    }
                    
                    login.next();
                    kar.setUsername(login.getString("Username"));
                    kar.setPassword(login.getString("Password"));
                    kar.setHakAkses(login.getString("Hak Akses"));
                    kar.setTTL(rs.getString("TTL"));
                    kar.setStatus(rs.getString("status"));
                    kar.setJabatan(rs.getString("Jabatan"));
                    kar.setDept(rs.getString("Departemen"));
                    kar.setKontrak(rs.getString("Akhir kontrak"));
                    kar.setGaji(Double.parseDouble(rs.getString("Gaji")));
                    ListKaryawan.add(kar);
                }else if(rs.getString("Jabatan").equals("Karyawan Magang")){
                    karyawanMagang mag = new karyawanMagang();
                    mag.setNIP(rs.getString("NIP"));
                    mag.setNama(rs.getString("Nama"));
                    mag.setAlamat(rs.getString("Alamat"));
                    mag.setJenisKelamin(rs.getString("jenis Kelamin"));
                    login = kon.connect("SELECT * FROM login "
                            + "WHERE NIP = "+mag.getNIP());
                    slip = kon.connect("SELECT COUNT(NIP) FROM gajian "
                            + "WHERE NIP = "+mag.getNIP());
                    lembur = kon.connect("SELECT * FROM lembur WHERE NIP = "+mag.getNIP());
                    
                    while (lembur.next()){
                        mag.setLembur(Integer.parseInt(lembur.getString("Jumlah Lembur")));
                    }
                    slip.next();
                    if(Integer.parseInt(slip.getString("COUNT(NIP)"))!=0){
                        slip = kon.connect("SELECT * FROM gajian WHERE NIP = "+mag.getNIP());
                        
                        while(slip.next()){
                          //  tgl = dt.parse(rs.getString("Tanggal"));
                            mag.tambahSlip(slip.getString("ID"),
                                    Integer.parseInt(slip.getString("Gaji")),slip.getString("Tanggal"),
                                    Integer.parseInt(slip.getString("Lembur")));
                        }
                    
                    }
                    
                    login.next();
                    mag.setUsername(login.getString("Username"));
                    mag.setPassword(login.getString("Password"));
                    mag.setHakAkses(login.getString("Hak Akses"));
                    mag.setTTL(rs.getString("TTL"));
                    mag.setStatus(rs.getString("status"));
                    mag.setJabatan(rs.getString("Jabatan"));
                    mag.setDept(rs.getString("Departemen"));
                    mag.setKontrak(rs.getString("Akhir kontrak"));
                    mag.setGaji(Double.parseDouble(rs.getString("Gaji")));
                    ListMagang.add(mag);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void readJob(){
        koneksi kon = new koneksi();
        try {
            ResultSet rs = kon.connect("SELECT * FROM jobdepartemen");
            
            while(rs.next()){
                listPekerjaan.add(new Pekerjaan(rs.getString("Departemen"),
                        rs.getString("Pekerjaan"),
                        rs.getString("Deadline")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<Pekerjaan> getListPekerjaan() {
        return listPekerjaan;
    }

    public void setListPekerjaan(ArrayList<Pekerjaan> listPekerjaan) {
        this.listPekerjaan = listPekerjaan;
    }
    
    public void tambahJob(Pekerjaan listPekerjaan){
        this.listPekerjaan.add(listPekerjaan);
    }
    
    public void delJob(Pekerjaan p){
        listPekerjaan.remove(p);
        
        kon.exec("DELETE FROM `jobdepartemen` WHERE Pekerjaan = '"+p.getJob()+"'");
    }
    
    public void readFeed(){
        koneksi kon = new koneksi();
        try {
            ResultSet rs = kon.connect("SELECT * FROM `news feed`");
            
            while(rs.next()){
                feed.add(new NewsFeed(rs.getString("News"),rs.getString("kode")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<NewsFeed> getFeed() {
        return feed;
    }

    public void setFeed(ArrayList<NewsFeed> feed) {
        this.feed = feed;
    }
    
    public void tambahFeed(NewsFeed feed){
        this.feed.add(feed);
        kon.exec("INSERT INTO `news feed`(`kode`, `News`) VALUES ('"+feed.getKode()+"','"+
                feed.getNews()+"')");
    }
    
    public void delfeed(NewsFeed f){
        System.out.println(f.getKode()+f.getNews());
        kon.exec("DELETE FROM `news feed` WHERE kode = '"+f.getKode()+"'");
        this.feed.remove(f);
    }
    
}
