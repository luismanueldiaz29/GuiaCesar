package com.example.guiavalledupar.Adapters;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.guiavalledupar.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;


public class ModalBottomSheet extends BottomSheetDialogFragment {
    //fecha
    private int Dia, Mes, Ano;
    //hora
    private int Hora, Minuto;

    private int layoutStyle;
    private TextView Fechaseleccionada;
    private TextView SeleccionarHora;
    private TextView nameMunicipio;
    String date = "";
    String horas = "";

    public ModalBottomSheet(int layoutStyle) {
        this.layoutStyle = layoutStyle;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        final View VW = View.inflate(getContext(), this.layoutStyle, null);

        if (this.layoutStyle == R.layout.recordatorio) {

            VW.findViewById(R.id.btnSeleccionarFecha).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    int dia = c.get(Calendar.DAY_OF_MONTH);
                    int mes = c.get(Calendar.MONTH);
                    int ano = c.get(Calendar.YEAR);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            Dia = dayOfMonth;Mes = month; Ano = year;
                            date = dayOfMonth+"/0"+month+"/"+year;
                            Fechaseleccionada = VW.findViewById(R.id.Fechaseleccionada);
                            Fechaseleccionada.setText(date);
                        }
                    }, dia, mes, ano);
                    datePickerDialog.show();
                }
            });

            VW.findViewById(R.id.SeleccionarHora).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Calendar c = Calendar.getInstance();
                    final int hora = c.get(Calendar.HOUR);
                    int minuto = c.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Hora = hourOfDay; Minuto = minute;
                            horas = hourOfDay+":"+minute;
                            SeleccionarHora = VW.findViewById(R.id.HoraSeleccionada);
                            SeleccionarHora.setText(horas);
                        }
                    }, hora, minuto, false);
                    timePickerDialog.show();
                }
            });

            VW.findViewById(R.id.agegarRecordatorio).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SeleccionarHora = VW.findViewById(R.id.HoraSeleccionada);
                    Fechaseleccionada = VW.findViewById(R.id.Fechaseleccionada);
                    if(SeleccionarHora.getText() != "" && Fechaseleccionada.getText() != "") {
                        addFavorito();
                    }else{
                        Toast.makeText(getContext(), "debe seleccionar la fecha y la hora", Toast.LENGTH_LONG).show();
                    }
                    dialog.dismiss();
                }
            });

        }

        dialog.setContentView(VW);
    }

    public void addFavorito(){
        //nameMunicipio=VW.findViewById(R.id.nameMunicipio);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,Ano);                 //
        cal.set(Calendar.MONTH, Mes);   // Set de AÑO MES y Dia
        cal.set(Calendar.DAY_OF_MONTH, Dia);       //


        cal.set(Calendar.HOUR_OF_DAY, Hora);// Set de HORA y MINUTO
        cal.set(Calendar.MINUTE,Minuto);

        Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
        intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis() + 60 * 60 * 1000);

        //intent.putExtra(CalendarContract.Events.ALL_DAY, duracion.isSelected());
        intent.putExtra(CalendarContract.Events.TITLE, "Mi sito de interes ");
        //intent.putExtra(CalendarContract.Events.DESCRIPTION, "Recordatorio de "+nameMunicipio.getText());
        intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Departamento del Cesar");

        startActivity(intent);
    }

    public void ConsultFavite(){
        Uri number = Uri.parse("content://com.android.calendar");
        Intent calendarIntent = new Intent(Intent.CATEGORY_OPENABLE);
        calendarIntent.setType("vnd.android.cursor.item");
        startActivity(calendarIntent);
        /*Intent intent = new Intent(Intent.ACTION_EDIT);
        intent.setType("vnd.android.cursor.item/event");
        startActivity(intent);*/
    }
}
