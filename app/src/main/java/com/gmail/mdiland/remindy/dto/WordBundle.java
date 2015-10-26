package com.gmail.mdiland.remindy.dto;

import java.util.List;

/**
 * Created by mdiland on 2015-10-25.
 */
public class WordBundle {
    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "WordBundle{" +
                "words=" + words +
                '}';
    }
}
