package com.example.gestionevenements;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListeEvenements#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListeEvenements extends Fragment {

    RecyclerView rvliste ;
    AdapterListe adapterListe ;
    Context context ;
    MonViewModel monViewModel;
    TextView warning ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListeEvenements() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListeEvenements.
     */
    // TODO: Rename and change types and number of parameters
    public static ListeEvenements newInstance(String param1, String param2) {
        ListeEvenements fragment = new ListeEvenements();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static ListeEvenements newInstance() {
        ListeEvenements fragment = new ListeEvenements();
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
        return inflater.inflate(R.layout.fragment_liste_evenements, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        warning = view.findViewById(R.id.tvWarning);

        warning.setText("Veuillez faire un click long pour sélectionner l'èvenement auquel vous souhaitez participer !");

        rvliste = view.findViewById(R.id.rvEvenents);
        rvliste.setHasFixedSize(true);

        rvliste.setLayoutManager(new LinearLayoutManager(context));

        monViewModel = new ViewModelProvider(requireActivity()).get(MonViewModel.class);
        monViewModel.getevents().observe(requireActivity(), events -> {
            adapterListe = new AdapterListe(events, getActivity());

            rvliste.setAdapter(adapterListe);
        });






    }

}