package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.bingo.StandFlutterActivity;

import io.flutter.embedding.android.FlutterFragmentActivity;

public class MainActivity extends FlutterFragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(View view) {
        FrameLayout testLayout = new FrameLayout(this);
        testLayout.addView(view, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

        Button btn = new Button(this);
        btn.setText("Start Child");

        FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        flp.gravity = Gravity.BOTTOM;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StandFlutterActivity.class));
            }
        });

        testLayout.addView(btn, flp);
        super.setContentView(testLayout);
    }
}
