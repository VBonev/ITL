package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.league.interactive.itl.R;

/**
 * Created by Valio on 6/25/2017.
 */

public class FeatureMatchPage extends RelativeLayout {
    public FeatureMatchPage(Context context) {
        super(context);
        init(context);
    }

    public FeatureMatchPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FeatureMatchPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FeatureMatchPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.feature_match_page, this, true);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void bindData() {
    }
}
