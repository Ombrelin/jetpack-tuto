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
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.arsenelapostolet.jetpacktuto.R;

public class DetailFragment extends Fragment {


    @BindView(R.id.floatingActionButton2)
    public FloatingActionButton fab;

    @BindView(R.id.textView2)
    public TextView textView;

    private int uuid;

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments() != null){
            this.uuid = DetailFragmentArgs.fromBundle(getArguments()).getDogUuid();
            textView.setText(Integer.toString(this.uuid));
        }
        fab.setOnClickListener(this::onGoToList);
    }

    private void onGoToList(View view) {
        NavDirections action = DetailFragmentDirections.actionList();
        Navigation.findNavController(fab).navigate(action);
    }
}