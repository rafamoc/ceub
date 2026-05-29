package br.uniceub.ads.pdm.app_copa2026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import br.uniceub.ads.pdm.app_copa2026.model.ConfiguracaoModel;
import br.uniceub.ads.pdm.app_copa2026.model.LinguaModel;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoLingua;

public class SelecionarLinguaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_lingua);

        // Configuração dos ouvintes para cada botão
        configurarBotao(R.id.btn_pt, CodigoLingua.PORTUGUES);
        configurarBotao(R.id.btn_en, CodigoLingua.INGLES);
        configurarBotao(R.id.btn_es, CodigoLingua.ESPANHOL);
        configurarBotao(R.id.btn_fr, CodigoLingua.FRANCES);
        configurarBotao(R.id.btn_de, CodigoLingua.ALEMAO);
        configurarBotao(R.id.btn_ru, CodigoLingua.RUSSO);
        configurarBotao(R.id.btn_it, CodigoLingua.ITALIANO);
        configurarBotao(R.id.btn_jp, CodigoLingua.JAPONES);
    }

    private void configurarBotao(int idBotao, final CodigoLingua linguaEnum) {
        Button btn = findViewById(idBotao);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processarEscolhaIdioma(linguaEnum);
            }
        });
    }

    private void processarEscolhaIdioma(CodigoLingua linguaEnum) {
        // 1. Recuperar a chave primária (ID) através do LinguaModel
        LinguaModel linguaModel = new LinguaModel(this);
        int idLinguaNoBanco = linguaModel.getIdLinguaPeloCodigo(linguaEnum);

        if (idLinguaNoBanco != -1) {
            // 2. Gravar o ID na tabela Configuracao através do ConfiguracaoModel
            ConfiguracaoModel configModel = new ConfiguracaoModel(this);
            configModel.salvarLinguaSelecionada(idLinguaNoBanco);

            Toast.makeText(this, "Idioma salvo com sucesso!", Toast.LENGTH_SHORT).show();

            // 3. Prosseguir para a LoadDataActivity
            Intent intent = new Intent(this, LoadDataActivity.class);
            startActivity(intent);
            finish(); // Fecha esta tela para não voltar ao botão de "back"
        } else {
            Toast.makeText(this, "Erro ao localizar idioma no banco.", Toast.LENGTH_SHORT).show();
        }
    }
}