package com.unleashed.android.gamescore;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sudhanshu on 16/01/17.
 */

public class PlayerScoreCard extends View implements View.OnClickListener {

    int mPlayerId;

    public PlayerScoreCard(Context context, int playerId) {
        super(context);

        this.mPlayerId = playerId;
    }

    @Override
    public void onClick(View v) {
        TextView ps = (TextView) v.getRootView().findViewById(R.id.tv_playerscore);
        Integer newvalue = 0;

        switch (v.getId()){
            case R.id.tv_add:
                newvalue = Integer.parseInt(ps.getText().toString()) + 1;
                break;

            case R.id.tv_sub:
                newvalue = Integer.parseInt(ps.getText().toString()) - 1;
                break;
        }

        ps.setText(String.valueOf(newvalue));

    }
}
