package com.searchbook.kelvincheah.searchnovelapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    TextView txtauthor;
    TextView txtnovel;
    TextView txtdescription;
    int cover;
    String author;
    String novel;
    String description;
    ImageView txtcover;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);


        Intent i = getIntent();



        author = i.getStringExtra("author");

        novel = i.getStringExtra("novel");

        description = i.getStringExtra("description");

        cover = i.getIntExtra("cover",cover);



        // Locate the TextViews in singleitemview.xml
        txtauthor = (TextView) findViewById(R.id.author);
        txtnovel = (TextView) findViewById(R.id.novel);
        txtdescription = (TextView) findViewById(R.id.description);


       txtcover = (ImageView) findViewById(R.id.cover);


        txtauthor.setText(author);
        txtnovel.setText(novel);
        txtdescription.setText(description);
       txtcover.setImageResource(cover);

    }



}