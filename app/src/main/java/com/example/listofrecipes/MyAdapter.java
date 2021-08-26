package com.example.listofrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        MyHolder viewHolder = new MyHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myholder, int i) {

        myholder.mTitle.setText(models.get(i).getTitle());
        myholder.mDes.setText(models.get(i).getDescription());
        myholder.mIneaView.setImageResource(models.get(i).getImg());
    }

    @Override
    public int getItemCount() {

        if(models!=null) return models.size();
        else return 0;
    }
}
