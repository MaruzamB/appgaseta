package com.maruzamjunior.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.maruzamjunior.appgaseta.R;
import com.maruzamjunior.appgaseta.controller.CombustivelController;
import com.maruzamjunior.appgaseta.database.GasetaDB;
import com.maruzamjunior.appgaseta.model.Combustivel;
import com.maruzamjunior.appgaseta.util.UtilGasEta;

import java.util.List;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;

    Combustivel combustivelEtanol;
    Combustivel combustivelGasolina;


    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);

        dados = controller.getListaDeDados();

        Combustivel objAlteracao = dados.get(1);
        objAlteracao.setNomeCombustivel("GASOLINA**ADULTERADA");
        objAlteracao.setPrecoCombustivel(1.99);
        objAlteracao.setRecomendacao("**NÃO**COMPRE**");

        controller.alterar(objAlteracao);


        editEtanol = findViewById(R.id.editEtanol);
        editGasolina = findViewById(R.id.editGasolina);

        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("*OBRIGATÓRIO*");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if (TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("*OBRIGATÓRIO*");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if(isDadosOk){
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());
                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);
                }
                else {
                    Toast.makeText(GasEtaActivity.this,
                            "Atenção verifique os dados digitados",
                            Toast.LENGTH_LONG).show();

                    btnSalvar.setEnabled(false);
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editEtanol.setText("");
                editGasolina.setText("");

                btnSalvar.setEnabled(false);

                controller.limpar();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelEtanol.setNomeCombustivel("Etanol");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);

                combustivelGasolina.setNomeCombustivel("Gasolina");
                combustivelGasolina.setPrecoCombustivel(precoGasolina);

                combustivelGasolina.setRecomendacao
                        (UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                combustivelEtanol.setRecomendacao
                        (UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol));

                controller.salvar(combustivelEtanol);
                controller.salvar(combustivelGasolina);



            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this,
                        "Obrigado por usar o Aplicativo GasEta",
                        Toast.LENGTH_LONG).show();
                finish();

            }
        });

        Toast.makeText(GasEtaActivity.this,
                UtilGasEta.calcularMelhorOpcao(5.12, 3.29),
                Toast.LENGTH_LONG).show();
    }
}
