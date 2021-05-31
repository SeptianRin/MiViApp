package io.github.septianrin.miviapp.ui.tvshow;

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

import io.github.septianrin.miviapp.databinding.FragmentTvshowBinding;
import io.github.septianrin.miviapp.model.TVShowModel;


public class TvshowFragment extends Fragment implements TvshowFragmentCallback {
    FragmentTvshowBinding fragmentTvshowBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(inflater,container,false);
        return fragmentTvshowBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null){
            TvshowViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TvshowViewModel.class);
            List<TVShowModel> tvModel = viewModel.getTvshow();
            TvshowAdapter adapter = new TvshowAdapter(this);
            adapter.setTvshow(tvModel);
            fragmentTvshowBinding.rvTvshow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvshowBinding.rvTvshow.setHasFixedSize(true);
            fragmentTvshowBinding.rvTvshow.setAdapter(adapter);
        }
    }

    @Override
    public void onShareClick(TVShowModel tvShowModel) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText("Ayo nonton TV Show "+ tvShowModel.getTitle() +" sama aku dijamin seru")
                    .startChooser();
        }

    }
}