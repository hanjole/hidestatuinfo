package com.han.hidestatu;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by hs on 2017/4/26.
 */

class HideStatuScrollView extends ScrollView {

    Activity mActivity;

    public HideStatuScrollView(Context context, Activity activity) {
        super(context);
        mActivity = activity;
    }


    public HideStatuScrollView(Context context) {
        super(context);
    }

    public HideStatuScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HideStatuScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //按下时位置
    float eventY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (mActivity == null) {
            return super.onTouchEvent(event);
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                eventY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                float y = eventY - event.getY();

                if (y > 400) {
                    mActivity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
                } else if (y < -400) {
                    mActivity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }


                break;
        }


        return super.onTouchEvent(event);

    }


}
