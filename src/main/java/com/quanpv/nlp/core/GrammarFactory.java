package com.quanpv.nlp.core;

import com.quanpv.nlp.rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class GrammarFactory {

    private String text;

    public GrammarFactory(String text){
        this.text = text;
    }

    /**
     * Check the word is valid with all rule pre-defined
     * @param word
     * @return
     */
    private boolean isValidWord(String word){
//        if(!Rule1.isValid1(word)){
//            System.out.println(word + "\t" + "Rule1");
//        }
//        if(!Rule2.isValid(word)){
//            System.out.println(word + "\t" + "Rule2");
//        }
//        if(!Rule3.isValid(word)){
//            System.out.println(word + "\t" + "Rule3");
//        }
//        if(!Rule4.isValid(word)){
//            System.out.println(word + "\t" + "Rule4");
//        }
//        if(!Rule5.isValid(word)){
//            System.out.println(word + "\t" + "Rule5");
//        }
//        if(!Rule6.isValid(word)){
//            System.out.println(word + "\t" + "Rule6");
//        }
//        if(!Rule7.isValid(word)){
//            System.out.println(word + "\t" + "Rule7");
//        }
//        if(!Rule8.isValid(word)){
//            System.out.println(word + "\t" + "Rule8");
//        }
       return (Rule1.isValid1(word)&& Rule2.isValid(word)&& Rule3.isValid(word)&& Rule4.isValid(word)
               && Rule5.isValid(word)&&Rule6.isValid(word)&&Rule7.isValid(word)&&Rule8.isValid(word));
    }

    /**
     * tokenize a text to single word
     * @return
     */

    public List<String> tokenizeText(){
        List<String> results = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(this.text, "\t \n\r\f?.,\'\"=+-_*&^%$#@!`~></:[]{}()");

        while (st.hasMoreTokens()){
            results.add(st.nextToken());
        }
        return results;
    }

    /**
     * get all incorrect word from text input in constructor
     * @return
     */
    public List<String> getIncorrectWords(){
        List<String> results = new ArrayList<>();
        for(String word: this.tokenizeText()){
            if(!isValidWord(word)){
                results.add(word);
            }
        }
        return results;
    }
}
