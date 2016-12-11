package com.league.interactive.itl.screens.tournaments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.league.interactive.itl.R;
import com.league.interactive.itl.models.DummyContent;
import com.league.interactive.itl.models.Tournament;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TournamentsFragment.OnListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TournamentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TournamentsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnListFragmentInteractionListener mListener;

    private ListSection progressTour;
    private ListSection itlTour;
    private ListSection weekendTour;
    private ListSection pastTour;

    public TournamentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TournamentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TournamentsFragment newInstance(String param1, String param2) {
        TournamentsFragment fragment = new TournamentsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tournamentsView = inflater.inflate(R.layout.fragment_tournaments, container, false);
        progressTour = (ListSection) tournamentsView.findViewById(R.id.in_progress_tour);
        itlTour = (ListSection) tournamentsView.findViewById(R.id.itl_tour);
        weekendTour = (ListSection) tournamentsView.findViewById(R.id.weekend_tour);
        pastTour = (ListSection) tournamentsView.findViewById(R.id.past_tour);

        progressTour.bindData(DummyContent.getDummyProgressTournament(),mListener,"Tournaments in Progress");
        itlTour.bindData(DummyContent.getDummyITLTournament(),mListener,"ITL Sofia Tours");
        weekendTour.bindData(DummyContent.getDummyWeekendTournament(),mListener,"Weekend Tours");
        pastTour.bindData(DummyContent.getDummyPastTournament(),mListener,"Finished Tournaments");

        return tournamentsView;
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Tournament tournament);
    }
}
