package com.uork.uork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Proposta extends AppCompatActivity implements View.OnClickListener {
    TextView titulo_proposta, descricao_proposta, orcamento_proposta, local_servico;
    ImageView foto_servico;
    Button btnEnviarProposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposta);
        titulo_proposta = findViewById(R.id.tituloProposta);
        descricao_proposta = findViewById(R.id.descricaoProposta);
        orcamento_proposta = findViewById(R.id.orcamentoProposta);
        local_servico = findViewById(R.id.orcamentoProposta);
        foto_servico = findViewById(R.id.fotoServico);
        btnEnviarProposta = findViewById(R.id.btnEnviarProposta);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviarProposta) {
            //toast e envio proposta
        } else {
            //toast erro
        }
    }
}
