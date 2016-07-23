package com.example.kevinrotairo.androidcodecamp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.util.Log;

import com.example.kevinrotairo.androidcodecamp.MainActivity;
import com.example.kevinrotairo.androidcodecamp.R;
import com.example.kevinrotairo.androidcodecamp.model.ListData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class ListContentFragment extends Fragment {
    private ArrayList<ListData> datasample= new ArrayList<ListData>();

    public void onCreate(String filename,Context context){
        pfreadFromFile( context);
        ListData sample;

        /*for(int i=1;i<=5;i++) {
            sample = new ListData("", "description");
            datasample.add(sample);
        }*/
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        //populateData();
        onCreate(Constants.FILENAME,getContext());
        ContentAdapter adapter = new ContentAdapter(datasample);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;

    }

    public void pfreadFromFile(Context context){
        Constants.readFromFile = null;
        //Constants.numLinesRead = 0;
        ListData sample;
        int pfNumLinesRead = 0;
        String finSpecLocation;
        final String TAG = MainActivity.class.getName();
        try {
            FileInputStream inputStream =context.openFileInput(Constants.FILENAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null ) {
                    //Constants.numLinesRead = Constants.numLinesRead + 1;
                    pfNumLinesRead = pfNumLinesRead + 1;
                    //stringBuilder.append(receiveString + "\n");
                    ;
                    String[] separated = receiveString.split(":");
                    sample = new ListData(separated[0], separated[1]);
                    datasample.add(sample);
                }

                inputStream.close();
                //Constants.readFromFile = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
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
        private static final int LENGTH = 5;
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
            return datasample.size();
        }

    }
}