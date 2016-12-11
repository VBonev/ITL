package com.league.interactive.itl.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class ViewUtils {

    /**
     * Expand-like animation created every time per view.
     * Duration = 1 dp per the given number of millisecond(s).
     *
     * @param viewToAnimate the given view to expand with animation
     * @param msPerDp       the speed indicator to show 1 dp per the given number of millisecond(s)
     */
    public static void expand(final View viewToAnimate,
                              final int msPerDp) {
        if (viewToAnimate.getVisibility() == View.VISIBLE) {
            return;
        }
        viewToAnimate.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = viewToAnimate.getMeasuredHeight();
        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        viewToAnimate.getLayoutParams().height = 1;
        viewToAnimate.setVisibility(View.VISIBLE);
        final Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                viewToAnimate.getLayoutParams().height = (interpolatedTime == 1)
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                viewToAnimate.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        // 1dp/given ms
        a.setDuration((int) ((targetHeight * msPerDp) / viewToAnimate.getContext().getResources().getDisplayMetrics().density));
        viewToAnimate.startAnimation(a);
    }

    /**
     * Collapse-like animation created every time per view.
     * Duration = 1 dp per the given number of millisecond(s).
     *
     * @param viewToAnimate the given view to collapse with animation
     * @param msPerDp       the speed indicator to hide 1 dp per the given number of millisecond(s)
     */
    public static void collapse(final View viewToAnimate,
                                final int msPerDp) {
        if (viewToAnimate.getVisibility() != View.VISIBLE) {
            return;
        }
        final int initialHeight = viewToAnimate.getMeasuredHeight();
        final Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    viewToAnimate.setVisibility(View.GONE);

                } else {
                    viewToAnimate.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    viewToAnimate.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        // 1dp/given ms
        animation.setDuration((int) ((initialHeight * msPerDp) / viewToAnimate.getContext().getResources().getDisplayMetrics().density));
        viewToAnimate.startAnimation(animation);
    }
}
