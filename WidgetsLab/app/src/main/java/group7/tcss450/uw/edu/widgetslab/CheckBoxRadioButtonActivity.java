package group7.tcss450.uw.edu.widgetslab;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxRadioButtonActivity extends AppCompatActivity {

    private List<String> strings = new ArrayList<String>();
    private StringBuilder checkText = new StringBuilder();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_radio_button);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GradientDrawable bg = (GradientDrawable) findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill, null));
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable) findViewById(R.id.radioGroup).getBackground();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes, null));
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no, null));
                break;
        }
    }

    public void onCheckButtonClicked(View view) {
        checkButton(view);
    }

    public void MakeSelectToast(View veiw) {
        SelectToast();
    }

    private void SelectToast() {
        Context context = getApplicationContext();
        checkText = new StringBuilder(getString(R.string.sb_message));
        if (strings.size() < 1) {
            checkText.append(" Nothing.");
        } else {
            for(String temp: strings) {
                checkText.append(" ");
                checkText.append(temp);
            }
            checkText.append(".");
        }

        CharSequence text = checkText.toString();
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private void checkButton(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBoxCheese:
                if (checked) {
                    strings.add(getString(R.string.check_cheese));
                } else {
                    if (strings.contains(getString(R.string.check_cheese))) {
                        strings.remove(strings.indexOf(getString(R.string.check_cheese)));
                    }
                }
                    break;
            case R.id.checkBoxMeat:
                if (checked) {
                    strings.add(getString(R.string.check_meat));
                } else {
                    if (strings.contains(getString(R.string.check_meat))) {
                        strings.remove(strings.indexOf(getString(R.string.check_meat)));
                    }
                }
                break;
            case R.id.checkBoxSauce:
                if (checked) {
                    strings.add(getString(R.string.check_sauce));
                } else {
                    if (strings.contains(getString(R.string.check_sauce))) {
                        strings.remove(strings.indexOf(getString(R.string.check_sauce)));
                    }
                }
                break;
            case R.id.checkBoxVegtables:
                if (checked) {
                    strings.add(getString(R.string.check_vegtables));
                } else {
                    if (strings.contains(getString(R.string.check_vegtables))) {
                        strings.remove(strings.indexOf(getString(R.string.check_vegtables)));
                    }
                }
                break;
        }
    }
}
