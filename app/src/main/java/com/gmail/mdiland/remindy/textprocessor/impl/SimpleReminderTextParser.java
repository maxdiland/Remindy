package com.gmail.mdiland.remindy.textprocessor.impl;

import com.gmail.mdiland.remindy.dto.Word;
import com.gmail.mdiland.remindy.dto.WordType;
import com.gmail.mdiland.remindy.entity.Reminder;
import com.gmail.mdiland.remindy.textprocessor.ReminderTextParser;
import com.gmail.mdiland.remindy.textprocessor.SentenceMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Max Diland.
 */
public class SimpleReminderTextParser implements ReminderTextParser {
    private static final String SINGLE_SPACE = " ";


    private Map<String, Word> dictionary;

    @Override
    public Reminder process(String text) {
        SentenceMap sentenceMap = buildSentenceMap(text);
        return null;
    }

    private SentenceMap buildSentenceMap(String text) {
        SentenceMap sentenceMap = new SentenceMap();

        String clearSentence = removePunctuationMarks(text);
        clearSentence = removeRedundantSpaces(clearSentence);
        String[] words = clearSentence.split(SINGLE_SPACE);

        sentenceMap.setWords(words);
        sentenceMap.setWordSequence(getWordSequence(words));

        return sentenceMap;
    }

    private Word[] getWordSequence(String[] words) {
        List<Word> wordSequence = new ArrayList<>(words.length);

        for (String wordAsText : words) {
            Integer numericValue = parseNumber(wordAsText);
            Word word = dictionary.get(wordAsText.toLowerCase());
            if (word == null) {
                word = new Word();
                if (numericValue != null) {
                    word.setType(WordType.NUMERAL);
                    word.setNumericValue(numericValue);
                }
                word.setType(WordType.UNDEFINED);
                word.setRoot(wordAsText);
            }
            wordSequence.add(word);
        }

        return wordSequence.toArray(new Word[wordSequence.size()]);
    }

    private Integer parseNumber(String wordAsText) {
        try{
            return Integer.parseInt(wordAsText);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String removeRedundantSpaces(String text) {
        return text.replaceAll("\\s+", SINGLE_SPACE);
    }

    private String removePunctuationMarks(String text) {
        final StringBuilder builder = new StringBuilder();
        for(final char c : text.toCharArray())
            if(Character.isLetterOrDigit(c) || Character.isSpaceChar(c))
                builder.append(Character.isLowerCase(c) ? c : Character.toLowerCase(c));
        return builder.toString();
    }

    public Map<String, Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Word> dictionary) {
        this.dictionary = dictionary;
    }
}
