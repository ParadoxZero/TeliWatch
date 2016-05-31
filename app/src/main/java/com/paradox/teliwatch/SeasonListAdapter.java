package com.paradox.teliwatch;/*
 * Created by Zero on 23-May-16.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SeasonListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private ArrayList<Episode> episodes ;
    private List<String> header; // header titles
    // Child data in format of header title, child title
    private HashMap<String, List<String>> child;
    private  ArrayList<Episode> SeriesEpisodeDetails = null ;

    public void setSeriesEpisodeDetails(ArrayList<Episode> k){
        SeriesEpisodeDetails = k ;
    }

    public SeasonListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData,String id) {
        this._context = context;
        this.header = listDataHeader;
        this.child = listChildData;
        DBMS db = new DBMS(_context,null,null,1);
        episodes = db.getSeriesEpisodes(id);
        Log.i("DBMS", episodes.size() + "");
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {

        // This will return the child
        return this.child.get(this.header.get(groupPosition)).get(
                childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        // Getting child text
        final String childText = (String) getChild(groupPosition, childPosition);

        // Inflating child layout and setting textview
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_child_episode, parent, false);
        }

        TextView child_text = (TextView) convertView.findViewById(R.id.child);
        for(Episode e : episodes){
            if(e.imdbID.equals(childText)){
                if(e.watched == true) {
                    child_text.setTypeface(null, Typeface.BOLD);
                    child_text.setTextColor(Color.RED); // FOR TESTING PURPOSES ONLY
                }
            }
        }
        for(Episode e : SeriesEpisodeDetails){
            if(e.imdbID.equals(childText)){
                child_text.setText(e.Title);
            }
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        // return children count
        return this.child.get(this.header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        // Get header position
        return this.header.get(groupPosition);
    }

    @Override
    public int getGroupCount() {

        // Get header size
        return this.header.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        // Getting header title
        String headerTitle = (String) getGroup(groupPosition);

        // Inflating header layout and setting text
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_header_season, parent, false);
        }

        TextView header_text = (TextView) convertView.findViewById(R.id.header);

        header_text.setText(headerTitle);

        // If group is expanded then change the text into bold and change the
        // icon
        if (isExpanded) {
            header_text.setTypeface(null, Typeface.BOLD);
            header_text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.ic_arrow_drop_up_black_24dp, 0);
        } else {
            // If group is not expanded then change the text back into normal
            // and change the icon

            header_text.setTypeface(null, Typeface.NORMAL);
            header_text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.ic_arrow_drop_down_black_24dp, 0);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
