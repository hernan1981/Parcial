package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSumar,btnRestar, btnReset;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSumar=(Button) findViewById(R.id.btnSumar);
        btnRestar=(Button) findViewById(R.id.btnRestar);
        btnReset=(Button) findViewById(R.id.btnLimpiar);
        resultado=(TextView) findViewById(R.id.txtResultado);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int resTemporal=Integer.parseInt(String.valueOf(resultado));
        if(v.getId()==btnSumar.getId()){
            resTemporal+=1;
            resultado.setText(String.valueOf(resTemporal));
        }
        if(v.getId()==btnRestar.getId()) {
            if(resTemporal>0){
                resTemporal-=1;
                resultado.setText(String.valueOf(resTemporal));
            }
        }
        if(v.getId()==btnReset.getId()){
            resultado.setText(String.valueOf(0));
        }
    }
}