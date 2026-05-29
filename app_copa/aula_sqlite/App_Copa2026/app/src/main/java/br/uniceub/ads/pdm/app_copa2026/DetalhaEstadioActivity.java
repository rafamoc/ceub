package br.uniceub.ads.pdm.app_copa2026;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.uniceub.ads.pdm.app_copa2026.model.EstadioModel;
import br.uniceub.ads.pdm.app_copa2026.pojo.EstadioPojo;
import br.uniceub.ads.pdm.app_copa2026.utilitarios.Codificacoes.CodigoEstadios;

public class DetalhaEstadioActivity extends AppCompatActivity {

    private ImageView imgEstadio;
    private TextView txtNome, txtLocal, txtDescricao, txtCapacidade, txtData;
    private Button btnAbrirMaps;
    private EstadioModel estadioModel;
    private String urlMaps; // Variável para armazenar o link vindo do banco

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_estadio);

        // 1. Inicializar componentes da tela
        inicializarComponentes();

        // 2. Recuperar o parâmetro enviado pela DevListaEstadiosActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            CodigoEstadios codigoRecebido = (CodigoEstadios) extras.getSerializable("ESTADIO_SELECIONADO");

            if (codigoRecebido != null) {
                // 3. Consultar o banco de dados via Model
                estadioModel = new EstadioModel(this);
                EstadioPojo estadio = estadioModel.getEstadioByCodigo(codigoRecebido);

                if (estadio != null) {
                    // 4. Popular os campos da tela com os dados do POJO
                    preencherCampos(estadio);
                } else {
                    Toast.makeText(this, "Erro: Estádio não encontrado no banco.", Toast.LENGTH_LONG).show();
                }
            }
        }

        // 5. Configurar o clique do botão do Maps
        btnAbrirMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlMaps != null && !urlMaps.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlMaps));
                    startActivity(intent);
                } else {
                    Toast.makeText(DetalhaEstadioActivity.this, "Link do Maps não disponível.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarComponentes() {
        imgEstadio = findViewById(R.id.img_detalhe_estadio);
        txtNome = findViewById(R.id.txt_detalhe_nome);
        txtLocal = findViewById(R.id.txt_detalhe_local);
        txtDescricao = findViewById(R.id.txt_detalhe_descricao);
        txtCapacidade = findViewById(R.id.txt_detalhe_capacidade);
        txtData = findViewById(R.id.txt_detalhe_data);
        btnAbrirMaps = findViewById(R.id.btn_abrir_maps);
    }

    private void preencherCampos(EstadioPojo estadio) {
        txtNome.setText(estadio.getNome());
        txtLocal.setText(estadio.getLocal());
        txtDescricao.setText(estadio.getDescricao() != null ? estadio.getDescricao() : "Descrição não disponível.");
        txtCapacidade.setText(estadio.getCapacidade() > 0 ? String.format("%,d", estadio.getCapacidade()) + " pessoas" : "Não informada");
        txtData.setText(estadio.getDataFundacao() != null ? estadio.getDataFundacao() : "Não informada");

        // Guarda a URL do Maps para usar no clique do botão
        urlMaps = estadio.getLinkMaps();

        // Lógica para carregar a imagem do Drawable dinamicamente
        // Nota: O banco agora traz "estadio1_toronto.png", precisamos remover a extensão se ela existir
        String nomeImagem = estadio.getImagem();
        if (nomeImagem != null && nomeImagem.contains(".png")) {
            nomeImagem = nomeImagem.replace(".png", "");
        }

        int resId = getResources().getIdentifier(
                nomeImagem,
                "drawable",
                getPackageName()
        );

        if (resId != 0) {
            imgEstadio.setImageResource(resId);
        } else {
            // Imagem padrão caso o recurso não seja encontrado
            imgEstadio.setImageResource(android.R.drawable.ic_menu_report_image);
        }
    }
}