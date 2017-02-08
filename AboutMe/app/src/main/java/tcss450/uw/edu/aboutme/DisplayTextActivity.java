package tcss450.uw.edu.aboutme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayTextActivity extends AppCompatActivity {

    final String message = new String("Name:  Travis Holloway\n\n\nAge:  38\n\n\n" +
            "Major:  Computer Science\n\n\nGraduation Date:  June 14, 2017\n\n\n" +
            "Employment Status:  Student\n\n\nHobbies:  Bass Guitar, Woodworking" +
            ", Gaming\n\n\nEmail:  thollow@uw.edu");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        TextView myTextView = (TextView) findViewById(R.id.displayText);
        myTextView.setText(message);
    }
}
