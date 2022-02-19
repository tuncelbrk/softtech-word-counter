package com.softtech.codetest.wordcount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountWordsImp implements CountWords {
    private Sentences sentences;
    Map<String, Integer> counterMap = new HashMap<>();
    public CountWordsImp(Sentences sentences ) {
        this.sentences = sentences;
    }

    public void findWords(int sentenceNumber){
        String sentence = sentences.getSentence(sentenceNumber);
        String[] words = sentence.split("\\s+|(,)+\\s");
        Arrays.stream(words).forEach(System.out::println);
        Arrays.stream(words).forEach(s -> increaseOrSubmitWord(counterMap, s));

    }

    public synchronized void increaseOrSubmitWord(Map<String, Integer> counterMap, String word ) {
        if (counterMap.containsKey(word)){
            counterMap.put(word, counterMap.get(word) + 1);
        }else{
            counterMap.put( word, 1 );
        }
    }


}
