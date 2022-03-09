package com.example.gestionevenements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MonViewModel extends ViewModel {
    private MutableLiveData<List<Event>> events;

    public LiveData<List<Event>> getevents() {
        if (events == null) {
            events = new MutableLiveData<List<Event>>();
            chargerListe();
        }
        return events;
    }

//BD utilitlies chargerListe()
    private void chargerListe()
    {
        List<Event> listeEvents = new ArrayList<>();
        events.setValue(listeEvents);
    }

}
