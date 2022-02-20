package com.softtech.codetest.wordcount;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubmissionTest {
    private static Sentences readSentences;
    private CountWords service;

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
        System.out.println("Sentence Count:"+ readSentences.sentenceNumber());
        System.out.println("Avg. Word Count: "+ readSentences.averageWordNumber());
        System.out.println("Total number of the words : "+ readSentences.totalWordNumber());
        new Starter(service, readSentences,3);
        service.printThreadList();
        service.printWordAndCounts();
    }

    @Test
    public void testWithDefaultThreadNumber() throws Exception {
        System.out.println("Sentence Count:"+ readSentences.sentenceNumber());
        System.out.println("Avg. Word Count: "+ readSentences.averageWordNumber());
        System.out.println("Total number of the words : "+ readSentences.totalWordNumber());
        new Starter(service, readSentences);
        service.printThreadList();
        service.printWordAndCounts();
    }
}
