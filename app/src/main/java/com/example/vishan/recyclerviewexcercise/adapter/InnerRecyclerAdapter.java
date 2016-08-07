package com.example.vishan.recyclerviewexcercise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vishan.recyclerviewexcercise.R;
import com.example.vishan.recyclerviewexcercise.model.Sailboat;

import java.util.List;

/**
 * Created by vishan on 7/2/16.
 */
public class InnerRecyclerAdapter extends RecyclerView.Adapter<InnerRecyclerAdapter.MyInnerViewHolder> {

    private List<Sailboat> mData;
    private LayoutInflater mInflator;
    private static final String TAG = "TAG";

    public InnerRecyclerAdapter(Context context, List<Sailboat> data) {
        this.mData = data;
        this.mInflator = LayoutInflater.from(context);
    }

    @Override
    public MyInnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "Inner onCreateViewHolder called");

        View view = mInflator.inflate(R.layout.secondrecyclerview_item, parent, false);
        MyInnerViewHolder holder = new MyInnerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyInnerViewHolder holder, int position) {
        Log.d(TAG, "Inner onBindViewHolder called");

        Sailboat currentObj = mData.get(position);
        holder.setData(currentObj, position);
        holder.setupActionOnClick();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyInnerViewHolder extends RecyclerView.ViewHolder {

        ImageView innerImgView;
        Sailboat current;
        int position;

        public MyInnerViewHolder(View itemView) {
            super(itemView);

            innerImgView = (ImageView) itemView.findViewById(R.id.innerImg);
        }

        public void setData(Sailboat currentObj, final int position) {
            this.current = currentObj;
            this.position = position;
            innerImgView.setImageResource(currentObj.getInnerImageID());
        }

        public void setupActionOnClick() {
            innerImgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "This image's position is "+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
