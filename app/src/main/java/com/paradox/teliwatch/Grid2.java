package com.paradox.teliwatch;

/**
 * Created by prankul on 5-05-2016.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Grid2 extends BaseAdapter{
    private Context mContext;
    private ArrayList<Episode> resultlist = new ArrayList<Episode>();
    public ImageView im ;
    public Grid2(Context c,ArrayList<Episode> resultlist) {
        mContext = c;
        this.resultlist = resultlist;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return resultlist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid2;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid2 = new View(mContext);
            grid2 = inflater.inflate(R.layout.episodeelement, null);
            TextView season = (TextView) grid2.findViewById(R.id.season);
            TextView episode = (TextView) grid2.findViewById(R.id.episode);
            TextView imdb = (TextView) grid2.findViewById(R.id.imdbid);
            TextView plot = (TextView) grid2.findViewById(R.id.plot);
            ImageView imageView = (ImageView)grid2.findViewById(R.id.imageView2);
            im = imageView ;
            ArrayList<String> tempseason = new ArrayList<String>();
            ArrayList<String> tempepisode = new ArrayList<String>();
            ArrayList<String> tempimdb = new ArrayList<String>();
            ArrayList<String> tempplot = new ArrayList<String>();
            ArrayList<String> tempimage = new ArrayList<String>();
            for(Episode element : resultlist)
            {
                tempseason.add(element.Season);
                tempepisode.add(element.Title);
                tempimdb.add(element.imdbRating);
                tempplot.add(element.Plot);
                tempimage.add(element.Poster);
            }
            String[] seasonarray = new String[resultlist.size()];
            String[] episodearray = new String[resultlist.size()];
            String[] imdbarray = new String[resultlist.size()];
            String[] plotarray = new String[resultlist.size()];
            String[] imagearray = new String[resultlist.size()];

            seasonarray = tempseason.toArray(seasonarray);
            episodearray = tempepisode.toArray(episodearray);
            imdbarray = tempimdb.toArray(imdbarray);
            plotarray = tempplot.toArray(plotarray);
            imagearray = tempimage.toArray(imagearray);

            season.setText(seasonarray[position]);
            episode.setText(episodearray[position]);
            imdb.setText(imdbarray[position]);
            plot.setText(plotarray[position]);

            /*downloadImageAndSet dd = new downloadImageAndSet();
            dd.setView(imageView);
            dd.execute(imagearray[position]);*/

        }
        else
        {
            grid2 = (View) convertView;
        }

        return grid2;
    }

    public Bitmap get(String src)
    {
        try
        {
            URL url=new URL(src);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            InputStream is=con.getInputStream();
            Bitmap bm= BitmapFactory.decodeStream(is);
            bm = Bitmap.createScaledBitmap(bm,300,400,false);
            return bm;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }


}
