package com.example.newn;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class form extends AppCompatActivity {
    public Button btn_book, btn_browse;
    public EditText edit_name, edit_address, edit_uid, edit_pan, edit_birthdate, edit_date, edit_email;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage mStorage;
    ImageButton imagebtn;
    ProgressDialog progressDialog;
    private static final int Gallery_Code=1;
    Uri imageUrl=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        // initializing all our variables.
        btn_book = findViewById(R.id.btn_book);
        edit_name = findViewById(R.id.edit_name);
        edit_address =findViewById(R.id.edit_address);
        edit_uid = findViewById(R.id.edit_uid);
        edit_pan = findViewById(R.id.edit_pan);
        edit_birthdate = findViewById(R.id.edit_birthdate);
        edit_email = findViewById(R.id.edit_email);
        edit_date = findViewById(R.id.edit_date);
        imagebtn = findViewById(R.id.imagebtn);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("request");
        mStorage = FirebaseStorage.getInstance();
        progressDialog = new ProgressDialog(this);




        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,Gallery_Code);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == Gallery_Code && resultCode == RESULT_OK)

        {
            imageUrl = data.getData();
            imagebtn.setImageURI(imageUrl);
        }

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edit_name.getText().toString().trim();
                String address = edit_address.getText().toString().trim();
                String uid = edit_uid.getText().toString().trim();
                String pan = edit_pan.getText().toString().trim();
                String birthdate = edit_birthdate.getText().toString().trim();
                String email = edit_email.getText().toString().trim();
                String date = edit_date.getText().toString().trim();

                if (allFieldsChecked())

                {
                    progressDialog.setTitle("Uploding...");
                    progressDialog.show();

                    StorageReference filepath = mStorage.getReference().child("imagePost").child(imageUrl.getLastPathSegment());
                    filepath.putFile(imageUrl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {

                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {

                                    String image = task.getResult().toString();
                                    DatabaseReference newPost = databaseReference.push();

                                    newPost.child("name").setValue(name);
                                    newPost.child("address").setValue(address);
                                    newPost.child("uid").setValue(uid);
                                    newPost.child("pan").setValue(pan);
                                    newPost.child("birthdate").setValue(birthdate);
                                    newPost.child("email").setValue(email);
                                    newPost.child("date").setValue(date);
                                    newPost.child("image").setValue(task.getResult().toString());
                                    progressDialog.dismiss();
                                    startActivity(new Intent(form.this, confirm_book.class));

                                }

                            });

                        }
                    });
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Allfiled is needed this form",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private boolean allFieldsChecked() {
        if(edit_name.length() == 0){
            Toast.makeText(form.this, "Enter Name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edit_address.length() == 0){
            Toast.makeText(form.this, "Enter Address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edit_uid.length() == 0){
            Toast.makeText(form.this, "Enter UID", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edit_birthdate.length() == 0){
            Toast.makeText(form.this, "Enter BirthDate", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edit_email.length() == 0){
            Toast.makeText(form.this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(edit_date.length() == 0){
            Toast.makeText(form.this, "Enter Date", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}