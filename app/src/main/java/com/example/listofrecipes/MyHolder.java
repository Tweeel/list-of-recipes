package com.example.listofrecipes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView mIneaView;
    TextView mTitle,mDes;
    ItemClickListener itemClickListener;

    MyHolder(@NonNull View itemView) {
        super(itemView);
        this.mIneaView = itemView.findViewById(R.id.imageTv);
        this.mTitle = itemView.findViewById(R.id.titleTv);
        this.mDes = itemView.findViewById(R.id.descriptionTv);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListiner(view,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
