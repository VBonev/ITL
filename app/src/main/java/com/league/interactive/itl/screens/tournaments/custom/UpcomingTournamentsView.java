package com.league.interactive.itl.screens.tournaments.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.TournamentsAdapter;
import com.league.interactive.itl.interfaces.OnListFragmentInteractionListener;
import com.league.interactive.itl.models.Tournament;

import java.util.List;

/**
 * Created by Valio on 6/13/2017.
 */

public class UpcomingTournamentsView extends FrameLayout {
    private RecyclerView recyclerView;

    public UpcomingTournamentsView(Context context) {
        super(context);
        initView(context);
    }

    public UpcomingTournamentsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public UpcomingTournamentsView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tournaments_view, this, true);
    }

    public boolean isShown() {
        return recyclerView.getVisibility() == VISIBLE;
    }

    public void bindData(List<Tournament> tournaments,
                         OnListFragmentInteractionListener mListener) {
        TournamentsAdapter adapter = new TournamentsAdapter();
        adapter.setTournaments(tournaments);
        adapter.setListener(mListener);
        recyclerView.setAdapter(adapter);
    }

}