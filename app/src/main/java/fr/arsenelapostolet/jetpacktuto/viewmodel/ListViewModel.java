package fr.arsenelapostolet.jetpacktuto.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.Arrays;
import java.util.List;

import fr.arsenelapostolet.jetpacktuto.model.DogBreed;

public class ListViewModel extends AndroidViewModel {

    public MutableLiveData<List<DogBreed>> dogs = new MutableLiveData<>();
    public MutableLiveData<Boolean> dogLoadError = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public ListViewModel(@NonNull Application application) {
        super(application);
    }

    public void refresh() {
        this.dogs.setValue(Arrays.asList(
                new DogBreed("1", "corgi", "15 years", "", "", "", ""),
                new DogBreed("2", "rotwailer", "10 years", "", "", "", ""),
                new DogBreed("3", "labrador", "13 years", "", "", "", ""),
                new DogBreed("1", "corgi", "15 years", "", "", "", ""),
                new DogBreed("2", "rotwailer", "10 years", "", "", "", ""),
                new DogBreed("3", "labrador", "13 years", "", "", "", ""),
                new DogBreed("1", "corgi", "15 years", "", "", "", ""),
                new DogBreed("2", "rotwailer", "10 years", "", "", "", ""),
                new DogBreed("3", "labrador", "13 years", "", "", "", ""),
                new DogBreed("1", "corgi", "15 years", "", "", "", ""),
                new DogBreed("2", "rotwailer", "10 years", "", "", "", ""),
                new DogBreed("3", "labrador", "13 years", "", "", "", "")
        ));
        this.loading.setValue(false);
        this.dogLoadError.setValue(false);
    }

}

