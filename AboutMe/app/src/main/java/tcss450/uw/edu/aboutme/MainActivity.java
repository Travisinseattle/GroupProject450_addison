package tcss450.uw.edu.aboutme;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Integer to be used to access array of toast Strings used in sendToastMessage().
    private int i = 10;

    //Declare some custom dialogs.
    final StartsAJokeDialogFragment startFrag = new StartsAJokeDialogFragment();
    final TellsTheJokeDialog tellFrag = new TellsTheJokeDialog();
    final FinishTheJokeDialog finishFrag = new FinishTheJokeDialog();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button textButton = (Button) findViewById(R.id.textButton);
        final Button imageButton = (Button) findViewById(R.id.imageButton);
        final Button webButton = (Button) findViewById(R.id.webButton);
        final Button toastButton = (Button) findViewById(R.id.toastButton);
        final Button dialogButton = (Button) findViewById(R.id.dialogButton);
    }

    /** Called when the user clicks the Text button */
    public void sendTextMessage(View view) {
        Intent intent = new Intent(this, DisplayTextActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the image button */
    public void sendImageMessage(View view) {
        Intent intent = new Intent(this, DisplayImageActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the web button */
    public void sendWebMessage(View view) {
        goToUrl("http://developer.android.com/index.html");
    }

    /** Called when the user clicks the toast button */
    public void sendToastMessage(View view) {
        Random rand = new Random();
        Context context = getApplicationContext();
        String[] greetings = context.getResources().getStringArray(R.array.greetings);
        CharSequence text = context.getString(R.string.toastMessage);
        int duration = Toast.LENGTH_SHORT;
        /*First time, run an initial message to indicate that user should try clicking
         the button more than once*/
        if(i > 6) {
            Toast.makeText(context, text, duration).show();
            //set i to 0 so it will enter else statement
            i = 0;
        } else {
            //generate a random value between 0 and 5
            i  = rand.nextInt(6 - 0 +1) + 0;
            //Set text to be the index of greetings that corresponds to i.
            text = greetings[i];
            Toast.makeText(context, text, duration).show();
        }
    }

    /** Called when the user clicks the dialog button */
    public void sendDialogMessage(View view) {
        startJoke();
    }

    /** Called when the user clicks the Sure! button */
    public void continueJokeMessage(View view) {
        continueJoke();
    }

    /** Called when the user clicks the Nope! button */
    public void fireToastMesage(View view) {
        fireToast();
    }

    public void finiahJokeMessage(View view) {
        finishJoke();
    }

    //A private method to open a browser to a specific website.
    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    //Creates a toast and then opens a TellsAJokeDialog
    public void fireToast(){
        Context context = getApplicationContext();
        CharSequence text = context.getString(R.string.toBad);
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        continueJoke();
    }

    /**method to open a StartsAJokeDialogw.*/
    public void startJoke(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        startFrag.show(ft, "dialog");
    }

    //A method to close the StartsAJokeDialog and opens the TellsTheJokeDialog
    public void continueJoke() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tellFrag.show(ft, "dialog");
        startFrag.dismiss();
    }

    //A method to close the TellsAJokeDialog and opens the FinishTheJokeDialog
    public void finishJoke(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        finishFrag.show(ft, "dialog");
        tellFrag.dismiss();
    }

    //A method to dismish the FinishTheJokeDialog.
    public void dismissListener(final View view) {
        if(finishFrag != null) {
            finishFrag.dismiss();
        }
    }
}
