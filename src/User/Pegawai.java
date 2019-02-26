/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import backgroundProcess.koneksi;
import java.util.ArrayList;

public class  Pegawai {
    private String NIP;
    private String Nama;
    private String Alamat;
    private String jenisKelamin;
    private String TTL;
    private String status;
    private String username;
    private String password;
    private String Jabatan;
    private String Dept;
    private String HakAkses;
    private String kontrak;
   // private String kodeSlip;
    private ArrayList<slipGaji> slip = new ArrayList();
    private int lembur;
    private String goldar;
    static double gajiBersih;
    private double gaji;
    private static double bonus;
    int idx;
    koneksi kon = new koneksi();
    
    public Pegawai(String NIP, String Nama, String Alamat, String jenisKelamin, 
            String TTL, String status, String username, String password, 
            String Jabatan,String Dept){//, String kodeSlip) {
        this.NIP = NIP;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.jenisKelamin = jenisKelamin;
        this.TTL = TTL;
        this.status = status;
        this.username = username;
        this.password = password;
        this.Dept = Dept;
        this.Jabatan = Jabatan;
        
    }

    public String generateKdSlip(){
        String kd;
        
        kd = Character.toString(this.Jabatan.charAt(0))+
                Character.toString(this.Jabatan.charAt(1))+
                Character.toString(this.Jabatan.charAt(2))+
                Character.toString(this.NIP.charAt(0))+
                Character.toString(this.NIP.charAt(1))+
                Character.toString(this.NIP.charAt(2))+
                slip.size();
        
        return kd;
    }
    
    public Pegawai(String NIP, String Nama, String Alamat, 
            String jenisKelamin, String TTL, String status, 
            String username, String password, String Jabatan, 
            String Dept, String HakAkses, String kontrak, 
            int lembur, String goldar, double gaji) {
        this.NIP = NIP;
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.jenisKelamin = jenisKelamin;
        this.TTL = TTL;
        this.status = status;
        this.username = username;
        this.password = password;
        this.Jabatan = Jabatan;
        this.Dept = Dept;
        this.HakAkses = HakAkses;
        this.kontrak = kontrak;
        this.lembur = lembur;
        this.goldar = goldar;
        this.gaji = gaji;
    }
    
    public Pegawai(){
        
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    
    
    public static double getGajiBersih() {
        return gajiBersih;
    }

    public static void setGajiBersih(double gajiBersih) {
        Pegawai.gajiBersih = gajiBersih;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        Pegawai.bonus = bonus;
    }
    
    public String getNIP() {
        return NIP;
    }

    public String getDept() {
        return Dept;
    }

    public String getKontrak() {
        return kontrak;
    }

    public void setKontrak(String kontrak) {
        this.kontrak = kontrak;
    }
    
    
    public slipGaji getLastSlip(){
        if(!slip.isEmpty()){
            slipGaji s = new slipGaji();
            int size = slip.size()-1;
            s = this.slip.get(size);
            return s;
        }
        
        return null;
    }
    
    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    
    
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return Jabatan;
    }

    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }
    
    public void tambahSlip(String kdSlip,double gaji,String tanggal, int lembur){
        slip.add(new slipGaji(kdSlip,gaji,tanggal,lembur));
    }
    
    public int getLembur() {
        return lembur;
    }

    public String getHakAkses() {
        return HakAkses;
    }

    public void setHakAkses(String HakAkses) {
        this.HakAkses = HakAkses;
    }

    public ArrayList<slipGaji> getSlip() {
        return slip;
    }

    public void setSlip(ArrayList<slipGaji> slip) {
        this.slip = slip;
    }

    public String getGoldar() {
        return goldar;
    }

    public void hapus(){
        kon.exec("DELETE FROM pegawai WHERE NIP = "+this.NIP);
        kon.exec("DELETE FROM lembur WHERE NIP = "+this.NIP);
        kon.exec("DELETE FROM login WHERE NIP = "+this.NIP);
    }
    
    public void setGoldar(String goldar) {
        this.goldar = goldar;
    }

    public void updateLembur(int lembur){
        kon.exec("UPDATE `lembur` SET `Jumlah Lembur` = "+lembur+" WHERE NIP = "+this.NIP+"");
    }
    
    public void setLembur(int lembur) {
        
        this.lembur = lembur;
    }
    
    
}
