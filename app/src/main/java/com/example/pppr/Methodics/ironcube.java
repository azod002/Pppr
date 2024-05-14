package com.example.pppr.Methodics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.pppr.R;

public class ironcube extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ironcube);

        String savedtext = getIntent().getStringExtra("savedText");

        int minValue = 0;
        int maxValue = 7;
        int a = minValue + (int) (Math.random() * (maxValue - minValue + 1));
        String[] arr = new String[10];
        arr = new String[]{"Мне кажется — «да»", "Никаких сомнений", "Очень сомнительно", "Сконцентрируйся и спроси опять", "Сейчас нельзя предсказать", "Да", "Можешь быть уверен в этом", "По моим данным — «нет»"};

        TextView view1 = findViewById(R.id.punchline);
        TextView view2 = findViewById(R.id.view2);
        ImageView back = findViewById(R.id.backButton);
        ImageView gifImageView = findViewById(R.id.gifImageView);





        Glide.with(this)
                .asGif()
                .load("file:///android_asset/2INg.gif")
                .listener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.setLoopCount(1);

                        return false;
                    }
                })
                .into(gifImageView);

        view1.setText(arr[a]);
        view2.setText(savedtext);
        //Typeface typeface = Typeface.createFromAsset(getAssets(), "font/rosemary.ttf");

        //view1.setTypeface(typeface);
        //view2.setTypeface(typeface);



        int gifDuration = 3500; // Продолжительность GIF в миллисекундах, подберите значение самостоятельно
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                newvisib(view1);
            }
        }, gifDuration);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.page_turn_out_reverse, R.anim.page_turn_in_reverse);
            }
        });



    }
    private void newvisib(TextView view1) {
        view1.setVisibility(view1.VISIBLE);
    }
}