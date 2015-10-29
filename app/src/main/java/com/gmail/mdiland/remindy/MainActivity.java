package com.gmail.mdiland.remindy;

import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gmail.mdiland.remindy.application.RemindyApplication;
import com.gmail.mdiland.remindy.textprocessor.impl.SimpleReminderTextParser;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private EditText etPreview;
    private EditText etInput;
    private Button btnParse;

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
    }

    public void processInput(View view) {
        RemindyApplication application = (RemindyApplication) getApplication();
        SimpleReminderTextParser textParser = new SimpleReminderTextParser();
        textParser.setDictionary(application.getDictionaryBase());

        String inputText = etInput.getText().toString();
        textParser.process(inputText);
    }

    public void recognizeSpeech() {
        SpeechRecognizer speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
//        if (view == btnParse) {
//            event.getButtonState()
//        }
        return false;
    }

    private class MyRecognitionListener implements RecognitionListener {

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

        }

        @Override
        public void onPartialResults(Bundle bundle) {

        }

        @Override
        public void onEvent(int i, Bundle bundle) {

        }
    }
}
