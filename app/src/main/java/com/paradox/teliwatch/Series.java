package com.paradox.teliwatch;

import org.json.JSONObject;

/**
 * Created by prankul on 08-05-2016.
 */
public class Series {
    public String Title,Year,Rated,Released,Runtime,Plot,Awards,Poster,Metascore,imdbRating,imdbVotes,imdbID,Type,Genre,Director,Writer,Actors,Language,Country;

    //constructors

    void makenull()
    {
        Title = null;
        Year = null;
        Rated = null;
        Released = null;
        Runtime = null;
        Plot = null;
        Awards = null;
        Poster = null;
        Metascore = null;
        imdbRating = null;
        imdbVotes = null;
        imdbID = null;
        Type = null;
        Genre = null;
        Director = null;
        Writer = null;
        Actors = null;
        Language = null;
        Country = null;
    }

    public Series() {
        makenull();
    }
    public Series(JSONObject obj){
        makenull();
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
        } catch(org.json.JSONException e){ imdbRating = "0";}
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

    public Series(String title, String year, String rated, String released, String runtime, String plot, String awards, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String genre, String director, String writer, String actors, String language, String country) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Plot = plot;
        Awards = awards;
        Poster = poster;
        Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        Type = type;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Language = language;
        Country = country;
    }

    //getters and setters

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
