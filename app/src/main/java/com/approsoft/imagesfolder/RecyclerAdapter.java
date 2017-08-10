package com.approsoft.imagesfolder;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Approsoft on 6/22/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter {
    ArrayList<SingleImage> imagesList = new ArrayList<>();
    Context context;

    public RecyclerAdapter(Context context, ArrayList<SingleImage> imagesList){
        this.context = context;
        this.imagesList = imagesList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.single_image, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SingleImage image = imagesList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
//        Glide.with(context).asBitmap().load(image.getImagePath()).into(myViewHolder.imageView);
        myViewHolder.imageView.setImageURI(Uri.parse(image.getImagePath()));
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
