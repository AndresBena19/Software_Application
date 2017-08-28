package com.example.labsoftware18.softwarefactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button Estudiante;
    private Button Profesor;
    private Button Admin;
    private Button show;



    boolean Value=false;
    int i=0;
    ListView lista;
    ListView lista2;
    ListView lista3;
    ArrayAdapter info;
    ArrayAdapter info2;
    ArrayAdapter info3;

    List<String> Nombres = new ArrayList<String>();
    List<String> Tipos = new ArrayList<String>();
    List<String> Codigos= new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = (ListView) findViewById(R.id.list);
        lista2 = (ListView) findViewById(R.id.listt);
        lista3 = (ListView) findViewById(R.id.listtt);
        info = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Nombres);
        info2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Tipos);
        info3 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Codigos);


        Estudiante = (Button) findViewById(R.id.Estu);
        Estudiante.setOnClickListener (new View.OnClickListener(){

            public void onClick(View view){


                Persona A= FactoryAcademia.Obtener("Estudiante");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);

                EditText nombre = (EditText) findViewById(R.id.editText4);
                EditText id = (EditText) findViewById(R.id.editText10);
                EditText edad = (EditText) findViewById(R.id.editText11);

                TextView cont= (TextView) findViewById(R.id.cont);

                ListView mostrar = (ListView) findViewById(R.id.list);
                A.Setname(nombre.getText().toString());
                A.Setedad(edad.getText().toString());
                A.SetID(id.getText().toString());
                A.Settipo("Estudiante");

                Nombres.add(nombre.getText().toString());
                Tipos.add(A.Gettipo().toString());
                Codigos.add(id.getText().toString());





               cont.setText("cont : " + Cont.GetContador());

            }}


        );



        Profesor = (Button) findViewById(R.id.Pro);

        Profesor.setOnClickListener (new View.OnClickListener(){
            public void onClick(View view){

                Persona A=  FactoryAcademia.Obtener("Profesor");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);

                EditText nombre = (EditText) findViewById(R.id.editText4);
                EditText id = (EditText) findViewById(R.id.editText10);
                EditText edad = (EditText) findViewById(R.id.editText11);
                TextView cont= (TextView) findViewById(R.id.cont);

                A.Setname(nombre.getText().toString());
                A.Setedad(edad.getText().toString());
                A.SetID(id.getText().toString());
                A.Settipo("Profesor");
                Nombres.add(nombre.getText().toString());
                Tipos.add(A.Gettipo().toString());
                Codigos.add(id.getText().toString());
                cont.setText("cont : " + Cont.GetContador());

            }}
        );


        Admin = (Button) findViewById(R.id.Admin);

        Admin.setOnClickListener (new View.OnClickListener(){
            public void onClick(View view){

                Persona A= FactoryAcademia.Obtener("Administrativo");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);

                EditText nombre = (EditText) findViewById(R.id.editText4);
                EditText id = (EditText) findViewById(R.id.editText10);
                EditText edad = (EditText) findViewById(R.id.editText11);
                TextView cont= (TextView) findViewById(R.id.cont);

                A.Setname(nombre.getText().toString());
                A.Setedad(edad.getText().toString());
                A.SetID(id.getText().toString());
                A.Settipo("Administrativo");
                Nombres.add(nombre.getText().toString());
                Tipos.add(A.Gettipo().toString());
                Codigos.add(id.getText().toString());
                cont.setText("cont : " + Cont.GetContador());

            }}
        );



        show = (Button) findViewById(R.id.Mostrar);

        show.setOnClickListener (new View.OnClickListener(){
            public void onClick(View view){


                lista.setAdapter(info);
                lista2.setAdapter(info2);
                lista3.setAdapter(info3);
                //mostrar.setText("Nombre : "+A.Getname().toString()+"\nID : "+A.GetID()+"\n"+ "Edad: "+A.Getedad()+"\n"+ "Tipo: "+A.Gettipo());

            }}
        );









    }








}
