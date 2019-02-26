/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Dimas Adiyaksa
 */
public class Pekerjaan {
    private String departemen;
    private String job;
    private String tanggal;

    public Pekerjaan(String departemen, String job, String tanggal) {
        this.departemen = departemen;
        this.job = job;
        this.tanggal = tanggal;
    }

    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
    
    
}
