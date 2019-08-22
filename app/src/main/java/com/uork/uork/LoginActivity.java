package com.uork.uork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import classes.Usuario;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;

    FirebaseAuth mAuth;

    //private ViewHolder mViewHolder = new ViewHolder();
    Button btnCadastro, loginFacebook, login, loginGoogle;
    //TextView username, password;

/*
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
*/


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

        mAuth = FirebaseAuth.getInstance();
      //  btnCadastro.setOnClickListener(cadastroEmail);

       // inicializarFirebase();
    }
    /*
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(LoginActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

*/

   /* private void abrirCadastro() {

    }

    private void loginGoogle() {

    }

    private void loginFacebook () {

    }*/


    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnCadastro) {
            //ajustar, o valor que será recebido da prompt que irá definir se será cadastro de usuário ou empresa
            Intent intent = new Intent(this, CadastroUsuario.class);
            startActivity(intent);
        } else if(v.getId()== R.id.loginFacebook) {
            //ações facebook
        } else if(v.getId() == R.id.loginGoogle) {
            //ações google
        } else if(v.getId() == R.id.login) {
            //ações auth email
            loginUsuarioEmail();

        }
    }

    private void loginUsuarioEmail() {
        String email, senha;
        email = username.getText().toString();
        senha = password.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Todos campos devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(senha)) {
            Toast.makeText(getApplicationContext(), "Todos campos devem ser preenchidos", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Bem vindo!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login inválido.Cheque suas informações.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



}
