package com.skyp.cctvofguard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private ArrayList<cctvData> tempList;
    private Context context;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private int prePosition = -1;

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleTextView;
        public LinearLayout foldLinearLayout;
        public Button redButton, checkButton;
        public cctvData data;
        private int position;
        public MainViewHolder(View v){
            super(v);
            titleTextView = v.findViewById(R.id.row_title_TextView);
            foldLinearLayout = v.findViewById(R.id.row_fold_LinearLayout);
            redButton = v.findViewById(R.id.row_Red_Button);
            checkButton = v.findViewById(R.id.row_Yellow_Button);
        }

        void onBind(cctvData data, int position){
            this.data = data;
            this.position = position;
            titleTextView.setText(data.getCctvTitle());

            changeVisibility(selectedItems.get(position));
            titleTextView.setOnClickListener(this);
            redButton.setOnClickListener(this);
            checkButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.row_title_TextView:
                    if(selectedItems.get(position)){
                        selectedItems.delete(position);
                    }else{
                        selectedItems.delete(prePosition);
                        selectedItems.put(position, true);
                    }
                    if(prePosition != -1) notifyItemChanged(prePosition);
                    notifyItemChanged(position);
                    prePosition = position;
                    break;
                case R.id.row_Red_Button:
                    Toast.makeText(context, data.getCctvTitle()+"입니다.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.row_Yellow_Button:
                    Toast.makeText(context, data.getCctvLink(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        private void changeVisibility(final boolean isExpanded){
            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, foldLinearLayout.getLayoutParams().height) : ValueAnimator.ofInt(foldLinearLayout.getLayoutParams().height,0);
            va.setDuration(600);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int value = (int) animation.getAnimatedValue();
                    foldLinearLayout.getLayoutParams().height = value;
                    foldLinearLayout.requestLayout();
                    foldLinearLayout.setVisibility(isExpanded? View.VISIBLE : View.GONE);
                }
            });
            va.start();
        }
    }

    public MainAdapter(ArrayList<cctvData> tempData) {
        tempList = tempData;
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.row_cctv_expandable, parent, false);
        MainViewHolder vh = new MainViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(tempList.get(position), position);

    }

    @Override
    public int getItemCount() {
        return (null != tempList ? tempList.size() : 0);
    }


}
