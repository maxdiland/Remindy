package com.gmail.mdiland.remindy.textprocessor.impl;

import com.gmail.mdiland.remindy.dto.Word;
import com.gmail.mdiland.remindy.entity.Reminder;
import com.gmail.mdiland.remindy.textprocessor.ReminderTextParser;
import com.gmail.mdiland.remindy.textprocessor.SentenceMap;

import java.util.Map;

/**
 * Created by Max Diland.
 */
public class SimpleReminderTextParser implements ReminderTextParser {
    private Map<String, Word> dictionary;

    @Override
    public Reminder process(String text) {
        SentenceMap sentenceMap = new SentenceMap(text, dictionary);



        return null;
    }

    public Map<String, Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, Word> dictionary) {
        this.dictionary = dictionary;
    }
}
