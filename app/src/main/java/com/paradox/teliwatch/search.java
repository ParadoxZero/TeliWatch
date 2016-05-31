package com.paradox.teliwatch;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/*
 * Created by Zero on 13-May-16.
 */
public class search extends Fragment {


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

        root = inflater.inflate(R.layout.search, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        search = (SearchView) root.findViewById(R.id.searchView);
        context = this.getActivity();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                results.clear();
                adapter.notifyDataSetChanged();
                String term = search.getQuery().toString();
                String url = "http://www.omdbapi.com/?s=" + term.replace(" ","%20") + "&type=series" ;
                ProgressBar p = (ProgressBar) root.findViewById(R.id.searchProgress);
                p.setVisibility(View.VISIBLE);
                new SearchSeries().execute(url);
                return false;
            }
        });
        adapter = new Grid(context, results);
        grid=(GridView)root.findViewById(R.id.gridView);
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
    private void useResults(JSONObject res){
        ProgressBar p = (ProgressBar) root.findViewById(R.id.searchProgress);
        p.setVisibility(View.INVISIBLE);
        results.clear();
        JSONArray result  ;
        JSONObject o ;
        try {
            result = res.getJSONArray("Search");
            for(int i=0;!result.isNull(i);++i){
                o = (JSONObject) result.get(i);
                System.out.println(i + ": " + results.toString());
                results.add(new SearchResults(o));
                adapter.notifyDataSetChanged();
            }
        }catch(org.json.JSONException e){
            Toast.makeText(context,"Error response result nill",Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * The below code holds the Utility inner classes
     */
    private class SearchSeries extends AsyncTask<String, Void, Void> {
        protected Void doInBackground(String... url) {
            RequestQueue queue = Volley.newRequestQueue(context);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url[0], response,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject result) {
                            response = result;
                            System.out.println(result.toString());
                            useResults(result);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        /* Add method to handle error */
                            Toast.makeText(context, "Unable to connect to internet", Toast.LENGTH_SHORT).show();
                            ProgressBar p = (ProgressBar) root.findViewById(R.id.searchProgress);
                            p.setVisibility(View.INVISIBLE);
                        }
                    }
            );
            queue.add(request);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }
    }
}
