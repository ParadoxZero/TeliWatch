package com.paradox.teliwatch;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Zero on 13-May-16.
 */
public class Home extends Fragment {

    private Context context;
    private View root;
    private SearchView search;
    private JSONObject response;
    public ArrayList<Series> results = new ArrayList<Series>();
    GridView grid;
    Grid adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home,container,false);
        return root ;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = this.getActivity();
        DBMS db = new DBMS(context,null, null, 1);
        results = db.getAllSeries();
        adapter = new Grid(context, results);
        grid=(GridView)root.findViewById(R.id.gridView2);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            Intent i = new Intent(context,SeriesDetailsActivity.class);
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                i.putExtra("id",results.get(position).imdbID);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
