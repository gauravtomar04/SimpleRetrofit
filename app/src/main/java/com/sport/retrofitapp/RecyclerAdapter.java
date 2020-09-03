package com.sport.retrofitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PostViewHolder> {

    Context context;
    List<Item> list;

    public RecyclerAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public PostViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row,parent,false);
        return new PostViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Item item=list.get(position);
        holder.title.setText(item.getTitle());

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
         TextView title;
         TextView description;
         ImageView image;
        public PostViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description= itemView.findViewById(R.id.description);
            image= itemView.findViewById(R.id.image);
        }
    }
}
