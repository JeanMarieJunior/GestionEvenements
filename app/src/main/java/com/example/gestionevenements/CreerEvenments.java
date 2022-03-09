package com.example.gestionevenements;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreerEvenments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreerEvenments extends Fragment {

    TextView tvTitre , tvDescription,tvDate,tvHeure ;
    ImageButton addevents ;
    List<Event> list = new ArrayList<Event>();
    MonViewModel monViewModel ;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreerEvenments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreerEvenments.
     */
    // TODO: Rename and change types and number of parameters
    public static CreerEvenments newInstance(String param1, String param2) {
        CreerEvenments fragment = new CreerEvenments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static CreerEvenments newInstance() {
        CreerEvenments fragment = new CreerEvenments();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creer_evenments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        tvTitre = view.findViewById(R.id.editTitre);
        tvDescription = view.findViewById(R.id.editDescription);
        tvDate = view.findViewById(R.id.tvDate);
        tvHeure = view.findViewById(R.id.tvHeure);
        addevents = view.findViewById(R.id.addevents);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogueDate = new ChoixDate();
                dialogueDate.show(requireActivity().getSupportFragmentManager(), "choix_date");

            }
        });

        tvHeure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialogHeure = new ChoixHeure();
                dialogHeure.show(requireActivity().getSupportFragmentManager(),"choix-heure");
            }
        });

        addevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvTitre.getText().equals("") ){
                    Toast.makeText(getContext(),"Veuillez remplir les champs vides",Toast.LENGTH_SHORT);
                    return ;
                }
                else if(tvDescription.getText().equals("")){
                    Toast.makeText(getContext(),"Veuillez remplir les champs vides",Toast.LENGTH_SHORT);
                    return ;
                }
                else{
                    monViewModel = new ViewModelProvider(requireActivity()).get(MonViewModel.class);
                    Event event= new Event(tvTitre.getText().toString(),tvDescription.getText().toString(),tvDate.getText().toString(),tvHeure.getText().toString());
                    List<Event> liste = monViewModel.getevents().getValue();

                    monViewModel.getevents().getValue().add(event);
                }
            }
        });

    }
}