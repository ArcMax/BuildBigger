package com.explore.archana.andolibrary;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by archana on 1/6/2016.
 */
public class MyActivity extends Activity {

    public final static String INTENT_JOKE = "INTENT_JOKE";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andolib_main);
        // joke intent
        String joke = getIntent().getStringExtra(INTENT_JOKE);
        TextView textViewJoke = (TextView) findViewById(R.id.textview_joke);
        textViewJoke.setText(joke);
    }
}
