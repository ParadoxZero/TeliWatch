package com.paradox.teliwatch;

/**
 * Created by prankul on 08-05-2016.
 */
public class Episode {
    public String Title , Year , Rated , Released , Season , Episode , Runtime , Plot , Awards , Poster , Metascore , imdbRating , imdbVotes , imdbID , seriesID , Type,Genre , Director , Writer , Actors , Language , Country;
    public Boolean watched = false;

    //constructors

    public Episode() {
        /*Test change comment.. ignore delete or do whatever you want with it */
        Title = null;
        Year = null;
        Rated = null;
        Released = null;
        Season = null;
        Episode = null;
        Runtime = null;
        Plot = null;
        Awards = null;
        Poster = null;
        Metascore = null;
        imdbRating = null;
        imdbVotes = null;
        imdbID = null;
        seriesID = null;
        Type = null;
        Genre = null;
        Director = null;
        Writer = null;
        Actors = null;
        Language = null;
        Country = null;
        watched = false;
    }

    public Episode(String title, String year, String rated, String released, String season, String episode, String runtime, String plot, String awards, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String seriesID, String type, String genre, String director, String writer, String actors, String language, String country, Boolean watched) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Season = season;
        Episode = episode;
        Runtime = runtime;
        Plot = plot;
        Awards = awards;
        Poster = poster;
        Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.seriesID = seriesID;
        Type = type;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Language = language;
        Country = country;
        this.watched = watched;
    }

    public Episode(String title, String year, String rated, String released, String season, String episode, String runtime, String plot, String awards, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, String seriesID, String type, String genre, String director, String writer, String actors, String language, String country) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Season = season;
        Episode = episode;
        Runtime = runtime;
        Plot = plot;
        Awards = awards;
        Poster = poster;
        Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.seriesID = seriesID;
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

    public String getSeason() {
        return Season;
    }

    public void setSeason(String season) {
        Season = season;
    }

    public String getEpisode() {
        return Episode;
    }

    public void setEpisode(String episode) {
        Episode = episode;
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

    public String getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
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

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }
}
