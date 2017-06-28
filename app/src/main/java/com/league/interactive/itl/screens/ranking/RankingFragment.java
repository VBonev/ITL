package com.league.interactive.itl.screens.ranking;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.RankingAdapter;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.models.RankPlayer;

import java.util.List;

/**
 * Created on 6/27/2017.
 */

public class RankingFragment extends Fragment {
    private RecyclerView playersList;
    private OnRankListItemCLickListener onRankListItemCLickListener;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ranking_view, container, false);
        playersList = (RecyclerView) view.findViewById(R.id.rank_players_list);
        playersList.setItemAnimator(new DefaultItemAnimator());
        playersList.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        playersList.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(playersList.getContext(), 1);
        playersList.addItemDecoration(divider);
        bindData(DummyContent.getDummyRankItems(), onRankListItemCLickListener);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRankListItemCLickListener) {
            onRankListItemCLickListener = (OnRankListItemCLickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void bindData(List<RankPlayer> rankPlayers,
                         OnRankListItemCLickListener mListener) {
        RankingAdapter adapter = new RankingAdapter(rankPlayers, mListener);
        playersList.setAdapter(adapter);
    }

    public interface OnRankListItemCLickListener {
        void onListFragmentInteraction(Object object);
    }
}
