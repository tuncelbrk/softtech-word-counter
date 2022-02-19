package com.softtech.codetest.wordcount;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubmissionTest {
    static Sentences readSentences;
    CountWords service;

    @BeforeClass
    public static void oneTimeSetUp() {
        readSentences = new ReadSentencesImp();
    }

    @Before
    public void setUp() throws Exception {
        service = new CountWordsImp(readSentences);
    }

    @Test
    public void testSubmission() throws Exception {
        System.out.println(readSentences);
        service.findWords(0);
        service.findWords(1);
        service.findWords(2);
        service.findWords(3);

    }
}
