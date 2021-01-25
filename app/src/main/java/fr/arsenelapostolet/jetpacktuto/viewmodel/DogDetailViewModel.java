package fr.arsenelapostolet.jetpacktuto.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import fr.arsenelapostolet.jetpacktuto.model.DogBreed;

public class DogDetailViewModel extends ViewModel {

    public MutableLiveData<String> dogName = new MutableLiveData<>();
    public MutableLiveData<String> dogPurpose = new MutableLiveData<>();
    public MutableLiveData<String> dogTemperament = new MutableLiveData<>();
    public MutableLiveData<String> dogLifeSpan = new MutableLiveData<>();

    public void init(){
        DogBreed dog = new DogBreed("1", "corgi", "15 years", "", "eating", "nervous", "");
        this.dogName.setValue(dog.getDogBreed());
        this.dogPurpose.setValue(dog.getBredFor());
        this.dogTemperament.setValue(dog.getTemperament());
        this.dogLifeSpan.setValue(dog.getLifeSpan());
    }


}
