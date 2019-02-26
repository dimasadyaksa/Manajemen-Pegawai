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
public class Manager extends Pegawai {
    static double gajiBersih;
    private double gaji;
    private static double bonus;
    
    public static void setGajiBersih(double gajiBersih) {
        Manager.gajiBersih = gajiBersih;
    }
    
    
    
    public Manager(){
        //this.gaji = gajiBersih +(bonus*super.getLembur());
    }
    

//    public void setGaji() {
//        this.gaji = gajiBersih +(bonus*super.getLembur());
//    }
    
    public static double getGajiBersih(){
        return gajiBersih;
    }

    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        Manager.bonus = bonus;
    }

    @Override
    public double getGaji() {
        return gaji+(bonus*super.getLembur());
    }

    @Override
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
    
    
}
