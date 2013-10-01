package Kwicv3;

import java.io.EOFException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Noé
 */
public class Sentence extends Filter{

    private ArrayList<String> kwic_sentences;

    public Sentence(String s) {
        kwic(s);
    }

    public void kwic(String s) {
        ArrayList<String> wordList = getWords(s);
        ArrayList<String> sentences = getSentences(wordList);
        this.kwic_sentences = orderSentences(sentences);

    }

    public ArrayList<String> getSentences() {
        return kwic_sentences;
    }
    

    private ArrayList<String> orderSentences(ArrayList<String> sentences) {
        ArrayList<String> orderedSentences = new ArrayList<String>();
        while (sentences.size() > 1) {
            int lowerPosition = 0;
            for (int i = 1; i <= sentences.size() - 1; i++) {
                if (sentences.get(lowerPosition).compareTo(sentences.get(i)) > 0) {
                    lowerPosition = i;
                }
            }
            orderedSentences.add(sentences.get(lowerPosition));
            sentences.remove(lowerPosition);
        }
        orderedSentences.add(sentences.get(0));
        return orderedSentences;
    }

    private ArrayList<String> getWords(String kwic_sentence) {
        ArrayList<String> list = new ArrayList<String>();
        String[] sentence = kwic_sentence.split(" ");
        for (int i = 0; i < sentence.length; i++) {
            list.add(sentence[i]);
        }
        return list;
    }

    private ArrayList<String> getSentences(ArrayList<String> wordList) {
        ArrayList<String> sentenceList = new ArrayList<String>();
        for (int i = 0; i < wordList.size(); i++) {
            sentenceList.add(createSentence(wordList, i));

        }

        return sentenceList;
    }

    private String createSentence(ArrayList<String> wordList, int nextWord) {
        int startingWord = nextWord;
        String sentence = "";
        for (int i = 0; i < wordList.size(); i++) {
            if ((i + startingWord) < wordList.size()) {
                sentence = sentence + wordList.get(startingWord + i) + " ";
            } else {
                sentence = sentence + wordList.get(startingWord - (wordList.size() - i)) + " ";
            }
        }
        return sentence;
    }

    @Override
    public void run() {
       
    }


}
