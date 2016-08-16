package com.example.hwhong.tsaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView right, left;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        right = (ImageView) findViewById(R.id.right);
        left = (ImageView) findViewById(R.id.left);
        button = (Button) findViewById(R.id.button);

        final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);

        left.setAnimation(fadeOut);
        right.setAnimation(fadeOut);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                left.setVisibility(View.GONE);
                right.setVisibility(View.GONE);

                button.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int i = random.nextInt(2);
                button.setVisibility(View.GONE);

                if(i == 0) {
                    left.setVisibility(View.VISIBLE);
                    left.setAnimation(fadeOut);
                } else {
                    right.setVisibility(View.VISIBLE);
                    right .setAnimation(fadeOut);
                }
            }
        });
    }
}
