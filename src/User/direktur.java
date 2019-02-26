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
public class direktur extends Pegawai {
    static double gajiBersih;
    private double gaji;
    private static double bonus;
    
    public direktur(){
        //this.gaji = gajiBersih +(bonus*super.getLembur());
    }


//    public void setGaji() {
//        gaji = gajiBersih + (bonus*super.getLembur());
//    }
//    
    public void setGaji(double gj) {
        this.gaji = gj ;//+(bonus*super.getLembur()) ;
    }
    @Override
    public double getGaji(){
        return gaji+(bonus*super.getLembur());
    }
    
    public void gajiLembur(int sum){
        this.gaji = this.gaji +(bonus*super.getLembur());
    }
    public static double getGajiBersih() {
        return gajiBersih;
    }

    public static void setGajiBersih(double gajiBersih) {
        direktur.gajiBersih = gajiBersih;
    }

    public static double getBonus() {
        return bonus;
    }

    public static void setBonus(double bonus) {
        direktur.bonus = bonus;
    }
    
    
}
