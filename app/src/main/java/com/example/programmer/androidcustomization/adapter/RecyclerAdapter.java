package com.example.programmer.androidcustomization.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.programmer.androidcustomization.R;
import com.example.programmer.androidcustomization.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Programmer on 07-12-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Contact> list= new ArrayList<>();

    public RecyclerAdapter(List<Contact> list)
    {
        this.list = list;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.id.setText(Integer.toString(list.get(position).getId()));
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView id,name;

        public MyViewHolder(View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.tv_first);
            id = (TextView)itemView.findViewById(R.id.name);

        }
    }

}
