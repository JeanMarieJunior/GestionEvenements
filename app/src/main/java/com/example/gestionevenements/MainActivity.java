package com.example.gestionevenements;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btaddEvents, btevenents, btMyEvents ;
    FragmentContainerView fragmentContainerView ;

    FragmentManager fragmentManager ;

    ListeEvenements listeEvenements;
    CreerEvenments creerEvenments;
    NosEvenements nosEvenements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainerView = findViewById(R.id.fragmentContainerView);

        btevenents = findViewById(R.id.btEvents);
        btaddEvents = findViewById(R.id.btAddEvents);
        btMyEvents = findViewById(R.id.btMyEvents);

        fragmentManager = getSupportFragmentManager();

        listeEvenements= ListeEvenements.newInstance();
        creerEvenments = CreerEvenments.newInstance();
        nosEvenements = NosEvenements.newInstance();

        if(savedInstanceState == null){
            getSupportFragmentManager().
                    beginTransaction().
                    setReorderingAllowed(true).
                    replace(R.id.fragmentContainerView,listeEvenements,null).
                    commit();
        }
    }

    public void clickbtevenents(View v){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,listeEvenements);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void clickBtAddEvents(View v){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,creerEvenments);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void clickMyEvents(View v){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,nosEvenements);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}