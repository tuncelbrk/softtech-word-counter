package com.softtech.codetest.wordcount;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class ReadSentencesImp implements Sentences {

    private Vector<String> v = new Vector<>();
    private int totalWordNumber;

     ReadSentencesImp() {
        try {
            Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/paragraph.txt"),
                    "utf-8");
            scanner.useDelimiter(Pattern.compile("[.?!]+ "));

            while(scanner.hasNext()) {
                String sentence = scanner.next();
                v.add(sentence);
                totalWordNumber += sentence.split("\\W+").length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int sentenceNumber() {
        return v.size();
    }

    @Override
    public synchronized String getSentence(int sentenceNumber) {
        if(v.size()!=0){
            String returnValue = v.get(sentenceNumber);
            v.remove(sentenceNumber);
            return returnValue;
        }
        return "";
    }

    @Override
    public int averageWordNumber() {
        return totalWordNumber/sentenceNumber();
    }

    @Override
    public int totalWordNumber() {
        return totalWordNumber;
    }

}
