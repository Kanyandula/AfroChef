package com.ephraim.me.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    View mView;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        mView=itemView;
    }


    public void setImageName (String tittle){
        TextView textView_name = (TextView)mView.findViewById(R.id.title);
        textView_name.setText(tittle);
    }
    public void  setImageUrl (Context context, String image)
    {
        ImageView imageView = (ImageView)mView.findViewById(R.id.image);
        Picasso.with(context).load(image)
                .into(imageView);
    }

    @Override
    public void onClick(View v) {


    }



}