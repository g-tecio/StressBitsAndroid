package com.games.cartwheelgalaxy.stressbits;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {
    private float xCoOrdinate, yCoOrdinate;
    Button btnRotate;
    ImageView figureCircleBlue, figureCircleRed, figureCircleDBlue, figureCircleGreen, figureCircleYellow,  bin, imageView, timerNeedle ;
    float windowWidth, windowHeight;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,
            imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,imageView20,imageView21,imageView22,imageView23,imageView24,imageView25;
    List<ImageView> names;
    List<ImageView> figures;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        windowHeight = displayMetrics.heightPixels;
        windowWidth = displayMetrics.widthPixels;

        figureCircleBlue = (ImageView) findViewById(R.id.figureCircleBlue);
        figureCircleDBlue = (ImageView) findViewById(R.id.figureCircleDBlue);
        figureCircleGreen = (ImageView) findViewById(R.id.figureCircleGreen);
        figureCircleRed = (ImageView) findViewById(R.id.figureCircleRed);
        figureCircleYellow = (ImageView) findViewById(R.id.figureCircleYellow);
        timerNeedle = findViewById(R.id.timerNeedle);
        bin = (ImageView) findViewById(R.id.bin);
        imageView = (ImageView) findViewById(R.id.imageView);


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

        ImageView Imageviews[] = {imageView1,imageView2,imageView3,imageView4,imageView5,
                imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,
                imageView13,imageView14,imageView15,imageView16,imageView17,imageView18,imageView19,
                imageView20,imageView21,imageView22,imageView23,imageView24,imageView25};
        Collections.shuffle(Arrays.asList(Imageviews));

        System.out.println("ARRAY0" + Imageviews[0]);
        System.out.println("ARRAY1" + Imageviews[1]);
        System.out.println("ARRAY2" + Imageviews[2]);
        System.out.println("ARRAY3" + Imageviews[3]);
        System.out.println("ARRAY4" + Imageviews[4]);
        System.out.println("ARRAY5" + Imageviews[5]);
        System.out.println("ARRAY6" + Imageviews[6]);
        System.out.println("ARRAY7" + Imageviews[7]);
        System.out.println("ARRAY8" + Imageviews[8]);
        System.out.println("ARRAY9" + Imageviews[9]);
        System.out.println("ARRAY10" + Imageviews[10]);
        System.out.println("ARRAY11" + Imageviews[11]);
        System.out.println("ARRAY12" + Imageviews[12]);
        System.out.println("ARRAY13" + Imageviews[13]);
        System.out.println("ARRAY14" + Imageviews[14]);
        System.out.println("ARRAY15" + Imageviews[15]);
        System.out.println("ARRAY16" + Imageviews[16]);
        System.out.println("ARRAY17" + Imageviews[17]);
        System.out.println("ARRAY18" + Imageviews[18]);
        System.out.println("ARRAY19" + Imageviews[19]);
        System.out.println("ARRAY20" + Imageviews[20]);
        System.out.println("ARRAY21" + Imageviews[21]);
        System.out.println("ARRAY22" + Imageviews[22]);
        System.out.println("ARRAY23" + Imageviews[23]);
        System.out.println("ARRAY24" + Imageviews[24]);

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
        System.out.println("LISTA0" + names.get(0));
        System.out.println("LISTA1" + names.get(1));
        System.out.println("LISTA2" + names.get(2));
        System.out.println("LISTA3" + names.get(3));
        System.out.println("LISTA4" + names.get(4));

        System.out.println("LISTA5" + names.get(5));
        System.out.println("LISTA6" + names.get(6));
        System.out.println("LISTA7" + names.get(7));
        System.out.println("LISTA8" + names.get(8));
        System.out.println("LISTA9" + names.get(9));

        System.out.println("LISTA10" + names.get(10));
        System.out.println("LISTA11" + names.get(11));
        System.out.println("LISTA12" + names.get(12));
        System.out.println("LISTA13" + names.get(13));
        System.out.println("LISTA14" + names.get(14));

        System.out.println("LISTA15" + names.get(15));
        System.out.println("LISTA16" + names.get(16));
        System.out.println("LISTA17" + names.get(17));
        System.out.println("LISTA18" + names.get(18));
        System.out.println("LISTA19" + names.get(19));

        System.out.println("LISTA20" + names.get(20));
        System.out.println("LISTA21" + names.get(21));
        System.out.println("LISTA22" + names.get(22));
        System.out.println("LISTA23" + names.get(23));
        System.out.println("LISTA24" + names.get(24));


        int intname= imageView1.getId();
        String stringname= getResources().getResourceEntryName(intname);
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

        Log.v("POSICION0", imageName1);
        Log.v("POSICION1", imageName2);
        Log.v("POSICION2", imageName3);
        Log.v("POSICION3", imageName4);
        Log.v("POSICION4", imageName5);
        Log.v("POSICION5", imageName6);
        Log.v("POSICION6", imageName7);
        Log.v("POSICION7", imageName8);
        Log.v("POSICION8", imageName9);
        Log.v("POSICION9", imageName10);
        Log.v("POSICION10", imageName11);
        Log.v("POSICION11", imageName12);
        Log.v("POSICION12", imageName13);
        Log.v("POSICION13", imageName14);
        Log.v("POSICION14", imageName15);
        Log.v("POSICION15", imageName16);
        Log.v("POSICION16", imageName17);
        Log.v("POSICION17", imageName18);
        Log.v("POSICION18", imageName19);
        Log.v("POSICION19", imageName20);
        Log.v("POSICION20", imageName21);
        Log.v("POSICION21", imageName22);
        Log.v("POSICION22", imageName23);
        Log.v("POSICION23", imageName24);
        Log.v("POSICION24", imageName25);

        names.get(0).setImageResource(getResources().getIdentifier(imageName1, "drawable", getPackageName()));
        names.get(1).setImageResource(getResources().getIdentifier(imageName2, "drawable", getPackageName()));
        names.get(2).setImageResource(getResources().getIdentifier(imageName3, "drawable", getPackageName()));
        names.get(3).setImageResource(getResources().getIdentifier(imageName4, "drawable", getPackageName()));
        names.get(4).setImageResource(getResources().getIdentifier(imageName5, "drawable", getPackageName()));

        names.get(5).setImageResource(getResources().getIdentifier(imageName6, "drawable", getPackageName()));
        names.get(6).setImageResource(getResources().getIdentifier(imageName7, "drawable", getPackageName()));
        names.get(7).setImageResource(getResources().getIdentifier(imageName8, "drawable", getPackageName()));
        names.get(8).setImageResource(getResources().getIdentifier(imageName9, "drawable", getPackageName()));
        names.get(9).setImageResource(getResources().getIdentifier(imageName10, "drawable", getPackageName()));

        names.get(10).setImageResource(getResources().getIdentifier(imageName11, "drawable", getPackageName()));
        names.get(11).setImageResource(getResources().getIdentifier(imageName12, "drawable", getPackageName()));
        names.get(12).setImageResource(getResources().getIdentifier(imageName13, "drawable", getPackageName()));
        names.get(13).setImageResource(getResources().getIdentifier(imageName14, "drawable", getPackageName()));
        names.get(14).setImageResource(getResources().getIdentifier(imageName15, "drawable", getPackageName()));

        names.get(15).setImageResource(getResources().getIdentifier(imageName16, "drawable", getPackageName()));
        names.get(16).setImageResource(getResources().getIdentifier(imageName17, "drawable", getPackageName()));
        names.get(17).setImageResource(getResources().getIdentifier(imageName18, "drawable", getPackageName()));
        names.get(18).setImageResource(getResources().getIdentifier(imageName19, "drawable", getPackageName()));
        names.get(19).setImageResource(getResources().getIdentifier(imageName20, "drawable", getPackageName()));

        names.get(20).setImageResource(getResources().getIdentifier(imageName21, "drawable", getPackageName()));
        names.get(21).setImageResource(getResources().getIdentifier(imageName22, "drawable", getPackageName()));
        names.get(22).setImageResource(getResources().getIdentifier(imageName23, "drawable", getPackageName()));
        names.get(23).setImageResource(getResources().getIdentifier(imageName24, "drawable", getPackageName()));
        names.get(24).setImageResource(getResources().getIdentifier(imageName25, "drawable", getPackageName()));




        figureCircleBlue.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();
                        break;

                    case MotionEvent.ACTION_UP:
                        detectCollision();

                        break;

                    default:
                        return false;
                }
                return true;
            }
        });



        figureCircleRed.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();

                        break;

                    case MotionEvent.ACTION_UP:
                        detectCollisionRed();

                        break;

                    default:
                        return false;
                }
                return true;
            }
        });


        figureCircleGreen.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();

                        break;

                    case MotionEvent.ACTION_UP:
                        detectCollisionGreen();

                        break;

                    default:
                        return false;
                }
                return true;
            }
        });


        figureCircleYellow.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xCoOrdinate = view.getX() - event.getRawX();
                        yCoOrdinate = view.getY() - event.getRawY();

                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.animate().x(event.getRawX() + xCoOrdinate).y(event.getRawY() + yCoOrdinate).setDuration(0).start();

                        break;

                    case MotionEvent.ACTION_UP:
                        detectCollisionYellow();

                        break;

                    default:
                        return false;
                }
                return true;
            }
        });

        bin.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:

                        figures = new ArrayList<ImageView>();
                        figures.add(figureCircleBlue);
                        figures.add(figureCircleDBlue);
                        figures.add(figureCircleGreen);
                        figures.add(figureCircleRed);
                        figures.add(figureCircleYellow);

                        Random r = new Random();

                        switch(r.nextInt(figures.size())) {
                            case 0:
                                Log.d("SELECTED", "FIGURE BLUE");
                                break;
                            case 1:
                                Log.d("SELECTED", "FIGURE DEEPBLUE");
                                break;
                            case 2:
                                Log.d("SELECTED", "FIGURE GREEN");
                                break;
                            case 3:
                                Log.d("SELECTED", "FIGURE RED");
                                break;
                            case 4:
                                Log.d("SELECTED", "FIGURE YELLOW");
                                break;
                            default:
                                Log.d("SELECTED", "NADA");
                        }

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

/*
        //GRAB A FIGURE
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                figures = new ArrayList<ImageView>();
                figures.add(figureCircleBlue);
                figures.add(figureCircleDBlue);
                figures.add(figureCircleGreen);
                figures.add(figureCircleRed);
                figures.add(figureCircleYellow);

                Random r = new Random();

                switch(r.nextInt(figures.size())) {
                    case 0:
                        Log.d("SELECTED", "FIGURE BLUE");
                        break;
                    case 1:
                        Log.d("SELECTED", "FIGURE DEEPBLUE");
                        break;
                    case 2:
                        Log.d("SELECTED", "FIGURE GREEN");
                        break;
                    case 3:
                        Log.d("SELECTED", "FIGURE RED");
                        break;
                    case 4:
                        Log.d("SELECTED", "FIGURE YELLOW");
                        break;
                    default:
                        Log.d("SELECTED", "NADA");
                }

            }
        });

*/

        //ROTATE TIMER NEEDLE
        timerNeedle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                        0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotation.setDuration(10000);

                timerNeedle.setAnimation(rotation);
                timerNeedle.startAnimation(rotation);
            }
        });


    }



    public void detectCollision(){
        final int[] loc = new int[2];

        figureCircleBlue.getLocationInWindow(loc);
        final Rect rc1 = new Rect(loc[0], loc[1],
                loc[0] + figureCircleBlue.getWidth(), loc[1] + figureCircleBlue.getHeight());

        names.get(5).getLocationInWindow(loc);
        final Rect rc2 = new Rect(loc[0], loc[1],
                loc[0] + names.get(5).getWidth(), loc[1] + names.get(5).getHeight());

        if (Rect.intersects(rc1,rc2)) {
            Log.d(TAG, "Colision");
            Toast.makeText(this, "Hay una colision", Toast.LENGTH_SHORT).show();
            names.get(5).setImageResource(R.drawable.filled_circle_blue1x);

            ParticleSystem ps = new ParticleSystem(this, 3, R.drawable.figure_circle_blue1x, 600);
            ps.setScaleRange(0.3f, 0.3f);
            ps.setSpeedRange(0.1f, 0.25f);
            ps.setRotationSpeedRange(90, 180);
            ps.setFadeOut(200, new AccelerateInterpolator());
            ps.oneShot(names.get(5), 70);

            figureCircleBlue.setVisibility(View.GONE);
        } else {
            Log.d(TAG, "Sin colision");
            Toast.makeText(this, "No hay colision", Toast.LENGTH_SHORT).show();

        }
    }

    public void detectCollisionRed(){
        final int[] loc = new int[2];

        figureCircleRed.getLocationInWindow(loc);
        final Rect rc1 = new Rect(loc[0], loc[1],
                loc[0] + figureCircleRed.getWidth(), loc[1] + figureCircleRed.getHeight());

        names.get(15).getLocationInWindow(loc);
        final Rect rc2 = new Rect(loc[0], loc[1],
                loc[0] + names.get(15).getWidth(), loc[1] + names.get(15).getHeight());

        if (Rect.intersects(rc1,rc2)) {
            Log.d(TAG, "Colision");
            Toast.makeText(this, "Hay una colision", Toast.LENGTH_SHORT).show();
            names.get(15).setImageResource(R.drawable.filled_circle_red1x);

            ParticleSystem ps = new ParticleSystem(this, 3, R.drawable.figure_circle_red1x, 600);
            ps.setScaleRange(0.3f, 0.3f);
            ps.setSpeedRange(0.1f, 0.25f);
            ps.setRotationSpeedRange(90, 180);
            ps.setFadeOut(200, new AccelerateInterpolator());
            ps.oneShot(names.get(15), 70);


            figureCircleRed.setVisibility(View.GONE);
        } else {
            Log.d(TAG, "Sin colision");
            Toast.makeText(this, "No hay colision", Toast.LENGTH_SHORT).show();

        }
    }

    public void detectCollisionYellow(){
        final int[] loc = new int[2];

        figureCircleYellow.getLocationInWindow(loc);
        final Rect rc1 = new Rect(loc[0], loc[1],
                loc[0] + figureCircleYellow.getWidth(), loc[1] + figureCircleYellow.getHeight());

        names.get(20).getLocationInWindow(loc);
        final Rect rc2 = new Rect(loc[0], loc[1],
                loc[0] + names.get(20).getWidth(), loc[1] + names.get(20).getHeight());

        if (Rect.intersects(rc1,rc2)) {
            Log.d(TAG, "Colision");
            Toast.makeText(this, "Hay una colision", Toast.LENGTH_SHORT).show();
            names.get(20).setImageResource(R.drawable.filled_circle_yellow1x);

            ParticleSystem ps = new ParticleSystem(this, 3, R.drawable.figure_circle_yellow1x, 600);
            ps.setScaleRange(0.3f, 0.3f);
            ps.setSpeedRange(0.1f, 0.25f);
            ps.setRotationSpeedRange(90, 180);
            ps.setFadeOut(200, new AccelerateInterpolator());
            ps.oneShot(names.get(20), 70);


            figureCircleYellow.setVisibility(View.GONE);
        } else {
            Log.d(TAG, "Sin colision");
            Toast.makeText(this, "No hay colision", Toast.LENGTH_SHORT).show();

        }
    }


    public void detectCollisionGreen(){
        final int[] loc = new int[2];

        figureCircleGreen.getLocationInWindow(loc);
        final Rect rc1 = new Rect(loc[0], loc[1],
                loc[0] + figureCircleGreen.getWidth(), loc[1] + figureCircleGreen.getHeight());

        names.get(10).getLocationInWindow(loc);
        final Rect rc2 = new Rect(loc[0], loc[1],
                loc[0] + names.get(10).getWidth(), loc[1] + names.get(10).getHeight());

        if (Rect.intersects(rc1,rc2)) {
            Log.d(TAG, "Colision");
            Toast.makeText(this, "Hay una colision", Toast.LENGTH_SHORT).show();
            names.get(10).setImageResource(R.drawable.filled_circle_green1x);

            ParticleSystem ps = new ParticleSystem(this, 3, R.drawable.figure_circle_green1x, 600);
            ps.setScaleRange(0.3f, 0.3f);
            ps.setSpeedRange(0.1f, 0.25f);
            ps.setRotationSpeedRange(90, 180);
            ps.setFadeOut(200, new AccelerateInterpolator());
            ps.oneShot(names.get(10), 70);


            figureCircleGreen.setVisibility(View.GONE);
        } else {
            Log.d(TAG, "Sin colision");
            Toast.makeText(this, "No hay colision", Toast.LENGTH_SHORT).show();

        }
    }
}
