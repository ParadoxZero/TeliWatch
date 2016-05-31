package com.paradox.teliwatch;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by Zero on 07-May-16, modified by Prankul on 14-May-16.
 */
public class SearchResults extends Series {

    public static String SERIES_ID = "SearchResult.id";
    ///public  String title = "",id = "",year ="",url = "" ;


    public SearchResults(JSONObject obj){

        try {
            Title  = (String) obj.get("Title");
        } catch(org.json.JSONException e){}
        try {
            Year  = (String) obj.get("Year");
        } catch(org.json.JSONException e){}
        try {
            Rated  = (String) obj.get("Rated");
        } catch(org.json.JSONException e){}
        try {
            Released  = (String) obj.get("Released");
        } catch(org.json.JSONException e){}
        try {
            Runtime  = (String) obj.get("Runtime");
        } catch(org.json.JSONException e){}
        try {
            Plot  = (String) obj.get("Plot");
        } catch(org.json.JSONException e){}
        try {
            Awards  = (String) obj.get("Awards");
        } catch(org.json.JSONException e){}
        try {
            Poster  = (String) obj.get("Poster");
        } catch(org.json.JSONException e){}
        try {
            Metascore  = (String) obj.get("Metascore");
        } catch(org.json.JSONException e){}
        try {
            imdbRating  = (String) obj.get("imdbRating");
        } catch(org.json.JSONException e){}
        try {
            imdbVotes  = (String) obj.get("imdbVotes");
        } catch(org.json.JSONException e){}
        try {
            imdbID  = (String) obj.get("imdbID");
        } catch(org.json.JSONException e){}
        try {
            Type  = (String) obj.get("Type");
        } catch(org.json.JSONException e){}
        try {
            Genre  = (String) obj.get("Genre");
        } catch(org.json.JSONException e){}
        try {
            Director  = (String) obj.get("Director");
        } catch(org.json.JSONException e){}
        try {
            Writer  = (String) obj.get("Writer");
        } catch(org.json.JSONException e){}
        try {
            Actors  = (String) obj.get("Actors");
        } catch(org.json.JSONException e){}
        try {
            Language  = (String) obj.get("Language");
        } catch(org.json.JSONException e){}
        try {
            Country  = (String) obj.get("Country");
        } catch(org.json.JSONException e){}

    }
    /*public void addEntry(Context context, LinearLayout holder){
        TextView Title  ;
        TextView ID ;
        Title = new TextView(context);
        Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CAll the next activity from here
            }
        });
        Title.setText(Title);
        Title.setTextColor(Color.BLACK);
        Title.setTextSize(20);
        Title.setPadding(10,10,10,10);
        ID = new TextView(context);
        String idText = "imdb id =" + imdbID + "\nYear :" + Year ;
        ID.setText(idText);
        ID.setPadding(10, 10, 10, 10);
        holder.addView(Title);
        holder.addView(ID);
        System.out.println("Made Wdget");
    }*/
}
