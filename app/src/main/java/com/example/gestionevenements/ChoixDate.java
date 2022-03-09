package com.example.gestionevenements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class ChoixDate extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int annee = calendar.get(Calendar.YEAR);
        int mois = calendar.get(Calendar.MONTH);
        int jour = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,annee, mois, jour);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i,i1,i2);

        TextView date = getActivity().findViewById(R.id.tvDate);
        String laDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        date.setText(laDate);
    }

}
