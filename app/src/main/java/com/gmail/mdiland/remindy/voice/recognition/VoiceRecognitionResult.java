package com.gmail.mdiland.remindy.voice.recognition;

import java.util.List;

/**
 * Created by Max Diland.
 */
public class VoiceRecognitionResult {
    private float[] resultScores;
    private List<String> results;

    public float[] getResultScores() {
        return resultScores;
    }

    public void setResultScores(float[] resultScores) {
        this.resultScores = resultScores;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
