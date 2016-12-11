package com.league.interactive.itl.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.models.RankPlayer;

import java.util.List;

/**
 * Created by Valio on 12/4/2016.
 */

public class SchemeAdapter extends RecyclerView.Adapter<SchemeAdapter.ViewHolder> {

    private final List<RankPlayer> mValues;
    private final RankingsFragment.OnListFragmentInteractionListener mListener;

    public SchemeAdapter(List<RankPlayer> items, RankingsFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public SchemeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ranking_item, parent, false);
        return new SchemeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SchemeAdapter.ViewHolder holder, int position) {
        final RankPlayer rankPlayer = mValues.get(position);
        holder.rankPosition.setText(String.valueOf(rankPlayer.position));
        holder.rankName.setText(rankPlayer.name);
        holder.rankTown.setText(rankPlayer.town);
        holder.rankITN.setText(String.valueOf(rankPlayer.rank));
        holder.rankPoints.setText(String.valueOf(rankPlayer.points));

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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView rankPosition;
        public final TextView rankName;
        public final TextView rankTown;
        public final TextView rankITN;
        public final TextView rankPoints;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            rankPosition = (TextView) view.findViewById(R.id.rank_position);
            rankName = (TextView) view.findViewById(R.id.rank_name);
            rankTown = (TextView) view.findViewById(R.id.rank_town);
            rankITN = (TextView) view.findViewById(R.id.rank_itn);
            rankPoints = (TextView) view.findViewById(R.id.rank_points);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + rankName.getText() + "'";
        }
    }
}
