package fr.arsenelapostolet.jetpacktuto.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import fr.arsenelapostolet.jetpacktuto.R;
import fr.arsenelapostolet.jetpacktuto.databinding.FragmentDetailBinding;
import fr.arsenelapostolet.jetpacktuto.viewmodel.DogDetailViewModel;

public class DetailFragment extends Fragment {

    private DogDetailViewModel viewModel;
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(DogDetailViewModel.class);
        viewModel.init();
        viewModel.dog.observe(this, binding::setDog);

        if (getArguments() != null) {
            Log.d("DOG ID IN FRAGMENT", Integer.toString(DetailFragmentArgs.fromBundle(getArguments()).getDogUuid()));
        }

    }
}