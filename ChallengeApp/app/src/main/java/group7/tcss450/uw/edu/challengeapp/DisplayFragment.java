package group7.tcss450.uw.edu.challengeapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    protected String user;
    protected String pw;
    protected  TextView user_textView;
    protected  TextView pw_textView;

    Bundle b = null;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_display, container, false);
        user_textView = (TextView) v.findViewById(R.id.user_textView);
        pw_textView = (TextView) v.findViewById(R.id.pw_textView);
        b = getArguments();
        user_textView.setText(b.getString("user"));
        pw_textView.setText(b.getString("pw"));
        return v;
    }
}
