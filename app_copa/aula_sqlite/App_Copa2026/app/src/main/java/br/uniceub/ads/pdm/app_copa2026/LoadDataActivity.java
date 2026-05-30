package br.uniceub.ads.pdm.app_copa2026;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class LoadDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_data);

        // Handler para aguardar 1000 milissegundos (1 segundo)
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cria a intenção para abrir a HomeActivity
                Intent intent = new Intent(LoadDataActivity.this, HomeActivity.class);
                startActivity(intent);

                // Finaliza a LoadActivity para que o usuário não volte para ela ao apertar "Voltar"
                finish();
            }
        }, 1000);
    }
}