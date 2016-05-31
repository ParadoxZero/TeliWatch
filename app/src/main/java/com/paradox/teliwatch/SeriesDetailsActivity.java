package com.paradox.teliwatch;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SeriesDetailsActivity extends AppCompatActivity {

    String id ;
    Series series;
    int season = 1 ;
    FloatingActionButton fab = null;
    ArrayList<Episode> episode_list = new ArrayList<Episode>();
    ExpandableListView seasonContainer ;
    SeasonListAdapter adapter ;
    HashMap<String,List<String>>  map = new LinkedHashMap<>();
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        seasonContainer = (ExpandableListView) findViewById(R.id.simple_expandable_listview);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this ;
        Intent i = getIntent();
        id = i.getStringExtra("id");
        DBMS db = new DBMS(context,null,null,1);
        ArrayList<Series> allseries = db.getAllSeries();
        boolean flag = false;
        ((ProgressBar)findViewById(R.id.prgressbar)).setVisibility(View.VISIBLE);
        for(Series s : allseries)
        {
            if(s.imdbID.equals(id))
            {
                flag=true;
                poplateScreen(s);
            }
        }
        if(flag==false) {
            new getSeriesInformation().execute();
        }
    }


    private void poplateScreen(Series s){
        this.series = s;
        ((ProgressBar)findViewById(R.id.prgressbar)).setVisibility(View.INVISIBLE);
        ((TextView)findViewById(R.id.details)).setText("Year: " + series.getYear()
                + "\nRated: " + series.getRated());
        if(series.getImdbRating().equals("N/A"))
        {
            ((RatingBar)findViewById(R.id.ratingBar)).setRating(0);
        }
        else {
            ((RatingBar) findViewById(R.id.ratingBar)).setRating(Float.parseFloat(series.getImdbRating()) / 2);
        }
        ((TextView)findViewById(R.id.plot)).setText(series.getPlot());
        ((TextView)findViewById(R.id.rating)).setText(series.getImdbRating());
        setImage k = new setImage();
        k.setView((ImageView) findViewById(R.id.poster));
        k.execute(series.getPoster());
        new getEpisodes().execute("http://www.omdbapi.com/?i=" + id +"&Season=" + season);
        getSupportActionBar().setTitle(series.Title);
        {
            final DBMS db = new DBMS(context,null,null,1);
            int i=0;
            for(Series t : db.getAllSeries())
            {
                if(t.imdbID.equals(series.imdbID))
                {
                    i=1;
                }
            }
            if(i==1)
            {
                fab.setImageResource(R.drawable.ic_remove_circle_outline_black_24dp);
            }
            else
            {
                fab.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
            }
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DBMS db = new DBMS(context,null,null,1);
                int i=0;
                for(Series t : db.getAllSeries())
                {
                    if(t.imdbID.equals(series.imdbID))
                    {
                        i=1;
                    }
                }
                if(i==1)
                {
                    db.deleteSeries(series.imdbID);
                    for(Episode e : episode_list)
                    {
                        db.deleteEpisode(e.imdbID);
                    }

                    fab.setImageResource(R.drawable.ic_add_circle_outline_black_24dp);
                    Snackbar.make(v, "Removed from Favourites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
                else
                {
                    fab.setImageResource(R.drawable.ic_remove_circle_outline_black_24dp);
                    Snackbar.make(v, "Added to Favourites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    db.addSeries(series);
                    for(Episode e : episode_list)
                    {
                        db.addEpisode(e);
                        Log.i("EPRINT",e.Title + " " + e.imdbID);
                    }

                }
            }
        });

    }
    public  void populateEpisodes(JSONObject obj){
        try {
            List<String> li = new ArrayList<>();
            JSONArray arr = obj.getJSONArray("Episodes");
            for (int i = 0; i < arr.length(); ++i) {
                JSONObject jo = arr.getJSONObject(i);
                Episode e = new Episode();
                e.Episode = ""+(i+1);
                e.Season = ""+season;
                e.imdbID = (String)jo.get("imdbID");
                e.Title = (String)jo.get("Title");
                e.watched = false;
                e.seriesID = id ;
                episode_list.add(e);
                li.add(e.imdbID);
            }
            map.put("Season " + season,li);
            ++season;
            String link = "http://www.omdbapi.com/?i=" + id +"&Season=" + season ;
            new getEpisodes().execute(link);
        } catch (JSONException e) {
            List<String> list = new ArrayList<>();
            for(String s : map.keySet()){
                list.add(s);
            }
            System.out.println(list.toString());
            seasonContainer.setIndicatorBounds(0,20);
            adapter = new SeasonListAdapter(this,list,map,id);
            adapter.setSeriesEpisodeDetails(episode_list);
            seasonContainer.setAdapter(adapter);
            setListener();
            ViewGroup.LayoutParams s = seasonContainer.getLayoutParams();
            s.height = (season + (map.get(list.get(0))).size()) * 100 ;
            seasonContainer.setLayoutParams(s);
            System.out.println(map.toString());
        }
    }



    private class setImage extends downloadImageAndSet{


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

        }
    }

    private class getSeriesInformation extends AsyncTask<Void,Void,Void> {
        public Void doInBackground(Void...v){
            String url = "http://www.omdbapi.com/?i=" + id;
            RequestQueue queue = Volley.newRequestQueue(context);
            System.out.println(url);
            JSONObject data = new JSONObject();
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    System.out.println("Request recieved");
                    poplateScreen(new Series(response));
                }
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("POST error");
                }
            });
            queue.add(request);
            System.out.println("Return");

            return null ;
        }
    }
    private class getEpisodes extends AsyncTask<String,Void,Void>{
        JSONObject obj = null ;
        String link = "" ;
        @Override
        protected Void doInBackground(String... params) {
            System.out.println("Season Get:" + params[0]);
            link = params[0];
            RequestQueue queue = Volley.newRequestQueue(context);
            JSONObject d = new JSONObject();
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, params[0], d, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    obj = response;
                    System.out.println(response.toString());
                    populateEpisodes(response);
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context,"Error connecting",Toast.LENGTH_SHORT).show();

                        }
                    });
            queue.add(request);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

        }

    }
    void setListener() {

        // This listener will show toast on group click
        seasonContainer.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Toast.makeText(context,
                        "You clicked : " + adapter.getGroup(group_pos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        seasonContainer
                .setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                    // Default position
                    int previousGroup = 0;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            seasonContainer.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });
        // This listener will show toast on child click
        seasonContainer.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                Toast.makeText(
                        context,
                        "You clicked : " + adapter.getChild(groupPos, childPos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
