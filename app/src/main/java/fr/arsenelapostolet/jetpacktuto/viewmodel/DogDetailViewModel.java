package fr.arsenelapostolet.jetpacktuto.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import fr.arsenelapostolet.jetpacktuto.model.DogBreed;

public class DogDetailViewModel extends ViewModel {

    public MutableLiveData<DogBreed> dog = new MutableLiveData<>();

    public void init() {
        DogBreed dog = new DogBreed("1", "corgi", "15 years", "", "eating", "nervous", "");
        this.dog.setValue(dog);
    }


}
