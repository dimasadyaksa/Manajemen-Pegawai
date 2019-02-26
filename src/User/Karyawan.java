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
public class Karyawan extends Pegawai{
    static double gajiBersih;

    private double gaji;
    private static double bonus;
    public Karyawan(){
        
    }

    public static double getGajiBersih() {
        return gajiBersih;
    }
    @Override
    public void setGaji(double gj) {
        gaji = gj ;
    }
    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        Karyawan.bonus = bonus;
    }
    
    
    public static void setGajiBersih(double gj) {
        Karyawan.gajiBersih = gj;
    }
    

    public void setGaji() {
        gaji = gajiBersih + (bonus*super.getLembur());
    }
    
    @Override
    public double getGaji(){
        return gaji+(bonus*super.getLembur()) ;
    }
}
