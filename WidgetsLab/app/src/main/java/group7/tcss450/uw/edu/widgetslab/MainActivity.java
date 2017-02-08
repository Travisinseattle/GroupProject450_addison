package group7.tcss450.uw.edu.widgetslab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.duration;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(i);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        //obtain acess to the ListView object defined in XML
        final ListView listview = (ListView) findViewById(R.id.listView);

        //Obtain access to the String array defined in xml
        String[] labels = getResources().getStringArray(R.array.list_view_labels);

        //create and array of intents
        Intent[] intents = new Intent[] {
                new Intent(this, ButtonActivity.class),
                new Intent(this, TextViewActivity.class),
                new Intent(this, EditTextActivity.class),
                new Intent(this, AutoCompleteTextActivity.class),
                new Intent(this, SpinnerActivity.class),
                new Intent(this, CheckBoxRadioButtonActivity.class)
        };

        //create and populate a map linking the labels to the intents
        final Map<String, Intent> map = new HashMap<String, Intent>();
        for(int i = 0; i< labels.length; ++i) {
            map.put(labels[i], intents[i]);
        }

        //add an Adapter to the ListView
        listview.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, labels));

        //define what happens when an element in the ListView is clicked
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Log.d("MAIN_ACTIVITY", item);
                startActivity(map.get(item));
            }
        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void MakeStaticToast(View veiw) {
        StaticToast();
    }

    private void StaticToast() {
        Context context = getApplicationContext();
        CharSequence text = context.getString(R.string.static_toast_text);
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
