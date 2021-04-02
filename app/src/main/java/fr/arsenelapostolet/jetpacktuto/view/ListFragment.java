package fr.arsenelapostolet.jetpacktuto.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.arsenelapostolet.jetpacktuto.R;
import fr.arsenelapostolet.jetpacktuto.viewmodel.ListViewModel;

public class ListFragment extends Fragment {

    private ListViewModel viewModel;
    private DogsListAdapter dogsListAdapter = new DogsListAdapter(new ArrayList<>());


    @BindView(R.id.dogsList)
    public RecyclerView dogsList;

    @BindView(R.id.listError)
    public TextView error;

    @BindView(R.id.loadingView)
    public ProgressBar loader;

    @BindView(R.id.refreshLayout)
    public SwipeRefreshLayout refreshLayout;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.refresh();

        dogsList.setLayoutManager(new LinearLayoutManager(getContext()));
        dogsList.setAdapter(this.dogsListAdapter);

        viewModel.dogs.observe(this, dogs -> {
            if (dogs != null) {
                dogsList.setVisibility(View.VISIBLE);
                this.dogsListAdapter.setDogList(dogs);
            }
        });

        viewModel.dogLoadError.observe(this, isError -> {
            if (isError != null) {
                error.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.loading.observe(this, isLoading -> {
            if (isLoading != null) {
                loader.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            }
            if (isLoading) {
                dogsList.setVisibility(View.GONE);
                error.setVisibility(View.GONE);
            }
        });
    }

}