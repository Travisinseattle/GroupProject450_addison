package group7.tcss450.uw.edu.challengeapp;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static group7.tcss450.uw.edu.challengeapp.MainActivity.PARTIAL_URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment implements  View.OnClickListener {

    private MainFragment.OnFragmentInteractionListener mListener;
    private Context mContext;

    EditText user;
    EditText pw;

    public LogInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /// Inflate the layout for this fragmentView
        View v = inflater.inflate(R.layout.fragment_log_in, container, false);
        Button b = (Button) v.findViewById(R.id.display_login_results_button);
        user = (EditText) v.findViewById(R.id.log_in_editText);
        pw = (EditText) v.findViewById(R.id.pw_editText);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

        if (context instanceof MainFragment.OnFragmentInteractionListener) {
            mListener = (MainFragment.OnFragmentInteractionListener) context;
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

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            switch (view.getId()) {
                case R.id.display_login_results_button:
                    if (user.getText().toString().trim().length() <= 0) {
                        user.setError(getString(R.string.user_error));
                    } else if (pw.getText().toString().trim().length() <= 0) {
                        pw.setError(getString(R.string.pw_error));
                    } else {
                        AsyncTask<String, Void, String> task = null;
                        task = new PostWebServiceTask(mContext);
                        String url = PARTIAL_URL +
                                getString(R.string._insert) +
                                user.getText().toString().trim() +
                                getString(R.string.and_pw) +
                                pw.getText().toString().trim() + "'";
                        task.execute(url, "Create User");
                        task = new GetWebServiceTask(mContext, mListener);
                        url = PARTIAL_URL +
                                getString(R.string._get) +
                                user.getText().toString().trim() +
                                getString(R.string.and_pw) +
                                pw.getText().toString().trim() + "'";
                        task.execute(url, "Retrieve User");
                    }
                    break;
            }
        }

    }
}
