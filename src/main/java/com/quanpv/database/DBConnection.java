package com.quanpv.database;

import com.quanpv.model.STKimDung;
import com.quanpv.nlp.core.GrammarFactory;
import org.jsoup.Jsoup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DBConnection {

    private Connection conn;

    public DBConnection() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:kimdung.sqlite");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get all content of chapper
     * @return
     */
    public List<String> getAllContent(){
        List<String> results = new ArrayList<>();
        try{
           PreparedStatement pst = conn.prepareStatement("SELECT decontent FROM st_kimdung");
           ResultSet rs = pst.executeQuery();
           while (rs.next()) {
               String content = rs.getString("decontent");
               results.add(Jsoup.parse(content).text());
           }
           return results;
       } catch (Exception e){
           e.printStackTrace();
       }
       return results;
    }

    /**
     * get data of all chapper
     * @return
     */
    public List<STKimDung> getAll(){
        List<STKimDung> results = new ArrayList<>();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM st_kimdung");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("deID");
                String deName = rs.getString("deName");
                String deContent = rs.getString("decontent");
                STKimDung stKimDung = new STKimDung(id, deName, deContent);
                results.add(stKimDung);
            }
            return results;
        } catch (Exception e){
            e.printStackTrace();
        }
        return results;
    }

    public List<String> getLimitedContent(int numRecord){
        List<String> results = new ArrayList<>();
        try{
            PreparedStatement pst = conn.prepareStatement("SELECT decontent FROM st_kimdung LIMIT " + numRecord );
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String content = rs.getString("decontent");
                results.add(Jsoup.parse(content).text());
            }
            return results;
        } catch (Exception e){
            e.printStackTrace();
        }
        return results;
    }
}
