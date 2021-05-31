package io.github.septianrin.miviapp.ui.detail;

import org.junit.Before;
import org.junit.Test;

import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.model.TVShowModel;
import io.github.septianrin.miviapp.utils.DataDummy;

import static org.junit.Assert.*;

public class DetailViewModelTest {
    private DetailViewModel viewModel;
    private final MovieModel dummyMovieModel = DataDummy.generateDummyMovies().get(0);
    private final TVShowModel dummyTVShowModel = DataDummy.generateDummyTVShow().get(0);


    @Before
    public void setUp() throws Exception {
        viewModel = new DetailViewModel();
    }

    @Test
    public void getTitleMovie() {
        viewModel.setTitle(dummyMovieModel.getTitle());
        MovieModel movieModel = viewModel.getTitleMovie();
        assertNotNull(movieModel);
        assertEquals(dummyMovieModel.getTitle(),movieModel.getTitle());
        assertEquals(dummyMovieModel.getGenre(),movieModel.getGenre());
        assertEquals(dummyMovieModel.getDuration(),movieModel.getDuration());
        assertEquals(dummyMovieModel.getRating(),movieModel.getRating());
        assertEquals(dummyMovieModel.getSinopsis(),movieModel.getSinopsis());
        assertEquals(dummyMovieModel.getThumbnail(),movieModel.getThumbnail());

    }

    @Test
    public void getTitleTV() {
        viewModel.setTitle(dummyTVShowModel.getTitle());
        TVShowModel tvShowModel = viewModel.getTitleTV();
        assertNotNull(tvShowModel);
        assertEquals(dummyTVShowModel.getTitle(),tvShowModel.getTitle());
        assertEquals(dummyTVShowModel.getGenre(),tvShowModel.getGenre());
        assertEquals(dummyTVShowModel.getEpisode(),tvShowModel.getEpisode());
        assertEquals(dummyTVShowModel.getRating(),tvShowModel.getRating());
        assertEquals(dummyTVShowModel.getSinopsis(),tvShowModel.getSinopsis());
        assertEquals(dummyTVShowModel.getThumbnail(),tvShowModel.getThumbnail());
    }
}