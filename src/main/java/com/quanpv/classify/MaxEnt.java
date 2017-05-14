package com.quanpv.classify;

import com.quanpv.database.DBConnection;
import com.quanpv.database.FileUtils;
import com.quanpv.nlp.core.GrammarFactory;
import de.daslaboratorium.machinelearning.classifier.Classifier;
import opennlp.maxent.GIS;
import opennlp.maxent.GISModel;
import opennlp.maxent.io.GISModelReader;
import opennlp.maxent.io.SuffixSensitiveGISModelWriter;
import opennlp.model.AbstractModelWriter;
import opennlp.model.DataReader;
import opennlp.model.MaxentModel;
import opennlp.model.PlainTextFileDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class MaxEnt {

    private static final String MODEL_FILE_NAME = "model-maxent.tar.gz";

    public static void main(String[] args) {

//        DBConnection dbConnection = new DBConnection();
//        List<String> contents = dbConnection.getAllContent();
//
//        List<String> kimDung = new ArrayList<>();
//        for(String content : contents) {
//            kimDung.add(preProcess(content));
//        }
//        System.gc();

        List<String> files = FileUtils.getListFile("data/test/");

        List<String> khongKimDung = new ArrayList<>();

        for(String file : files) {
            String content = FileUtils.readTestData(file);
            khongKimDung.add(preProcess(content));
        }
        System.gc();

//        test(kimDung);
        test(khongKimDung);

//        train(kimDung, khongKimDung);

    }


    public static void train(List<String> list1, List<String> list2) {
        ArrayList<LearningSample> samples = new ArrayList<>();
        for(String kimDung :list1) {
            LearningSample sample = new LearningSample("kimdung", kimDung.toLowerCase());
            samples.add(sample);
        }

        for(String notKimDung :list2) {
            LearningSample sample = new LearningSample("not_kimdung", notKimDung.toLowerCase());
            samples.add(sample);
        }

        try{
            PlainTextEventStream stream = new PlainTextEventStream(samples);
            GISModel model = GIS.trainModel(stream, 100, 1, false, true);
            // Storing the trained model into a file for later use (gzipped)
            File outFile = new File(MODEL_FILE_NAME);
            AbstractModelWriter writer = new SuffixSensitiveGISModelWriter(model, outFile);
            writer.persist();

        } catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println("Training model complete........");
    }


    public static void test(List<String> test) {

        try{
            FileInputStream inputStream = new FileInputStream(MODEL_FILE_NAME);
            InputStream decodedInputStream = new GZIPInputStream(inputStream);
            DataReader modelReader = new PlainTextFileDataReader(decodedInputStream);
            MaxentModel loadedMaxentModel = new GISModelReader(modelReader).getModel();

            for(String data : test) {
                classify(loadedMaxentModel, data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String classify(MaxentModel loadedMaxentModel, String textContent) throws Exception {
        double[] result = loadedMaxentModel.eval(PlainTextEventStream.buildContext(textContent));
        for(double r : result)
            System.out.print(r + "\t");
        System.out.println(loadedMaxentModel.getBestOutcome(result));
        return loadedMaxentModel.getBestOutcome(result);
    }


    private static String preProcess(String content){
        GrammarFactory grammarFactory = new GrammarFactory(content);
        List<String> tokens = grammarFactory.tokenizeText();

        StringBuilder sb = new StringBuilder();

        for(String token : tokens) {
            if(token.trim().isEmpty()) {
                continue;
            }
            if(grammarFactory.isValidWord(token)){
                sb.append(token);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
