package com.sandipbhattacharya.spaceshooter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvPoints, tvPersonalBest;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        int points = getIntent().getExtras().getInt("points");
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        int scoreSP = pref.getInt("scoreSP", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(points > scoreSP){
            scoreSP = points;
            editor.putInt("scoreSP", scoreSP);
            editor.commit();
        }
        tvPoints = (TextView) findViewById(R.id.tvPoints);
        tvPersonalBest = (TextView) findViewById(R.id.tvPersonalBest);
        tvPoints.setText(""+points);
        tvPersonalBest.setText(""+scoreSP);
    }
    public void restart(View view) {
        Intent intent = new Intent(GameOver.this, StartUp.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}
