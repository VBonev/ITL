package com.league.interactive.itl.screens.tournaments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.screens.tournaments.customviews.CurrentTournamentsView;
import com.league.interactive.itl.screens.tournaments.customviews.PastTournamentsView;
import com.league.interactive.itl.screens.tournaments.customviews.UpcomingTournamentsView;


public class TournamentsFragment extends Fragment {
    private OnListItemInteractionListener mListener;

    public static TournamentsFragment newInstance() {
        return new TournamentsFragment();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tournaments_overview_layout, container, false);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getContext());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListItemInteractionListener) {
            mListener = (OnListItemInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private class SectionsPagerAdapter extends PagerAdapter {

        private final Context context;
        private int childCount = 3;

        SectionsPagerAdapter(Context context) {
            super();
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View view = null;
            switch (position) {
                case 0:
                    view = new CurrentTournamentsView(context);
                    ((CurrentTournamentsView) view).onFinishInflate();
                    ((CurrentTournamentsView) view).bindData(DummyContent.getDummyProgressTournament(), mListener);
                    break;
                case 1:
                    view = new UpcomingTournamentsView(context);
                    ((UpcomingTournamentsView) view).onFinishInflate();
                    ((UpcomingTournamentsView) view).bindData(DummyContent.getDummyITLTournament(), mListener);
                    break;
                case 2:
                    view = new PastTournamentsView(context);
                    ((PastTournamentsView) view).onFinishInflate();
                    ((PastTournamentsView) view).bindData(DummyContent.getDummyPastTournament(), mListener);
                    break;
            }

            collection.addView(view, position);
            return view;
        }

        /**
         * Change the child count of the pager - currently removing last page (Phone contacts).
         * In case a more generic implementation is needed in future, rework the logic.
         *
         * @param childCount - the new child count (with one child less)
         */
        public void setChildCount(int childCount) {
            this.childCount = childCount;
        }

        @Override
        public int getCount() {
            return childCount;
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
            switch (position) {
                case 0:
                    return "In Progress";
                case 1:
                    return "Upcoming";
                case 2:
                    return "Past";
            }
            return null;
        }
    }

}
