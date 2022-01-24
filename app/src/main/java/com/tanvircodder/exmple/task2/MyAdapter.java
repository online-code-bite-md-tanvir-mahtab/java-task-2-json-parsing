package com.tanvircodder.exmple.task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tanvircodder.exmple.task2.model.Util;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewModer>{
    private Context context;
    private List<Util> mData;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewModer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewModer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModer holder, int position) {
        Util util = mData.get(position);
        holder.mId.setText(util.getmId());
        holder.mName.setText(util.getmName());
        holder.mEmail.setText(util.getmEmail());
        holder.mGender.setText(util.getmGender());
        holder.mStatus.setText(util.getmActive());
    }

    @Override
    public int getItemCount() {
        if (mData == null) return 0;
        return mData.size();
    }
    public void swapData(List<Util> mData){
        this.mData = mData;
        if (mData != null){
            notifyDataSetChanged();
        }
    }

    class ViewModer extends RecyclerView.ViewHolder{
        private TextView mName ;
        private TextView mId;
        private TextView mEmail;
        private TextView mGender;
        private TextView mStatus;

        public ViewModer(@NonNull View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.name);
            mId = (TextView) itemView.findViewById(R.id.id);
            mEmail = (TextView) itemView.findViewById(R.id.email);
            mGender= (TextView) itemView.findViewById(R.id.gender);
            mStatus = (TextView) itemView.findViewById(R.id.status);
        }
    }
}
