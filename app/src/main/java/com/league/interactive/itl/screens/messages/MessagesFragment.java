package com.league.interactive.itl.screens.messages;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.adapters.MessagesAdapter;
import com.league.interactive.itl.adapters.TournamentsAdapter;
import com.league.interactive.itl.interfaces.OnListItemInteractionListener;
import com.league.interactive.itl.models.DummyContent;

/**
 * Created on 6/26/2017.
 */

public class MessagesFragment extends Fragment {
    private FloatingActionButton writeMessage;
    private OnListItemInteractionListener mListener;
    private RecyclerView recyclerView;

    public static MessagesFragment newInstance() {
        return new MessagesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messages_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        writeMessage= (FloatingActionButton) view.findViewById(R.id.message_button);
        MessagesAdapter adapter = new MessagesAdapter();
        adapter.setMessages(DummyContent.getDummyMessages());
        adapter.setListener(mListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
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
