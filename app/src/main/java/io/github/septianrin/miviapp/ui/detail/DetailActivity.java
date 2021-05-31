package io.github.septianrin.miviapp.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import io.github.septianrin.miviapp.R;
import io.github.septianrin.miviapp.databinding.ActivityDetailBinding;
import io.github.septianrin.miviapp.databinding.ContentDetailBinding;
import io.github.septianrin.miviapp.model.MovieModel;
import io.github.septianrin.miviapp.model.TVShowModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    private ContentDetailBinding contentDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActivityDetailBinding activityDetailBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        contentDetailBinding =activityDetailBinding.detailContent;

        setContentView(activityDetailBinding.getRoot());
        setSupportActionBar(activityDetailBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        DetailViewModel viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(DetailViewModel.class);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String title = extras.getString(EXTRA_TITLE);
            if (title != null) {
                viewModel.setTitle(title);
                if(viewModel.getTitleMovie() !=null){
                    MovieModel movie= viewModel.getTitleMovie();
                    populateMovie(movie);
                }else{
                    TVShowModel tvshow= viewModel.getTitleTV();
                    populateTVShow(tvshow);
                }
            }
        }
    }

    private void populateTVShow(TVShowModel tvshow) {
        contentDetailBinding.textTitle.setText(tvshow.getTitle());
        contentDetailBinding.textGenre.setText(tvshow.getGenre());
        contentDetailBinding.textRating.setText(tvshow.getRating()+"/10");
        contentDetailBinding.textDura.setText("Episode");
        contentDetailBinding.textDuration.setText(tvshow.getEpisode());
        contentDetailBinding.textDescription.setText(tvshow.getSinopsis());

        Glide.with(this)
                .load(tvshow.getThumbnail())
                .apply(RequestOptions.placeholderOf(R.drawable.bg_button).error(R.drawable.bg_button))
                .into(contentDetailBinding.imagePoster);
        contentDetailBinding.btnShare.setOnClickListener(v->{
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText("Ayo nonton TV Show "+ tvshow.getTitle() +" sama aku dijamin seru")
                    .startChooser();

        });
    }

    private void populateMovie(MovieModel movie) {
        contentDetailBinding.textTitle.setText(movie.getTitle());
        contentDetailBinding.textGenre.setText(movie.getGenre());
        contentDetailBinding.textRating.setText(movie.getRating()+"/10");
        contentDetailBinding.textDuration.setText(movie.getDuration());
        contentDetailBinding.textDescription.setText(movie.getSinopsis());

        Glide.with(this)
                .load(movie.getThumbnail())
                .apply(RequestOptions.placeholderOf(R.drawable.bg_button).error(R.drawable.bg_button))
                .into(contentDetailBinding.imagePoster);

        contentDetailBinding.btnShare.setOnClickListener(v->{
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText("Ayo nonton Movie "+ movie.getTitle() +" sama aku dijamin seru")
                    .startChooser();

        });
    }
}