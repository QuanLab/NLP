package com.quanpv.classify;

import com.quanpv.nlp.core.GrammarFactory;


public class Test {

    public static void main(String[] args) {
        GrammarFactory grammarFactory = new GrammarFactory("");
        System.out.println(grammarFactory.isValidWord("nghén"));;
    }
}
