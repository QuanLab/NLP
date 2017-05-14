package com.quanpv.database;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    public static List<String> getListFile(String folderPath) {

        ArrayList<String> listFile = new ArrayList<>();

        File file = new File(folderPath);

        File[] arrFile = file.listFiles();

        for (int i = 0; i < arrFile.length; i++) {
            if (arrFile[i].isFile()) {
                listFile.add(arrFile[i].getPath().toString());
            }
        }
        return listFile;
    }

    public static String getFileName(String path) {
        File file = new File(path);
        return file.getName();
    }

    public static List<String> readFile(String file) {

        ArrayList<String> linesList = new ArrayList<>();

        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String line;

            while ((line = br.readLine()) != null) {
                linesList.add(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error while reading file: " + e + " cause by " + e);
        }
        return linesList;
    }

    public static String readFileToLine(String file) {

        try {
            FileInputStream fstream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(" ");
                sb.append(line);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String readTestData(String file) {

        try {
            List<String> lines = Files.readLines(new File(file), Charsets.UTF_16);
            StringBuilder sb = new StringBuilder();
            for(String line: lines) {
                sb.append(" ");
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static void writeToFile(List<String> lines, String fileName) {

        BufferedWriter output = null;
        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            output = new BufferedWriter(new FileWriter(file));
            for (String line: lines){
                output.write(line + System.getProperty("line.separator"));
            }
            output.flush();
            output.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            try{
                if ( output != null ) {
                    output.close();
                }
            }catch (IOException ioe){
                System.out.println( "Error write to file " + fileName + " cause by "  + ioe);
            }
        }
    }
}
