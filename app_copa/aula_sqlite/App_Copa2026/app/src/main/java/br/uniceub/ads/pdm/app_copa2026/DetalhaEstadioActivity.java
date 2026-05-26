package br.uniceub.ads.pdm.app_copa2026;

import android.os.Bundle;
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
    private EstadioModel estadioModel;

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
    }

    private void inicializarComponentes() {
        imgEstadio = findViewById(R.id.img_detalhe_estadio);
        txtNome = findViewById(R.id.txt_detalhe_nome);
        txtLocal = findViewById(R.id.txt_detalhe_local);
        txtDescricao = findViewById(R.id.txt_detalhe_descricao);
        txtCapacidade = findViewById(R.id.txt_detalhe_capacidade);
        txtData = findViewById(R.id.txt_detalhe_data);
    }

    private void preencherCampos(EstadioPojo estadio) {
        txtNome.setText(estadio.getNome());
        txtLocal.setText(estadio.getLocal());
        txtDescricao.setText(estadio.getDescricao() != null ? estadio.getDescricao() : "Descrição não disponível.");
        txtCapacidade.setText(estadio.getCapacidade() > 0 ? String.valueOf(estadio.getCapacidade()) : "Não informada");
        txtData.setText(estadio.getDataFundacao() != null ? estadio.getDataFundacao() : "Não informada");

        // 5. Lógica para carregar a imagem do Drawable dinamicamente
        int resId = getResources().getIdentifier(
                estadio.getImagem(),
                "drawable",
                getPackageName()
        );

        if (resId != 0) {
            imgEstadio.setImageResource(resId);
        } else {
            // Caso a imagem não exista na pasta drawable, define uma imagem padrão de erro
            imgEstadio.setImageResource(android.R.drawable.ic_menu_report_image);
        }
    }
}