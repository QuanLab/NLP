package com.quanpv.nlp.core;

import com.quanpv.database.DBConnection;
import org.jsoup.Jsoup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainFactory {

    public static void main(String[] args) {

        GrammarFactory grammarFactory;
        List<String> listContent = new DBConnection().getAllContent();

        Set<String> missingWords = new HashSet<>();

        for(String content: listContent){
            grammarFactory = new GrammarFactory(content);
            List<String> result = grammarFactory.getIncorrectWords();
            missingWords.addAll(result);
        }
        System.out.println(missingWords);
    }
}

