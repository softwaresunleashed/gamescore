package com.unleashed.android.gamescore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout scorecard_player1;
    LinearLayout scorecard_player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHandle();
    }

    private void initHandle() {
        scorecard_player1 = (LinearLayout) findViewById(R.id.player1);
        scorecard_player1.findViewById(R.id.tv_add).setOnClickListener(this);
        scorecard_player1.findViewById(R.id.tv_sub).setOnClickListener(this);

        scorecard_player2 = (LinearLayout) findViewById(R.id.player2);
        scorecard_player2.findViewById(R.id.tv_add).setOnClickListener(this);
        scorecard_player2.findViewById(R.id.tv_sub).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_add:
                break;

            case R.id.tv_sub:

                break;
        }

    }
}
