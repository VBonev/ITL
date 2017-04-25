package com.league.interactive.pt;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.pt.models.DummyContent.RankPlayer;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link RankPlayer} and makes a call to the
 * specified {@link RankingsFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRankingsRecyclerViewAdapter extends RecyclerView.Adapter<MyRankingsRecyclerViewAdapter.ViewHolder> {

    private final List<RankPlayer> mValues;
    private final RankingsFragment.OnListFragmentInteractionListener mListener;

    public MyRankingsRecyclerViewAdapter(List<RankPlayer> items, RankingsFragment.OnListFragmentInteractionListener listener) {
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
