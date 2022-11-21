package com.example.newn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
   ImageButton btn;
   ImageButton btn1;
   ImageButton btn2;
   ImageButton btn3;
   ImageButton btn4;
   ImageButton btn5;
   ImageButton btn6;
   ImageButton btn7;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.home);
        btn1 = findViewById(R.id.gallery);
        btn2 = findViewById(R.id.slideshow);
        btn3 = findViewById(R.id.admin);
        btn4 = findViewById(R.id.map);
        btn5 = findViewById(R.id.view);
        btn6 = findViewById(R.id.time);
        btn7 = findViewById(R.id.contect);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Userlist.class));
            }
        });
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_gallery.class));
           }
       });
       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_Slideshow.class));
           }
       });
       btn3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_admin.class));
           }
       });
       btn4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_map.class));
           }
       });
       btn5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_view.class));
           }
       });
       btn6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, activity_time.class));
           }
       });
       btn7.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, contact.class));
           }
       });
    }
}