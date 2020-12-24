package com.calzateu.tareacalificada;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etTelefono, etEmail, etDescripcion;
    DatePicker dpFecha;
    Button btnSiguiente;

    private static Activity estaActividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estaActividad = this;



        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescipcion);
        dpFecha = (DatePicker) findViewById(R.id.dpFecha);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNombre.getText().toString().trim().length() > 0){
                    if(etTelefono.getText().toString().trim().length() > 0){
                        if (etEmail.getText().toString().trim().length() >0 ){
                            if (etDescripcion.getText().toString().trim().length() >0){
                                String nombre, fecha, telefono, email, descripcion;
                                nombre = etNombre.getText().toString();
                                fecha = String.valueOf(dpFecha.getDayOfMonth()) + "/" +
                                        String.valueOf(dpFecha.getMonth()) + "/" + String.valueOf(dpFecha.getYear());
                                telefono = etTelefono.getText().toString();
                                email = etEmail.getText().toString();
                                descripcion = etDescripcion.getText().toString();

                                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                                intent.putExtra(getResources().getString(R.string.pnombre), nombre);
                                intent.putExtra(getResources().getString(R.string.pfecha), fecha);
                                intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
                                intent.putExtra(getResources().getString(R.string.pemail), email);
                                intent.putExtra(getResources().getString(R.string.pdescripcion), descripcion);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.falta_descripcion), Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.falta_email), Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.falta_telefono), Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.falta_nombre), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static Activity getEstaActividad(){
        return estaActividad;
    }
}