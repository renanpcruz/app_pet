package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        // Referências aos campos
        EditText editTextNome = findViewById(R.id.edtNome);
        Spinner spinnerFoto = findViewById(R.id.spnFoto);
        Button buttonGerar = findViewById(R.id.btnGerar);

        // Configuração do Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opcoes_foto, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFoto.setAdapter(adapter);

        // Configuração do botão Gerar
        buttonGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recupera o nome digitado
                String nomeUsuario = editTextNome.getText().toString();

                // Recupera a seleção do Spinner
                String selecao = spinnerFoto.getSelectedItem().toString();

                // Envia o nome e a seleção para a tela pet
                Intent intent = new Intent(principal.this, pet.class);
                intent.putExtra("nome_usuario", nomeUsuario);
                intent.putExtra("selecao_foto", selecao);
                startActivity(intent);
            }
        });
    }
}
