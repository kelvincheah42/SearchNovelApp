package com.searchbook.kelvincheah.searchnovelapp.item;

import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.searchbook.kelvincheah.searchnovelapp.R;

/**
 * Created by ASUS on 1/3/2017.
 */
// ViewHolder for xml
public class SetViewHolder extends RecyclerView.ViewHolder {
   public TextView txt_NAME;
    public TextView txt_AUTHOR;
    public TextView txt_DESCRPITION;
    public ImageView txt_COVER;
    public SetViewHolder(View itemView) {
        super(itemView);
        txt_NAME=(TextView) itemView.findViewById(R.id.text_word);
        txt_AUTHOR=(TextView) itemView.findViewById(R.id.txt_author);
        txt_DESCRPITION=(TextView) itemView.findViewById(R.id.txt_description);
        txt_COVER=(ImageView) itemView.findViewById(R.id.cover);
    }
}
