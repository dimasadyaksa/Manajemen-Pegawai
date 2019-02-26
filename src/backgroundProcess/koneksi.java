/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backgroundProcess;

import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Dimas Adiyaksa
 */
public class koneksi {
    private static Connection kon;
    private static Statement st = null;
    private static ResultSet rs = null;
    
    public ResultSet connect(String sql) throws SQLException{ //Ambil Data 
        kon = DriverManager.getConnection("jdbc:mysql://"+"localhost"+"/"+"managepegawai","root","");
        st = kon.createStatement();
        rs = st.executeQuery(sql);
        return rs;
    }
    
    public void exec(String query){     //manipulasi data
        try {
            kon = DriverManager.getConnection("jdbc:mysql://"+"localhost"+"/"+"managepegawai","root","");
            st = kon.createStatement();
            st.executeUpdate(query);
            System.out.println("Berhasil");
        } catch (Exception ex) {
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("GAGAL");
        }
    }
   
}

