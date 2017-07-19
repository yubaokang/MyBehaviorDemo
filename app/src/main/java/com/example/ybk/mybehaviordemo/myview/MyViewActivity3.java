package com.example.ybk.mybehaviordemo.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ybk.mybehaviordemo.R;

public class MyViewActivity3 extends AppCompatActivity {
    private MyView3 myView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view3);
        myView3 = (MyView3) findViewById(R.id.myView3);
    }

    public void click(View view) {
        if (myView3.isStarted) {
            myView3.stop();
        } else {
            myView3.start();
        }
    }
}
