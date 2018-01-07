package com.example.kevin.rhythmtaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayBeginnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_beginner);
    }

    public void openLevel1(View view) {
        Intent intent = new Intent(this, Level1Activity.class);
        startActivity(intent);
    }
}
