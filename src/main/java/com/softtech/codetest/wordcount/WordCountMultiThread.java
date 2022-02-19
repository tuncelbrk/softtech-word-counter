//package com.softtech.codetest.wordcount;
//
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class WordCountMultiThread
//{
//    private static final int THREAD_COUNT = 4;
//
//    private static class Transformers
//    {
//        public String[] mapToTokens( String input )
//        {
//            return input.split( "[ _\\.,\\-\\+]" );
//        }
//
//
//        private String[] filterIllegalTokens( String[] words )
//        {
//            List<String> filteredList = new ArrayList<>();
//            for ( String word : words ) {
//                if ( word.matches( "[a-zA-Z]+" ) ) {
//                    filteredList.add( word );
//                }
//            }
//            return filteredList.toArray( new String[filteredList.size()] );
//        }
//
//
//        private String[] mapToLowerCase( String[] words )
//        {
//            String[] filteredList = new String[words.length];
//            for ( int i = 0; i < words.length; i++ ) {
//                filteredList[i] = words[i].toLowerCase();
//            }
//            return filteredList;
//        }
//
//
//        public synchronized void increaseOrSubmitWord(Map<String, Integer> counterMap, String word )
//        {
//            if ( counterMap.containsKey( word ) ) {
//                counterMap.put( word, counterMap.get( word ) + 1 );
//            } else {
//                counterMap.put( word, 1 );
//            }
//        }
//    }
//
//
//    private static class WordCountImp implements Runnable
//    {
//        private Transformers tr;
//        private Vector<String> dataVector;
//        private Map<String, Integer> counters;
//
//
//        public WordCountImp( Transformers tr, Map<String, Integer> counters, Vector<String> dataVector )
//        {
//            this.tr = tr;
//            this.dataVector = dataVector;
//            this.counters = counters;
//        }
//
//
//        @Override
//        public void run()
//        {
//
//            System.out.println(Thread.currentThread().getName());
//            while ( !dataQueue.isEmpty() ) {
//                String line = dataQueue.;
//                if ( line != null ) {
//                    String[] words = tr.mapToTokens( line );
//                    String[] legalWords = tr.filterIllegalTokens( words );
//                    String[] lowerCaseWords = tr.mapToLowerCase( legalWords );
//                    for ( String word : lowerCaseWords ) {
//                        tr.reduce( counters, word );
//                    }
//                }
//            }
//        }
//    }
//
//
//    public static void main( final String[] args ) throws Exception
//    {
//        ReadSentencesImp readSentences;
//        Transformers tr = new Transformers();
//        Map<String, Integer> counters = new HashMap<>();
//
//        readSentences = new ReadSentencesImp();
//
//
//        ExecutorService es = Executors.newFixedThreadPool( THREAD_COUNT );
//        for ( int i = 0; i < THREAD_COUNT; i++ ) {
//            es.execute( new WordCountImp( tr, counters, readSentences.v ) );
//        }
//        es.shutdown();
//        es.awaitTermination( 1, TimeUnit.MINUTES );
//        System.out.println( "Word Count:\n" + counters );
//    }
//}