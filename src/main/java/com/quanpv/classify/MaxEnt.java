package com.quanpv.classify;


import com.quanpv.database.DBConnection;
import com.quanpv.nlp.core.GrammarFactory;

import java.util.HashMap;
import java.util.List;

public class MaxEnt {

    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();
        List<String> contents = dbConnection.getAllContent();
        HashMap<String, Integer> hashMap = new HashMap<>();
        GrammarFactory grammarFactory;

        for(String content : contents) {
            grammarFactory = new GrammarFactory(content);
            List<String> tokens = grammarFactory.tokenizeText();
            for(String token : tokens) {
                if(token.trim().isEmpty()) {
                    continue;
                }
                if (hashMap.containsKey(token)){
                    int count = hashMap.get(token) + 1;
                    hashMap.put(token, count);
                } else {
                    if(grammarFactory.isValidWord(token)){
                        hashMap.put(token.toLowerCase(), 1);
                    }
                }
            }
        }

        for(String word :hashMap.keySet()) {
            System.out.println(String.format("%-10s%-5d", word, hashMap.get(word)));
        }
        System.out.println(hashMap.size());
    }
}
