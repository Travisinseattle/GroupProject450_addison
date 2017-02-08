package group7.tcss450.uw.edu.widgetslab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button b = (Button) findViewById(R.id.dynamic_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = getString(R.string.dynamic_toast_text);
                Toast.makeText(ButtonActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void MakeStaticToast(View veiw) {
        StaticToast();
    }

    private void StaticToast() {
        Context context = getApplicationContext();
        CharSequence text = context.getString(R.string.static_toast_text);
        Toast.makeText(ButtonActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
