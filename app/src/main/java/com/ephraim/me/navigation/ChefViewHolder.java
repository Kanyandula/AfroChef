package com.ephraim.me.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChefViewHolder extends RecyclerView.ViewHolder  {

    View cView;
    public ChefViewHolder(View itemView) {
        super(itemView);
        cView=itemView;
    }

    public void setImageName (String name){
        TextView textView_name = (TextView)cView.findViewById(R.id.image_name);
        textView_name.setText(name);
    }
    public void  setImageUrl (Context context, String image)
    {
        ImageView imageView = (ImageView)cView.findViewById(R.id.image3);
        Picasso.with(context).load(image)
                .into(imageView);
    }
}
