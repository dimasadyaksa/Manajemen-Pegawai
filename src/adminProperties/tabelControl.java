/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminProperties;

import List.List;
import User.Karyawan;
import User.Manager;
import User.NewsFeed;
import User.Pegawai;
import User.Pekerjaan;
import User.direktur;
import User.karyawanMagang;
import User.slipGaji;
import backgroundProcess.koneksi;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dimas Adiyaksa
 */
public class tabelControl { 
    
    private ArrayList<Karyawan> ListKaryawan = new ArrayList<>();
    private ArrayList<Manager> ListManager = new ArrayList<>();
    private ArrayList<direktur> ListDirektur = new ArrayList<>();
    private ArrayList<karyawanMagang> ListMagang = new ArrayList<>();
    private ArrayList<Pekerjaan> lp = new ArrayList<>();
    private ArrayList<NewsFeed> feed = new ArrayList<>();
    koneksi kon = new koneksi();
    
    public void tabelStatistik(javax.swing.JTable tabel,ArrayList<direktur> ListDirektur,ArrayList<Manager> ListManager,
            ArrayList<Karyawan> ListKaryawan,ArrayList<karyawanMagang> ListMagang){
       /* TableColumn colmod = new TableColumn();
        colmod = tabel.getColumn("No");
        colmod.setMinWidth(16);
        colmod.setMaxWidth(16);
        */
        DefaultTableModel model = new DefaultTableModel();
        
        model = new DefaultTableModel(null,new String[]{
            "No", "Nama", "Jabatan","Departemen"
        });
        
        tabel.setModel(model);
        
        Object[] row = new Object[4];
        int count=1;
        
        
        
        
        for(int i = 0;i<ListDirektur.size();i++){
            row[0] = count++;
            row[1] = ListDirektur.get(i).getNama();
            row[2] = ListDirektur.get(i).getJabatan();
            row[3] = ListDirektur.get(i).getDept();
            
            model.addRow(row);
        }
        for(int i = 0;i<ListManager.size();i++){
            row[0] = count++;
            row[1] = ListManager.get(i).getNama();
            row[2] = ListManager.get(i).getJabatan();
            row[3] = ListManager.get(i).getDept();
            //System.out.println(row[1]);
            model.addRow(row);
        }
        for(int i = 0;i<ListKaryawan.size();i++){
            row[0] = count++;
            row[1] = ListKaryawan.get(i).getNama();
            row[2] = ListKaryawan.get(i).getJabatan();
            row[3] = ListKaryawan.get(i).getDept();
            model.addRow(row);
        }
        for(int i = 0;i<ListMagang.size();i++){
            row[0] = count++;
            row[1] = ListMagang.get(i).getNama();
            row[2] = ListMagang.get(i).getJabatan();
            row[3] = ListMagang.get(i).getDept();
            model.addRow(row);
        }
        
        tabel.setModel(model);
        tabel.getColumn("No").setMaxWidth(30);
        tabel.getColumn("No").setMinWidth(30);
    }
    
    public void tabelStatistik(javax.swing.JTable tabel,ArrayList<direktur> ListDirektur,ArrayList<Manager> ListManager,
            ArrayList<Karyawan> ListKaryawan,ArrayList<karyawanMagang> ListMagang,int a){
        
        DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "No", "Nama", "Jabatan","Departemen","Jumlah Lembur","Gaji"
        });
        
        Object[] row = new Object[6];
        int count=1;
        tabel.setModel(model);
        for(int i = 0;i<ListDirektur.size();i++){
            row[0] = count++;
            row[1] = ListDirektur.get(i).getNama();
            row[2] = ListDirektur.get(i).getJabatan();
            row[3] = ListDirektur.get(i).getDept();
            row[4] = ListDirektur.get(i).getLembur();
            row[5] = formatUang(ListDirektur.get(i).getGaji());
            
            model.addRow(row);
        }
        for(int i = 0;i<ListManager.size();i++){
            row[0] = count++;
            row[1] = ListManager.get(i).getNama();
            row[2] = ListManager.get(i).getJabatan();
            row[3] = ListManager.get(i).getDept();
            row[4] = ListManager.get(i).getLembur();
            row[5] = formatUang(ListManager.get(i).getGaji());
            //System.out.println(row[1]);
            model.addRow(row);
        }
        for(int i = 0;i<ListKaryawan.size();i++){
            row[0] = count++;
            row[1] = ListKaryawan.get(i).getNama();
            row[2] = ListKaryawan.get(i).getJabatan();
            row[3] = ListKaryawan.get(i).getDept();
            row[4] = ListKaryawan.get(i).getLembur();
            row[5] = formatUang(ListKaryawan.get(i).getGaji());
            model.addRow(row);
        }
        for(int i = 0;i<ListMagang.size();i++){
            row[0] = count++;
            row[1] = ListMagang.get(i).getNama();
            row[2] = ListMagang.get(i).getJabatan();
            row[3] = ListMagang.get(i).getDept();
            row[4] = ListMagang.get(i).getLembur();
            row[5] = formatUang(ListMagang.get(i).getGaji());
            model.addRow(row);
        }
        
        tabel.setModel(model);
        tabel.getColumn("No").setMaxWidth(30);
        tabel.getColumn("No").setMinWidth(30);
    }
    
    
    public void tabelTim(javax.swing.JTable tabel, ArrayList<direktur> ld,ArrayList<Manager> lm,
            ArrayList<Karyawan> lk,ArrayList<karyawanMagang> lkm,String dept){
        DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "No", "Nama","Jabatan","Alamat"
        });
        
        
            Object[] row = new Object[4];
            int count=1;
        tabel.setModel(model);
            for(int i = 0;i<ld.size();i++){
                
                if(ld.get(i).getDept().equals(dept)){
                    row[0] = count++;
                    row[1] = ld.get(i).getNama();
                    row[2] = ld.get(i).getJabatan();
                    row[3] = ld.get(i).getAlamat(); 
                    model.addRow(row);  
                }
                     
            }
            for(int i = 0;i<lm.size();i++){
                
                if(lm.get(i).getDept().equals(dept)){
                    row[0] = count++;
                    row[1] = lm.get(i).getNama();
                    row[2] = lm.get(i).getJabatan();
                    row[3] = lm.get(i).getAlamat(); 
                    model.addRow(row);  
                }
            }
        
            for(int i = 0;i<lk.size();i++){
               
                if(lk.get(i).getDept().equals(dept)){
                    row[0] = count++;
                    row[1] = lk.get(i).getNama();
                    row[2] = lk.get(i).getJabatan();
                    row[3] = lk.get(i).getAlamat();
                    model.addRow(row);  
                }
                
            }
       
            for(int i = 0;i<lkm.size();i++){
                
                if(lkm.get(i).getDept().equals(dept)){
                    row[0] = count++;
                    row[1] = lkm.get(i).getNama();
                    row[2] = lkm.get(i).getJabatan();
                    row[3] = lkm.get(i).getAlamat(); 
                    model.addRow(row);  
                }
            }
        
        
        tabel.setModel(model);
        tabel.getColumn("No").setMaxWidth(30);
        tabel.getColumn("No").setMinWidth(30);
    }
  
    public void tabelSlip(javax.swing.JTable tabel,Pegawai peg){
        DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "Kode Slip", "Nama","Jumlah","Tanggal","Keterangan"
        });
        
        
            Object[] row = new Object[5];
        int count=1;
        tabel.setModel(model);
        
        for(int i = 0;i<peg.getSlip().size();i++){
            row[0] = peg.getSlip().get(i).getKodeSlip();
            row[1] = peg.getNama();
            row[2] = formatUang(peg.getSlip().get(i).getGaji());
            row[3] = peg.getSlip().get(i).getTanggal();
            row[4] = "Lembur = "+peg.getSlip().get(i).getLembur();
            model.addRow(row);
        }
        
        
    }
    
    
    public void tabelData(javax.swing.JTable tabel, ArrayList<direktur> ld,ArrayList<Manager> lm,
            ArrayList<Karyawan> lk,ArrayList<karyawanMagang> lkm,int opsi){
        DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "No", "Nama","Departemen","Jumlah Lembur","Gaji Total","Tanggal"
        });
        
        if(opsi ==0){
            Object[] row = new Object[6];
            int count=1;
        tabel.setModel(model);
            for(int i = 0;i<ld.size();i++){
                row[0] = count++;
                row[1] = ld.get(i).getNama();
                row[2] = ld.get(i).getDept();
                row[3] = ld.get(i).getLembur();
                row[4] = formatUang(ld.get(i).getGaji());
                
                if(ld.get(i).getLastSlip() != null){
                     row[5] = ld.get(i).getLastSlip().getTanggal();    
                }else{
                    row[5] = "Belum Dibayar";
                }
                
                model.addRow(row);
            }
        }else if(opsi ==1){
            Object[] row = new Object[6];
            int count=1;
        
            for(int i = 0;i<lm.size();i++){
                row[0] = count++;
                row[1] = lm.get(i).getNama();
                row[2] = lm.get(i).getDept();
                row[3] = lm.get(i).getLembur();
                row[4] = formatUang(lm.get(i).getGaji());
                if(lm.get(i).getLastSlip() != null){
                    row[5] = lm.get(i).getLastSlip().getTanggal();                    
                }else{
                    row[5] = "Belum Dibayar";
                }
    
                model.addRow(row);
            }
        }else if(opsi == 2){
            Object[] row = new Object[6];
            int count=1;
        
            for(int i = 0;i<lk.size();i++){
                row[0] = count++;
                row[1] = lk.get(i).getNama();
                row[2] = lk.get(i).getDept();
                row[3] = lk.get(i).getLembur();
                row[4] = formatUang(lk.get(i).getGaji());
                if(lk.get(i).getLastSlip() != null){
                    row[5] = lk.get(i).getLastSlip().getTanggal();
                }else{
                    row[5] = "Belum Dibayar";
                }

                model.addRow(row);
                
            }
        }else{
            Object[] row = new Object[6];
            int count=1;
        
            for(int i = 0;i<lkm.size();i++){
                row[0] = count++;
                row[1] = lkm.get(i).getNama();
                row[2] = lkm.get(i).getDept();
                row[3] = lkm.get(i).getLembur();
                row[4] = formatUang(lkm.get(i).getGaji());
                if(lkm.get(i).getLastSlip() != null){
                    row[5] = lkm.get(i).getLastSlip().getTanggal();
                }else{
                    row[5] = "Belum Dibayar";
                }
                model.addRow(row);
            }
        }
        
        tabel.setModel(model);
        tabel.getColumn("No").setMaxWidth(30);
        tabel.getColumn("No").setMinWidth(30);
    }
    
    
    
    public String formatUang(double uang){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        return kursIndonesia.format(uang); 
    }
    
    public double getTotalGaji(){
        double total = 0;
        
        for(int i = 0; i<ListDirektur.size();i++){
            total = total +ListDirektur.get(i).getGaji();
        }
        for(int i = 0; i<ListManager.size();i++){
            total = total +ListManager.get(i).getGaji();
        }
        for(int i = 0; i<ListKaryawan.size();i++){
            total = total +ListKaryawan.get(i).getGaji();
        }
        for(int i = 0; i<ListMagang.size();i++){
            total = total +ListMagang.get(i).getGaji();
        }
        return total;
    }

    public ArrayList<Karyawan> getListKaryawan() {
        return ListKaryawan;
    }

    public void setListKaryawan(ArrayList<Karyawan> ListKaryawan) {
        this.ListKaryawan = ListKaryawan;
    }

    public ArrayList<Manager> getListManager() {
        return ListManager;
    }

    public void setListManager(ArrayList<Manager> ListManager) {
        this.ListManager = ListManager;
    }

    public ArrayList<direktur> getListDirektur() {
        return ListDirektur;
    }

    public void setListDirektur(ArrayList<direktur> ListDirektur) {
        this.ListDirektur = ListDirektur;
    }

    public ArrayList<karyawanMagang> getListMagang() {
        return ListMagang;
    }

    public void setListMagang(ArrayList<karyawanMagang> ListMagang) {
        this.ListMagang = ListMagang;
    }
    
    public void pembayaran(String date){
        for(int i = 0;i<ListDirektur.size();i++){
            ListDirektur.get(i).tambahSlip(ListDirektur.get(i).generateKdSlip(), 
                    ListDirektur.get(i).getGaji(), date,ListDirektur.get(i).getLembur());
            
            kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListDirektur.get(i).generateKdSlip()+"',"+ListDirektur.get(i).getNIP()+","
                            + "'"+ListDirektur.get(i).getNama()+"',"
                                    + ""+ListDirektur.get(i).getGaji()+","
                                            + ""+ListDirektur.get(i).getLembur()+",'"+date+"')");
            ListDirektur.get(i).setLembur(0);
        }
        
        for(int i = 0;i<ListManager.size();i++){
            ListManager.get(i).tambahSlip(ListManager.get(i).generateKdSlip(),
                    ListManager.get(i).getGaji(), date,ListManager.get(i).getLembur());
            
            kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListManager.get(i).generateKdSlip()+"',"+ListManager.get(i).getNIP()+","
                            + "'"+ListManager.get(i).getNama()+"',"
                                    + ""+ListManager.get(i).getGaji()+","
                                            + ""+ListManager.get(i).getLembur()+",'"+date+"')");
            ListManager.get(i).setLembur(0);
        }
        
        for(int i = 0;i<ListKaryawan.size();i++){
            ListKaryawan.get(i).tambahSlip(ListKaryawan.get(i).generateKdSlip(),
                    ListKaryawan.get(i).getGaji(), date,ListKaryawan.get(i).getLembur());
            
            kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListKaryawan.get(i).generateKdSlip()+"',"+ListKaryawan.get(i).getNIP()+","
                            + "'"+ListKaryawan.get(i).getNama()+"',"
                                    + ""+ListKaryawan.get(i).getGaji()+","
                                            + ""+ListKaryawan.get(i).getLembur()+",'"+date+"')");
            ListKaryawan.get(i).setLembur(0);
        }
        
        for(int i = 0;i<ListMagang.size();i++){
            ListMagang.get(i).tambahSlip(ListKaryawan.get(i).generateKdSlip(),
                    ListMagang.get(i).getGaji(), date,ListMagang.get(i).getLembur());
            
            kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListMagang.get(i).generateKdSlip()+"',"+ListMagang.get(i).getNIP()+","
                            + "'"+ListMagang.get(i).getNama()+"',"
                                    + ""+ListMagang.get(i).getGaji()+","
                                            + ""+ListMagang.get(i).getLembur()+",'"+date+"')");
            ListMagang.get(i).setLembur(0);
        }
        
    }
    
    
    public void pembayaranIndividu(String date,String nama){
        for(int i = 0;i<ListDirektur.size();i++){
            if(ListDirektur.get(i).getNama().equals(nama)){
                ListDirektur.get(i).tambahSlip(ListDirektur.get(i).generateKdSlip(), 
                    ListDirektur.get(i).getGaji(), date,ListDirektur.get(i).getLembur());
            
                kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListDirektur.get(i).generateKdSlip()+"',"+ListDirektur.get(i).getNIP()+","
                            + "'"+ListDirektur.get(i).getNama()+"',"
                                    + ""+ListDirektur.get(i).getGaji()+","
                                            + ""+ListDirektur.get(i).getLembur()+",'"+date+"')");
                ListDirektur.get(i).setLembur(0);
            }
            
        }
        
        
        for(int i = 0;i<ListManager.size();i++){
            if(ListManager.get(i).getNama().equals(nama)){
                ListManager.get(i).tambahSlip(ListManager.get(i).generateKdSlip(),
                    ListManager.get(i).getGaji(), date,ListManager.get(i).getLembur());
            
            kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListManager.get(i).generateKdSlip()+"',"+ListManager.get(i).getNIP()+","
                            + "'"+ListManager.get(i).getNama()+"',"
                                    + ""+ListManager.get(i).getGaji()+","
                                            + ""+ListManager.get(i).getLembur()+",'"+date+"')");
            ListManager.get(i).setLembur(0);

            }
        }
        
        for(int i = 0;i<ListKaryawan.size();i++){
            if(ListKaryawan.get(i).getNama().equals(nama)){
             
                ListKaryawan.get(i).tambahSlip(ListKaryawan.get(i).generateKdSlip(),
                    ListKaryawan.get(i).getGaji(), date,ListKaryawan.get(i).getLembur());
            
                kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListKaryawan.get(i).generateKdSlip()+"',"+ListKaryawan.get(i).getNIP()+","
                            + "'"+ListKaryawan.get(i).getNama()+"',"
                                    + ""+ListKaryawan.get(i).getGaji()+","
                                            + ""+ListKaryawan.get(i).getLembur()+",'"+date+"')");
                ListKaryawan.get(i).setLembur(0);   
            }
        }
        
        for(int i = 0;i<ListMagang.size();i++){
            if(ListKaryawan.get(i).getNama().equals(nama)){
                ListMagang.get(i).tambahSlip(ListKaryawan.get(i).generateKdSlip(),
                    ListMagang.get(i).getGaji(), date,ListMagang.get(i).getLembur());
            
                kon.exec("INSERT INTO `gajian`(ID,"
                    + "`NIP`, `NAMA`, `GAJI`, `Lembur`, "
                    + "`TANGGAL`) VALUES ('"+ListMagang.get(i).generateKdSlip()+"',"+ListMagang.get(i).getNIP()+","
                            + "'"+ListMagang.get(i).getNama()+"',"
                                    + ""+ListMagang.get(i).getGaji()+","
                                            + ""+ListMagang.get(i).getLembur()+",'"+date+"')");
                ListMagang.get(i).setLembur(0);
            }
            
        }
        
    }
    
    public void tabelPekerjaan(javax.swing.JTable tabel,String departemen){
        List job = new List();
        job.readJob();
        lp = job.getListPekerjaan();
         DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "No", "Departemen","Pekerjaan","Deadline"
        });
            Object[] row = new Object[6];
            int count=1;
            tabel.setModel(model);
            for(int i = 0;i<lp.size();i++){
                if(lp.get(i).getDepartemen().equals(departemen)){
                    row[0] = count++;
                    row[1] = lp.get(i).getDepartemen();
                    row[2] = lp.get(i).getJob();
                    row[3] = lp.get(i).getTanggal();
                
                    model.addRow(row);
                }
                
            }
    }
    
    public void tabelFeed(javax.swing.JTable tabel){
        List feed = new List();
        feed.readFeed(); 
         DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null,new String[]{
            "Kode", "Berita"
        });
            Object[] row = new Object[2];
            int count=1;
            tabel.setModel(model);
            for(int i = 0;i<feed.getFeed().size();i++){
                row[0] = feed.getFeed().get(i).getKode();
                row[1] = feed.getFeed().get(i).getNews();                
                model.addRow(row);
            }
            tabel.getColumn("Kode").setMaxWidth(60);
            tabel.getColumn("Kode").setMinWidth(60);
            tabel.setModel(model);
    }
}
