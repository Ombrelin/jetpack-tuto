package fr.arsenelapostolet.jetpacktuto.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.arsenelapostolet.jetpacktuto.R;

public class ListFragment extends Fragment {

    @BindView(R.id.floatingActionButton)
    public FloatingActionButton fab;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab.setOnClickListener(this::onGoToDetails);
    }

    private void onGoToDetails(View view) {
        ListFragmentDirections.ActionDetail action = ListFragmentDirections.actionDetail();
        action.setDogUuid(new Random().nextInt());
        Navigation.findNavController(fab).navigate(action);
    }

}