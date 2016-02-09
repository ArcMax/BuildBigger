package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.explore.archana.andolibrary.MyActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
    public void tellJoke(View view){
        new EndpointsAsyncTask(this, new EndpointsAsyncTask.IJokeListener() {
            @Override
            public void iJokeListener(String joke){
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtra(MyActivity.INTENT_JOKE,joke);
                startActivity(intent);
            }
        }).execute();
    }
}
