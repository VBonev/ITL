package com.league.interactive.itl.screens.tournaments.details.schemesection;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.Tournament;
import com.league.interactive.itl.models.TournamentMatch;
import com.league.interactive.itl.screens.tournaments.customviews.CurrentTournamentsView;

import java.util.List;

/**
 * Created on 6/22/2017.
 */

public class DetailsKnockoutView extends CoordinatorLayout {

    private OnListItemInteractionListener mListener;
    private ViewPager mViewPager;
    private TabLayout tabs;

    public DetailsKnockoutView(Context context) {
        super(context);
        initView(context);
    }

    public DetailsKnockoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DetailsKnockoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        tabs = (TabLayout) findViewById(R.id.tabs);

    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tournament_details_knockout_page, this, true);
    }

    public void bindData(List<String> tabLabels,
                         List<List<TournamentMatch>> matches) {
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getContext(), tabLabels, matches);
        mListener = (OnListItemInteractionListener) getContext();
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabs.setupWithViewPager(mViewPager);
    }


    private class SectionsPagerAdapter extends PagerAdapter {
        private List<String> tabLabels;
        private List<List<TournamentMatch>> matches;
        private final Context context;

        SectionsPagerAdapter(Context context,
                             List<String> tabLabels,
                             List<List<TournamentMatch>> matches) {
            super();
            this.context = context;
            this.tabLabels = tabLabels;
            this.matches = matches;
        }

        @Override
        public int getCount() {
            return tabLabels.size();
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View view = new KnockOutPage(context);
            ((KnockOutPage) view).onFinishInflate();
            ((KnockOutPage) view).bindData(matches.get(position), mListener);
            collection.addView(view, 0);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabLabels.get(position);
        }
    }
}

