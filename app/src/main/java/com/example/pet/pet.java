package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class pet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet);

        // Referências aos campos
        TextView textViewNome = findViewById(R.id.tvNome);
        ImageView imageViewFoto = findViewById(R.id.ivFoto);
        Button buttonRetornar = findViewById(R.id.btnRetornar);

        // Recebe os dados da MainActivity
        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome_usuario");
        String selecaoFoto = intent.getStringExtra("selecao_foto");

        // Exibe o nome na TextView
        textViewNome.setText(nome);

        // Lógica para escolher uma imagem aleatória
        Random rand = new Random();
        if (selecaoFoto.equals("Cachorro")) {
            int[] imagensCachorro = {R.drawable.cachorro1, R.drawable.cachorro2, R.drawable.cachorro3};
            int randomIndex = rand.nextInt(imagensCachorro.length);
            imageViewFoto.setImageResource(imagensCachorro[randomIndex]);
        } else if (selecaoFoto.equals("Gato")) {
            int[] imagensGato = {R.drawable.gato1, R.drawable.gato2, R.drawable.gato3};
            int randomIndex = rand.nextInt(imagensGato.length);
            imageViewFoto.setImageResource(imagensGato[randomIndex]);
        }

        // Configuração do botão Retornar
        buttonRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finaliza a activity e volta para a principal
            }
        });
    }
}
