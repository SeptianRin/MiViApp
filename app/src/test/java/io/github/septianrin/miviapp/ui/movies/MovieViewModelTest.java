package io.github.septianrin.miviapp.ui.movies;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.github.septianrin.miviapp.model.MovieModel;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovie() {
        List<MovieModel> movieModels = viewModel.getMovie();
        assertNotNull(movieModels);
        assertEquals(11,movieModels.size());
    }
}