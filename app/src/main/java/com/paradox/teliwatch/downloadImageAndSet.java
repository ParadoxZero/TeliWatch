package com.paradox.teliwatch;

/*
 * Created by Zero on 15-May-16.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.URL;

public class downloadImageAndSet extends AsyncTask<String,Void,Bitmap> {
    ImageView image = null ;
    ProgressBar bar = null;
    public void setView(ImageView i){
        image = i ;
    }
    public void setProgress(ProgressBar p){
        bar = p ;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        URL url ;
        BufferedInputStream buf ;
        InputStream in ;
        BufferedOutputStream out ;
        Bitmap bmap = null ;
        try{
            url = new URL(params[0]);
            in = url.openStream();
            buf = new BufferedInputStream(in);

            bmap = BitmapFactory.decodeStream(buf);
            if(in!=null)
                in.close();
            if(buf!=null)
                buf.close();

        }
        catch (Exception e){
            Log.e("Error downloading image", e.toString());

        }
        return bmap;
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        image.setImageBitmap(bitmap);
        if(bar != null)
            bar.setVisibility(View.INVISIBLE);

    }
}
