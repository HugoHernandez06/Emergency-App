package com.example.emergencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreEvento, ubicacion, fechadesde, horadesde, fechahasta, horahasta, descripcion;
    private Button guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombreEvento=(EditText) findViewById(R.id.edtNombreEvento);
        ubicacion=(EditText) findViewById(R.id.edtDescripcion);
        fechadesde=(EditText) findViewById(R.id.edtFecha);
        fechahasta=(EditText) findViewById(R.id.edtFechaHasta);
        horadesde=(EditText) findViewById(R.id.edtHoraInicio);
        horahasta=(EditText) findViewById(R.id.edtHoraHasta);
        descripcion=(EditText) findViewById(R.id.edtDescripcion);

        Bundle bundle = getIntent().getExtras();
        int dia=0, mes=0, anio=0;
        bundle.getInt("dia");
        bundle.getInt("mes");
        bundle.getInt("anio");
        fechadesde.setText(dia+" - " + mes +" - "+ anio);
        fechahasta.setText(dia+" - " + mes +" - "+ anio);

        guardar=(Button) findViewById(R.id.btnGuardar);
        cancelar=(Button) findViewById(R.id.btnCancelar);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==guardar.getId()){
    //guardar los datos de los vampos de texto
            BDSQLite bd = new BDSQLite(getApplication(), "Agenda",null, 1 );
            SQLiteDatabase db = bd.getWritableDatabase();
            String sql = "insert into eventos" +
                    "(nombreEvento, ubicacion, fechaDesde, horaDesde, fechaHasta, horaHasta, descripcion) values ('" +
                    nombreEvento.getText()+
                    "','" +ubicacion.getText() +
                    "','" +fechadesde.getText() +
                    "','" +horadesde.getText() +
                    "','" +fechahasta.getText() +
                    "','" +horahasta.getText() +
                    "','" +descripcion.getText() + "')";
            try {
               db.execSQL(sql);
               nombreEvento.setText("");
               ubicacion.setText("");
               fechadesde.setText("");
               horadesde.setText("");
               fechahasta.setText("");
               horahasta.setText("");
               descripcion.setText("");
            }catch (Exception e){
                Toast.makeText(getApplication(), "Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }else {
            this.finish();
            return;
        }
    }
}
