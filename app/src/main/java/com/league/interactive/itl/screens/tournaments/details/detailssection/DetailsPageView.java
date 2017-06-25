package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.league.interactive.itl.R;
import com.league.interactive.itl.customviews.ExpandableSection;

/**
 * Created on 6/22/2017.
 */

public class DetailsPageView extends LinearLayout {
    private FloatingActionButton addResultButton;
    private TournamentDetailsSection tourInfoSection;
    private TournamentDetailsSection tourRulesSection;

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
        addResultButton = (FloatingActionButton) findViewById(R.id.add_result_button);
        addResultButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(DetailsPageView.this, "Add Result", Snackbar.LENGTH_LONG).show();
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
