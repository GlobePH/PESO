package com.example.kevinrotairo.androidcodecamp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.kevinrotairo.androidcodecamp.MainActivity;
import com.example.kevinrotairo.androidcodecamp.R;
import com.example.kevinrotairo.androidcodecamp.model.ListData;

import java.util.ArrayList;

/**
 * Created by Macadamia on 3/28/2016.
 */
public class TileContentFragment extends Fragment {
    private ArrayList<ListData> datasample= new ArrayList<ListData>();
    ImageButton MyImageButton1,MyImageButton2,MyImageButton3,MyImageButton4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.item_tile, container, false);
        MyImageButton1= (ImageButton) view.findViewById(R.id.imageButton);
        MyImageButton2= (ImageButton) view.findViewById(R.id.imageButton2);
        MyImageButton3= (ImageButton) view.findViewById(R.id.imageButton3);
        MyImageButton4= (ImageButton) view.findViewById(R.id.imageButton4);
        addListenerOnButton();

        return view;

    }

    public void addListenerOnButton() {

        MyImageButton1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println("FireButton clicked");

            }

        });
        MyImageButton2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println("Earthquake clicked");

            }

        });
        MyImageButton3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println("Flood clicked");

            }

        });
        MyImageButton4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                System.out.println("Emergency clicked");

            }

        });
    }


}