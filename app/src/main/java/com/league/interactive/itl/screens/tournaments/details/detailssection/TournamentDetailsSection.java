package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.view.View;

import com.league.interactive.itl.customviews.ExpandableSection;

/**
 * Created on 6/22/2017.
 */

public class TournamentDetailsSection {
    private final View headerView;
    private final View contentView;

    public TournamentDetailsSection(ExpandableSection section) {
        headerView = section.getHeader();
        contentView = section.getContent();
    }
    public void updateData(){

    }
}
