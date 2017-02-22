package com.android.mikechenmj.premissionrequester;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DANGEROUS_ACTION = "mikechenmj.intent.action.DANGEROUS_TEST";

    private static final String NORMAL_ACTION = "mikechenmj.intent.action.NORMAL_TEST";

    private static final String DANGEROUS_PERMISSION = "mikechenmj.permission.DANGEROUS_TEST";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.message);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.normal:
                try {
                    startActivity(new Intent(NORMAL_ACTION));
                } catch (Exception e) {
                    e.printStackTrace();
                    mTextView.setText(e.getMessage());
                }
                break;

            case R.id.dangerous:
                try {
                    startActivity(new Intent(DANGEROUS_ACTION));
                } catch (Exception e) {
                    e.printStackTrace();
                    mTextView.setText(e.getMessage());
                }
                break;

            case R.id.dangerous_with_permission:
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ActivityCompat.checkSelfPermission(this,DANGEROUS_PERMISSION)
                                != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(this,new String[]
                                    {DANGEROUS_PERMISSION},1);
                        }else {
                            startActivity(new Intent(DANGEROUS_ACTION));
                        }
                    }else {
                        startActivity(new Intent(DANGEROUS_ACTION));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mTextView.setText(e.getMessage());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults != null && grantResults.length >=0) {
            switch (requestCode) {
                case 1:
                    if (grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                        startActivity(new Intent(DANGEROUS_ACTION));
                    }
            }
        }
    }
}
