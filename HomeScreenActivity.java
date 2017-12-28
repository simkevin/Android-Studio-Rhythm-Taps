package com.example.kevin.rhythmtaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void openLevels(View view) {
        Intent intent = new Intent(this, DisplayLevelsActivity.class);
        startActivity(intent);
    }
}
