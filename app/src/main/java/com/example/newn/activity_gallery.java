package com.example.newn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class activity_gallery extends AppCompatActivity {
    RecyclerView recyclerViewg;
    ArrayList<image> imageArrayList;
    DatabaseReference databaseReference;
    MyAdapterg MyAdapterg;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        recyclerViewg = findViewById(R.id.recycleviewg);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewg.setLayoutManager(linearLayoutManager);
        recyclerViewg.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        imageArrayList = new ArrayList<>();

        ClearAll();

        GetDataFromFirebase();


    }

    private void GetDataFromFirebase() {
        Query query =   databaseReference.child("image");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();

                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    image image = new image();
                    image.setImage(snapshot1.child("image").getValue().toString());
                    imageArrayList.add(image);
                }
                MyAdapterg = new MyAdapterg(getApplicationContext() , imageArrayList);
                recyclerViewg.setAdapter(MyAdapterg);
                MyAdapterg.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void ClearAll(){
        if (imageArrayList != null){
            imageArrayList.clear();

            if(MyAdapterg != null){
                MyAdapterg.notifyDataSetChanged();
            }

        }
        imageArrayList = new ArrayList<>();
    }

}