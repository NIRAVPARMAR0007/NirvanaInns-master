package com.example.newn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class confirm_book extends AppCompatActivity {
    Button btnbookingreqconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_book);

        btnbookingreqconfirm = findViewById(R.id.buttonbacktohome);
        btnbookingreqconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(confirm_book.this, MainActivity.class));
            }
        });
    }
}