package com.softtech.codetest.wordcount;

public interface CountWords {
    void findWords(String sentence);

    void printWordAndCounts();

    void printThreadList();

    void initializeThreadMap(Thread thread);
}
