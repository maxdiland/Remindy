package com.gmail.mdiland.remindy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.gmail.mdiland.remindy.application.RemindyApplication;
import com.gmail.mdiland.remindy.dto.WordBundle;
import com.gmail.mdiland.remindy.textprocessor.SentenceMap;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

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
        String inputText = etInput.getText().toString();
        RemindyApplication application = (RemindyApplication) getApplication();
        SentenceMap sentenceMap = new SentenceMap(inputText, application.getDictionaryBase());
        int i = sentenceMap.hashCode();
    }
}
