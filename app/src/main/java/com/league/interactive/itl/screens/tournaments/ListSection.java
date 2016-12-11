package com.league.interactive.itl.screens.tournaments;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.TournamentsAdapter;
import com.league.interactive.itl.models.Tournament;
import com.league.interactive.itl.utils.ViewUtils;

import java.util.List;

public class ListSection extends LinearLayout {

    private static final int MILLISECONDS_PER_DP = 2; // how many milliseconds to show/hide 1 dp
    private CustomLinearLayoutManager notScrollableManager;
    private TextView headerView;
    private TournamentsAdapter adapter;
    private RecyclerView recyclerView;

    public ListSection(Context context) {
        super(context);
        initView(context);
    }

    public ListSection(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ListSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ListSection(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_section, this, true);
        headerView = (TextView) view.findViewById(R.id.header_list);
        recyclerView = (RecyclerView) view.findViewById(R.id.accounts_recycler_view);
        headerView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showHideSection();
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        notScrollableManager = new CustomLinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(notScrollableManager);
        adapter = new TournamentsAdapter();

    }

    public boolean isShown() {
        return recyclerView.getVisibility() == VISIBLE;
    }

    public void bindData(List<Tournament> tournaments,
                         TournamentsFragment.OnListFragmentInteractionListener mListener,
                         String title) {
        adapter.setTournaments(tournaments);
        recyclerView.setAdapter(adapter);
        adapter.setmListener(mListener);
        headerView.setText(title);
    }

    public void showHideSection() {
        if (!isShown()) {
            ViewUtils.expand(recyclerView, MILLISECONDS_PER_DP);
        } else {
            ViewUtils.collapse(recyclerView, MILLISECONDS_PER_DP);
        }
    }

    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);

        }

        // it will always pass false to RecyclerView when calling "canScrollVertically()" method.
        @Override
        public boolean canScrollVertically() {
            return false;
        }
    }
}
