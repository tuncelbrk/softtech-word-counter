package com.softtech.codetest.wordcount;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CountWordsTransformation implements CountWords {
    private Map<String, Integer> counterMap = new ConcurrentHashMap<>();
    private Map<Long, Integer> threadMap = new ConcurrentHashMap<>();

    private synchronized void increaseOrSubmitWord(Map<String, Integer> counterMap, String word) {
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
        Long threadNumber = Thread.currentThread().getId();
        if(threadMap.containsKey(threadNumber)){
            threadMap.put(threadNumber, threadMap.get(threadNumber) + 1);
        }else{
            threadMap.put(threadNumber, 1);
        }

    }

    @Override
    public void printWordAndCounts() {
        Map<String,Integer>  sortedMapReverseOrder =  counterMap.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedMapReverseOrder.forEach( (k,v) -> System.out.println(k + " --> " + v));
    }

    @Override
    public void printThreadList() {
        System.out.println("Thread counts:");
        threadMap.forEach( (k,v) -> System.out.println("\tThreadId="+k+"  Count="+v));
    }

    @Override
    public void initializeThreadMap(Thread thread){
        threadMap.put(thread.getId(), 0);
    }
}
