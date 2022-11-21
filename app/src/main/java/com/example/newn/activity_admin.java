package com.example.newn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_admin extends AppCompatActivity {
    EditText edtuser,edtpass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        edtuser=(EditText)findViewById(R.id.edtuser);
        edtpass=(EditText)findViewById(R.id.edtpass);
        btnLogin=(Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(edtuser.getText().toString().equals("admin") &&
                        edtpass.getText().toString().equals("12345")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(activity_admin.this,activity_contect.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}