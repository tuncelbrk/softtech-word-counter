package com.softtech.codetest.wordcount;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class ReadSentencesImp implements Sentences {

    Vector<String> v = new Vector<>();

     ReadSentencesImp() {
        try {
            Scanner scanner = new Scanner(this.getClass().getResourceAsStream("/paragraph.txt"),
                    "utf-8");
            scanner.useDelimiter(Pattern.compile("([a-zA-Z])+\\."));

            while(scanner.hasNext()) {
                v.add(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int size() {
        return v.size();
    }

    @Override
    public String getSentence(int sentenceNumber) {
        return v.get(sentenceNumber);
    }

}
