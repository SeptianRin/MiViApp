package io.github.septianrin.miviapp.ui.movies;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.utils.DataDummy;

public class MovieViewModel extends ViewModel {
    List<MovieModel> getMovie(){
        return DataDummy.generateDummyMovies();
    }
}
