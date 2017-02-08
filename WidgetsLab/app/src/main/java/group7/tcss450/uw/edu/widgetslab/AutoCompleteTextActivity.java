package group7.tcss450.uw.edu.widgetslab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);

        final String[] COLORS = getResources().getStringArray(R.array.auto_complete_colors);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line,
                        COLORS);
        AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.AutoCompleteTextView);
        text.setAdapter(adapter);
    }
}
