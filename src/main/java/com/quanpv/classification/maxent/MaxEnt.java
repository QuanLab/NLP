package com.quanpv.classification.maxent;

import com.quanpv.classification.config.SystemInfo;
import com.quanpv.database.DBConnection;
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

    private static final String MODEL_FILE_NAME = SystemInfo.PATH_TRAINED_MODEL;
    private static final int MAX_ITERATOR = SystemInfo.MAX_ITERATOR;


    public static void main(String[] args) throws Exception {

        trainModel();

//        FileInputStream inputStream = new FileInputStream(MODEL_FILE_NAME);
//        InputStream decodedInputStream = new GZIPInputStream(inputStream);
//        DataReader modelReader = new PlainTextFileDataReader(decodedInputStream);
//        MaxentModel loadedMaxentModel = new GISModelReader(modelReader).getModel();

//        List<String> testData = new DBConnection().getLimitedContent(10);

//        for(String dataTest: testData){
//            String dataTest = "Well-de\fned design structures like these have a positive impact on software development. A\n" +
//                    "software architect who is familiar with a good set of design structures can apply them immediately\n" +
//                    "to design problems without having to rediscover them. Design structures also facilitate the reuse of\n" +
//                    "successful architectures|expressing proven techniques as design structures makes them more readily\n" +
//                    "accessible to developers of new systems";
//            classify(loadedMaxentModel, dataTest);
//        System.out.println(classify(loadedMaxentModel, dataTest));
//        }
    }


    public static void trainModel() throws Exception {

        ArrayList<LearningSample> samples = new ArrayList<>();

        String preDefinedCategories = "Kim Dung";

        List<String> allTextExample = new DBConnection().getAllContent();

        int i=0;
        for (String example : allTextExample) {
            i++;
            LearningSample learningSample = new LearningSample(preDefinedCategories, example);
            samples.add(learningSample);
            System.out.println(i);

        }

        PlainTextEventStream stream = new PlainTextEventStream(samples);
        GISModel model = GIS.trainModel(stream, MAX_ITERATOR, 1, false, true);

        // Storing the trained model into a file for later use (gzipped)
        File outFile = new File(MODEL_FILE_NAME);
        AbstractModelWriter writer = new SuffixSensitiveGISModelWriter(model, outFile);
        writer.persist();
        System.out.println("Training model complete........");

    }

    private static String classify(MaxentModel loadedMaxentModel, String textContent) throws Exception {
        double[] result = loadedMaxentModel.eval(PlainTextEventStream.buildContext(textContent));
        return loadedMaxentModel.getBestOutcome(result);
    }
}