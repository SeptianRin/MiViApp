package io.github.septianrin.miviapp.ui.detail;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.model.TVShowModel;
import io.github.septianrin.miviapp.utils.DataDummy;

public class DetailViewModel extends ViewModel {
    private String title;

    public void setTitle(String title){
        this.title = title;
    }

    public MovieModel getTitleMovie(){
        MovieModel movie= null;

        ArrayList<MovieModel> movieModels = (ArrayList<MovieModel>) DataDummy.generateDummyMovies();
        for(MovieModel movieModel:movieModels){
            if(movieModel.getTitle().equals(title)){
                movie = movieModel;
            }
        }

        return movie;
    }

    public TVShowModel getTitleTV(){
        TVShowModel tvshow= null;

        ArrayList<TVShowModel> tvShowModels = (ArrayList<TVShowModel>) DataDummy.generateDummyTVShow();
        for(TVShowModel tvShowModel:tvShowModels){
            if(tvShowModel.getTitle().equals(title)){
                tvshow = tvShowModel;
            }
        }

        return tvshow;
    }
}
