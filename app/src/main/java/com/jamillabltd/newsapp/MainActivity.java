package com.jamillabltd.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        createList();

    }


    //TODO ====== Create adapter ===============
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("MissingInflatedId")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.list_item, parent, false);

            hashMap = arrayList.get(position);

            ImageView tvImage = myView.findViewById(R.id.tvImage);
            TextView tvTitle = myView.findViewById(R.id.tvTitle);
            TextView tvDes = myView.findViewById(R.id.tvDes);
            TextView tvType = myView.findViewById(R.id.tvType);

            String getTvImage = hashMap.get("img_url");
            String getTvTitle = hashMap.get("title");
            String getTvDes = hashMap.get("des");
            String getTvType = hashMap.get("type");

            //set the image
            Picasso.get().load(getTvImage)
                    .placeholder(R.drawable.loading)
                    .into(tvImage);

            //set title, des and type
            tvTitle.setText(getTvTitle);
            tvDes.setText(getTvDes);
            tvType.setText(getTvType);

            //type bg random color
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            tvType.setBackgroundColor(color);

            //onclick to go another activity
            LinearLayout itemArea = myView.findViewById(R.id.itemAreaId);
            itemArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ReadNews.topTitle = getTvTitle;
                    ReadNews.topDes = getTvDes;

                    Bitmap bitmap = ((BitmapDrawable) tvImage.getDrawable()).getBitmap();
                    ReadNews.myBitmap = bitmap;

                    startActivity(new Intent(MainActivity.this, ReadNews.class));
                }
            });

            return myView;
        }
    }
    //================== end ===================

    private void createList() {

        //==== 1st Item =========
        hashMap = new HashMap<>();
        hashMap.put("type", "Job News");
        hashMap.put("img_url", "https://d2u0ktu8omkpf6.cloudfront.net/6f3a5fbb4ab1960299ad60a5381527199cc62e8b6a0ea701.jpg");
        hashMap.put("title", "ActionAid Bangladesh Job Circular");
        hashMap.put("des", "As on the official job notice, ActionAid Bangladesh Job Circular 2023 has been published on 14 September 2023. A total of (Not Specific) people will be hired for the 01 job post through this ActionAid Bangladesh Job Circular. The job application method is online. The ActionAid job application last date is 27 September 2023.");
        arrayList.add(hashMap);

        //==== 2nd Item =========
        hashMap = new HashMap<>();
        hashMap.put("type", "Apps");
        hashMap.put("img_url", "https://assets.ennomotive.com/wp-content/uploads/2015/04/20092948/apps-creativity-innovation.jpg");
        hashMap.put("title", "এই ৩৭ অ্যাপ আপনার ফোনে আছে কি");
        hashMap.put("des", "ক্ষতিকর ৩৭টি অ্যাপ সরিয়ে ফেলেছে টেক জায়ান্ট গুগল। এসব অ্যাপকে বলা হয় কপিক্যাটজ (CopyCatz) অ্যাপ। এগুলো ফোনে ঢুকে ভয়ংকর ক্ষতি করতে পারে। তাই গুগল প্লে স্টোর থেকে সরিয়ে নিয়েছে। গুগল সরালেও ফোনে আছে কি না, তা দেখে নিতে হবে। থাকলে দ্রুত মুছে ফেলা বা ডিলিট করে ফেলতে হবে অ্যাপগুলো।\n" +
                "গ্যাজেটস নাউয়ের খবরে বলা হয়েছে, এ অ্যাপগুলোর মূলত মোবাইল ব্যবহারকারীদের স্মার্টফোনের খুব প্রয়োজনীয় কিছু অ্যাপের প্রতিলিপি তৈরি করে ফেলে। যখনই ব্যবহারকারী (উইজার) জরুরি অ্যাপগুলো খোলেন, তখন সেই ভুয়া অ্যাপগুলো ইউজারদের অপ্রত্যাশিত কিছু বিজ্ঞাপন দেখাতে শুরু করে। যে বিজ্ঞাপনগুলো দেখানো হয়, সেগুলো আসলে ম্যালওয়্যার দ্বারা প্রভাবিত। আর অনেকে কৌতূহলবশত বিজ্ঞাপনে ক্লিক করার সঙ্গে সঙ্গে গ্রাহকদের ফোনে ঢুকে যেতে পারে ম্যালওয়্যার। ক্ষতি হয় ব্যবহারকারীর। মোবাইলের অনেক ক্ষতি করে চলেছে ওই ৩৭ অ্যাপ। তাই এগুলো সরিয়ে ফেলেছে গুগল। ব্যবহারকারীদের অ্যাপগুলো সরিয়ে ফেলার অনুরোধ জানিয়েছে গুগল। কিছুদিন আগেই ১৬৪টি অ্যাপস প্লে স্টোর থেকে সরিয়েছে গুগল। এসব অ্যাপ প্রায় ১০ কোটিরও বেশি ডাউনলোড হয়েছিল। এই ১৬৪টি অ্যাপের বিরুদ্ধ অভিযোগ ছিল অপ্রত্যাশিত কিছু বিজ্ঞাপন দেখানো।\n" +
                "\n");
        arrayList.add(hashMap);


    }


}