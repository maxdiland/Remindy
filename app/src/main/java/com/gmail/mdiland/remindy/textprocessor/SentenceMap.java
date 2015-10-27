package com.gmail.mdiland.remindy.textprocessor;

import com.gmail.mdiland.remindy.dto.Word;
import com.gmail.mdiland.remindy.dto.WordType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Max Diland.
 */
public class SentenceMap {
    private static String WORD_SEPARATOR = " ";

    private Map<String, Word> dictionary;
    private String sentence;
    private Word[] wordSequence;

    public SentenceMap(String sentence, Map<String, Word> dictionary) {
        this.sentence = sentence;
        this.dictionary = dictionary;
        buildMap();
    }

    private void buildMap() {
        String clearSentence = removePunctuationMarks(sentence);
        clearSentence = removeRedundantSpaces(clearSentence);
        String[] words = clearSentence.split(WORD_SEPARATOR);
        List<Word> wordSequence = new ArrayList<>(words.length);

        for (String wordAsText : words) {
            boolean isNumber = isNumber(wordAsText);
            Word word = dictionary.get(wordAsText.toLowerCase());
            if (word == null) {
                word = new Word();
                word.setType(isNumber ? WordType.NUMERAL : WordType.UNDEFINED);
                word.setRoot(wordAsText);
            }
            wordSequence.add(word);
        }

        this.wordSequence = wordSequence.toArray(new Word[wordSequence.size()]);
    }

    private boolean isNumber(String wordAsText) {
        try{
            Integer.parseInt(wordAsText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String removeRedundantSpaces(String text) {
        return text;
    }

    private String removePunctuationMarks(String text) {
//        sentence.replace()
        return text;
    }


}
