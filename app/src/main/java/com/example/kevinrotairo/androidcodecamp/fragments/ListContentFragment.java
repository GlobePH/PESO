package com.example.kevinrotairo.androidcodecamp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevinrotairo.androidcodecamp.R;
import com.example.kevinrotairo.androidcodecamp.model.ListData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macadamia on 3/28/2016.
 */
public class ListContentFragment extends Fragment {
    private ArrayList<ListData> datasample= new ArrayList<ListData>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        populateData();
        ContentAdapter adapter = new ContentAdapter(datasample);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }
    public void populateData(){
        ListData sample;

        for(int i=1;i<=10;i++) {
            sample = new ListData("abc"+i, "description");
            datasample.add(sample);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView list_avatar;
        TextView list_title;
        TextView list_desc;

        public ViewHolder(View view){
            super(view);
            list_avatar=(ImageView) view.findViewById(R.id.list_avatar);
            list_title=(TextView) view.findViewById(R.id.list_title);
            list_desc=(TextView) view.findViewById(R.id.list_desc);
        }

        //public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
          //  super(inflater.inflate(R.layout.item_list, parent, false));
        //}
    }
    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ListContentFragment.ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 10;
        private ArrayList<ListData> datasample= new ArrayList<ListData>();

        public ContentAdapter(ArrayList<ListData> datasample) {
            this.datasample=datasample;
        }

        @Override
        public ListContentFragment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
            ListContentFragment.ViewHolder holder = new ListContentFragment.ViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(ListContentFragment.ViewHolder holder, int position) {
            // no-op
            holder.list_title.setText(datasample.get(position).getTitle());
            holder.list_desc.setText(datasample.get(position).getDescription());
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }

    }

}