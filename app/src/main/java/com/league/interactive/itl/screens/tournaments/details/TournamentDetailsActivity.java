package com.league.interactive.itl.screens.tournaments.details;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.models.Tournament;
import com.league.interactive.itl.screens.tournaments.details.detailssection.DetailsPageView;
import com.league.interactive.itl.screens.tournaments.details.playerssection.DetailsRegPlayersView;
import com.league.interactive.itl.screens.tournaments.details.schemesection.DetailsSchemeView;

public class TournamentDetailsActivity extends AppCompatActivity {
    private OnListItemInteractionListener mListener=new OnListItemInteractionListener() {
        @Override
        public void onListFragmentInteraction(Object object) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tournaments_details_overview_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_details);
        setSupportActionBar(toolbar);
        // Set up the ViewPager with the sections adapter.
        Bundle extras = getIntent().getExtras();
        String tourName;
        if (!TextUtils.isEmpty(extras.getString(Tournament.TOURNAMENT_NAME))) {
            tourName = extras.getString(Tournament.TOURNAMENT_NAME);
        } else {
            tourName = "Tournament Details";
        }
        toolbar.setTitle(tourName);
        toolbar.setNavigationIcon(R.drawable.ic_navbar_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(this);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);

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
                    view = new DetailsPageView(context);
                    ((DetailsPageView) view).onFinishInflate();
                    ((DetailsPageView) view).bindData();
                    break;
                case 1:
                    view = new DetailsRegPlayersView(context);
                    ((DetailsRegPlayersView) view).onFinishInflate();
                    ((DetailsRegPlayersView) view).bindData(DummyContent.getDummyRankItems(), mListener);
                    break;
                case 2:
                    view = new DetailsSchemeView(context);
                    ((DetailsSchemeView) view).onFinishInflate();
                    ((DetailsSchemeView) view).bindData();
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
                    return "Details";
                case 1:
                    return "Reg. Players";
                case 2:
                    return "Scheme";
            }
            return null;
        }
    }

}
