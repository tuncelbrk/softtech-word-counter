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
    public void testProperSubmission() throws Exception {
        System.out.println("Total number of sentences : "+ readSentences.sentenceNumber());
        System.out.println("Total number of the words : "+ readSentences.totalWordNumber());
        System.out.println("Average number of the words for each sentence : "+ readSentences.averageWordNumber());

        new Starter(service, readSentences,4);
        service.printWordAndCounts();

    }
}
