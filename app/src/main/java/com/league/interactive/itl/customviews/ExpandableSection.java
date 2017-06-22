package com.league.interactive.itl.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.league.interactive.itl.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 6/22/2017.
 */

public class ExpandableSection extends RelativeLayout implements Observer {
    private final View header;
    private final ViewStub contentStub;
    private View content;
    private final View delimiter;
    private ExpandNotifier expandNotifier;

    public ExpandableSection(Context context) {
        this(context, null);
    }

    public ExpandableSection(Context context, AttributeSet attrs) {
        this(context, attrs, R.styleable.ExpandableSection_ExpandableSectionStyle);
    }

    public ExpandableSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ExpandableSection, defStyleAttr, 0);

        final int headerId = a.getResourceId(R.styleable.ExpandableSection_inflateId_header, NO_ID);
        final int contentId = a.getResourceId(R.styleable.ExpandableSection_inflateId_content, NO_ID);
        final int indicatorId = android.R.id.icon;
        final int delimiterId = android.R.id.widget_frame;

        final int headerLayout = a.getResourceId(R.styleable.ExpandableSection_layout_header, 0);
        final int contentLayout = a.getResourceId(R.styleable.ExpandableSection_layout_content, 0);
        final boolean supportElevation = a.getBoolean(R.styleable.ExpandableSection_support_elevation, false);
        int headerBackground = a.getResourceId(R.styleable.ExpandableSection_header_background, android.R.color.transparent);
        this.setBackgroundResource(headerBackground);

        int marginRight = context.getResources().getDimensionPixelSize(R.dimen.padding_small);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_TOP, headerId);
        params.addRule(RelativeLayout.ALIGN_BOTTOM, headerId);
        params.addRule(RelativeLayout.ABOVE, contentId);
        params.setMargins(0, 0, marginRight, 0);
        // Indicator
        final ImageView indicator = new ImageView(context);
        indicator.setImageResource(R.drawable.arrow);
        indicator.setScaleType(ImageView.ScaleType.CENTER);
        indicator.setId(indicatorId);
        indicator.setVisibility(GONE);
        addView(indicator, params);

        // Header
        if (headerLayout != 0) {
            header = LayoutInflater.from(context).inflate(headerLayout, null, false);
        } else {
            header = new ViewStub(context); // Use ViewStub as a default header since it's cheap enough.
        }
        if (headerId != NO_ID) {
            header.setId(headerId);
        }

        header.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse();
            }
        });

        params = new LayoutParams(LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.LEFT_OF, indicatorId);
        addView(header, params);

        // Content
        contentStub = new ViewStub(context);
        if (contentLayout != 0) {
            contentStub.setLayoutResource(contentLayout);
        }
        if (contentId != NO_ID) {
            contentStub.setInflatedId(contentId);
        }
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, delimiterId);
        addView(contentStub, params);

        // Delimiter
        delimiter = new View(context);
        delimiter.setId(delimiterId);
        delimiter.setVisibility(GONE);
        params = new LayoutParams(LayoutParams.MATCH_PARENT, 2);
        params.addRule(RelativeLayout.BELOW, headerId);
        addView(delimiter, params);

        // Elevation
        if (supportElevation) {
            final View elevation = new View(context);
            elevation.setBackgroundResource(R.drawable.elevation_shadow);
            params = new LayoutParams(LayoutParams.MATCH_PARENT, 5);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, NO_ID);
            addView(elevation, params);
        }

        a.recycle();
    }

    public View getHeader() {
        return header;
    }

    public View getContent() {
        int id = contentStub.getInflatedId();
        if (id == NO_ID) {
            throw new IllegalStateException("Cannot reference a content without an " +
                    "appointed resource id!");
        }

        if (content == null && contentStub.getLayoutResource() != 0) {
            content = contentStub.inflate();
            content.setVisibility(GONE);
        }

        return content;
    }

    /**
     * Check and handle expand state
     */
    private void expandOrCollapse() {
        if (content == null || content.getVisibility() != VISIBLE) {
            expand();
        } else {
            collapse();
        }
    }

    private StateChangedListener stateChangedListener;

    public void setOnStateChangedListener(final StateChangedListener stateChangedListener) {
        this.stateChangedListener = stateChangedListener;
    }

    public interface StateChangedListener {
        void onCollapsed();

        void onExpanded();
    }

    private void expand() {
        if (content == null) {
            content = contentStub.inflate();
        }
        if (content.getVisibility() != VISIBLE) {
            content.setVisibility(VISIBLE);
            delimiter.setVisibility(VISIBLE);
            setHeaderViewsActive(true);
            if (expandNotifier != null) {
                expandNotifier.notifyObservers(this);
            }
            if (stateChangedListener != null) {
                stateChangedListener.onExpanded();
            }
        }
    }

    public void collapse() {
        if (content.getVisibility() != GONE) {
            setHeaderViewsActive(false);
            content.setVisibility(GONE);
            delimiter.setVisibility(GONE);

            if (stateChangedListener != null) {
                stateChangedListener.onCollapsed();
            }
        }
    }

    private void setHeaderViewsActive(boolean isActive) {
        ViewGroup viewGroup = (ViewGroup) header;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            child.setActivated(isActive);
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        if (data != this) {
            collapse();
        }
    }

    public void setExpandNotifier(ExpandNotifier expandNotifier) {
        this.expandNotifier = expandNotifier;
        this.expandNotifier.addObserver(this);
    }

    public static class ExpandNotifier extends Observable {
        @Override
        public void notifyObservers(Object data) {
            setChanged();
            super.notifyObservers(data);
        }
    }
}
