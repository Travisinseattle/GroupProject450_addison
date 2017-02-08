package tcss450.uw.edu.aboutme;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class DisplayImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        //Load the imageview for the animation and set it to the drawable.
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.phish_cycle);
        //Get the background which has been compiled to a AnimationDrawable
        AnimationDrawable phishAnimation = (AnimationDrawable) imageView.getBackground();
        //Start the animation
        phishAnimation.start();
    }
}
