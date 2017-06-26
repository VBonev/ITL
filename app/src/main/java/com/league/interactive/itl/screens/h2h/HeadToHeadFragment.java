package com.league.interactive.itl.screens.h2h;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;

/**
 * Created by Valio on 6/27/2017.
 */

public class HeadToHeadFragment extends Fragment {
    private OnListItemInteractionListener mListener;
    public static HeadToHeadFragment newInstance() {
        return new HeadToHeadFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.head_to_head_view, container, false);
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
}
