package com.searchbook.kelvincheah.searchnovelapp.FragmentActivity;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.searchbook.kelvincheah.searchnovelapp.DatabaseHelper;
import com.searchbook.kelvincheah.searchnovelapp.OntapListener;
import com.searchbook.kelvincheah.searchnovelapp.R;
import com.searchbook.kelvincheah.searchnovelapp.SingleItemView;
import com.searchbook.kelvincheah.searchnovelapp.adapter.NovelAdapter;
import com.searchbook.kelvincheah.searchnovelapp.item.Item;

import java.util.ArrayList;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class NovelFragment extends Fragment {
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;
    private ArrayList<Item> arrayList=new ArrayList<Item>();
    private Cursor cursor;
    private NovelAdapter adapter;
    EditText editsearch;
   int[]image= { R.drawable.linclon, R.drawable.exit,
            R.drawable.norse, R.drawable.carve,
            R.drawable.king, R.drawable.women, R.drawable.right,
            R.drawable.way, R.drawable.echoes, R.drawable.all};


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Search Novel");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup viewGroup=(ViewGroup) inflater.inflate(R.layout.fragment_blank, container, false);

        recyclerView= (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        editsearch = (EditText) viewGroup.findViewById(R.id.txtsearch);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {

                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

            }
        });

        loadDatabase();

        return viewGroup;
    }
// load database data into recycler view
    public void loadDatabase(){
        databaseHelper=new DatabaseHelper(getActivity());
        try {
            databaseHelper.checkAndCopyDatabse();
            databaseHelper.openDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        try {
            Cursor cursor = databaseHelper.QueryData("select * from FINDBook_TABLE");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        Item item = new Item();
                        item.setBOOK_NAME(cursor.getString(1));
                        item.setAUTHOR(cursor.getString(2));
                        item.setDESCRIPTION(cursor.getString(3));


                        arrayList.add(item);
                    } while (cursor.moveToNext());
                }
            }
        }catch(SQLiteException e){
           e.printStackTrace();
        }


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());

        // Pass results to Adapter Class
        adapter=new NovelAdapter(getActivity(),arrayList,image);
        adapter.setOntapListener(new OntapListener() {
            @Override
            public void OnTapView(int position) {
                Intent intent = new Intent (getActivity (), SingleItemView.class);

                intent.putExtra("novel",
                        (arrayList.get(position).getBOOK_NAME()));

                intent.putExtra("author",
                        (arrayList.get(position).getAUTHOR()));

                intent.putExtra("description",
                        (arrayList.get(position).getDESCRIPTION()));
                intent.putExtra("cover",
                        (image[position]));

                startActivity (intent);

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }



}
