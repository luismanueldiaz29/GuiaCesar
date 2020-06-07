package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Adapters.ModalBottomSheet;
import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Services.MunicipioService;
import com.example.guiavalledupar.Services.SitioService;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Sitios extends AppCompatActivity {
    //RepositorioSitio repositorio;
    int numeroImagenes;
    CarouselView carouselView;
    SitioService servicio;
    private TextView nameMunicipio;
    private MunicipioService municipioService;
    private Municipio municipio;
    private TextView historiaMunicipio;
    private TextView sitio;
    private TextView queencntrar;
    private FloatingActionButton buttonRecordatorio;
    private FloatingActionButton btnConsultCalendar;

    int[] valleduparImg = {R.drawable.valledupar, R.drawable.valledupar2, R.drawable.valledupar3, R.drawable.valledupar4};
    int[] LapazImg = {R.drawable.lapazcesar, R.drawable.lapaz, R.drawable.lapaz3, R.drawable.lapaz4};
    int[] ManuereImg = {R.drawable.manaure, R.drawable.manaure2, R.drawable.manaure3, R.drawable.manaure4, R.drawable.manaure5};
    int[] PuebloBelloImg = {R.drawable.pueblobellocesar, R.drawable.pueblobello, R.drawable.pueblobello3, R.drawable.pueblobello4};

    private int[] imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        municipioService = new MunicipioService(this);

        nameMunicipio = (TextView)findViewById(R.id.nameMunicipio);
        historiaMunicipio = (TextView)findViewById(R.id.historiaMunicipio);
        sitio = (TextView)findViewById(R.id.sitio);
        queencntrar = (TextView)findViewById(R.id.queencntrar);
        buttonRecordatorio = findViewById(R.id.btnCalendar);
        btnConsultCalendar = findViewById(R.id.btnConsultCalendar);

        if(getIntent().getStringExtra("PMunicipio") != null){
            int pocision = Integer.parseInt(getIntent().getStringExtra("PMunicipio"));
            municipio = municipioService.getMunicipio(pocision);
            nameMunicipio.setText(municipio.Name);
            historiaMunicipio.setText(municipio.Description);
            sitio.setText(municipio.Sitio);
            queencntrar.setText("¿ Que puedes encontrar en "+municipio.Name+" ?");
        }

        servicio= new SitioService();

        numeroImagenes=servicio.getSize();

        imagenes = Imagen(Integer.parseInt(getIntent().getStringExtra("PMunicipio")));

        carouselView =findViewById(R.id.carouselView);
        carouselView.setPageCount(imagenes.length);
        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                //SitiosInteres(position);
            }
        });

        buttonRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarSBDialog(R.layout.recordatorio, historiaMunicipio.getText().toString(), nameMunicipio.getText().toString());
            }
        });

        btnConsultCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarRecordatorios();
            }
        });
    }

    private void lanzarRecordatorios(){
        String[] mProjection = new String[] {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
        };

        Cursor mProfileCursor =
                getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        mProjection, null, null, null);
    }

    private void lanzarSBDialog(int layoutStyle, String descripcion, String nombre) {
        BottomSheetDialogFragment bottomSheetDialogFragment = new ModalBottomSheet(layoutStyle, descripcion, nombre);
        //si esta en FALSE obliga al usuario a pulsar un boton
        //bottomSheetDialogFragment.setCancelable(false);
        bottomSheetDialogFragment.setShowsDialog(true);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //int imagen= servicio.getImg(position);
            imageView.setImageResource(imagenes[position]);
        }
    };

    public int[] Imagen(int pocision){
        if(pocision == 0){
            return valleduparImg;
        }else if (pocision == 1){
            return LapazImg;
        }else if (pocision == 2){
            return ManuereImg;
        }else if (pocision == 3){
            return PuebloBelloImg;
        }
        return null;
    }

    public void SitiosInteres(int position) {
        android.widget.Toast toast1;
        toast1=Toast.makeText(getApplicationContext(),"Detalle de "+servicio.getNombre(position), Toast.LENGTH_SHORT);
        toast1.show();

        String id=String.valueOf(servicio.getId(position));
        Intent intent= new Intent (this,detalleSitios.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
    public void informacionSitio(View view) {
        Intent intent = new Intent(this, Sitios.class);
        startActivity(intent);
    }

}
