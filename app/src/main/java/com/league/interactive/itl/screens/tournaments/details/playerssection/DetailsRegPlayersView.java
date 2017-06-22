package com.league.interactive.itl.screens.tournaments.details.playerssection;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.TourPlayersAdapter;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.RankPlayer;

import java.util.List;

/**
 * Created on 6/22/2017.
 */

public class DetailsRegPlayersView extends CoordinatorLayout {
    private RecyclerView playersList;

    public DetailsRegPlayersView(Context context) {
        super(context);
        initView(context);
    }

    public DetailsRegPlayersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DetailsRegPlayersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        playersList = (RecyclerView) findViewById(R.id.recycler_view);
        playersList.setItemAnimator(new DefaultItemAnimator());
        playersList.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        playersList.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(playersList.getContext(),1);
        playersList.addItemDecoration(divider);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tournament_details_reg_players_page, this, true);
    }

    public void bindData(List<RankPlayer> tournaments,
                         OnListItemInteractionListener mListener) {
        TourPlayersAdapter adapter = new TourPlayersAdapter(tournaments, mListener);
        playersList.setAdapter(adapter);
    }
}
