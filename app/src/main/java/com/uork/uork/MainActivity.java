package com.uork.uork;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import classes.Proposta;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private List<Proposta> listaProposta = new ArrayList<Proposta>();
    private ArrayAdapter<Proposta> arrayAdapterProposta;
    ListView listaPropostas;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Proposta propostaSelecionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPropostas = findViewById(R.id.listaPropostas);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        listaPropostas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //utilizar para chamar a activity proposta 
                propostaSelecionada = (Proposta)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if (user == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        inicializarFirebase();
        eventoDatabase();



    }

    private void eventoDatabase() {

        databaseReference.child("Proposta").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //limpeza
            listaProposta.clear();

            //laço de repetição para mostrar  todos os dados
            for (DataSnapshot objSnapshot:dataSnapshot.getChildren()) {
                Proposta p = objSnapshot.getValue(Proposta.class);
                listaProposta.add(p);
            }

            arrayAdapterProposta = new ArrayAdapter<Proposta>(MainActivity.this, android.R.layout.simple_list_item_1, listaProposta);
            listaPropostas.setAdapter(arrayAdapterProposta);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //permissão para salvar os arquivos dentro da nuvem e no próprio app
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }
}
