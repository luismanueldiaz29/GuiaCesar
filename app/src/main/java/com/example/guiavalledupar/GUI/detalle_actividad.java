package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Adapters.ModalBottomSheet;
import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Repository.ActividadRepository;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class detalle_actividad extends AppCompatActivity {

    private Actividad actividad;
    private int pocision;
    private TextView tvName;
    private TextView tvTitle;
    private TextView tvDescription;
    private ImageView imgActividad;
    ActividadRepository repository;
    private FloatingActionButton btnCalendarActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Init();
        btnCalendarActividad = (FloatingActionButton)findViewById(R.id.btnCalendarActividad);
        btnCalendarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarSBDialog(R.layout.recordatorio, actividad.Description, actividad.Name);
            }
        });
    }

    private void Init(){
        tvName=findViewById(R.id.tvNameActividad);
        tvTitle=findViewById(R.id.titleActividadTV);
        tvDescription=findViewById(R.id.tvActividadDescription);
        imgActividad=findViewById(R.id.imgActividadDe);
        repository=new ActividadRepository(this);

        if(getIntent().getStringExtra("posicion") != null) {
            pocision = Integer.parseInt(getIntent().getStringExtra("posicion"));
            actividad = repository.getActividad(pocision);
            detalleActividad();
            Toast.makeText(this, actividad.Name + " clicked in detalle", Toast.LENGTH_LONG).show();
        }

    }
    private void detalleActividad(){
        imgActividad.setImageResource(actividad.Image);
        tvName.setText(actividad.Name);
        tvTitle.setText(actividad.title);
        tvDescription.setText(actividad.Description);
    }
    private void lanzarSBDialog(int layoutStyle, String descripcion, String nombre) {
        BottomSheetDialogFragment bottomSheetDialogFragment = new ModalBottomSheet(layoutStyle, descripcion, nombre);
        //si esta en FALSE obliga al usuario a pulsar un boton
        //bottomSheetDialogFragment.setCancelable(false);
        bottomSheetDialogFragment.setShowsDialog(true);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }

}
