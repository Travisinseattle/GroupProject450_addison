package group7.tcss450.uw.edu.challengeapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {
    protected String mUser;
    protected String mPw;

    public static final String PARTIAL_URL =
            "http://cssgate.insttech.washington.edu/~thollow/test";

    public TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.fragmentContainer) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new MainFragment())
                        .commit();
            }
        }
    }

    @Override
    public void OnFragmentListener(String user, String pw) {
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString("user", user);
        args.putString("pw", pw);
        displayFragment.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, displayFragment)
                    .addToBackStack(null);
            transaction.commit();
    }
}

