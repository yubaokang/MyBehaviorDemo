package com.example.ybk.mybehaviordemo.gaojijinjie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ybk.mybehaviordemo.R;
import com.example.ybk.mybehaviordemo.fragment.ItemListDialogFragment;
import com.example.ybk.mybehaviordemo.gaojijinjie.messenger.MessengerActivity;

public class GJJJActivity extends AppCompatActivity implements ItemListDialogFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gjjj);
    }

    @Override
    public void onItemClicked(int position) {
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn_messenger:
                startActivity(new Intent(this, MessengerActivity.class));
                break;
            case R.id.ScrollingActivity:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            default:
                break;
        }
    }
}
