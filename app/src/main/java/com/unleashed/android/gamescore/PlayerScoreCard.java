package com.unleashed.android.gamescore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sudhanshu on 16/01/17.
 */

public class PlayerScoreCard extends View implements View.OnClickListener {

    View rootLayout;
    TextView tvAdd;
    TextView tvSub;

    public PlayerScoreCard(Context context) {
        super(context);

        rootLayout = LayoutInflater.from(context).inflate(R.layout.score_snip, null).getRootView();
        tvAdd = (TextView) rootLayout.findViewById(R.id.tv_add);
        tvSub = (TextView) rootLayout.findViewById(R.id.tv_sub);

        tvAdd.setOnClickListener(this);
        tvSub.setOnClickListener(this);

    }


    public View getRootLayout(){
        return rootLayout;
    }

    @Override
    public void onClick(View v) {
        TextView ps = (TextView) rootLayout.findViewById(R.id.tv_playerscore);
        Integer newvalue = 0;

        switch (v.getId()){
            case R.id.tv_add:
                newvalue = Integer.parseInt(ps.getText().toString()) + 1;
                break;

            case R.id.tv_sub:
                newvalue = Integer.parseInt(ps.getText().toString()) - 1;
                if(newvalue < 0)
                    newvalue = 0;
                break;
        }

        ps.setText(String.valueOf(newvalue));

    }
}
