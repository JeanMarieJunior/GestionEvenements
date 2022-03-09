package com.example.gestionevenements;

import android.widget.CalendarView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Date;

public class Event {

    String Titre, Description, Date, Heure ;



    boolean participe;

    public Event(String titre, String description, String date, String heure) {
        Titre = titre;
        Description = description;
        Date = date;
        Heure = heure;
        participe = false;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHeure() {
        return Heure;
    }

    public void setHeure(String heure) {
        Heure = heure;
    }

    public boolean isParticipe() {
        return participe;
    }

    public void setParticipe(boolean participe) {
        this.participe = participe;
    }
}
