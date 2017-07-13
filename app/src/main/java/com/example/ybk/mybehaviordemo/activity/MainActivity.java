package com.example.ybk.mybehaviordemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ybk.mybehaviordemo.R;
import com.example.ybk.mybehaviordemo.fragment.ItemListDialogFragment;
import com.example.ybk.mybehaviordemo.myview.MyViewActivity;

public class MainActivity extends AppCompatActivity implements ItemListDialogFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onItemClicked(int position) {

    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_bottom_dialog:
                ItemListDialogFragment.newInstance(102).show(getSupportFragmentManager(), "aaaaa");
                break;
            case R.id.ScrollingActivity:
                startActivity(new Intent(this, ScrollingActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, MyActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, MyDragActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, ScrollNextActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, BehaviorActivity.class));
                break;
            case R.id.button7:
                startActivity(new Intent(this, MyViewActivity.class));
                break;
            default:
                break;
        }
    }
}
