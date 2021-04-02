package fr.arsenelapostolet.jetpacktuto.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.arsenelapostolet.jetpacktuto.R;
import fr.arsenelapostolet.jetpacktuto.databinding.ItemDogBinding;
import fr.arsenelapostolet.jetpacktuto.model.DogBreed;

public class DogsListAdapter extends RecyclerView.Adapter<DogsListAdapter.DogViewHolder> {

    private ArrayList<DogBreed> dogList;

    public DogsListAdapter(ArrayList<DogBreed> dogList) {
        this.dogList = dogList;
    }

    public void setDogList(List<DogBreed> dogList) {
        this.dogList.clear();
        this.dogList.addAll(dogList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDogBinding view = DataBindingUtil.inflate(inflater, R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        DogBreed dog = dogList.get(position);
        holder.itemView.setDog(dog);
        holder.itemView.setOnDogClicked(v -> {
            ListFragmentDirections.ActionDetail action = ListFragmentDirections.actionDetail();
            action.setDogUuid(Integer.parseInt(dog.getBreedId()));
            Navigation.findNavController(v).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return this.dogList.size();
    }

    class DogViewHolder extends RecyclerView.ViewHolder {

        public ItemDogBinding itemView;

        public DogViewHolder(@NonNull ItemDogBinding binding) {
            super(binding.getRoot());
            this.itemView = binding;
        }
    }

}
