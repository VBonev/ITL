package com.league.interactive.itl.screens.tournaments.details.detailssection;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.league.interactive.itl.R;

/**
 * Created by Valio on 6/25/2017.
 */

public class FeatureMatchesView extends RelativeLayout {
    private ViewPager pager;
    private PagerAdapter adapter;
    private TabLayout tabLayout;

    public FeatureMatchesView(Context context) {
        super(context);
        init(context);
    }

    public FeatureMatchesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FeatureMatchesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FeatureMatchesView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_feature_matches, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        pager = (ViewPager) findViewById(R.id.feature_matches_pager);
        adapter = new FeatureMatchesAdapter(getContext());
        pager.setAdapter(adapter);
        pager.setClipToPadding(false);
        pager.setPadding(0, 0, 60, 0);
        pager.setPageMargin(20);
        tabLayout = (TabLayout) findViewById(R.id.feature_matches_tabs);
        tabLayout.setupWithViewPager(pager, true);
    }

    private class FeatureMatchesAdapter extends PagerAdapter {

        private final Context context;

        FeatureMatchesAdapter(Context context) {
            super();
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {

            View view = new FeatureMatchPage(context);
            ((FeatureMatchPage) view).onFinishInflate();
            ((FeatureMatchPage) view).bindData();

            collection.addView(view, 0);
            return view;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }
    }
}
