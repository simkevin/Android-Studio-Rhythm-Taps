package com.example.kevin.rhythmtaps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import java.util.LinkedList;
import edu.princeton.cs.algs4.Stopwatch;

public class Level1Activity extends AppCompatActivity {

    private final double BARLENGTH = 4 * (1.0 / (85.0 / 60.0));
    private final double QUARTER = 1.0 / (85.0 / 60.0);
    private Stopwatch timer;
    private LinkedList<Double> recordedTaps;
    private LinkedList<Double> answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        timer = new Stopwatch();
        recordedTaps = new LinkedList<Double>();
        answer = new LinkedList<Double>();
        answer.add(BARLENGTH);
        answer.add(BARLENGTH + QUARTER);
        answer.add(BARLENGTH + 2 * QUARTER);
        answer.add(BARLENGTH + 3 * QUARTER);

        final MediaPlayer countOffMP = MediaPlayer.create(this, R.raw.countoff);
        final Button playCountoff = (Button) this.findViewById(R.id.play_countoff);
        final Button check = (Button) this.findViewById(R.id.check);
        playCountoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                recordedTaps = new LinkedList<Double>();
                timer = new Stopwatch();
                countOffMP.start();
                playCountoff.setVisibility(View.INVISIBLE);
                check.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        final MediaPlayer beatMP = MediaPlayer.create(this, R.raw.beat);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                beatMP.start();
                recordedTaps.add(timer.elapsedTime());
        }
        return true;
    }

    public void check(View view) {
        while (answer.peek() != null && recordedTaps.peek() != null) {
            if (Math.abs(recordedTaps.remove() - answer.remove()) > QUARTER / 4.0) {
                displayWrong();
                return;
            }
        }
        displayRight();
    }

    public void displayRight() {
        Intent intent = new Intent(this, DisplayRightActivity.class);
        startActivity(intent);
    }

    public void displayWrong() {
        Intent intent = new Intent(this, DisplayWrongActivity.class);
        startActivity(intent);
    }
}
