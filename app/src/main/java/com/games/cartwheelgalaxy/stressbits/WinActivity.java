package com.games.cartwheelgalaxy.stressbits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

public class WinActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public boolean onTouchEvent(MotionEvent e)
    {
        int xpos=(int) e.getX();
        int ypos=(int) e.getY();
        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Intent menuIntent = new Intent(WinActivity.this, MainActivity.class);
                startActivity(menuIntent);
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