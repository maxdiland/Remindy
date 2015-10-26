package com.gmail.mdiland.remindy.application;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import com.gmail.mdiland.remindy.R;
import com.gmail.mdiland.remindy.dictionary.loader.WordsLoader;
import com.gmail.mdiland.remindy.dto.Word;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Max Diland.
 */
public class RemindyApplication extends Application {
    private Map<String, Word> dictionaryBase = new TreeMap<>();
    private boolean dictionaryReady = false;
    private int[] wordResources = {R.raw.adverb, R.raw.numeral, R.raw.pretext};

    @Override
    public void onCreate() {
        super.onCreate();
        new BackgroundWordLoader().execute();
    }

    private class BackgroundWordLoader extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            WordsLoader.loadWords(dictionaryBase, getResources(), wordResources);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            RemindyApplication.this.dictionaryReady = true;
            Toast.makeText(RemindyApplication.this, "Dictionary loaded", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isDictionaryReady() {
        return dictionaryReady;
    }

    public Map<String, Word> getDictionaryBase() {
        return dictionaryBase;
    }
}


