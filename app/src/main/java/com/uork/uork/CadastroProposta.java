package com.uork.uork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classes.Proposta;

public class CadastroProposta extends AppCompatActivity {
    Button enviarProposta;
    EditText tituloProposta, descricaoProposta, orcamentoProposta, localProposta;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_proposta);
        enviarProposta = findViewById(R.id.enviarProposta);
        tituloProposta = findViewById(R.id.tituloProposta);
        descricaoProposta = findViewById(R.id.descricaoProposta);
        orcamentoProposta = findViewById(R.id.orcamentoProposta);
        localProposta = findViewById(R.id.localProposta);

        enviarProposta.setOnClickListener(cadastroproposta);

        inicializarFirebase();
    }

    private View.OnClickListener cadastroproposta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Proposta proposta = new Proposta();
            proposta.setTitulo_proposta(tituloProposta.getText().toString());
            proposta.setDescricao_proposta(descricaoProposta.getText().toString());
            proposta.setOrcamento_proposta(Double.parseDouble(orcamentoProposta.getText().toString()));
            proposta.setLocal_servico(localProposta.getText().toString());
            databaseReference.child("Proposta").child(String.valueOf(proposta.getId_proposta())).setValue(proposta);

        }
    };

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroProposta.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}
