package com.example.ybk.mybehaviordemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.ybk.mybehaviordemo.gaojijinjie.GJJJActivity;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void click(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_main:
                intent.setAction("com.mainActivity");
                intent.addCategory("hahaha");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setData(Uri.parse("ybk://www.ybk.com"));
                if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "没有匹配", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_gaoji:
                startActivity(new Intent(this, GJJJActivity.class));
                break;
            default:
                break;
        }
    }
}
