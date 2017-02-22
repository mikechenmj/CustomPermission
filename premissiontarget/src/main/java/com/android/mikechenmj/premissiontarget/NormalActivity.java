package com.android.mikechenmj.premissiontarget;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mikechenmj on 17-2-21.
 */

public class NormalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        if (getIntent().getAction().equals("mikechenmj.intent.action.NORMAL_TEST")) {
            ((TextView) findViewById(R.id.title)).setText("Normal");
        }
    }
}
