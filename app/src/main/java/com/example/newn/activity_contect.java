package com.example.newn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_contect extends AppCompatActivity {
    Button btnInsert,btnView;
    EditText name, mail, age;
    DatabaseReference databaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect);
        //initializing all above
        btnInsert = findViewById(R.id.btninsert);
        btnView = findViewById(R.id.btnview);
        name = findViewById(R.id.edtname);
        mail = findViewById(R.id.edtmail);
        age = findViewById(R.id.edtage);
        databaseUser = FirebaseDatabase.getInstance().getReference();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insertdata();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_contect.this,Userlist.class));
                finish();
            }
        });




    }

    private void Insertdata() {
        String username = name.getText().toString();
        String usermail = mail.getText().toString();
        String userage = age.getText().toString();
        String id = databaseUser.push().getKey();

        User user  = new User(username, usermail, userage);
        databaseUser.child("user").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_contect.this, "USER DATA INSERTED", Toast.LENGTH_SHORT).show();
                        }
                    }
                });





    }
}