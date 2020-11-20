
package com.emilianohg.demo_topicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtRFC, txtNombre;
    Button btnGrabar, btnBorrar, btnLimpiar,btnModificar,btnGenerar,btnActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRFC = (EditText) findViewById(R.id.RFC);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnGrabar=(Button) findViewById(R.id.btnGrabar);
        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnModificar=(Button) findViewById(R.id.btnModificar);
        btnGenerar=(Button) findViewById(R.id.btnGenerar);
        btnActividad=(Button) findViewById(R.id.btnActividad);

        // se requiere poner escuchadores a los botónes
        btnLimpiar.setOnClickListener(this);
        btnGenerar.setOnClickListener(this);
        btnActividad.setOnClickListener(this);


    }

    @Override
    public void onClick(View evt) {
        if(evt == btnLimpiar){
            txtRFC.setText("");
            txtNombre.setText("");
              return;
        }
        if(evt == btnGenerar){

            String nombre=Rutinas.nextNombre(1);
            txtNombre.setText(nombre);
            // calcular el rfc del nombre   :   JUAN LOPEZ GARCIA  LOGJ

            int pos=nombre.indexOf(" ");
            String iniPaterno=nombre.substring(pos+1,pos+3);
            pos=nombre.lastIndexOf(" ");
            String iniMaterno=nombre.substring(pos+1,pos+2);

            String RFC=iniPaterno+iniMaterno+nombre.charAt(0)+Rutinas.nextInt(1950,2020);
            RFC+=Rutinas.PonCeros(Rutinas.nextInt(1,12),2)+Rutinas.PonCeros(Rutinas.nextInt(1,31),2);

            txtRFC.setText(RFC);
            return;
        }
        if(evt == btnActividad){
            // Lanzar una actividad requerimos de un objeto Intent
            Intent ObjInt = new Intent(this, MainActivity2.class);
            startActivity(ObjInt);
            return;


        }

    }
}