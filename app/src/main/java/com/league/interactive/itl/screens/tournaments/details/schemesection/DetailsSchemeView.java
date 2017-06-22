package com.league.interactive.itl.screens.tournaments.details.schemesection;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.league.interactive.itl.R;

/**
 * Created on 6/22/2017.
 */

public class DetailsSchemeView extends CoordinatorLayout {
    public DetailsSchemeView(Context context) {
        super(context);
        initView(context);
    }

    public DetailsSchemeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DetailsSchemeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tournament_details_scheme_page, this, true);
    }

    public void bindData() {
    }
}
