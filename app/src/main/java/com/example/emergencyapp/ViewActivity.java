package com.example.emergencyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    private SQLiteDatabase db;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView= (ListView)findViewById(R.id.ltvListaEventos);
        listView.setOnItemLongClickListener(this);

        Bundle bundle = getIntent().getExtras();
        int dia, mes, anio;
        dia=mes=anio=0;

        dia= bundle.getInt("dia");
        dia= bundle.getInt("mes");
        dia= bundle.getInt("anio");
        String cadena =dia+" - "+mes+" - "+anio;
        BDSQLite bd = new BDSQLite(getApplicationContext(), "Agenda", null, 1);
        db = bd.getReadableDatabase();
        String sql = "select*from eventos where fechadesde='"+cadena+"'";
        Cursor c;

        String nombre, fechasdesde, fechahasta, descripcion, ubicacion;
        try {
            c=db.rawQuery(sql, null);
            arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
            if(c.moveToFirst()){
                do{
                    nombre= c.getString(1);
                    ubicacion=c.getString(2);
                    fechasdesde=c.getString(3);
                    fechahasta=c.getString(5);
                    descripcion=c.getString(7);
                    arrayAdapter.add(nombre+","+ubicacion+","+fechasdesde+","+fechahasta+","+descripcion);
                }while(c.moveToNext());
                listView.setAdapter(arrayAdapter);
            }else{
                this.finish();
            }
        }catch (Exception ex){
            Toast.makeText(getApplication(),"Error:"+ ex.getMessage(), Toast.LENGTH_SHORT).show();
            this.finish();
         }

        listView.setOnItemLongClickListener(this);
    }


    private void eleminar (String dato){

        String [] datos = dato.split(",");

        String sql = "delete from eventos where nombreEvento='"+datos[0]+"' and "+
        "ubicacion='"+datos[1]+"' and fechadesde='"+datos[2]+"' and  fechahasta='"+datos[3]+"' and descripcion='"+datos[4]+"'";
        try {
            arrayAdapter.remove(dato);
            listView.setAdapter(arrayAdapter);
            db.execSQL(sql);
            Toast.makeText(getApplication(),"Evento eliminado",Toast.LENGTH_SHORT).show();
        }catch (Exception ex) {
            Toast.makeText(getApplication(),"Error: "+ ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            CharSequence []items = new CharSequence [2];
            items[0]="Eleminar evento ";
            items[1]="Cancelar";
            builder.setTitle("Eleminar evento").setItems(items, new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i==0){
                        //eliminar evento
                    eleminar(adapterView.getItemAtPosition(i).toString());

                    }
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();


        return false;
    }
}



