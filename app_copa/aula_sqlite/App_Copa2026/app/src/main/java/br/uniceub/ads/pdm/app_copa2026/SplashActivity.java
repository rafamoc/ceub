package br.uniceub.ads.pdm.app_copa2026;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import br.uniceub.ads.pdm.app_copa2026.model.ConfiguracaoModel;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define o layout que contém a logo_splash
        setContentView(R.layout.activity_splash);

        // Handler atualizado para 3 segundos (3000 milissegundos)
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                verificarDirecionamento();
            }
        }, 3000);
    }

    private void verificarDirecionamento() {
        ConfiguracaoModel model = new ConfiguracaoModel(this);
        Intent intent;

        // Lógica de verificação no banco de dados
        if (model.isLinguaDefinida()) {
            // Se já existe uma língua no banco, vai para a carga de dados
            intent = new Intent(SplashActivity.this, LoadDataActivity.class);
        } else {
            // Se o campo id_lingua_selecionada for NULL, vai para seleção
            intent = new Intent(SplashActivity.this, SelecionarLinguaActivity.class);
        }

        startActivity(intent);

        // Finaliza a Splash para que ela não fique na pilha de atividades
        finish();
    }
}