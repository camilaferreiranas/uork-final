package com.uork.uork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import classes.Empresa;

public class CadastroEmpresa extends AppCompatActivity {

    EditText cnpj_empresa, nome_empresa, email_empresa, senha_empresa;
    Button btnCadastroEmpresa;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);

        cnpj_empresa = findViewById(R.id.cnpj_empresa);
        nome_empresa = findViewById(R.id.nome_empresa);
        email_empresa = findViewById(R.id.email_empresa);
        senha_empresa = findViewById(R.id.senha_empresa);
        btnCadastroEmpresa = findViewById(R.id.btnCadastroEmpresa);



        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroEmpresa.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private View.OnClickListener cadastroEmpresa = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Empresa empresa = new Empresa();
            empresa.setCnpj_empresa(Long.parseLong(cnpj_empresa.getText().toString()));
            empresa.setNome_empresa(nome_empresa.getText().toString());
            empresa.setEmail_empresa(email_empresa.getText().toString());
            empresa.setSenha_empresa(senha_empresa.getText().toString());
            databaseReference.child("Empresa").child(String.valueOf(empresa.getId_empresa())).setValue(empresa);


        }
    };
}
