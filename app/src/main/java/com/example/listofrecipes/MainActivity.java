package com.example.listofrecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter=new MyAdapter(this,getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models= new ArrayList<>();

        Model m = new Model();
        m.setTitle("Crepe");
        m.setDescription("this is the crepe description");
        m.setImg(R.drawable.crepe);
        models.add(m);

        m = new Model();
        m.setTitle("Cheesecake");
        m.setDescription("this is the cheesecake description");
        m.setImg(R.drawable.cheesecake);
        models.add(m);

        m = new Model();
        m.setTitle("Panecake");
        m.setDescription("this is the panecake description");
        m.setImg(R.drawable.panecake);
        models.add(m);

        m = new Model();
        m.setTitle("Donuts");
        m.setDescription("this isthe description of the donuts");
        m.setImg(R.drawable.donuts);
        models.add(m);

        return models;
    }
}