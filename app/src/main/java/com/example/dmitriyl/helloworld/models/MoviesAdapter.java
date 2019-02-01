package com.example.dmitriyl.helloworld.models;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmitriyl.helloworld.InfoActivity;
import com.example.dmitriyl.helloworld.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {


    RecyclerViewClickListener recyclerViewClickListener = new RecyclerViewClickListener() {
        @Override
        public void onClick(View view, int position) {
            Saloon saloon = moviesList.get(position);
            Intent info = new Intent(view.getContext(), InfoActivity.class);
            info.putExtra("id", Integer.parseInt(saloon.getId()));

            context.startActivity(info);

        }
    };

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }





    private Context context;

    private List<Saloon> moviesList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, type, checkRating, pictureUrl;
        ImageView imageView;

        public MyViewHolder(View view, Context mContext) {
            super(view);
//            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            type = (TextView) view.findViewById(R.id.type);
//            checkRating = (TextView) view.findViewById(R.id.checkRating);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickListener.onClick(view,getAdapterPosition());
                }
            });
//            pictureUrl = (TextView) view.findViewById(R.id.pictureUrl);
        }

    }


    public MoviesAdapter(List<Saloon> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Saloon movie = moviesList.get(position);
//        holder.id.setText(movie.getId());
        holder.name.setText(movie.getName());
        holder.type.setText(movie.getType());
//        holder.checkRating.setText(movie.getCheckRating());
        if(movie.getPictureUrl() !=null && ! movie.getPictureUrl().isEmpty()){
            Picasso.with(holder.imageView.getContext())
                    .load("http://zp.jgroup.kz" + movie.getPictureUrl())
                    // To fit image into imageView
                    .fit()
                    // To prevent fade animation
                    .noFade()
                    .into(holder.imageView);
        }else{
            holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(),R.drawable.ic_access_time_white_24dp));
        }

//        Picasso.with().load(movie.getPictureUrl()).into(holder.imageView);

//        holder.pictureUrl.setText(movie.getPictureUrl());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

}