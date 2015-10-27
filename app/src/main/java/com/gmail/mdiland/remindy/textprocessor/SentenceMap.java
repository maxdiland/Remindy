package com.gmail.mdiland.remindy.textprocessor;

import com.gmail.mdiland.remindy.dto.Word;

/**
 * Created by Max Diland.
 */
public class SentenceMap {
    private String sentence;
    private String[] words;
    private Word[] wordSequence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public Word[] getWordSequence() {
        return wordSequence;
    }

    public void setWordSequence(Word[] wordSequence) {
        this.wordSequence = wordSequence;
    }
}
