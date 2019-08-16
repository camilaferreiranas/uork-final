package com.uork.uork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classes.Proposta;

public class PerfilEmpresa extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Proposta propostaSelecionada;
    EditText tituloProposta, descricaoProposta, orcamentoProposta, localProposta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_empresa);
        tituloProposta = findViewById(R.id.tituloProposta);
        descricaoProposta = findViewById(R.id.descricaoProposta);
        orcamentoProposta = findViewById(R.id.orcamentoProposta);
        localProposta = findViewById(R.id.localProposta);
       Proposta proposta = new Proposta();
       inicializarFirebase();
       //exclusão
       proposta.setId_proposta(propostaSelecionada.getId_proposta());
       databaseReference.child("Proposta").child(String.valueOf(proposta.getId_proposta())).removeValue();


       //edição

       proposta.setId_proposta(propostaSelecionada.getId_proposta());
       proposta.setTitulo_proposta(tituloProposta.getText().toString().trim());
       proposta.setDescricao_proposta(descricaoProposta.getText().toString().trim());
       proposta.setOrcamento_proposta(Double.parseDouble(orcamentoProposta.getText().toString().trim()));
       proposta.setLocal_servico(localProposta.getText().toString().trim());
       databaseReference.child("Proposta").child(String.valueOf(proposta.getId_proposta())).setValue(proposta);





    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(PerfilEmpresa.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
