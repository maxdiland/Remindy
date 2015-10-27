package com.gmail.mdiland.remindy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.gmail.mdiland.remindy.application.RemindyApplication;
import com.gmail.mdiland.remindy.textprocessor.impl.SimpleReminderTextParser;

public class MainActivity extends AppCompatActivity {

    private EditText etPreview;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();

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
}
