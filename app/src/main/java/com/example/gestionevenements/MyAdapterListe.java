package com.example.gestionevenements;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapterListe extends RecyclerView.Adapter<MyAdapterListe.MonViewHolder>
{
    List<Event> liste ;

    public MyAdapterListe(List<Event> liste){
        this.liste = liste ;
    }

    @NonNull
    @Override
    public MyAdapterListe.MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_mes_events,parent,false);
        return new MyAdapterListe.MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterListe.MonViewHolder holder, int position) {

        Event e = liste.get(position);
        holder.edtTitre.setText(e.getTitre());
        holder.edtDescription.setText(e.getDescription());
        holder.edtdate.setText(e.getDescription());
        holder.edtheure.setText(e.getHeure());
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder
    {
        TextView edtTitre, edtDescription, edtdate , edtheure ;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            edtTitre = itemView.findViewById(R.id.edtTitre);
            edtDescription = itemView.findViewById(R.id.edtDescription);
            edtdate = itemView.findViewById(R.id.EdtDate);
            edtheure = itemView.findViewById(R.id.edtTime);

        }
    }
}
