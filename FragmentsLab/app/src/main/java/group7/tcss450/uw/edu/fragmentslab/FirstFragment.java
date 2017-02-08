package group7.tcss450.uw.edu.fragmentslab;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentView
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Button b = (Button) v.findViewById(R.id.redButton);
        b.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.greenButton);
        b.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.blueButton);
        b.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.purpleButton);
        b.setOnClickListener(this);
        b = (Button) v.findViewById(R.id.goldButton);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            switch (view.getId()) {
                case R.id.redButton:
                    mListener.onFragmentInteraction(Color.RED);
                    break;
                case R.id.greenButton:
                    mListener.onFragmentInteraction(Color.GREEN);
                    break;
                case R.id.blueButton:
                    mListener.onFragmentInteraction(Color.BLUE);
                    break;
                case R.id.purpleButton:
                    mListener.onFragmentInteraction(Color.rgb(51, 0, 111));
                    break;
                case R.id.goldButton:
                    mListener.onFragmentInteraction(Color.rgb(232, 211, 262));
                    break;
            }
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int color);
    }
}
