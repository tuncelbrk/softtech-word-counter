package com.softtech.codetest.wordcount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Starter {
    int threadNumber = 5;
    public Starter(CountWords service, Sentences readSentences, int threadNumber) throws InterruptedException {
        this.threadNumber = threadNumber;
        ExecutorService es = Executors.newFixedThreadPool( threadNumber );

//        for(int i = 0; i< threadNumber; i++){
//            es.execute( new WordCountImp(service, readSentences.getSentence(i)) );
//        }

        for(int i = 0; i< readSentences.sentenceNumber(); i++){
            es.execute(new WordCountImp(service, readSentences.getSentence(i)));
        }
        es.shutdown();
        es.awaitTermination( 1, TimeUnit.MINUTES );
    }

    public Starter(CountWords service, Sentences readSentences) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool( threadNumber );
        for(int i = 0; i< threadNumber; i++){
            es.execute( new WordCountImp(service, readSentences.getSentence(i)) );
        }
        es.shutdown();
        es.awaitTermination( 1, TimeUnit.MINUTES );
    }
}
