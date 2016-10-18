package com.calc.rosana.calculadoracolor;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

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

    private double concatenado, resultado=0;
    private String numero="";

    @BindView(R.id.numA) EditText visor;

    @BindView(R.id.num1) Button uno;
    @BindView(R.id.num2) Button dos;
    @BindView(R.id.num3) Button tres;
    @BindView(R.id.num4) Button cuatro;

    @BindView(R.id.num5) Button cinco;
    @BindView(R.id.num6) Button seis;
    @BindView(R.id.num7) Button siete;
    @BindView(R.id.num8) Button ocho;

    @BindView(R.id.num9) Button nueve;
    @BindView(R.id.num0) Button cero;

    @BindView(R.id.igual) Button igual;
    @BindView(R.id.resetear) Button reset;
    @BindView(R.id.coma) Button coma;

    @BindView(R.id.suma) Button sumar;
    @BindView(R.id.resta) Button restar;
    @BindView(R.id.multipli) Button multiplicar;
    @BindView(R.id.div) Button dividir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            concatenado = savedInstanceState.getDouble(CONCATENATE_VALUE, 0);
            resultado = savedInstanceState.getDouble(RESULT_VALUE, 0);
            int op = savedInstanceState.getInt(OPERATION_VALUE, -1);
            if(op > -1)
                operation = Operations.values()[op];
        }

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

    @OnClick(R.id.num1)
    public void pressNum1() {
        numero = visor.getText().toString();
        visor.setText(numero + "1");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num2)
    public void pressNum2() {
        numero = visor.getText().toString();
        visor.setText(numero + "2");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num3)
    public void pressNum3() {
        numero = visor.getText().toString();
        visor.setText(numero + "3");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num4)
    public void pressNum4() {
        numero = visor.getText().toString();
        visor.setText(numero + "4");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num5)
    public void pressNum5() {
        numero = visor.getText().toString();
        visor.setText(numero + "5");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num6)
    public void pressNum6() {
        numero = visor.getText().toString();
        visor.setText(numero + "6");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num7)
    public void pressNum7() {
        numero = visor.getText().toString();
        visor.setText(numero + "7");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num8)
    public void pressNum8() {
        numero = visor.getText().toString();
        visor.setText(numero + "8");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.num9)
    public void pressNum9() {
        numero = visor.getText().toString();
        visor.setText(numero + "9");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
    }

    @OnClick(R.id.coma)
    public void pressComa() {
        numero = visor.getText().toString();
        decimal = true;
        if (decimal){
        visor.setText(numero + ".");
        numero = visor.getText().toString();
        concatenado = Double.parseDouble(numero);
            decimal = false;
        } else return;

    }

    @OnClick(R.id.suma)
    public void pressSuma() {
        numero = visor.getText().toString();
        operation = Operations.ADD;
        visor.setText("");
        resultado=concatenado;
        decimal=false;
    }

    @OnClick(R.id.resta)
    public void pressResta() {
        numero = visor.getText().toString();
        operation = Operations.SUBSTRACT;
        visor.setText("");
        resultado=concatenado;
        decimal=false;
    }

    @OnClick(R.id.multipli)
    public void pressMult() {
        numero = visor.getText().toString();
        operation = Operations.MULTIPLY;
        visor.setText("");
        resultado=concatenado;
        decimal=false;
    }

    @OnClick(R.id.div)
    public void pressDiv(){
        numero = visor.getText().toString();
        operation = Operations.DIVIDE;
        visor.setText("");
        resultado=concatenado;
        decimal=false;
    }

    @OnClick(R.id.igual)
    public void pressIgual(){
            numero = visor.getText().toString();

            if (operation == Operations.ADD) {
                resultado = resultado+concatenado;
                visor.setText(""+resultado);
            } else if (operation == Operations.SUBSTRACT) {
                resultado = resultado-concatenado;
                visor.setText("" + resultado);
            } else if (operation == Operations.MULTIPLY) {
                resultado = resultado * concatenado;
                visor.setText("" + resultado);
            } else if (operation == Operations.DIVIDE) {
                resultado = resultado / concatenado;
                visor.setText("" + resultado);
            }
        concatenado = resultado;
            operation = null;
        }


    @OnClick(R.id.resetear)
    public void pressReset() {
                visor.setText("");
        }

}

