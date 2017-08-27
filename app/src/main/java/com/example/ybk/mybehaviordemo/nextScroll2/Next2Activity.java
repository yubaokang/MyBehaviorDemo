package com.example.ybk.mybehaviordemo.nextScroll2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ybk.mybehaviordemo.R;

public class Next2Activity extends AppCompatActivity {

    private NextContainerLayout nextContainerLayout;
    private NextChildView topView;
    private NextChildView bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next2);
        nextContainerLayout = (NextContainerLayout) findViewById(R.id.nextContainerLayout);
        topView = (NextChildView) findViewById(R.id.topView);
        bottomView = (NextChildView) findViewById(R.id.bottomView);
//        nextContainerLayout.setTopView(topView);
//        nextContainerLayout.setBottomView(bottomView);
    }
}
