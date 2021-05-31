package io.github.septianrin.miviapp.ui.tvshow;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.github.septianrin.miviapp.model.TVShowModel;

import static org.junit.Assert.*;

public class TvshowViewModelTest {
    TvshowViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new TvshowViewModel();
    }

    @Test
    public void getTvshow() {
        List<TVShowModel> tvShowModels = viewModel.getTvshow();
        assertNotNull(tvShowModels);
        assertEquals(11,tvShowModels.size());
    }
}