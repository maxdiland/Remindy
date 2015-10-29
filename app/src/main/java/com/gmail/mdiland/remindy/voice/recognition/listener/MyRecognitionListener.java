package com.gmail.mdiland.remindy.voice.recognition.listener;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.widget.Toast;

import com.gmail.mdiland.remindy.voice.recognition.VoiceRecognitionResult;

import java.util.List;

/**
 * Created by Max Diland.
 */
public class MyRecognitionListener implements RecognitionListener {
    private final OnSpeechRecognitionResultListener listener;

    public MyRecognitionListener(OnSpeechRecognitionResultListener listener) {
        this.listener = listener;
    }

    @Override
    public void onReadyForSpeech(Bundle bundle) {

    }

    @Override
    public void onBeginningOfSpeech() {
    }

    @Override
    public void onRmsChanged(float v) {

    }

    @Override
    public void onBufferReceived(byte[] bytes) {

    }

    @Override
    public void onEndOfSpeech() {

    }

    @Override
    public void onError(int i) {
    }

    @Override
    public void onResults(Bundle bundle) {
        VoiceRecognitionResult result = new VoiceRecognitionResult();

        List<String> recognizedTexts =
                bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        float[] scores = bundle.getFloatArray(SpeechRecognizer.CONFIDENCE_SCORES);

        if (recognizedTexts != null) {
            result.setResults(recognizedTexts);
        }

        if (scores != null) {
            result.setResultScores(scores);
        }

        listener.onSpeechRecognitionResult(result);
    }

    @Override
    public void onPartialResults(Bundle bundle) {

    }

    @Override
    public void onEvent(int i, Bundle bundle) {

    }
}
