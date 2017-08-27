package com.example.ybk.mybehaviordemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ybk.mybehaviordemo.R;
import com.example.ybk.mybehaviordemo.behavior.HeaderBehaviorActivity;
import com.example.ybk.mybehaviordemo.drag.MyDragActivity;
import com.example.ybk.mybehaviordemo.fragment.ItemListDialogFragment;
import com.example.ybk.mybehaviordemo.myview.MyViewActivity;
import com.example.ybk.mybehaviordemo.myview.MyViewActivity2;
import com.example.ybk.mybehaviordemo.myview.MyViewActivity3;
import com.example.ybk.mybehaviordemo.nestBehavior.MyActivity;
import com.example.ybk.mybehaviordemo.nextScroll.ScrollNextActivity;
import com.example.ybk.mybehaviordemo.nextScroll2.Next2Activity;
import com.example.ybk.mybehaviordemo.nextScroll3.Next3Activity;

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
            case R.id.btn_messenger:
                ItemListDialogFragment.newInstance(102).show(getSupportFragmentManager(), "aaaaa");
                break;
            case R.id.ScrollingActivity:
                startActivity(new Intent(this, ScrollingActivity.class));
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
            case R.id.button8:
                startActivity(new Intent(this, MyViewActivity2.class));
                break;
            case R.id.button9:
                startActivity(new Intent(this, MyViewActivity3.class));
                break;
            case R.id.button10:
                startActivity(new Intent(this, HeaderBehaviorActivity.class));
                break;
            case R.id.button11:
                startActivity(new Intent(this, Next2Activity.class));
                break;
            case R.id.button12:
                startActivity(new Intent(this, Next3Activity.class));
                break;
            default:
                break;
        }
    }
}
