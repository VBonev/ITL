package com.league.interactive.itl.screens.tournaments.details.schemesection;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.MatchesAdapter;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.TournamentMatch;

import java.util.List;

public class KnockOutPage extends FrameLayout {
    private RecyclerView recyclerView;

    public KnockOutPage(Context context) {
        super(context);
        initView(context);
    }

    public KnockOutPage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public KnockOutPage(Context context, @Nullable AttributeSet attrs, int defStyle) {
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

    public void bindData(List<TournamentMatch> matches,
                         OnListItemInteractionListener mListener) {
        MatchesAdapter adapter = new MatchesAdapter();
        adapter.setMatches(matches);
        adapter.setListener(mListener);
        recyclerView.setAdapter(adapter);
    }

}
