package com.uork.uork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import classes.Usuario;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    //pass

    Button btnCadastro, loginFacebook, login, loginGoogle;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCadastro = findViewById(R.id.btnCadastro);
        loginFacebook = findViewById(R.id.loginFacebook);
        login = findViewById(R.id.login);
        loginGoogle = findViewById(R.id.loginGoogle);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
      //  btnCadastro.setOnClickListener(cadastroEmail);

        inicializarFirebase();
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(LoginActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}
