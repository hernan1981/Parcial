package com.example.parcial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Conversor extends AppCompatActivity  implements View.OnClickListener{
    Button btnConvertir,btnReiniciar;
    EditText txtMonto, txtResultado;
    RadioGroup rdbGrupo;
    RadioButton rdbDolar, rdbEuro, rdbReal;
    Double monto, dolar=70.52, real=14.23, euro=82.65;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        rdbGrupo= findViewById(R.id.rdbGrupo);
        rdbDolar= findViewById(R.id.rdbDolar);
        rdbEuro= findViewById(R.id.rdbEuro);
        rdbReal= findViewById(R.id.rdbReal);
        btnConvertir= findViewById(R.id.btnConvertir);
        btnReiniciar= findViewById(R.id.btnReiniciar);

        txtMonto= findViewById(R.id.txtMonto);
        txtResultado= findViewById(R.id.txtResultado);
        btnConvertir.setOnClickListener(this);
        btnReiniciar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        monto=Double.parseDouble(txtMonto.getText().toString());
        int botonActivado=rdbGrupo.getCheckedRadioButtonId();

        if (v.getId() == btnConvertir.getId()){
            if(monto > 0) {
                if(botonActivado==rdbDolar.getId()) monto*=dolar;
                if(botonActivado==rdbEuro.getId()) monto*=euro;
                if(botonActivado==rdbReal.getId()) monto*=real;
                txtResultado.setText(Double.toString(monto));
            }else{
                txtResultado.setText("Ingresa un monto superior");
            }
        }
        if (v.getId() == btnReiniciar.getId()) {
            txtMonto.setText("");
            txtMonto.setHint("Ingrese el monto en pesos");
            txtResultado.setText("");
            txtResultado.setHint("Resultado");
            rdbDolar.setChecked(true);
        }
    }
}