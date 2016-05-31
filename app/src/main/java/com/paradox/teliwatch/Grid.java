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

public class Grid extends BaseAdapter{
    private Context mContext;
    private ArrayList<Series> resultlist = new ArrayList<Series>();
    public ImageView im ;
    public Grid(Context c,ArrayList<Series> resultlist) {
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

    String kurl = "srg";

    public class background extends AsyncTask<ImageView,Void,Bitmap>
    {
        ImageView imageView ;



        @Override
        protected Bitmap doInBackground(ImageView... params) {
            Bitmap barray = null;
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
                try {
                    URL url = new URL(kurl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setDoInput(true);
                    con.connect();

                    Log.i("INDOINBG1", "");
                    InputStream is = con.getInputStream();
                    Bitmap bm = BitmapFactory.decodeStream(is);
                    bm = Bitmap.createScaledBitmap(bm, 300, 400, false);
                    barray = bm;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            imageView = params[0];
            Log.i("INDOINBG2","");
            return barray;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Log.i("post", "");
            im.setImageBitmap(bitmap);
            Log.i("1", "");
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //if (convertView == null) {
            System.out.println(resultlist.size());
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.element, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            TextView textView2 = (TextView) grid.findViewById(R.id.textView2);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            im = imageView ;
            textView.setText(resultlist.get(position).getTitle());
            textView2.setText(resultlist.get(position).Year);

            downloadImageAndSet dd = new downloadImageAndSet();
            dd.setView(imageView);
            dd.execute(resultlist.get(position).getPoster());

       /* }
        else
        {
            grid = (View) convertView;
        }*/

        return grid;
    }

}
