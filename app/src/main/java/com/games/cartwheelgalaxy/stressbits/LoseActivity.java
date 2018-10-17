package com.games.cartwheelgalaxy.stressbits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class LoseActivity extends Activity {

    private InterstitialAd mInterstitialAd;
    AdRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "PG");
        request = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .tagForChildDirectedTreatment(true)
                .build();

        MobileAds.initialize(this, "ca-app-pub-5267056163100832~9942579333");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5267056163100832/3484696781");
        mInterstitialAd.loadAd(request);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(new Intent(LoseActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
                mInterstitialAd.loadAd(request);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        int xpos=(int) e.getX();
        int ypos=(int) e.getY();
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    startActivity(new Intent(LoseActivity.this, MainActivity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }

                Log.v("PERDISTE", "CAMBIO DE ESCENA");
                Log.d("DEBUG", "On touch (down)" + String.valueOf(xpos) + String.valueOf(ypos));
            case MotionEvent.ACTION_UP:
                Log.d("DEBUG", "On touch (up)" + String.valueOf(xpos) + String.valueOf(ypos));
            case MotionEvent.ACTION_MOVE:
                Log.d("DEBUG", "On touch (move)" + String.valueOf(xpos) + String.valueOf(ypos));
                break;
        }
        return true;

    }

}