package com.paradox.teliwatch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by prankul on 08-05-2016.
 */
public class DBMS extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "teliwatch.db";
    public static final String TABLE_SERIES = "series";
    public static final String TABLE_EPISODES = "episodes";

    //series columns
    public static final String SERIES_TITLE = "Title";
    public static final String SERIES_YEAR = "Year";
    public static final String SERIES_RATED = "Rated";
    public static final String SERIES_RELEASED = "Released";
    public static final String SERIES_RUNTIME = "Runtime";
    public static final String SERIES_PLOT = "Plot";
    public static final String SERIES_AWARDS = "Awards";
    public static final String SERIES_POSTER = "Poster";
    public static final String SERIES_METASCORE = "Metascore";
    public static final String SERIES_IMDBRATING = "imdbRating";
    public static final String SERIES_IMDBVOTES = "imdbVotes";
    public static final String SERIES_IMDBID = "imdbID";
    public static final String SERIES_TYPE = "Type";
    public static final String SERIES_GENRE = "Genre";
    public static final String SERIES_DIRECTOR = "Director";
    public static final String SERIES_WRITER = "Writer";
    public static final String SERIES_ACTORS = "Actors";
    public static final String SERIES_LANGUAGE = "Language";
    public static final String SERIES_COUNTRY = "Country";

    //Episode columns

    public static final String EPISODE_TITLE = "Title";
    public static final String EPISODE_YEAR = "Year";
    public static final String EPISODE_RATED = "Rated";
    public static final String EPISODE_RELEASED = "Released";
    public static final String EPISODE_SEASON = "Season";
    public static final String EPISODE_EPISODE = "Episode";
    public static final String EPISODE_RUNTIME = "Runtime";
    public static final String EPISODE_PLOT = "Plot";
    public static final String EPISODE_AWARDS = "Awards";
    public static final String EPISODE_POSTER = "Poster";
    public static final String EPISODE_METASCORE = "Metascore";
    public static final String EPISODE_IMDBRATING = "imdbRating";
    public static final String EPISODE_IMDBVOTES = "imdbVotes";
    public static final String EPISODE_IMDBID = "imdbID";
    public static final String EPISODE_SERIESID = "seriesID";
    public static final String EPISODE_TYPE = "Type";
    public static final String EPISODE_GENRE = "Genre";
    public static final String EPISODE_DIRECTOR = "Director";
    public static final String EPISODE_WRITER = "Writer";
    public static final String EPISODE_ACTORS = "Actors";
    public static final String EPISODE_LANGUAGE = "Language";
    public static final String EPISODE_COUNTRY = "Country";

    //constructor

    public DBMS(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }


    //other functions

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + TABLE_SERIES + " ( " +
                SERIES_TITLE + " text, " +
                SERIES_YEAR + " text, " +
                SERIES_RATED + " text, " +
                SERIES_RELEASED + " text, " +
                SERIES_RUNTIME + " text, " +
                SERIES_PLOT + " text, " +
                SERIES_AWARDS + " text, " +
                SERIES_POSTER + " text, " +
                SERIES_METASCORE + " text, " +
                SERIES_IMDBRATING + " text, " +
                SERIES_IMDBVOTES + " text, " +
                SERIES_IMDBID + " text primary key, " +
                SERIES_TYPE + " text, " +
                SERIES_GENRE + " text, " +
                SERIES_DIRECTOR + " text, " +
                SERIES_WRITER + " text, " +
                SERIES_ACTORS + " text, " +
                SERIES_LANGUAGE + " text, " +
                SERIES_COUNTRY + " text " +
                ");";
        db.execSQL(query);
        query = "create table " + TABLE_EPISODES + " ( " +
                EPISODE_TITLE + " text, " +
                EPISODE_YEAR + " text, " +
                EPISODE_RATED + " text, " +
                EPISODE_RELEASED + " text, " +
                EPISODE_SEASON + " text, " +
                EPISODE_EPISODE + " text, " +
                EPISODE_RUNTIME + " text, " +
                EPISODE_PLOT + " text, " +
                EPISODE_AWARDS + " text, " +
                EPISODE_POSTER + " text, " +
                EPISODE_METASCORE + " text, " +
                EPISODE_IMDBRATING + " text, " +
                EPISODE_IMDBVOTES + " text, " +
                EPISODE_IMDBID + " text primary key, " +
                EPISODE_SERIESID + " text, " +
                EPISODE_TYPE + " text, " +
                EPISODE_GENRE + " text, " +
                EPISODE_DIRECTOR + " text, " +
                EPISODE_WRITER + " text, " +
                EPISODE_ACTORS + " text, " +
                EPISODE_LANGUAGE + " text, " +
                EPISODE_COUNTRY + " text " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EPISODES);
        onCreate(db);
    }

    public void addSeries(Series series){
        ContentValues values = new ContentValues();
        values.put(SERIES_TITLE, series.Title);
        values.put(SERIES_YEAR, series.Year);
        values.put(SERIES_RATED, series.Rated);
        values.put(SERIES_RELEASED, series.Released);
        values.put(SERIES_RUNTIME, series.Runtime);
        values.put(SERIES_PLOT, series.Plot);
        values.put(SERIES_AWARDS, series.Awards);
        values.put(SERIES_POSTER, series.Poster);
        values.put(SERIES_METASCORE, series.Metascore);
        values.put(SERIES_IMDBRATING, series.imdbRating);
        values.put(SERIES_IMDBVOTES, series.imdbVotes);
        values.put(SERIES_IMDBID, series.imdbID);
        values.put(SERIES_TYPE, series.Type);
        values.put(SERIES_GENRE, series.Genre);
        values.put(SERIES_DIRECTOR, series.Director);
        values.put(SERIES_WRITER, series.Writer);
        values.put(SERIES_ACTORS, series.Actors);
        values.put(SERIES_LANGUAGE, series.Language);
        values.put(SERIES_COUNTRY, series.Country);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SERIES, null, values);
        db.close();
    }

    public void addEpisode(Episode episode){
        ContentValues values = new ContentValues();
        values.put(EPISODE_TITLE, episode.Title);
        values.put(EPISODE_YEAR, episode.Year);
        values.put(EPISODE_RATED, episode.Rated);
        values.put(EPISODE_RELEASED, episode.Released);
        values.put(EPISODE_SEASON, episode.Season);
        values.put(EPISODE_EPISODE, episode.Episode);
        values.put(EPISODE_RUNTIME, episode.Runtime);
        values.put(EPISODE_PLOT, episode.Plot);
        values.put(EPISODE_AWARDS, episode.Awards);
        values.put(EPISODE_POSTER, episode.Poster);
        values.put(EPISODE_METASCORE, episode.Metascore);
        values.put(EPISODE_IMDBRATING, episode.imdbRating);
        values.put(EPISODE_IMDBVOTES, episode.imdbVotes);
        values.put(EPISODE_IMDBID, episode.imdbID);
        values.put(EPISODE_SERIESID, episode.seriesID);
        values.put(EPISODE_TYPE, episode.Type);
        values.put(EPISODE_GENRE, episode.Genre);
        values.put(EPISODE_DIRECTOR, episode.Director);
        values.put(EPISODE_WRITER, episode.Writer);
        values.put(EPISODE_ACTORS, episode.Actors);
        values.put(EPISODE_LANGUAGE, episode.Language);
        values.put(EPISODE_COUNTRY, episode.Country);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EPISODES, null, values);
        db.close();
    }

    public void deleteSeries(String imdbID){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SERIES + " WHERE " + SERIES_IMDBID + "=\"" + imdbID + "\";");
    }

    public void deleteEpisode(String imdbID){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_EPISODES + " WHERE " + EPISODE_IMDBID + "=\"" + imdbID + "\";");
    }

    public ArrayList<Series> getAllSeries(){
        ArrayList<Series> series = new ArrayList<Series>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SERIES + " WHERE 1 ;";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("imdbID")) != null) {
                Series temp = new Series();
                temp.Title = c.getString(c.getColumnIndex("Title"));
                temp.Year = c.getString(c.getColumnIndex("Year"));
                temp.Rated = c.getString(c.getColumnIndex("Rated"));
                temp.Released = c.getString(c.getColumnIndex("Released"));
                temp.Runtime = c.getString(c.getColumnIndex("Runtime"));
                temp.Plot = c.getString(c.getColumnIndex("Plot"));
                temp.Awards = c.getString(c.getColumnIndex("Awards"));
                temp.Poster = c.getString(c.getColumnIndex("Poster"));
                temp.Metascore = c.getString(c.getColumnIndex("Metascore"));
                temp.imdbRating = c.getString(c.getColumnIndex("imdbRating"));
                temp.imdbVotes = c.getString(c.getColumnIndex("imdbVotes"));
                temp.imdbID = c.getString(c.getColumnIndex("imdbID"));
                temp.Type = c.getString(c.getColumnIndex("Type"));
                temp.Genre = c.getString(c.getColumnIndex("Genre"));
                temp.Director = c.getString(c.getColumnIndex("Director"));
                temp.Writer = c.getString(c.getColumnIndex("Writer"));
                temp.Actors = c.getString(c.getColumnIndex("Actors"));
                temp.Language = c.getString(c.getColumnIndex("Language"));
                temp.Country = c.getString(c.getColumnIndex("Country"));
                series.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return series;
    }

    public ArrayList<Episode> getAllEpisodes(){
        ArrayList<Episode> episodes = new ArrayList<Episode>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EPISODES + " WHERE 1 ;";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("imdbID")) != null) {
                Episode temp = new Episode();
                temp.Title = c.getString(c.getColumnIndex("Title"));
                temp.Year = c.getString(c.getColumnIndex("Year"));
                temp.Rated = c.getString(c.getColumnIndex("Rated"));
                temp.Released = c.getString(c.getColumnIndex("Released"));
                temp.Season = c.getString(c.getColumnIndex("Season"));
                temp.Episode = c.getString(c.getColumnIndex("Episode"));
                temp.Runtime = c.getString(c.getColumnIndex("Runtime"));
                temp.Plot = c.getString(c.getColumnIndex("Plot"));
                temp.Awards = c.getString(c.getColumnIndex("Awards"));
                temp.Poster = c.getString(c.getColumnIndex("Poster"));
                temp.Metascore = c.getString(c.getColumnIndex("Metascore"));
                temp.imdbRating = c.getString(c.getColumnIndex("imdbRating"));
                temp.imdbVotes = c.getString(c.getColumnIndex("imdbVotes"));
                temp.imdbID = c.getString(c.getColumnIndex("imdbID"));
                temp.seriesID = c.getString(c.getColumnIndex("seriesID"));
                temp.Type = c.getString(c.getColumnIndex("Type"));
                temp.Genre = c.getString(c.getColumnIndex("Genre"));
                temp.Director = c.getString(c.getColumnIndex("Director"));
                temp.Writer = c.getString(c.getColumnIndex("Writer"));
                temp.Actors = c.getString(c.getColumnIndex("Actors"));
                temp.Language = c.getString(c.getColumnIndex("Language"));
                temp.Country = c.getString(c.getColumnIndex("Country"));
                episodes.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return episodes;
    }

    public ArrayList<Episode> getSeriesEpisodes(String series){
        ArrayList<Episode> episodes = new ArrayList<Episode>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EPISODES + " WHERE seriesID=\""+series+"\";";
        Log.i("Did", series);
        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("imdbID")) != null) {
                Episode temp = new Episode();
                temp.Title = c.getString(c.getColumnIndex("Title"));
                temp.Year = c.getString(c.getColumnIndex("Year"));
                temp.Rated = c.getString(c.getColumnIndex("Rated"));
                temp.Released = c.getString(c.getColumnIndex("Released"));
                temp.Season = c.getString(c.getColumnIndex("Season"));
                temp.Episode = c.getString(c.getColumnIndex("Episode"));
                temp.Runtime = c.getString(c.getColumnIndex("Runtime"));
                temp.Plot = c.getString(c.getColumnIndex("Plot"));
                temp.Awards = c.getString(c.getColumnIndex("Awards"));
                temp.Poster = c.getString(c.getColumnIndex("Poster"));
                temp.Metascore = c.getString(c.getColumnIndex("Metascore"));
                temp.imdbRating = c.getString(c.getColumnIndex("imdbRating"));
                temp.imdbVotes = c.getString(c.getColumnIndex("imdbVotes"));
                temp.imdbID = c.getString(c.getColumnIndex("imdbID"));
                temp.seriesID = c.getString(c.getColumnIndex("seriesID"));
                temp.Type = c.getString(c.getColumnIndex("Type"));
                temp.Genre = c.getString(c.getColumnIndex("Genre"));
                temp.Director = c.getString(c.getColumnIndex("Director"));
                temp.Writer = c.getString(c.getColumnIndex("Writer"));
                temp.Actors = c.getString(c.getColumnIndex("Actors"));
                temp.Language = c.getString(c.getColumnIndex("Language"));
                temp.Country = c.getString(c.getColumnIndex("Country"));
                episodes.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return episodes;
    }

    public ArrayList<Episode> getSeriesSeasonEpisodes(String series, String season){
        ArrayList<Episode> episodes = new ArrayList<Episode>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EPISODES + " WHERE seriesID = \""+series+"\" AND Season = \""+season+"\" ;";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("imdbID")) != null) {
                Episode temp = new Episode();
                temp.Title = c.getString(c.getColumnIndex("Title"));
                temp.Year = c.getString(c.getColumnIndex("Year"));
                temp.Rated = c.getString(c.getColumnIndex("Rated"));
                temp.Released = c.getString(c.getColumnIndex("Released"));
                temp.Season = c.getString(c.getColumnIndex("Season"));
                temp.Episode = c.getString(c.getColumnIndex("Episode"));
                temp.Runtime = c.getString(c.getColumnIndex("Runtime"));
                temp.Plot = c.getString(c.getColumnIndex("Plot"));
                temp.Awards = c.getString(c.getColumnIndex("Awards"));
                temp.Poster = c.getString(c.getColumnIndex("Poster"));
                temp.Metascore = c.getString(c.getColumnIndex("Metascore"));
                temp.imdbRating = c.getString(c.getColumnIndex("imdbRating"));
                temp.imdbVotes = c.getString(c.getColumnIndex("imdbVotes"));
                temp.imdbID = c.getString(c.getColumnIndex("imdbID"));
                temp.seriesID = c.getString(c.getColumnIndex("seriesID"));
                temp.Type = c.getString(c.getColumnIndex("Type"));
                temp.Genre = c.getString(c.getColumnIndex("Genre"));
                temp.Director = c.getString(c.getColumnIndex("Director"));
                temp.Writer = c.getString(c.getColumnIndex("Writer"));
                temp.Actors = c.getString(c.getColumnIndex("Actors"));
                temp.Language = c.getString(c.getColumnIndex("Language"));
                temp.Country = c.getString(c.getColumnIndex("Country"));
                episodes.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return episodes;
    }

    public ArrayList<Episode> getimdbEpisodes(String id){
        ArrayList<Episode> episodes = new ArrayList<Episode>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_EPISODES + " WHERE imdbID = \""+id+"\" ;";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("imdbID")) != null) {
                Episode temp = new Episode();
                temp.Title = c.getString(c.getColumnIndex("Title"));
                temp.Year = c.getString(c.getColumnIndex("Year"));
                temp.Rated = c.getString(c.getColumnIndex("Rated"));
                temp.Released = c.getString(c.getColumnIndex("Released"));
                temp.Season = c.getString(c.getColumnIndex("Season"));
                temp.Episode = c.getString(c.getColumnIndex("Episode"));
                temp.Runtime = c.getString(c.getColumnIndex("Runtime"));
                temp.Plot = c.getString(c.getColumnIndex("Plot"));
                temp.Awards = c.getString(c.getColumnIndex("Awards"));
                temp.Poster = c.getString(c.getColumnIndex("Poster"));
                temp.Metascore = c.getString(c.getColumnIndex("Metascore"));
                temp.imdbRating = c.getString(c.getColumnIndex("imdbRating"));
                temp.imdbVotes = c.getString(c.getColumnIndex("imdbVotes"));
                temp.imdbID = c.getString(c.getColumnIndex("imdbID"));
                temp.seriesID = c.getString(c.getColumnIndex("seriesID"));
                temp.Type = c.getString(c.getColumnIndex("Type"));
                temp.Genre = c.getString(c.getColumnIndex("Genre"));
                temp.Director = c.getString(c.getColumnIndex("Director"));
                temp.Writer = c.getString(c.getColumnIndex("Writer"));
                temp.Actors = c.getString(c.getColumnIndex("Actors"));
                temp.Language = c.getString(c.getColumnIndex("Language"));
                temp.Country = c.getString(c.getColumnIndex("Country"));
                episodes.add(temp);
            }
            c.moveToNext();
        }
        db.close();
        return episodes;
    }
}
