package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.league.interactive.itl.R;

public class WeatherView extends LinearLayout {
    public WeatherView(Context context) {
        super(context);
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.weather_view, this, true);
    }
}
