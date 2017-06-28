package com.league.interactive.itl.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.models.RankPlayer;
import com.league.interactive.itl.screens.ranking.RankingFragment;

import java.util.List;

/**
 * Created on 6/27/2017.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private final List<RankPlayer> mValues;
    private final RankingFragment.OnRankListItemCLickListener mListener;

    public RankingAdapter(List<RankPlayer> items, RankingFragment.OnRankListItemCLickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ranking_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RankPlayer rankPlayer = mValues.get(position);
        holder.rankName.setText(rankPlayer.name);
        holder.rankStats.setText(rankPlayer.rank + "/"+rankPlayer.points);
        holder.rankPosition.setText(String.valueOf(rankPlayer.position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(rankPlayer);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView rankName;
        final TextView rankStats;
        final TextView rankPosition;

        ViewHolder(View view) {
            super(view);
            mView = view;
            rankName = (TextView) view.findViewById(R.id.rank_player_name);
            rankStats = (TextView) view.findViewById(R.id.rank_player_stats);
            rankPosition = (TextView) view.findViewById(R.id.rank_player_position);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + rankName.getText() + "'";
        }
    }
}
