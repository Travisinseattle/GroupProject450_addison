package group7.tcss450.uw.edu.fragmentslab;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlowerFragment extends Fragment {

    public static final String COLOR = "key";


    public FlowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flower, container, false);
    }

    public void updateContent(int color) {
        GradientDrawable bg;
        bg = (GradientDrawable) getActivity().findViewById(R.id.shapeTopLeft).getBackground();
        bg.setColor(color);
        bg = (GradientDrawable) getActivity().findViewById(R.id.shapeTopRight).getBackground();
        bg.setColor(color);
        bg = (GradientDrawable) getActivity().findViewById(R.id.shapeBottomLeft).getBackground();
        bg.setColor(color);
        bg = (GradientDrawable) getActivity().findViewById(R.id.shapeBottomRight).getBackground();
        bg.setColor(color);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            int color = getArguments().getInt(COLOR);
            updateContent(color);
        }
    }

}
