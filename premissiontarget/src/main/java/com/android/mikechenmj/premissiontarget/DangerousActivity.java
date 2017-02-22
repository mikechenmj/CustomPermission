package com.android.mikechenmj.premissiontarget;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by mikechenmj on 17-2-21.
 */

public class DangerousActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        if (getIntent().getAction().equals("mikechenmj.intent.action.DANGEROUS_TEST")) {
            ((TextView) findViewById(R.id.title)).setText("Dangerous");
        }
    }
}
