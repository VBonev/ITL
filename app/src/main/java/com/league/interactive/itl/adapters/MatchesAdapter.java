package com.league.interactive.itl.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.TournamentMatch;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    private List<TournamentMatch> matches;
    private OnListItemInteractionListener mListener;

    public MatchesAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TournamentMatch match = matches.get(position);
        holder.playerOne.setText(match.getPlayerOne());
        holder.playerTwo.setText(match.getPlayerTwo());
        String[] results = match.getResults().split(":");
        if (match.getMatchStatus().equals(TournamentMatch.UPCOMING_STATUS)) {
            holder.statusPendingMatch.setVisibility(View.VISIBLE);
        } else if (match.getMatchStatus().equals(TournamentMatch.IN_PROGRESS_STATUS)) {
            holder.statusUpcomingMatch.setVisibility(View.VISIBLE);
        } else {
            holder.statusFinishedMatch.setVisibility(View.VISIBLE);
            holder.setOne.setText(results[0]);
            holder.setTwo.setText(results[1]);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(match);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView playerOne, playerTwo;
        final TextView setOne, setTwo;
        final FrameLayout statusPendingMatch, statusUpcomingMatch;
        final LinearLayout statusFinishedMatch;

        ViewHolder(View view) {
            super(view);
            mView = view;
            playerOne = (TextView) view.findViewById(R.id.match_player_one);
            playerTwo = (TextView) view.findViewById(R.id.match_player_two);
            setOne = (TextView) view.findViewById(R.id.set_one);
            setTwo = (TextView) view.findViewById(R.id.set_two);
            statusFinishedMatch = (LinearLayout) view.findViewById(R.id.status_finished_match);
            statusPendingMatch = (FrameLayout) view.findViewById(R.id.status_pending_match);
            statusUpcomingMatch = (FrameLayout) view.findViewById(R.id.status_in_progress_match);
        }
    }

    public void setMatches(List<TournamentMatch> matches) {
        this.matches = matches;
        notifyDataSetChanged();
    }

    public void setListener(OnListItemInteractionListener mListener) {
        this.mListener = mListener;
    }
}
