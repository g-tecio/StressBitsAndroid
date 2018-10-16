package com.games.cartwheelgalaxy.stressbits;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import android.view.MotionEvent;
import android.view.View;

import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;

import android.widget.ImageView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    float xCoOrdinate, yCoOrdinate;
    ImageView figureCircleBlue, figureCircleRed, figureCircleDBlue, figureCircleGreen, figureCircleYellow, figureSquareBlue, figureSquareRed, figureSquareDBlue, figureSquareGreen, figureSquareYellow,
            figureStarBlue, figureStarRed, figureStarDBlue, figureStarGreen, figureStarYellow, figureTriangleBlue, figureTriangleRed, figureTriangleDBlue, figureTriangleGreen, figureTriangleYellow,
            figureHexagonBlue, figureHexagonRed, figureHexagonDBlue, figureHexagonGreen, figureHexagonYellow, bin, timerNeedle, randomElement;
    float windowWidth, windowHeight;
    int xImage, yImage;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12,
            imageView13, imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20, imageView21, imageView22, imageView23, imageView24, imageView25, timerBase;
    List<ImageView> names;
    List<ImageView> figures;
    int count = -1;
    boolean noEntra=false, clickEnable=false;
    MediaPlayer pieceFit;
    MediaPlayer pieceDontFit;
    MediaPlayer timer;
    MediaPlayer lose;
    MediaPlayer win;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MobileAds.initialize(this, "ca-app-pub-5267056163100832~9942579333");

        pieceFit = MediaPlayer.create(MainActivity.this, R.raw.piece_fit);
        pieceDontFit = MediaPlayer.create(MainActivity.this, R.raw.piece_dont_fit);
        timer = MediaPlayer.create(MainActivity.this, R.raw.timer);
        lose = MediaPlayer.create(MainActivity.this, R.raw.lose);
        win = MediaPlayer.create(MainActivity.this, R.raw.kids_cheering);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        windowHeight = displayMetrics.heightPixels;
        windowWidth = displayMetrics.widthPixels;

        figureCircleBlue = findViewById(R.id.figureCircleBlue);
        figureCircleDBlue =  findViewById(R.id.figureCircleDBlue);
        figureCircleGreen =  findViewById(R.id.figureCircleGreen);
        figureCircleRed =  findViewById(R.id.figureCircleRed);
        figureCircleYellow =  findViewById(R.id.figureCircleYellow);
        figureSquareBlue = findViewById(R.id.figureSquareBlue);
        figureSquareDBlue = findViewById(R.id.figureSquareDBlue);
        figureSquareGreen = findViewById(R.id.figureSquareGreen);
        figureSquareRed = findViewById(R.id.figureSquareRed);
        figureSquareYellow = findViewById(R.id.figureSquareYellow);
        figureStarBlue = findViewById(R.id.figureStarBlue);
        figureStarDBlue = findViewById(R.id.figureStarDBlue);
        figureStarGreen = findViewById(R.id.figureStarGreen);
        figureStarRed = findViewById(R.id.figureStarRed);
        figureStarYellow = findViewById(R.id.figureStarYellow);
        figureTriangleBlue = findViewById(R.id.figureTriangleBlue);
        figureTriangleDBlue = findViewById(R.id.figureTriangleDBlue);
        figureTriangleGreen = findViewById(R.id.figureTriangleGreen);
        figureTriangleRed = findViewById(R.id.figureTriangleRed);
        figureTriangleYellow = findViewById(R.id.figureTriangleYellow);
        figureHexagonBlue = findViewById(R.id.figureHexagonBlue);
        figureHexagonDBlue = findViewById(R.id.figureHexagonDBlue);
        figureHexagonGreen = findViewById(R.id.figureHexagonGreen);
        figureHexagonRed = findViewById(R.id.figureHexagonRed);
        figureHexagonYellow = findViewById(R.id.figureHexagonYellow);

        timerNeedle = findViewById(R.id.timerNeedle);
        timerBase = findViewById(R.id.timerBase);
        bin = findViewById(R.id.bin);


        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);
        imageView12 = (ImageView) findViewById(R.id.imageView12);
        imageView13 = (ImageView) findViewById(R.id.imageView13);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        imageView15 = (ImageView) findViewById(R.id.imageView15);
        imageView16 = (ImageView) findViewById(R.id.imageView16);
        imageView17 = (ImageView) findViewById(R.id.imageView17);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        imageView19 = (ImageView) findViewById(R.id.imageView19);
        imageView20 = (ImageView) findViewById(R.id.imageView20);
        imageView21 = (ImageView) findViewById(R.id.imageView21);
        imageView22 = (ImageView) findViewById(R.id.imageView22);
        imageView23 = (ImageView) findViewById(R.id.imageView23);
        imageView24 = (ImageView) findViewById(R.id.imageView24);
        imageView25 = (ImageView) findViewById(R.id.imageView25);

        names = new ArrayList<ImageView>();
        names.add(imageView1);
        names.add(imageView2);
        names.add(imageView3);
        names.add(imageView4);
        names.add(imageView5);
        names.add(imageView6);
        names.add(imageView7);
        names.add(imageView8);
        names.add(imageView9);
        names.add(imageView10);
        names.add(imageView11);
        names.add(imageView12);
        names.add(imageView13);
        names.add(imageView14);
        names.add(imageView15);
        names.add(imageView16);
        names.add(imageView17);
        names.add(imageView18);
        names.add(imageView19);
        names.add(imageView20);
        names.add(imageView21);
        names.add(imageView22);
        names.add(imageView23);
        names.add(imageView24);
        names.add(imageView25);


        // shuffle or randomize
        Collections.shuffle(names);

        int intname = imageView1.getId();
        String stringname = getResources().getResourceEntryName(intname);
        System.out.println("stringname: " + stringname);


        imageView1.setTag("container_circle_dblue");
        imageView2.setTag("container_square_dblue");
        imageView3.setTag("container_hexagone_dblue");
        imageView4.setTag("container_triangle_dblue");
        imageView5.setTag("container_star_dblue");

        imageView6.setTag("container_circle_blue");
        imageView7.setTag("container_square_blue");
        imageView8.setTag("container_hexagone_blue");
        imageView9.setTag("container_triangle_blue");
        imageView10.setTag("container_star_blue");

        imageView11.setTag("container_circle_green");
        imageView12.setTag("container_square_green");
        imageView13.setTag("container_hexagone_green");
        imageView14.setTag("container_triangle_green");
        imageView15.setTag("container_star_green");

        imageView16.setTag("container_circle_red");
        imageView17.setTag("container_square_red");
        imageView18.setTag("container_hexagone_red");
        imageView19.setTag("container_triangle_red");
        imageView20.setTag("container_star_red");

        imageView21.setTag("container_circle_yellow");
        imageView22.setTag("container_square_yellow");
        imageView23.setTag("container_hexagone_yellow");
        imageView24.setTag("container_triangle_yellow");
        imageView25.setTag("container_star_yellow");

        String imageName1 = (String) imageView1.getTag();
        String imageName2 = (String) imageView2.getTag();
        String imageName3 = (String) imageView3.getTag();
        String imageName4 = (String) imageView4.getTag();
        String imageName5 = (String) imageView5.getTag();

        String imageName6 = (String) imageView6.getTag();
        String imageName7 = (String) imageView7.getTag();
        String imageName8 = (String) imageView8.getTag();
        String imageName9 = (String) imageView9.getTag();
        String imageName10 = (String) imageView10.getTag();

        String imageName11 = (String) imageView11.getTag();
        String imageName12 = (String) imageView12.getTag();
        String imageName13 = (String) imageView13.getTag();
        String imageName14 = (String) imageView14.getTag();
        String imageName15 = (String) imageView15.getTag();

        String imageName16 = (String) imageView16.getTag();
        String imageName17 = (String) imageView17.getTag();
        String imageName18 = (String) imageView18.getTag();
        String imageName19 = (String) imageView19.getTag();
        String imageName20 = (String) imageView20.getTag();

        String imageName21 = (String) imageView21.getTag();
        String imageName22 = (String) imageView22.getTag();
        String imageName23 = (String) imageView23.getTag();
        String imageName24 = (String) imageView24.getTag();
        String imageName25 = (String) imageView25.getTag();



        names.get(0).setImageResource(getResources().getIdentifier(imageName1, "mipmap", getPackageName()));
        names.get(1).setImageResource(getResources().getIdentifier(imageName2, "mipmap", getPackageName()));
        names.get(2).setImageResource(getResources().getIdentifier(imageName3, "mipmap", getPackageName()));
        names.get(3).setImageResource(getResources().getIdentifier(imageName4, "mipmap", getPackageName()));
        names.get(4).setImageResource(getResources().getIdentifier(imageName5, "mipmap", getPackageName()));

        names.get(5).setImageResource(getResources().getIdentifier(imageName6, "mipmap", getPackageName()));
        names.get(6).setImageResource(getResources().getIdentifier(imageName7, "mipmap", getPackageName()));
        names.get(7).setImageResource(getResources().getIdentifier(imageName8, "mipmap", getPackageName()));
        names.get(8).setImageResource(getResources().getIdentifier(imageName9, "mipmap", getPackageName()));
        names.get(9).setImageResource(getResources().getIdentifier(imageName10, "mipmap", getPackageName()));

        names.get(10).setImageResource(getResources().getIdentifier(imageName11, "mipmap", getPackageName()));
        names.get(11).setImageResource(getResources().getIdentifier(imageName12, "mipmap", getPackageName()));
        names.get(12).setImageResource(getResources().getIdentifier(imageName13, "mipmap", getPackageName()));
        names.get(13).setImageResource(getResources().getIdentifier(imageName14, "mipmap", getPackageName()));
        names.get(14).setImageResource(getResources().getIdentifier(imageName15, "mipmap", getPackageName()));

        names.get(15).setImageResource(getResources().getIdentifier(imageName16, "mipmap", getPackageName()));
        names.get(16).setImageResource(getResources().getIdentifier(imageName17, "mipmap", getPackageName()));
        names.get(17).setImageResource(getResources().getIdentifier(imageName18, "mipmap", getPackageName()));
        names.get(18).setImageResource(getResources().getIdentifier(imageName19, "mipmap", getPackageName()));
        names.get(19).setImageResource(getResources().getIdentifier(imageName20, "mipmap", getPackageName()));

        names.get(20).setImageResource(getResources().getIdentifier(imageName21, "mipmap", getPackageName()));
        names.get(21).setImageResource(getResources().getIdentifier(imageName22, "mipmap", getPackageName()));
        names.get(22).setImageResource(getResources().getIdentifier(imageName23, "mipmap", getPackageName()));
        names.get(23).setImageResource(getResources().getIdentifier(imageName24, "mipmap", getPackageName()));
        names.get(24).setImageResource(getResources().getIdentifier(imageName25, "mipmap", getPackageName()));

        figures = new ArrayList<ImageView>();
        figures.add(figureCircleBlue);
        figures.add(figureCircleDBlue);
        figures.add(figureCircleGreen);
        figures.add(figureCircleRed);
        figures.add(figureCircleYellow);
        figures.add(figureSquareBlue);
        figures.add(figureSquareDBlue);
        figures.add(figureSquareGreen);
        figures.add(figureSquareRed);
        figures.add(figureSquareYellow);
        figures.add(figureTriangleBlue);
        figures.add(figureTriangleDBlue);
        figures.add(figureTriangleGreen);
        figures.add(figureTriangleRed);
        figures.add(figureTriangleYellow);
        figures.add(figureHexagonBlue);
        figures.add(figureHexagonDBlue);
        figures.add(figureHexagonGreen);
        figures.add(figureHexagonRed);
        figures.add(figureHexagonYellow);
        figures.add(figureStarBlue);
        figures.add(figureStarDBlue);
        figures.add(figureStarGreen);
        figures.add(figureStarRed);
        figures.add(figureStarYellow);

        Collections.shuffle(figures);

        figureCircleBlue.setTag("container_circle_blue");
        figureSquareBlue.setTag("container_square_blue");
        figureHexagonBlue.setTag("container_hexagone_blue");
        figureTriangleBlue.setTag("container_triangle_blue");
        figureStarBlue.setTag("container_star_blue");

        figureCircleDBlue.setTag("container_circle_dblue");
        figureSquareDBlue.setTag("container_square_dblue");
        figureHexagonDBlue.setTag("container_hexagone_dblue");
        figureTriangleDBlue.setTag("container_triangle_dblue");
        figureStarDBlue.setTag("container_star_dblue");

        figureCircleGreen.setTag("container_circle_green");
        figureSquareGreen.setTag("container_square_green");
        figureHexagonGreen.setTag("container_hexagone_green");
        figureTriangleGreen.setTag("container_triangle_green");
        figureStarGreen.setTag("container_star_green");

        figureCircleRed.setTag("container_circle_red");
        figureSquareRed.setTag("container_square_red");
        figureHexagonRed.setTag("container_hexagone_red");
        figureTriangleRed.setTag("container_triangle_red");
        figureStarRed.setTag("container_star_red");

        figureCircleYellow.setTag("container_circle_yellow");
        figureSquareYellow.setTag("container_square_yellow");
        figureHexagonYellow.setTag("container_hexagone_yellow");
        figureTriangleYellow.setTag("container_triangle_yellow");
        figureStarYellow.setTag("container_star_yellow");


        Animation fadeIn = new AlphaAnimation(0.7f, 0.9f);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);
        fadeIn.setRepeatCount(Animation.INFINITE);

        Animation fadeOut = new AlphaAnimation(0.9f, 0.7f);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this

        fadeOut.setDuration(1000);
        fadeOut.setRepeatCount(Animation.INFINITE);

        final AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeOut);
        animation.addAnimation(fadeIn);
        timerBase.setAnimation(animation);

        bin.setEnabled(false);

        //ROTATE TIMER NEEDLE
        timerNeedle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                timer.setLooping(true);
                RotateAnimation rotation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotation.setDuration(90000);

                timerNeedle.setAnimation(rotation);
                timerNeedle.startAnimation(rotation);
                timerNeedle.setEnabled(false);
                timerBase.clearAnimation();
                timerBase.setAlpha(1.0f);
                bin.setEnabled(true);
                Log.v("ACTIVADO","SI SE ARMA");


                rotation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // Pass the Intent to switch to other Activity
                        timer.stop();
                        lose.start();

                            startActivity(new Intent(MainActivity.this, LoseActivity.class));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                            Log.d("TAG", "The interstitial wasn't loaded yet.");


                    }
                });
            }
        });

        Log.v("CONTADOR ARRAY", String.valueOf(figures.size()));




        bin.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:

                        count = count + 1;

                        if (count == 25) {
                            count = count - 24;

                        }

                        if (count >= figures.size()) {
                            count = figures.size() - 1;
                        }

                        randomElement = figures.get(count);
                        xImage = randomElement.getLeft();
                        yImage = randomElement.getTop();

                        randomElement.animate().x(event.getRawX() + xCoOrdinate - 50).y(event.getRawY() + yCoOrdinate - 180).setDuration(150).start();

                        break;

                    case MotionEvent.ACTION_MOVE:
                       randomElement.animate().x(event.getRawX() + xCoOrdinate - 50).y(event.getRawY() + yCoOrdinate - 180).setDuration(0).start();

                        break;

                    case MotionEvent.ACTION_UP:

                        detectCollision();
                        if (noEntra == false) {
                            figures.remove(count);
                        }if(noEntra){


                        randomElement.animate().x(xImage).y(yImage).setDuration(0).start();
                    }
                        if (figures.size() == 0){

                            win.start();
                            timer.stop();

                            startActivity(new Intent(MainActivity.this, WinActivity.class));
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

    }

    public void detectCollision() {

        if (randomElement.getTag() == imageView1.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(0).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(0).getWidth(), loc[1] + names.get(0).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(0).setImageResource(R.mipmap.filled_circle_dblue);
                randomElement.setVisibility(View.GONE);


                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_circle_dblue, 350);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(0), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();


            }

        }


        if (randomElement.getTag() == imageView2.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(1).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(1).getWidth(), loc[1] + names.get(1).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(1).setImageResource(R.mipmap.filled_squre_dblue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_square_dblue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(1), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();

            }

        }



        if (randomElement.getTag() == imageView3.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(2).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(2).getWidth(), loc[1] + names.get(2).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(2).setImageResource(R.mipmap.filled_hexagon_dblue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_hexa_dblue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(2), 70);

            } else {
                Log.d(TAG, "Sin colision");
                count = count + 1;
                pieceDontFit.start();
            }

        }


        if (randomElement.getTag() == imageView4.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(3).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(3).getWidth(), loc[1] + names.get(3).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(3).setImageResource(R.mipmap.filled_triangle_dblue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_triangle_dblue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(3), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();

            }

        }

        if (randomElement.getTag() == imageView5.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(4).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(3).getWidth(), loc[1] + names.get(4).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(4).setImageResource(R.mipmap.filled_star_dblue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_star_dblue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(4), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();
            }

        }



        if (randomElement.getTag() == imageView6.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(5).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(5).getWidth(), loc[1] + names.get(5).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(5).setImageResource(R.mipmap.filled_circle_blue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_circle_blue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(5), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();


            }

        }

        if (randomElement.getTag() == imageView7.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(6).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(6).getWidth(), loc[1] + names.get(6).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(6).setImageResource(R.mipmap.filled_squre_blue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_square_blue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(6), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();

            }

        }



        if (randomElement.getTag() == imageView8.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(7).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(7).getWidth(), loc[1] + names.get(7).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(7).setImageResource(R.mipmap.filled_hexagon_blue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_hexa_blue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(7), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView9.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(8).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(8).getWidth(), loc[1] + names.get(8).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(8).setImageResource(R.mipmap.filled_triangle_blue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_triangle_blue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(8), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView10.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(9).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(9).getWidth(), loc[1] + names.get(9).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(9).setImageResource(R.mipmap.filled_star_blue);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_star_blue, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(9), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();

            }

        }

        if (randomElement.getTag() == imageView11.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(10).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(10).getWidth(), loc[1] + names.get(10).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(10).setImageResource(R.mipmap.filled_circle_green);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_circle_green, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(10), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView12.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(11).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(11).getWidth(), loc[1] + names.get(11).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(11).setImageResource(R.mipmap.filled_squre_green);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_square_green, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(11), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView13.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(12).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(12).getWidth(), loc[1] + names.get(12).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(12).setImageResource(R.mipmap.filled_hexagon_green);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_hexa_green, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(12), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView14.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(13).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(13).getWidth(), loc[1] + names.get(13).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(13).setImageResource(R.mipmap.filled_triangle_green);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_triangle_green, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(13), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }
        }

        if (randomElement.getTag() == imageView15.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(14).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(14).getWidth(), loc[1] + names.get(14).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(14).setImageResource(R.mipmap.filled_star_green);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_star_green, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(14), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();

            }

        }

        if (randomElement.getTag() == imageView16.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(15).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(15).getWidth(), loc[1] + names.get(15).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(15).setImageResource(R.mipmap.filled_circle_red);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_circle_red, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(15), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();

            }

        }

        if (randomElement.getTag() == imageView17.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(16).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(16).getWidth(), loc[1] + names.get(16).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(16).setImageResource(R.mipmap.filled_squre_red);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_square_red, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(16), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;

                pieceDontFit.start();
            }

        }
        if (randomElement.getTag() == imageView18.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(17).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(17).getWidth(), loc[1] + names.get(17).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(17).setImageResource(R.mipmap.filled_hexagon_red);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_hexa_red, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(17), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;

                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView19.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(18).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(18).getWidth(), loc[1] + names.get(18).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(18).setImageResource(R.mipmap.filled_triangle_red);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_triangle_red, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(18), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView20.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(19).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(19).getWidth(), loc[1] + names.get(19).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(19).setImageResource(R.mipmap.filled_star_red);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_star_red, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(19), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView21.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(20).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(20).getWidth(), loc[1] + names.get(20).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(20).setImageResource(R.mipmap.filled_circle_yellow);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_circle_yellow, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(20), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView22.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(21).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(21).getWidth(), loc[1] + names.get(21).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(21).setImageResource(R.mipmap.filled_squre_yellow);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_square_yellow, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(21), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView23.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(22).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(22).getWidth(), loc[1] + names.get(22).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(22).setImageResource(R.mipmap.filled_hexagon_yellow);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_hexa_yellow, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(22), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView24.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(23).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(23).getWidth(), loc[1] + names.get(23).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(23).setImageResource(R.mipmap.filled_triangle_yellow);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_triangle_yellow, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(23), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;
                count = count + 1;
                pieceDontFit.start();
            }

        }

        if (randomElement.getTag() == imageView25.getTag()){
            Log.v("Correcto", "son iguales");


            final int[] loc = new int[2];

            randomElement.getLocationInWindow(loc);
            final Rect rc1 = new Rect(loc[0], loc[1],
                    loc[0] + randomElement.getWidth(), loc[1] + randomElement.getHeight());


            names.get(24).getLocationInWindow(loc);
            final Rect rc2 = new Rect(loc[0], loc[1],
                    loc[0] + names.get(24).getWidth(), loc[1] + names.get(24).getHeight());

            if (Rect.intersects(rc1, rc2)) {
                Log.d(TAG, "Colision");
                noEntra = false;

                names.get(24).setImageResource(R.mipmap.filled_star_yellow);
                randomElement.setVisibility(View.GONE);
                pieceFit.start();

                ParticleSystem ps = new ParticleSystem(this, 6, R.mipmap.particle_star_yellow, 600);
                ps.setScaleRange(0.3f, 0.6f);
                ps.setSpeedRange(0.1f, 0.25f);
                ps.setRotationSpeedRange(90, 180);
                ps.setFadeOut(200, new AccelerateInterpolator());
                ps.oneShot(names.get(24), 70);

            } else {
                Log.d(TAG, "Sin colision");
                noEntra = true;

                count = count + 1;
                pieceDontFit.start();

            }

        }
    }
}
