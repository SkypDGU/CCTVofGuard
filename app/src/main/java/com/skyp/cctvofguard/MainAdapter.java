package com.skyp.cctvofguard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private ArrayList<String> tempList;

    public class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTextView;

        public MainViewHolder(View v){
            super(v);
            titleTextView = v.findViewById(R.id.row_title_TextView);
        }
    }

    public MainAdapter(ArrayList<String> tempData) {
        tempList = tempData;
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cctv_expandable, parent, false);
        MainViewHolder vh = new MainViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.titleTextView.setText(tempList.get(position));

    }

    @Override
    public int getItemCount() {
        return (null != tempList ? tempList.size() : 0);
    }


}
