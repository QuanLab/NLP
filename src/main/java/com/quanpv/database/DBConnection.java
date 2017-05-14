package com.quanpv.database;

import com.google.common.io.Files;
import com.quanpv.model.STKimDung;
import com.quanpv.nlp.core.GrammarFactory;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
                int id = rs.getInt("deID");
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

    public static void main(String[] args) throws IOException{
        DBConnection connection = new DBConnection();
        List<STKimDung> data = connection.getAll();

        for(STKimDung s: data) {
            String fileName = "data" + File.separator + String.valueOf(s.getId());
            try{
                File file = new File(fileName);
                file.createNewFile();
                Files.append(Jsoup.parse(s.getDeContent()).text(), file, Charset.defaultCharset());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
