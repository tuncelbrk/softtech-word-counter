package com.softtech.codetest.wordcount;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SubmissionTest {
    static Sentences readSentences;
    CountWords service;

    @BeforeClass
    public static void oneTimeSetUp() {
        readSentences = new ReadSentencesImp();
    }

    @Before
    public void setUp(){
        service = new CountWordsTransformation();
    }

    @Test
    public void testSubmission() throws Exception {
        System.out.println(readSentences);
//        ExecutorService es = Executors.newFixedThreadPool( 4 );
//        for(int i = 0; i< 4; i++){
//            es.execute( new WordCountImp(service, readSentences.getSentence(i)) );
//        }
//        es.shutdown();
//        es.awaitTermination( 1, TimeUnit.MINUTES );
//        System.out.println(readSentences.averageWordNumber()+"--"+readSentences.sentenceNumber());
//        service.printWordAndCounts();
        new Starter(service, readSentences,4);
        service.printWordAndCounts();
        System.out.println(readSentences.totalWordNumber());
//        service.findWords(0);
//        service.findWords(1);
//        service.findWords(2);
//        service.findWords(3);

    }
}
