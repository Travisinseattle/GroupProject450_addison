package group7.tcss450.uw.edu.widgetslab;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private HashMap<String, Integer> colorMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        String[] colorNames = getResources().getStringArray(R.array.auto_complete_colors);
        int[] colorValues = getResources().getIntArray(R.array.colors);

        colorMap = new HashMap<>();
        for(int i = 0; i < colorNames.length; i++) {
            colorMap.put(colorNames[i], colorValues[i]);
        }


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.auto_complete_colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) findViewById(R.id.funny_shape);
        String color = (String) parent.getAdapter().getItem(position);
        ((GradientDrawable)textView.getBackground()).setColor(colorMap.get(color));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}