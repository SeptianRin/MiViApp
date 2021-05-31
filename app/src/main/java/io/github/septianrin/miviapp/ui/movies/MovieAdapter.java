package io.github.septianrin.miviapp.ui.movies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import io.github.septianrin.miviapp.R;
import io.github.septianrin.miviapp.databinding.ItemsMovieBinding;
import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.ui.detail.DetailActivity;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private final MovieFragmentCallback callback;
    private final List<MovieModel> listMovies =new ArrayList<>();

    public MovieAdapter(MovieFragmentCallback callback) {
        this.callback = callback;
    }

    void setListMovies(List<MovieModel> listMovies){
        if(listMovies == null) return;
        this.listMovies.clear();
        this.listMovies.addAll(listMovies);
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        ItemsMovieBinding binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        MovieModel movie = listMovies.get(position);
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ItemsMovieBinding binding;

        MovieViewHolder(ItemsMovieBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(MovieModel movie) {
            binding.tvItemDuration.setText(movie.getDuration());
            binding.tvItemGenre.setText(movie.getGenre());
            binding.tvItemTitle.setText(movie.getTitle());
            itemView.setOnClickListener(v->{
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TITLE, movie.getTitle());
                itemView.getContext().startActivity(intent);

            });
            binding.imgShare.setOnClickListener(view ->callback.onShareClick(movie));

            Glide.with(itemView.getContext())
                    .load(movie.getThumbnail())
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_button).error(R.drawable.bg_button))
                    .into(binding.imgPoster);

        }
    }
}
