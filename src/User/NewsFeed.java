/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.Random;

/**
 *
 * @author Dimas Adiyaksa
 */
public class NewsFeed {
    private String kode;
    private String news;
    
    public NewsFeed(String news,String kode){
        this.kode = kode;
        this.news = news;
    }

    public NewsFeed(String news){
        generateKode();
        this.news = news;
    }
    
    public String getKode() {
        return kode;
    }

    public void generateKode(){
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String kode;
        int random;
        Random rand = new Random();
        random = rand.nextInt(999);
        kode = Character.toString(a.charAt(random%26)) + random%999;        
        this.kode = kode;
    }
    
    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
    
    
}
