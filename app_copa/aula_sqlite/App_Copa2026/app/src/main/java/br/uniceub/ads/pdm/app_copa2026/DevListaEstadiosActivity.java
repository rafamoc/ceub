package br.uniceub.ads.pdm.app_copa2026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoEstadios;

public class DevListaEstadiosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_activity_lista_estadios);

        // Mapeamento e Configuração dos Botões dos EUA
        configurarClique(R.id.btn_dev_atlanta, CodigoEstadios.ATLANTA);
        configurarClique(R.id.btn_dev_boston, CodigoEstadios.BOSTON);
        configurarClique(R.id.btn_dev_dallas, CodigoEstadios.DALLAS);
        configurarClique(R.id.btn_dev_houston, CodigoEstadios.HOUSTON);
        configurarClique(R.id.btn_dev_kansas, CodigoEstadios.KANSAS);
        configurarClique(R.id.btn_dev_miami, CodigoEstadios.MIAMI);
        configurarClique(R.id.btn_dev_novayork, CodigoEstadios.NOVA_YORK);
        configurarClique(R.id.btn_dev_filadelfia, CodigoEstadios.FILADELFIA);
        configurarClique(R.id.btn_dev_sanfrancisco, CodigoEstadios.SAN_FRANCISCO);
        configurarClique(R.id.btn_dev_seattle, CodigoEstadios.SEATTLE);

        // Mapeamento e Configuração dos Botões do CANADÁ
        configurarClique(R.id.btn_dev_toronto, CodigoEstadios.TORONTO);
        configurarClique(R.id.btn_dev_vancouver, CodigoEstadios.VANCOUVER);

        // Mapeamento e Configuração dos Botões do MÉXICO
        configurarClique(R.id.btn_dev_cidademexico, CodigoEstadios.CIDADE_MEXICO);
        configurarClique(R.id.btn_dev_guadalajara, CodigoEstadios.GUADALAJARA);
        configurarClique(R.id.btn_dev_monterrey, CodigoEstadios.MONTERREY);
    }

    /**
     * Método auxiliar para encontrar o botão, definir o listener e enviar a Enum
     * @param idButton O ID do botão no XML
     * @param codigo O valor da Enum correspondente ao estádio
     */
    private void configurarClique(int idButton, final CodigoEstadios codigo) {
        Button btn = findViewById(idButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criando a Intent para a próxima Activity
                // Obs: A classe DetalheEstadioActivity será criada no próximo passo
                Intent intent = new Intent(DevListaEstadiosActivity.this, DetalhaEstadioActivity.class);

                // Criando o Bundle para passar a Enum
                Bundle parametros = new Bundle();
                parametros.putSerializable("ESTADIO_SELECIONADO", codigo);

                // Adicionando o Bundle na Intent
                intent.putExtras(parametros);

                // Iniciando a Activity
                startActivity(intent);
            }
        });
    }
}