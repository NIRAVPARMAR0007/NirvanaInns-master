package com.example.newn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList <User> list;
    static RecyclerViewListener listener;
        public MyAdapter(Context context, ArrayList<User> list, RecyclerViewListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.name.setText(user.getName());
        holder.mail.setText(user.getEmail());
        holder.age.setText(user.getAge());
        holder.user = user;

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface RecyclerViewListener{
            void onClick(View v, int postion);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name,age,mail;
        Button btn_roombook;
        int position;
        User user;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            mail = itemView.findViewById(R.id.textmail);
            age = itemView.findViewById(R.id.textage);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
