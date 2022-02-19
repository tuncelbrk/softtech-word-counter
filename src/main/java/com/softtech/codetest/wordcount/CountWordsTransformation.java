package com.softtech.codetest.wordcount;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CountWordsTransformation implements CountWords {
    Map<String, Integer> counterMap = new ConcurrentHashMap<>();
    int counter=0;
    public synchronized void increaseOrSubmitWord(Map<String, Integer> counterMap, String word ) {
        if (counterMap.containsKey(word)){
            counterMap.put(word, counterMap.get(word) + 1);
        }else{
            counterMap.put( word, 1 );
        }
    }

    @Override
    public void findWords(String sentence){
        String[] words = sentence.split("\\W+");
        Arrays.stream(words).forEach(s -> increaseOrSubmitWord(counterMap, s));
    }

    @Override
    public void printWordAndCounts() {

        counterMap.forEach( (k,v) -> {System.out.println(k + " --> " + v);sum(v);});
    }

    public void sum(int v){
        counter+=v;
    }


}
