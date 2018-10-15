package com.league.interactive.itl.adapters;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.league.interactive.itl.R;
import com.league.interactive.itl.models.League;
import com.league.interactive.itl.screens.leagues.LeaguesFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.ViewHolder> {

    private final List<League> mValues;
    private final LeaguesFragment.OnLeaguListItemClickListener mListener;

    public LeaguesAdapter(List<League> items, LeaguesFragment.OnLeaguListItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public LeaguesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_item, parent, false);
        return new LeaguesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeaguesAdapter.ViewHolder holder, int position) {
        final League league = mValues.get(position);
//        holder.leagueTitle.setText(league.getTitle());
//        holder.leagueSubtitle.setText(league.getSubtitle());
        ImageView cover = holder.mView;
        int coverRes = R.drawable.itl_cover;
        if (position == 0) {
            coverRes = R.drawable.itl_cover;
        } else if (position == 1) {
            coverRes = R.drawable.week_cover;
        } else if (position == 2) {
            coverRes = R.drawable.dema_cover;
        } else if (position == 3) {
            coverRes = R.drawable.diana_cover;
        } else if (position == 4) {
            coverRes = R.drawable.ntl_cover;
        } else if (position == 5) {
            coverRes = R.drawable.vambos_cover;
        } else if (position == 6) {
            coverRes = R.drawable.dema_cover;
        } else if (position == 7) {
            coverRes = R.drawable.diana_cover;
        } else if (position == 8) {
            coverRes = R.drawable.ntl_cover;
        } else if (position == 9) {
            coverRes = R.drawable.itl_cover;
        }
        Picasso.with(cover.getContext()).load(coverRes).fit().fit().into(cover);
        cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(league);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView mView;
//        final TextView leagueTitle;
//        final TextView leagueSubtitle;

        ViewHolder(View view) {
            super(view);
            mView = (ImageView) view;
//            leagueTitle = view.findViewById(R.id.league_title);
//            leagueSubtitle = view.findViewById(R.id.league_subtitle);
        }
    }
}
