package com.uork.uork;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import classes.SharedPrefManager;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {
    EditText username, password;
    private static  final String TAG = "LoginActivity";
    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth.AuthStateListener  mAuthListener;
    private static final int RC_SIGN_IN = 9001;
    private String idToken;
    public SharedPrefManager sharedPrefManager;
    private final Context mContext = this;
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
        configureSignIn();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@android.support.annotation.NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    createUserInFirebaseHelper();
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
        mAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
       // inicializarFirebase();
    }

    private void createUserInFirebaseHelper() {

    }

    private void configureSignIn() {
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


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
