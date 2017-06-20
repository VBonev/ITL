package com.league.interactive.itl.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListFragmentInteractionListener;
import com.league.interactive.itl.models.Tournament;
import com.league.interactive.itl.screens.tournament.LeaguesFragment;
import com.league.interactive.itl.screens.tournaments.ToursFragment;

import java.util.List;

/**
 * Created by Valio on 12/2/2016.
 */

public class TournamentsAdapter extends RecyclerView.Adapter<TournamentsAdapter.ViewHolder> {

    private List<Tournament> tournaments;
    private OnListFragmentInteractionListener mListener;

    public TournamentsAdapter() {

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
//        holder.tourDate.setText(tournament.date);
//        holder.tourLocation.setText(tournament.location);
        Context context = holder.mView.getContext();
//        holder.mView.setBackgroundColor(tournament.registered ? ContextCompat.getColor(context, R.color.registeredTournament) :
//                ContextCompat.getColor(context, R.color.unregisteredTournament));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
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
//        final TextView tourLocation;
//        final TextView tourDate;

        ViewHolder(View view) {
            super(view);
            mView = view;
            tourName = (TextView) view.findViewById(R.id.tour_name);
//            tourLocation = (TextView) view.findViewById(R.id.tour_location);
//            tourDate = (TextView) view.findViewById(R.id.tour_date);
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

    public void setListener(OnListFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }
}
