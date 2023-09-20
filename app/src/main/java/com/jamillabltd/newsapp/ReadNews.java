package com.jamillabltd.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class ReadNews extends AppCompatActivity {
    public static String topDes = "";
    public static String topTitle = "";
    public static Bitmap myBitmap = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_news);

        ImageView tvTopImage = findViewById(R.id.tvTopImageId);
        TextView tvTopTitle  = findViewById(R.id.tvTopTitleId);
        TextView tvTopDes  = findViewById(R.id.tvTopDesId);

        tvTopTitle.setText(topTitle);
        tvTopDes.setText(topDes);

        if (myBitmap != null) tvTopImage.setImageBitmap(myBitmap);

        //text to speech
        // Initialize the TextToSpeech engine with the Bengali locale
        TextToSpeech textToSpeech = new TextToSpeech(ReadNews.this, status -> {});

        FloatingActionButton playNews = findViewById(R.id.playNewsId);
        playNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.setSpeechRate(0.8f);
                textToSpeech.speak(topDes, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

    }
}