package com.softtech.codetest.wordcount;

public class WordCountImp implements Runnable {
    CountWords service;
    String sentence;

    public WordCountImp(CountWords service, String sentence) {
        this.service = service;
        this.sentence = sentence;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        service.findWords(sentence);
    }
}
