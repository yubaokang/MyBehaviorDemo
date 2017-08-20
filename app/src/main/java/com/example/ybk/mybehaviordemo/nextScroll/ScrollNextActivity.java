package com.example.ybk.mybehaviordemo.nextScroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ybk.mybehaviordemo.R;

public class ScrollNextActivity extends AppCompatActivity {
    private ScrollChildContainerLayout child_0;
    private ScrollChildContainerLayout child_1;
    private ScrollChildContainerLayout child_2;
    private ScrollNextContainerLayout layout_parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_next);
        layout_parent = (ScrollNextContainerLayout) findViewById(R.id.layout_parent);
        child_0 = (ScrollChildContainerLayout) findViewById(R.id.child_0);
        child_1 = (ScrollChildContainerLayout) findViewById(R.id.child_1);
        child_2 = (ScrollChildContainerLayout) findViewById(R.id.child_2);
        layout_parent.setChild_0(child_0);
        layout_parent.setChild_1(child_1);
        layout_parent.setChild_2(child_2);
    }
}
