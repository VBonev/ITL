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

public class PastTournamentsView extends FrameLayout {
    private RecyclerView recyclerView;

    public PastTournamentsView(Context context) {
        super(context);
        initView(context);
    }

    public PastTournamentsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PastTournamentsView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        CustomLinearLayoutManager notScrollableManager = new CustomLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(notScrollableManager);
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