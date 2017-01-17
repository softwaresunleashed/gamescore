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


        LinearLayout myRoot = (LinearLayout) findViewById(R.id.activity_main_root_id);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //myRoot.setLayoutParams(lp);

        PlayerScoreCard scorecard_player1 = new PlayerScoreCard(this);
        PlayerScoreCard scorecard_player2 = new PlayerScoreCard(this);

        myRoot.addView(scorecard_player1);
        myRoot.addView(scorecard_player2);


    }

}
