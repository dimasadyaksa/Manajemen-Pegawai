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
public class karyawanMagang extends Pegawai{
     static double gajiBersih;

    
    private double gaji;
    private static double bonus;
    
    public karyawanMagang(){
        
    }

    public static double getGajiBersih() {
        return gajiBersih;
    }

    public static double getBonus() {
        return bonus;
    }
    
    public static void setGajiBersih(double gaji) {
        karyawanMagang.gajiBersih = gaji;
    }

    public void setGaji() {
        gaji = gajiBersih + (bonus*super.getLembur());
    }
    
     @Override
    public void setGaji(double gj) {
        this.gaji = gj ;
    }
    public static void setBonus(double bonus) {
        karyawanMagang.bonus = bonus;
    }
    
    public double getGaji(){
        return gaji+(bonus*super.getLembur()) ;
    }
}
