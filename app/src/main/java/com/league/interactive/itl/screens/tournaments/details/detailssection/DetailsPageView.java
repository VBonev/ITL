package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.league.interactive.itl.R;
import com.league.interactive.itl.customviews.ExpandableSection;

/**
 * Created on 6/22/2017.
 */

public class DetailsPageView extends LinearLayout {
    private TournamentDetailsSection tourInfoSection;
    private TournamentDetailsSection tourRulesSection;
    private WeatherView weatherView;

    public DetailsPageView(Context context) {
        super(context);
        initView(context);
    }

    public DetailsPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DetailsPageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        tourInfoSection = new TournamentDetailsSection((ExpandableSection) findViewById(R.id.tour_info));
        tourRulesSection = new TournamentDetailsSection((ExpandableSection) findViewById(R.id.tour_rules));
        weatherView = (WeatherView) findViewById(R.id.weather_forecast);
        weatherView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sinoptik.bg/sofia-bulgaria-100727011/10-days"));
                getContext().startActivity(browserIntent);
            }
        });
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tournament_details_page, this, true);
    }

    public void bindData() {
        tourInfoSection.updateData();
        tourRulesSection.updateData();
    }
}
