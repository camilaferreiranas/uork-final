package com.uork.uork;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import classes.Usuario;

public class CadastroUsuario extends AppCompatActivity {
    //EditText username, password;
    //pass

   // Button btnCadastro, loginFacebook, login, loginGoogle;
    EditText nomeUsuario, emailUsuario, senhaUsuario, nascimentoUsuario, cpfUSuario, valorUsuario;

    Button btnCadastroUsuario;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        nomeUsuario = findViewById(R.id.nomeUsuario);
        emailUsuario = findViewById(R.id.emailUsuario);
        senhaUsuario = findViewById(R.id.senhaUsuario);
        nascimentoUsuario = findViewById(R.id.nascimentoUsuario);
        cpfUSuario = findViewById(R.id.cpfUsuario);
        valorUsuario = findViewById(R.id.valorUsuario);
        btnCadastroUsuario = findViewById(R.id.btnCadastroUsuario);


        btnCadastroUsuario.setOnClickListener(cadastroEmail);
        inicializarFirebase();

    }

    private View.OnClickListener cadastroEmail = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Usuario usuario = new Usuario();
            usuario.setId_usuario(Integer.parseInt(UUID.randomUUID().toString()));
            usuario.setSenha_usuario(senhaUsuario.getText().toString());
            usuario.setEmail_usuario(emailUsuario.getText().toString());
            usuario.setCpf_usuario(Long.parseLong(cpfUSuario.getText().toString()));
            usuario.setNomecompleto_usuario(nomeUsuario.getText().toString());
            usuario.setIdade_usuario(Integer.parseInt(nascimentoUsuario.getText().toString()));
            usuario.setValorhora_usuario(Double.parseDouble(valorUsuario.getText().toString()));
            databaseReference.child("Usuario").child(String.valueOf(usuario.getId_usuario())).setValue(usuario);




        }
    };

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroUsuario.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
