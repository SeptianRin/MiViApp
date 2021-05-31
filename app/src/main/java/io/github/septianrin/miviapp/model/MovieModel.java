package io.github.septianrin.miviapp.model;

public class MovieModel {
    private String title;
    private String thumbnail;
    private String rating;
    private String duration;
    private String genre;
    private String sinopsis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public MovieModel(String title, String thumbnail, String rating, String duration, String genre, String sinopsis) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.duration = duration;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }
}
