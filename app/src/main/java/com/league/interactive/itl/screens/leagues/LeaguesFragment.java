package com.league.interactive.itl.screens.leagues;

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
import com.league.interactive.itl.adapters.LeaguesAdapter;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.models.League;

import java.util.List;

public class LeaguesFragment extends Fragment {
    private RecyclerView leaguesList;
    private LeaguesFragment.OnLeaguListItemClickListener onLeaguListItemClickListener;

    public static LeaguesFragment newInstance() {
        return new LeaguesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leagues_fragment, container, false);
        leaguesList = view.findViewById(R.id.leagues_list);
        leaguesList.setItemAnimator(new DefaultItemAnimator());
        leaguesList.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        leaguesList.setLayoutManager(layoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(leaguesList.getContext(), 1);
        leaguesList.addItemDecoration(divider);
        bindData(DummyContent.getDummyLeagues(), onLeaguListItemClickListener);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LeaguesFragment.OnLeaguListItemClickListener) {
            onLeaguListItemClickListener = (LeaguesFragment.OnLeaguListItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void bindData(List<League> leagues,
                         LeaguesFragment.OnLeaguListItemClickListener mListener) {
        LeaguesAdapter adapter = new LeaguesAdapter(leagues, mListener);
        leaguesList.setAdapter(adapter);
    }

    public interface OnLeaguListItemClickListener {
        void onListFragmentInteraction(Object object);
    }
}
