package com.league.interactive.itl.screens.tournaments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListFragmentInteractionListener;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.screens.tournaments.custom.CurrentTournamentsView;
import com.league.interactive.itl.screens.tournaments.custom.PastTournamentsView;
import com.league.interactive.itl.screens.tournaments.custom.UpcomingTournamentsView;


public class ToursFragment extends Fragment {
    private OnListFragmentInteractionListener mListener;

    public static ToursFragment newInstance() {
        return new ToursFragment();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_view, container, false);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getContext(), new PagerDrawingListener() {
            @Override
            public void onFinishedInstantiation() {

            }
        });

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
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private class SectionsPagerAdapter extends PagerAdapter {


        private final Context context;
        private int childCount = 3;
        private PagerDrawingListener pagerDrawingListener;

        SectionsPagerAdapter(Context context, PagerDrawingListener pagerDrawingListener) {
            super();
            this.context = context;
            this.pagerDrawingListener = pagerDrawingListener;
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
//            if (position == getCount() - 1) {
//                notifyDataSetChanged();
//                pagerDrawingListener.onFinishedInstantiation();
//            }
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

    /**
     * Listener to notify the view when the adapter is done with inflating items
     */
    interface PagerDrawingListener {
        void onFinishedInstantiation();
    }
}
