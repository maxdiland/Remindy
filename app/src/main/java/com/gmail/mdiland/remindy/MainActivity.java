package com.gmail.mdiland.remindy;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.text.method.Touch;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gmail.mdiland.remindy.application.RemindyApplication;
import com.gmail.mdiland.remindy.gesture.MyGestureDetector;
import com.gmail.mdiland.remindy.textprocessor.impl.SimpleReminderTextParser;
import com.gmail.mdiland.remindy.voice.recognition.VoiceRecognitionResult;
import com.gmail.mdiland.remindy.voice.recognition.listener.MyRecognitionListener;
import com.gmail.mdiland.remindy.voice.recognition.listener.OnSpeechRecognitionResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnSpeechRecognitionResultListener {

    private EditText etPreview;
    private EditText etInput;
    private Button btnParse;
    private Button btnVoice;

    private boolean speechRecognitionInProgress;
    SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

    {
        speechRecognizer.setRecognitionListener(new MyRecognitionListener(this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

//        btnParse.setOnTouchListener();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void initUi() {
        etPreview = (EditText) findViewById(R.id.etPreview);
        etInput = (EditText) findViewById(R.id.etInput);
        btnParse = (Button) findViewById(R.id.btnParse);
        btnVoice = (Button) findViewById(R.id.btnVoice);
    }

    public void processInput(View view) {
        RemindyApplication application = (RemindyApplication) getApplication();
        SimpleReminderTextParser textParser = new SimpleReminderTextParser();
        textParser.setDictionary(application.getDictionaryBase());

        String inputText = etInput.getText().toString();
        textParser.process(inputText);
    }

    public void recognizeSpeech(View view) {
        if (speechRecognitionInProgress) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//            intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS, 1000000);
//            intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS, 2000000);
//            intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 10000000);
            speechRecognizer.startListening(intent);
        } else {
            speechRecognizer.stopListening();
        }
        speechRecognitionInProgress = !speechRecognitionInProgress;

    }

    @Override
    public void onSpeechRecognitionResult(VoiceRecognitionResult result) {
        StringBuilder sb = new StringBuilder();
        List<String> results = result.getResults();
        float[] resultScores = result.getResultScores();

        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i)).append("   ").append(resultScores[i]).append("\n");
        }
        etPreview.setText(sb);
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent event) {
//        if (view == btnParse) {
//            gestureDetector.onTouchEvent(event);
//            return true;
//        }
//        return false;
//    }

}
