package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("Pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("Papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView escolhaApp = findViewById(R.id.escolhaApp);
        TextView resultado = findViewById(R.id.Resultado);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoes = {"Pedra","Papel","Tesoura"};
        String opcaoApp = opcoes [numero];

        switch(opcaoApp){
            case "Pedra":
                escolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                escolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                escolhaApp.setImageResource(R.drawable.tesoura);
                break;
        }

        if( //App ganhador
                (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel") ||
                (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura")
        ){
            resultado.setText("Você perdeu!");
        } else if ( //Usuario ganhador
                (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel") ||
                (opcaoSelecionada == "Papel" && opcaoApp == "Pedra") ||
                (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura")
        ){
            resultado.setText("Você ganhou!");
        }else {
            resultado.setText("Empatamos!");
        }
    }
}