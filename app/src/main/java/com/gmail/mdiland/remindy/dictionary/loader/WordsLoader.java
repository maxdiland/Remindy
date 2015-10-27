package com.gmail.mdiland.remindy.dictionary.loader;

import android.content.res.Resources;

import com.gmail.mdiland.remindy.dto.Word;
import com.gmail.mdiland.remindy.dto.WordBundle;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * Created by Max Diland.
 */
public final class WordsLoader {
    private static Gson gson = new Gson();

    private static final Charset CHARSET = Charset.forName("UTF-8");

    private WordsLoader() {}

    public static void loadWords(Map<String, Word> dictionaryBase, Resources resources,
                          int ... rawWordBases) {

        for (int rawResource : rawWordBases) {
            WordBundle wordBundle = readWordBundle(resources, rawResource);
            List<Word> words = wordBundle.getWords();
            for (Word wordObject : words) {
                for (String word : wordObject.getWordVariants()) {
                    dictionaryBase.put(word.toLowerCase(), wordObject);
                }
            }
        }
    }

    private static WordBundle readWordBundle(Resources resources, int rawResource) {
        InputStream inputStream = resources.openRawResource(rawResource);
        Reader reader = new InputStreamReader(inputStream, CHARSET);
        return gson.fromJson(reader, WordBundle.class);
    }
}
