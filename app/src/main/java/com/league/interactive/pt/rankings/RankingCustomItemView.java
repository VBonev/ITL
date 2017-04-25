package com.league.interactive.itl.rankings;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RankingCustomItemView extends LinearLayout{
    public RankingCustomItemView(Context context) {
        super(context);
    }

    public RankingCustomItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RankingCustomItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RankingCustomItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
