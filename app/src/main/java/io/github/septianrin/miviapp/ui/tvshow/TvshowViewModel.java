package io.github.septianrin.miviapp.ui.tvshow;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.github.septianrin.miviapp.model.TVShowModel;
import io.github.septianrin.miviapp.utils.DataDummy;

public class TvshowViewModel extends ViewModel {
    List<TVShowModel> getTvshow(){
        return DataDummy.generateDummyTVShow();
    }
}
