package com.tuhuanjk.tuhuantest;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DemoActivity extends Activity {
    private TextView tv_dia;
    protected int activityCloseEnterAnimation;

    protected int activityCloseExitAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        tv_dia = (TextView) findViewById(R.id.tv_dia);

        TypedArray activityStyle = getTheme().obtainStyledAttributes(new int[] {android.R.attr.windowAnimationStyle});

        int windowAnimationStyleResId = activityStyle.getResourceId(0, 0);

        activityStyle.recycle();

        activityStyle = getTheme().obtainStyledAttributes(windowAnimationStyleResId, new int[] {android.R.attr.activityCloseEnterAnimation, android.R.attr.activityCloseExitAnimation});

        activityCloseEnterAnimation = activityStyle.getResourceId(0, 0);

        activityCloseExitAnimation = activityStyle.getResourceId(1, 0);

        activityStyle.recycle();

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(activityCloseEnterAnimation,activityCloseExitAnimation);
    }
}
