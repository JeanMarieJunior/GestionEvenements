package com.example.gestionevenements;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ChoixHeure extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance(Locale.CANADA_FRENCH);
        int heure = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,heure, minute,true);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Calendar c = Calendar.getInstance(Locale.CANADA_FRENCH);
        c.set(Calendar.HOUR_OF_DAY, i);
        c.set(Calendar.MINUTE,i1);

        String heure = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CANADA_FRENCH).format(c.getTime());

        TextView tvHeure = getActivity().findViewById(R.id.tvHeure);
        tvHeure.setText(heure);
    }

}
