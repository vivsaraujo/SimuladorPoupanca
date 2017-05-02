package com.example.vivian.simuladorpoupanca;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tx_1;
    private TextView tx_2;
    private TextView tx_3;
    private TextView tx_4;

    private EditText edt_valor_inicial;
    private EditText edt_aplicacao_mensal;
    private EditText edt_tempo_aplicacao;
    private EditText edt_taxa;

    private Button bt_calcular;

    double resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tx_1 = (TextView) findViewById(R.id.tx_1);
        tx_2 = (TextView) findViewById(R.id.tx_2);
        tx_3 = (TextView) findViewById(R.id.tx_3);
        tx_4 = (TextView) findViewById(R.id.tx_4);
        edt_valor_inicial = (EditText) findViewById(R.id.edt_valor_inicial);
        edt_aplicacao_mensal = (EditText) findViewById(R.id.edt_aplicacao_mensal);
        edt_tempo_aplicacao = (EditText) findViewById(R.id.edt_tempo_aplicacao);
        edt_taxa = (EditText) findViewById(R.id.edt_taxa);
        bt_calcular = (Button) findViewById(R.id.bt_calcular);

        tx_1.setText("Valor Inicial:");
        tx_2.setText("Aplicação Mensal");
        tx_3.setText("Tempo de Aplicação");
        tx_4.setText("Taxa");
        bt_calcular.setText("Calcular");

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calcularResultado();

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Montante Final Aplicado!");
                alert.setIcon(R.drawable.ic_poupanca);
                alert.setMessage("Saldo Atual em R$: " + String.format("%.2f", resultado));
                alert.setPositiveButton("Ok", null);
                alert.show();

            }
        });

    }

    public double calcularResultado(){

        double valorInicial = Double.parseDouble(edt_valor_inicial.getText().toString());
        double valorAplicacao = Double.parseDouble(edt_aplicacao_mensal.getText().toString());
        Integer tempoAplicacao = Integer.parseInt(edt_tempo_aplicacao.getText().toString());
        double taxa = Double.parseDouble(edt_taxa.getText().toString());

        resultado = valorInicial + (valorAplicacao*tempoAplicacao) + ((valorAplicacao*tempoAplicacao)*taxa);
        return resultado;
    }
}
