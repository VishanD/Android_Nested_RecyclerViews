package com.example.vishan.recyclerviewexcercise.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishan.recyclerviewexcercise.R;
import com.example.vishan.recyclerviewexcercise.model.Landscape;
import com.example.vishan.recyclerviewexcercise.model.Sailboat;


import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by vishan on 7/2/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Landscape> mData;
    private LayoutInflater mInflator;
    private static final String TAG = "TAG";
    private Context context;

    public RecyclerAdapter(Context context, List<Landscape> data) {
        this.mData = data;
        this.context = context;
        this.mInflator = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder called");

        View view = mInflator.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder called on position "+position);

        Landscape currentObj = mData.get(position);
        holder.setData(currentObj, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        //TextView title;
        //TextView description;
        ImageView imgThumb;
        int position;
        Landscape current;
        RecyclerView innerRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            //title             = (TextView) itemView.findViewById(R.id.txvTitle);
            //description       = (TextView) itemView.findViewById(R.id.txvDescription);
            imgThumb            = (ImageView) itemView.findViewById(R.id.imgRow);
            innerRecyclerView   = (RecyclerView) itemView.findViewById(R.id.innerRecyclerView);
        }

        public void setData(Landscape currentObj, final int position) {
            //title.setText(currentObj.getTitle());
            //description.setText(currentObj.getDescription());
            imgThumb.setImageResource(currentObj.getImageID());
            this.position = position;
            this.current = currentObj;

            InnerRecyclerAdapter innerAdapter = new InnerRecyclerAdapter(context, Sailboat.getData());
            innerRecyclerView.setAdapter(innerAdapter);

            LinearLayoutManager linearLayoutManagerHorizontal = new LinearLayoutManager(context);
            linearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);

            innerRecyclerView.setLayoutManager(linearLayoutManagerHorizontal);
        }
    }
}
