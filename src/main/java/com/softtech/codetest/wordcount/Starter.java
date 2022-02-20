package com.softtech.codetest.wordcount;

class Starter {
    private int threadNumber = 5; //default thread number is 5
    private Sentences readSentences;
    private CountWords service;

    Starter(CountWords service, Sentences readSentences, int threadNumber) {
        this.readSentences = readSentences;
        this.threadNumber = threadNumber;
        this.service = service;

        Thread[] threads = new Thread [threadNumber];
        for(int i =0; i < threadNumber; i++) {
            threads[i] = new Thread(new WordCountImp(service, readSentences));
            service.initializeThreadMap(threads[i]);
            threads[i].start();
        }

        while (readSentences.sentenceNumber()>0){
            for(int i =0; i < threadNumber; i++) {
                threads[i].run();
            }
        }
    }

    Starter(CountWords service, Sentences readSentences) {
        this.service = service;
        this.readSentences = readSentences;
        Thread[] threads = new Thread [threadNumber];
        for(int i =0; i < threadNumber; i++) {
            threads[i] = new Thread(new WordCountImp(service, readSentences));
            service.initializeThreadMap(threads[i]);
            threads[i].start();
        }

        while (readSentences.sentenceNumber()>0){
            for(int i =0; i < threadNumber; i++) {
                threads[i].run();
            }
        }
    }
}
