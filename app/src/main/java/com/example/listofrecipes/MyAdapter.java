package com.example.listofrecipes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
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

        return viewHolder; //this will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myholder, int i) {

        myholder.mTitle.setText(models.get(i).getTitle()); //here i is position
        myholder.mDes.setText(models.get(i).getDescription());
        myholder.mIneaView.setImageResource(models.get(i).getImg()); //here we used image resource because we will use images in our resource folder
        //resource folder which is drawable

        MyHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListiner(View v, int position) {
                String gTitle = models.get(position).getTitle();
                String gDesc = models.get(position).getDescription(); //these object get our data from previous activity
                BitmapDrawable bitmapDrawable = (BitmapDrawable)myholder.mIneaView.getDrawable(); // this will get our image from drawable

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream(); //image will get stream and bytes

                bitmap.compress(Bitmap.CompressFormat.PNG, 100,stream); //it will compress our image

                byte[] bytes = stream.toByteArray();

                //get our data with intent
                Intent intent = new Intent(c,AnotherActivity.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iDesc",gDesc); //get data and put it in intent
                intent.putExtra("iImage",bytes);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        if(models!=null) return models.size();
        else return 0;
    }
}
