package com.calzateu.tareacalificada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombre, tvFecha, tvTelefono, tvEmail, tvDescripcion;
    Button btnEditarDatos, btnConfirmar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);
        btnConfirmar = (Button) findViewById(R.id.btnConfirmar);

        Bundle parametros = getIntent().getExtras();
        String nombre, fecha, telefono, email, descripcion;
        nombre = parametros.getString(getResources().getString(R.string.pnombre));
        fecha = parametros.getString(getResources().getString(R.string.pfecha));
        telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        email = parametros.getString(getResources().getString(R.string.pemail));
        descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre.setText(nombre);
        tvFecha.setText("Fecha de nacimiento: " + fecha);
        tvTelefono.setText("Tel: " + telefono);
        tvEmail.setText("Email: " + email);
        tvDescripcion.setText("Descripción: " + descripcion);

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Contacto guardado exitosamente", Toast.LENGTH_LONG).show();
                MainActivity.getEstaActividad().finish();
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}