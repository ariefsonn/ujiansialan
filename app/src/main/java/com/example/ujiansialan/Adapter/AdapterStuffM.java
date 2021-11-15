package com.example.ujiansialan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ujiansialan.Activity.DetailStuff;
import com.example.ujiansialan.Modal.f_stuff;
import com.example.ujiansialan.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterStuffM extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<f_stuff> modalStuff;
    Context context;
    View view;

    public AdapterStuffM(ArrayList<f_stuff> modalStuff, Context context) {
        this.modalStuff = modalStuff;
        this.context = context;
    }

    class MyAdapterStuffM extends RecyclerView.ViewHolder {

        private TextView title, price;
        ImageView imageView;
        CardView clickMain;

        public MyAdapterStuffM(@NonNull View itemView) {
            super(itemView);
            clickMain = itemView.findViewById(R.id.click_st);
            title = itemView.findViewById(R.id.title_st);
            price = itemView.findViewById(R.id.pr_st);
            imageView = itemView.findViewById(R.id.img_st);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false);
        return new MyAdapterStuffM(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((MyAdapterStuffM) holder).title.setText(modalStuff.get(position).getTl_st());
        ((MyAdapterStuffM) holder).price.setText(modalStuff.get(position).getPrc_st());
        Picasso.get().load(modalStuff.get(position).getImg_st()).into(((MyAdapterStuffM) holder).imageView);
        ((MyAdapterStuffM) holder).clickMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), DetailStuff.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("b_id", modalStuff.get(position).getBearer_id());
                intent.putExtra("t_st", modalStuff.get(position).getTl_st());
                intent.putExtra("pr_st", modalStuff.get(position).getPrc_st());
                intent.putExtra("img_st", modalStuff.get(position).getImg_st());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        int i = 10;
        i = modalStuff.size();
        return modalStuff.size();
    }

    public void filterList(ArrayList<f_stuff> stf){
        modalStuff = stf;
        notifyDataSetChanged();
    }
}
