package com.example.vishan.recyclerviewexcercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vishan.recyclerviewexcercise.adapter.RecyclerAdapter;
import com.example.vishan.recyclerviewexcercise.model.Landscape;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView   = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter     = new RecyclerAdapter(this, Landscape.getData());

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this);
        linearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManagerVertical);

        // This is the default behaviour. Even if this line is not added, DefaultItemAnimator() instance will be called by default.
        // Therefore this line is not really necessary.
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
