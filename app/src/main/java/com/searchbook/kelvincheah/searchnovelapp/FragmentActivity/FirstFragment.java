package com.searchbook.kelvincheah.searchnovelapp.FragmentActivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.searchbook.kelvincheah.searchnovelapp.R;

// HOME PAGE
public class FirstFragment extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         // Onclick Button will go to another fragment
        View v =inflater.inflate(R.layout.fragment_first, container, false);
        Button ID = (Button) v.findViewById(R.id.search_button);
        ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                NovelFragment NAME = new NovelFragment();
                fragmentTransaction.replace(R.id.frame, NAME);
                fragmentTransaction.commit();

            }
        });
        return v;
    }
}

