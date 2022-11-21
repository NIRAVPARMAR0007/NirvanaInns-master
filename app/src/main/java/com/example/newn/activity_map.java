package com.example.newn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Button btn_map1, btn_map2;
        btn_map1 = findViewById(R.id.btn_map1);
        btn_map2 = findViewById(R.id.btn_map2);
        btn_map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_map.this, map_sardhar.class));
            }
        });
        btn_map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_map.this, maptosardhar.class));
            }
        });
    }
}