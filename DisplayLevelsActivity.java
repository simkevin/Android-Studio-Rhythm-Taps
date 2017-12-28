package com.example.kevin.rhythmtaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DisplayLevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_levels);
    }

    public void openBeginner(View view) {
        Intent intent = new Intent(this, DisplayBeginnerActivity.class);
        startActivity(intent);
    }

    public void openIntermediate(View view) {
        Intent intent = new Intent(this, DisplayIntermediateActivity.class);
        startActivity(intent);
    }

    public void openAdvanced(View view) {
        Intent intent = new Intent(this, DisplayAdvancedActivity.class);
        startActivity(intent);
    }
}
