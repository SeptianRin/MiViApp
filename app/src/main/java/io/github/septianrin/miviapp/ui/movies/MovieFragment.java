package io.github.septianrin.miviapp.ui.movies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.septianrin.miviapp.databinding.FragmentMovieBinding;
import io.github.septianrin.miviapp.model.MovieModel;


public class MovieFragment extends Fragment implements MovieFragmentCallback {
    FragmentMovieBinding fragmentMovieBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMovieBinding =FragmentMovieBinding.inflate(inflater,container,false);
        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null){
            MovieViewModel viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MovieViewModel.class);
            List<MovieModel> movies = viewModel.getMovie();
            MovieAdapter movieAdapter =new MovieAdapter(this);
            movieAdapter.setListMovies(movies);

            fragmentMovieBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMovieBinding.rvMovie.setHasFixedSize(true);
            fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
        }
    }

    @Override
    public void onShareClick(MovieModel movie) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText("Ayo nonton Movie "+ movie.getTitle() +" sama aku dijamin seru")
                    .startChooser();
        }
    }


}