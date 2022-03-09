package com.example.gestionevenements;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.MonViewHolder>
{
    List<Event> liste ;
    Context context;

    public AdapterListe(List<Event> liste, Context c){
        this.liste = liste ;
        this.context = c;
    }

    @NonNull
    @Override
    public MonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_events,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonViewHolder holder, int position) {

        Event e = liste.get(position);

        holder.tvTitre.setText(e.getTitre());
        holder.tvDescription.setText(e.getDescription());
        holder.date.setText(e.getDate());
        holder.heure.setText(e.getHeure());

        if(e.isParticipe())
            holder.imageView.setVisibility(View.VISIBLE);
        else
            holder.imageView.setVisibility(View.INVISIBLE);

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }




    public class MonViewHolder extends RecyclerView.ViewHolder
    {
      TextView tvTitre, tvDescription, date , heure ;
        ImageView imageView;

       public MonViewHolder(@NonNull View itemView) {
           super(itemView);

           tvTitre = itemView.findViewById(R.id.tvTitre);
           tvDescription = itemView.findViewById(R.id.tvDescription);
           date = itemView.findViewById(R.id.editDate);
           heure = itemView.findViewById(R.id.edTime);
           imageView = itemView.findViewById(R.id.imageView);

           AlertDialog.Builder builder = new AlertDialog.Builder(context);

           itemView.setOnLongClickListener(new View.OnLongClickListener() {
               @Override
               public boolean onLongClick(View view) {
                   builder.setTitle("Evenements");
                   builder.setMessage("Voulez-vous ajouter cette evènement ? ?");

                   builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Toast.makeText(context, "Oui " + which, Toast.LENGTH_SHORT).show();
                           liste.get(getLayoutPosition()).setParticipe(true);
                           notifyItemChanged(getLayoutPosition());
                       }
                   });
                   builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Toast.makeText(context, "Non " + which, Toast.LENGTH_SHORT).show();
                           liste.get(getLayoutPosition()).setParticipe(false);
                           notifyItemChanged(getLayoutPosition());
                       }
                   });
                   builder.setNeutralButton("Annuler", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Toast.makeText(context, "Neutre " + which, Toast.LENGTH_SHORT).show();
                       }
                   });
                   builder.create().show();

                   return false;
               }
           });
       }
   }
}
