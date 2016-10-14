package com.calc.rosana.calculadoracolor;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CONCATENATE_VALUE = "concatenado";
    private static final String RESULT_VALUE = "resultado";
    private static final String OPERATION_VALUE = "operacion";
    public enum Operations {
        ADD,
        SUBSTRACT,
        MULTIPLY,
        DIVIDE
    }
    boolean decimal = false;
    private Operations operation;

    private double concatenado, resultado, concatenado2=0;
    private String numero="";

    @BindView(R.id.numA) EditText visor;
    private EditText operando;

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

        if (savedInstanceState != null) {
            concatenado = savedInstanceState.getDouble(CONCATENATE_VALUE, 0);
            resultado = savedInstanceState.getDouble(RESULT_VALUE, 0);
            int op = savedInstanceState.getInt(OPERATION_VALUE, -1);
            if(op > -1)
                operation = Operations.values()[op];
        }

        //this.visor = (EditText) findViewById(R.id.numA);

        this.cero = (Button) findViewById(R.id.num0);
        //cero.setOnClickListener(this);
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
    protected void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save our own state now
        if(operation != null)
            outState.putSerializable(OPERATION_VALUE, operation.ordinal());

        outState.putSerializable(CONCATENATE_VALUE, concatenado);
        outState.putSerializable(RESULT_VALUE, resultado);
    }

    @OnClick(R.id.num0)
    public void pressNum0() {
        numero = visor.getText().toString();
        visor.setText(numero + "0");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @Override
    public void onClick(View v) {

       numero = visor.getText().toString();

        switch (v.getId()) {

            /*case R.id.num0:
                visor.setText(numero + "0");
                numero = visor.getText().toString();
                concatenado = Double.parseDouble(numero);
                break;*/

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
                operation = Operations.ADD;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                break;


            case R.id.resta:
                operation = Operations.SUBSTRACT;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                break;


            case R.id.multipli:
                operation = Operations.MULTIPLY;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                break;

            case R.id.div:
                operation = Operations.DIVIDE;
                resultado=concatenado;
                visor.setText("");
                decimal = false;
                break;

            case R.id.igual:
                if (operation == Operations.ADD) {
                    resultado =resultado+concatenado;
                    visor.setText(""+resultado);
                } else if (operation == Operations.SUBSTRACT) {
                    resultado =resultado-concatenado;
                    visor.setText("" + resultado);
                } else if (operation == Operations.MULTIPLY) {
                    resultado = resultado * concatenado;
                    visor.setText("" + resultado);
                } else if (operation == Operations.DIVIDE) {
                    resultado = resultado / concatenado;
                    visor.setText("" + resultado);
                }
                operation = null;
                break;

            case R.id.resetear:
                visor.setText("");
                break;

            default:
                visor.setText("0");

        }
    }



}

