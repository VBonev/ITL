package com.league.interactive.itl.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.Tournament;

import java.util.List;

/**
 * Created on 6/26/2017.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {

    private List<Tournament> tournaments;
    private OnListItemInteractionListener mListener;

    public MessagesAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tour_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Tournament tournament = tournaments.get(position);
        holder.tourName.setText(tournament.name);
        Context context = holder.mView.getContext();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(tournament);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tournaments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView tourName;

        ViewHolder(View view) {
            super(view);
            mView = view;
            tourName = (TextView) view.findViewById(R.id.tour_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tourName.getText() + "'";
        }
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
        notifyDataSetChanged();
    }

    public void setListener(OnListItemInteractionListener mListener) {
        this.mListener = mListener;
    }
}
