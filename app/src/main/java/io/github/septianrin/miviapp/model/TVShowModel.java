package io.github.septianrin.miviapp.model;

public class TVShowModel {
    private String title;
    private String thumbnail;
    private String rating;
    private String episode;
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

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
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

    public TVShowModel(String title, String thumbnail, String rating, String episode, String genre, String sinopsis) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.rating = rating;
        this.episode = episode;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }
}
