package com.searchbook.kelvincheah.searchnovelapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.searchbook.kelvincheah.searchnovelapp.OntapListener;
import com.searchbook.kelvincheah.searchnovelapp.R;
import com.searchbook.kelvincheah.searchnovelapp.item.Item;
import com.searchbook.kelvincheah.searchnovelapp.item.SetViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by ASUS on 1/3/2017.
 */

public class NovelAdapter extends RecyclerView.Adapter<SetViewHolder> {

    private Activity activity;
    List<Item> items= Collections.emptyList();
    private OntapListener OntapListener;
    private ArrayList<Item> arraylist;
    int[]image;
    public  NovelAdapter(Activity activity, List<Item> items,int imgs[]){
        this.activity = activity;
        this.image=imgs;
        this.items = items;
        this.arraylist = new ArrayList<Item>();
        this.arraylist.addAll(items);
    }
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_book,parent,false);

        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SetViewHolder holder, final int position) {


           holder.txt_NAME.setText(items.get(position).getBOOK_NAME());
           holder.txt_AUTHOR.setText(items.get(position).getAUTHOR());
           holder.txt_DESCRPITION.setText(items.get(position).getDESCRIPTION());
        holder.txt_COVER.setImageResource(image[position]);
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                 if(OntapListener !=null ){
                     OntapListener.OnTapView(position);
                 }
               }
           });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOntapListener(OntapListener ontapListener){
        this.OntapListener=ontapListener;
    }
// filter edittext in search
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
       items.clear();
        if (charText.length() == 0) {
            items.addAll(arraylist);
        } else {
            for (Item wp : arraylist) {
                if (wp.getBOOK_NAME().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    items.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
