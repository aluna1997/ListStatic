package com.example.latitude.listviewexampleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Definimos las variables
    private EditText editTxt;
    private Button btn;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creación de las variables
        editTxt = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button);
        list = (ListView)findViewById(R.id.listView);
        //Este array sera nuestra "base de datos a mostrar"
        arrayList = new ArrayList<String>();
        //Este es el encargado de "acomodar" los datos en nuestra vista
        /**De parametros usa
         * 1)una referencia con información de clases padre "getApplicationContext()"
         * 2)un layout que puede ser uno de los ya definidos en la clase android.R.layout.***
         * 3)y una coleccion de informaciín a organizar
         * */


        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.custom, arrayList);
        //Para mostrar los datos de la lista basta con pasarsela a setAdapter
        list.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                arrayList.add(editTxt.getText().toString());
                //Actualizar cuando algo cambie en el adaptador
                adapter.notifyDataSetChanged();

                editTxt.setText("");
            }


        });
    }



}
