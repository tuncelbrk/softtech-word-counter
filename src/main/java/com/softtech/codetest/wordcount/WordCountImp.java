package com.softtech.codetest.wordcount;

public class WordCountImp implements Runnable {
    private CountWords service;
    private static Sentences readSentences;
    private boolean exit = false;

    WordCountImp(CountWords service, Sentences readSentences) {
        this.service = service;
        this.readSentences = readSentences;
    }

    @Override
    public void run() {
        while (!exit){
            String sentence  = readSentences.getSentence(0);
            if(!sentence.equals("")){
                service.findWords(sentence);
            }else{
                stop();
            }
        }
    }

    private void stop() {
        exit = true;
    }
}
