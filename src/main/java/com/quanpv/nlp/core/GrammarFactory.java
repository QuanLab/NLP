package com.quanpv.nlp.core;

import com.quanpv.nlp.rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class GrammarFactory {

    private String text;

    public GrammarFactory(String text){
        this.text = text.toLowerCase();
    }

    /**
     * Check the word is valid with all rule pre-defined
     * @param word
     * @return
     */
    public boolean isValidWord(String word){
//        if(!Rule1.isValid(word)){
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
//        if(!Rule9.isValid(word)){
//            System.out.println(word + "\t" + "Rule9");
//        }
//        if(!Rule10.isValid(word)){
//            System.out.println(word + "\t" + "Rule10");
//        }
//        if(!Rule11.isValid(word)){
//            System.out.println(word + "\t" + "Rule11");
//        }
//        if(!Rule12.isValid(word)){
//            System.out.println(word + "\t" + "Rule12");
//        }
//        if(!Rule13.isValid(word)){
//            System.out.println(word + "\t" + "Rule13");
//        }
//
//        if(!Rule14.isValid(word)){
//            System.out.println(word + "\t" + "Rule14");
//        }
//        if(!Rule15.isValid(word)){
//            System.out.println(word + "\t" + "Rule15");
//        }
//        if(!Rule16.isValid(word)){
//            System.out.println(word + "\t" + "Rule16");
//        }

       return (Rule1.isValid(word)&&Rule2.isValid(word)&& Rule3.isValid(word)&& Rule4.isValid(word)
               && Rule5.isValid(word)&&Rule6.isValid(word)&&Rule7.isValid(word)&&Rule8.isValid(word)
                &&Rule9.isValid(word)&&Rule10.isValid(word)&&Rule11.isValid(word)&&Rule12.isValid(word)
               &&Rule13.isValid(word) &&Rule14.isValid(word)&&Rule15.isValid(word)&&Rule16.isValid(word));
    }

    /**
     * tokenize a text to single word
     * @return
     */

    public List<String> tokenizeText(){
        List<String> results = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(this.text, "\t \n\r\f?.;,\'\"=+-_*&^%$#@!`~></:[]{}()");

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
