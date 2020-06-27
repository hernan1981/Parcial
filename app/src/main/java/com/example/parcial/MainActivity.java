package com.example.parcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSumar,btnRestar, btnReset;
    TextView resultado;
    int resTemporal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSumar= findViewById(R.id.btnSumar);
        btnRestar= findViewById(R.id.btnRestar);
        btnReset= findViewById(R.id.btnLimpiar);
        resultado= findViewById(R.id.txtResultado);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Integer.parseInt(resultado.getText().toString());
        if(v.getId()==btnSumar.getId()){
            resTemporal++;
            resultado.setText(Integer.toString(resTemporal));
        }
        if(v.getId()==btnRestar.getId()) {
            if(resTemporal>0){
                resTemporal--;
                resultado.setText(Integer.valueOf(resTemporal).toString());
            }else {
                resTemporal=0;
                resultado.setText("0");
                Toast.makeText(getApplicationContext(), "invalido, valor=0", Toast.LENGTH_LONG).show();
            }
        }
        if(v.getId()==btnReset.getId()){
            resTemporal=0;
            resultado.setText("0");
        }
    }
}