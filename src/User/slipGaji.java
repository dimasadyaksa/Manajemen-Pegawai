/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.*;

/**
 *
 * @author Dimas Adiyaksa
 */
public class slipGaji {
    private String kodeSlip;
    private double gaji;
    private String tanggal;
    private int Lembur;
    public slipGaji(String kodeSlip, double gaji, String tanggal, int Lembur) {
        this.kodeSlip = kodeSlip;
        this.gaji = gaji;
        this.tanggal = tanggal;
        this.Lembur = Lembur;
    }

    slipGaji() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getLembur() {
        return Lembur;
    }

    public void setLembur(int Lembur) {
        this.Lembur = Lembur;
    }
    
    
    public String getKodeSlip() {
        return kodeSlip;
    }

    public void setKodeSlip(String kodeSlip) {
        this.kodeSlip = kodeSlip;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
