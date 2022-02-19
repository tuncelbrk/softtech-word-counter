package com.softtech.codetest.wordcount;

public interface Sentences {

    int sentenceNumber();

    String getSentence(int sentenceNumber);

    int averageWordNumber();

    int totalWordNumber();
}
