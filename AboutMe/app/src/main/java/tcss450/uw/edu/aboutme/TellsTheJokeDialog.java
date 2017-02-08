package tcss450.uw.edu.aboutme;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by travi on 1/9/2017.
 */

public class TellsTheJokeDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //add layout
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.tells_a_joke, null));
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
