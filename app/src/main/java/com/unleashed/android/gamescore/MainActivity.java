package com.unleashed.android.gamescore;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, PlayerScoreCard.OnScoreUpdate {

    PlayerScoreCard scorecard_player1;
    PlayerScoreCard scorecard_player2;

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout myRoot = (LinearLayout) findViewById(R.id.activity_main_root_id);


        scorecard_player1 = new PlayerScoreCard(this);
        scorecard_player2 = new PlayerScoreCard(this);

        myRoot.addView(scorecard_player1.getRootLayout());
        myRoot.addView(scorecard_player2.getRootLayout());

        scorecard_player1.setScoreUpdateListener(this);
        scorecard_player2.setScoreUpdateListener(this);


        tts = new TextToSpeech(this, this);

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
//                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @Override
    public void onScoreUpdate() {
        speakOut();
    }

    private void speakOut() {
        String text = "Score is : " +  scorecard_player1.getPlayerName() + scorecard_player1.getCurrentScore()
                + "-" + scorecard_player2.getPlayerName() + scorecard_player2.getCurrentScore();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
