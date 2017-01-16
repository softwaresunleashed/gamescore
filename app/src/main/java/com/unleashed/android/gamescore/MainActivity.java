package com.unleashed.android.gamescore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

    PlayerScoreCard scorecard_player1;
    PlayerScoreCard scorecard_player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PlayerScoreCard scorecard_player1 = new PlayerScoreCard(this, 1);
        PlayerScoreCard scorecard_player2 = new PlayerScoreCard(this, 2);

        LinearLayout myRoot = (LinearLayout) findViewById(R.id.activity_main_root_id);

        myRoot.addView(scorecard_player1);
        myRoot.addView(scorecard_player2);


        //initHandle();
    }

//    private void initHandle() {
//        scorecard_player1 = (LinearLayout) findViewById(R.id.player1);
//        scorecard_player1.findViewById(R.id.tv_add).setOnClickListener(this);
//        scorecard_player1.findViewById(R.id.tv_sub).setOnClickListener(this);
//
//        scorecard_player2 = (LinearLayout) findViewById(R.id.player2);
//        scorecard_player2.findViewById(R.id.tv_add).setOnClickListener(this);
//        scorecard_player2.findViewById(R.id.tv_sub).setOnClickListener(this);
//
//
//    }


}
