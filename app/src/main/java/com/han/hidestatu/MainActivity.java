package com.han.hidestatu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    HideStatuScrollView statuScrollView;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.ss);

        statuScrollView = (HideStatuScrollView) findViewById(R.id.s);
        statuScrollView.mActivity = this;
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            float eventY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        eventY = event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float y = eventY - event.getY();

                        if (y > 400) {
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
                        } else if (y < -400) {
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                        }

                        break;
                }


                return false;
            }
        });

    }

}
