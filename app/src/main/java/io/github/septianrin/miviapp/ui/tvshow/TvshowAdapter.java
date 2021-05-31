package io.github.septianrin.miviapp.ui.tvshow;

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
import io.github.septianrin.miviapp.databinding.ItemsTvshowBinding;
import io.github.septianrin.miviapp.model.TVShowModel;
import io.github.septianrin.miviapp.ui.detail.DetailActivity;

public class TvshowAdapter extends RecyclerView.Adapter<TvshowAdapter.TvshowViewHolder>{
    private final TvshowFragmentCallback callback;
    private final ArrayList<TVShowModel> listShow = new ArrayList<>();

    public TvshowAdapter(TvshowFragmentCallback callback) {
        this.callback = callback;
    }

    void setTvshow(List<TVShowModel> listShow){
        if(listShow == null) return;
        this.listShow.clear();
        this.listShow.addAll(listShow);
    }

    @NonNull
    @Override
    public TvshowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsTvshowBinding binding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new TvshowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TvshowAdapter.TvshowViewHolder holder, int position) {
        TVShowModel tvShowModel = listShow.get(position);
        holder.bind(tvShowModel);
    }

    @Override
    public int getItemCount() {
        return listShow.size();
    }

    public class TvshowViewHolder extends RecyclerView.ViewHolder {
        private final ItemsTvshowBinding binding;
        public TvshowViewHolder(ItemsTvshowBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        void bind(TVShowModel tvShowModel) {
            binding.tvItemGenre1.setText(tvShowModel.getGenre());
            binding.tvItemEpisode.setText(tvShowModel.getEpisode());
            binding.tvItemTitle1.setText(tvShowModel.getTitle());
            itemView.setOnClickListener(v->{
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TITLE,tvShowModel.getTitle());
                itemView.getContext().startActivity(intent);
            });
            binding.imgShare.setOnClickListener(view -> callback.onShareClick(tvShowModel));


            Glide.with(itemView.getContext())
                    .load(tvShowModel.getThumbnail())
                    .apply(RequestOptions.placeholderOf(R.drawable.bg_button).error(R.drawable.bg_button))
                    .into(binding.imgPoster);
        }
    }
}
