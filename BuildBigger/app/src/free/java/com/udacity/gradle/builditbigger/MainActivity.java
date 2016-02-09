package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.explore.archana.andolibrary.MyActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("3C0B8E853025512C2738F4A86B8E3629")
                .build();
        mAdView.loadAd(adRequest);
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
