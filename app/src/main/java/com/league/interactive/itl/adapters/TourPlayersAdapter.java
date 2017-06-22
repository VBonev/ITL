package com.league.interactive.itl.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.RankPlayer;

import java.util.List;

/**
 * Created on 6/22/2017.
 */

public class TourPlayersAdapter extends RecyclerView.Adapter<TourPlayersAdapter.ViewHolder> {

    private final List<RankPlayer> mValues;
    private final OnListItemInteractionListener mListener;

    public TourPlayersAdapter(List<RankPlayer> items, OnListItemInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public TourPlayersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ranking_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RankPlayer rankPlayer = mValues.get(position);
//        holder.rankName.setText(rankPlayer.name);
        holder.rankITN.setText(String.valueOf(rankPlayer.rank));

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
        final TextView rankITN;

        ViewHolder(View view) {
            super(view);
            mView = view;
            rankName = (TextView) view.findViewById(R.id.rank_name);
            rankITN = (TextView) view.findViewById(R.id.rank_itn);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + rankName.getText() + "'";
        }
    }
}
