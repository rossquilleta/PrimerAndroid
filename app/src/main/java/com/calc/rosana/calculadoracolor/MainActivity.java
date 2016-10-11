package com.calc.rosana.calculadoracolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean decimal, suma, resta, multiplica, divi = false;
    private EditText operando;
    private EditText visor;
    private double concatenado, resultado, concatenado2=0;
    private String numero="";

    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;

    private Button cinco;
    private Button seis;
    private Button siete;
    private Button ocho;

    private Button nueve;
    private Button cero;
    private Button igual;
    private Button reset;
    private Button coma;

    private Button sumar;
    private Button restar;
    private Button multiplicar;
    private Button dividir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.visor = (EditText) findViewById(R.id.numA);

        this.cero = (Button) findViewById(R.id.num0);
        cero.setOnClickListener(this);
        this.uno = (Button) findViewById(R.id.num1);
        uno.setOnClickListener(this);

        this.dos = (Button) findViewById(R.id.num2);
        dos.setOnClickListener(this);
        this.tres = (Button) findViewById(R.id.num3);
        tres.setOnClickListener(this);

        this.cuatro = (Button) findViewById(R.id.num4);
        cuatro.setOnClickListener(this);
        this.cinco = (Button) findViewById(R.id.num5);
        cinco.setOnClickListener(this);

        this.seis = (Button) findViewById(R.id.num6);
        seis.setOnClickListener(this);
        this.siete = (Button) findViewById(R.id.num7);
        siete.setOnClickListener(this);

        this.ocho = (Button) findViewById(R.id.num8);
        ocho.setOnClickListener(this);
        this.nueve = (Button) findViewById(R.id.num9);
        nueve.setOnClickListener(this);

        this.coma = (Button) findViewById(R.id.coma);
        coma.setOnClickListener(this);
        this.reset = (Button) findViewById(R.id.resetear);
        reset.setOnClickListener(this);

        this.sumar = (Button) findViewById(R.id.suma);
        sumar.setOnClickListener(this);
        this.restar = (Button) findViewById(R.id.resta);
        restar.setOnClickListener(this);

        this.multiplicar = (Button) findViewById(R.id.multipli);
        multiplicar.setOnClickListener(this);
        this.dividir = (Button) findViewById(R.id.div);
        dividir.setOnClickListener(this);

        this.igual = (Button) findViewById(R.id.igual);
        igual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

       numero = visor.getText().toString();

        switch (v.getId()) {

            case R.id.num0:
                visor.setText(numero + "0");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                concatenado2 = concatenado;
                concatenado=0;
                break;

            case R.id.num1:
                visor.setText(numero + "1");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num2:
                visor.setText(numero + "2");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num3:
                visor.setText(numero + "3");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num4:
                visor.setText(numero + "4");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num5:
                visor.setText(numero + "5");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num6:
                visor.setText(numero + "6");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num7:
                visor.setText(numero + "7");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num8:
                visor.setText(numero + "8");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.num9:
                visor.setText(numero + "9");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;

            case R.id.coma:
                decimal=true;
                if (decimal) {
                    visor.setText(numero + ".");
                    concatenado = Double.parseDouble(numero);
                    decimal = false;
                } else return;
                break;

            case R.id.suma:
                suma = true;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                resta=false;
                multiplica=false;
                divi=false;
                break;


            case R.id.resta:
                resta = true;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                suma=false;
                multiplica=false;
                divi=false;
                break;


            case R.id.multipli:
                multiplica = true;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                suma=false;
                divi=false;
                resta=false;
                break;

            case R.id.div:
                divi = true;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                suma=false;
                multiplica=false;
                resta=false;
                break;

            case R.id.igual:
                if (suma) {
                    resultado =resultado+concatenado;
                    visor.setText(""+resultado);
                    suma = false;
                } else if (resta) {
                    resultado =resultado-concatenado;
                    visor.setText("" + resultado);
                    resta=false;
                } else if (multiplica) {
                    resultado = resultado * concatenado;
                    visor.setText("" + resultado);
                    multiplica=false;
                } else if (divi) {
                    resultado = resultado / concatenado;
                    visor.setText("" + resultado);
                    divi=false;
                }
                break;

            case R.id.resetear:
                visor.setText("");
                break;

            default:
                visor.setText("0");

        }
    }



}

