package com.games.cartwheelgalaxy.stressbits;

import android.app.Activity;
import android.content.Intent;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.view.WindowManager;

import android.widget.ImageView;
import android.widget.VideoView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;

public class IntroActivity extends Activity {

    LottieAnimationView animationView;
    VideoView videoIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        videoIntro = (VideoView) findViewById(R.id.videoIntro);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro_android);

        videoIntro.setVideoURI(video);

        videoIntro.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (isFinishing())
                    return;

                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();
            }
        });

        videoIntro.start();

        }
    }