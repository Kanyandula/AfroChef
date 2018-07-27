package com.ephraim.me.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MarketViewHolder extends RecyclerView.ViewHolder  {
    View mView;

    public MarketViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
    }

    public void setImageName (String tittle){
       TextView textView_name = (TextView)mView.findViewById(R.id.title1);
        textView_name.setText(tittle);
    }
    public void  setImageUrl (Context context, String image)
    {
        ImageView imageView = (ImageView)mView.findViewById(R.id.image1);
        Picasso.with(context).load(image)
                .into(imageView);
    }
}
