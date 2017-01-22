package com.unleashed.android.gamescore;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.xenione.digit.TabDigit;

import info.hoang8f.widget.FButton;

/**
 * Created by sudhanshu on 16/01/17.
 */

public class PlayerScoreCard extends View implements View.OnClickListener {

    View rootLayout;
    FButton tvAdd;
    FButton tvSub;
    EditText playerName;

    TabDigit score_zeros;
    TabDigit score_ones;

    int currentValue;

    private TextToSpeech tts;

    OnScoreUpdate scoreUpdateListener;
    public interface OnScoreUpdate{
      void onScoreUpdate();
    };

    public void setScoreUpdateListener(OnScoreUpdate scoreUpdateListener){
        this.scoreUpdateListener = scoreUpdateListener;
    }

    public PlayerScoreCard(Context context) {
        super(context);

        rootLayout = LayoutInflater.from(context).inflate(R.layout.score_snip, null).getRootView();
        tvAdd = (FButton) rootLayout.findViewById(R.id.tv_add);
        tvSub = (FButton) rootLayout.findViewById(R.id.tv_sub);
        playerName = (EditText) rootLayout.findViewById(R.id.et_playername);

        tvAdd.setOnClickListener(this);
        tvSub.setOnClickListener(this);

        score_zeros = (TabDigit) rootLayout.findViewById(R.id.tabDigit_zeros);
        score_ones = (TabDigit) rootLayout.findViewById(R.id.tabDigit_ones);

        score_zeros.setChar(0);
        score_ones.setChar(0);

        currentValue = 0;
    }


    public View getRootLayout(){
        return rootLayout;
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.tv_add:
                currentValue++;
                break;

            case R.id.tv_sub:
                currentValue--;
                if(currentValue < 0)
                    currentValue = 0;
                break;
        }

        updatePlayerScoreCard(currentValue);

    }

    private void updatePlayerScoreCard(int currentValue) {

        score_zeros.setChar(currentValue % 10);
        score_ones.setChar(currentValue / 10);

        if(scoreUpdateListener != null){
            scoreUpdateListener.onScoreUpdate();
        }

        // Add Animation library
        YoYo.with(Techniques.Wobble).duration(700).playOn(score_zeros);
        YoYo.with(Techniques.Wobble).duration(700).playOn(score_ones);
    }

    public String getCurrentScore(){
        return String.valueOf(currentValue);
    }

    public String getPlayerName(){
        return playerName.getText().toString();
    }


}
