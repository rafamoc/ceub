package br.uniceub.ads.pdm.app_copa2026;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import br.uniceub.ads.pdm.app_copa2026.model.GrupoSelecaoModel;
import br.uniceub.ads.pdm.app_copa2026.pojo.GrupoSelecaoPojo;

public class HomeActivity extends AppCompatActivity {

    private GrupoSelecaoModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        model = new GrupoSelecaoModel(this);

        // Populando cada um dos 12 grupos
        for (int i = 1; i <= 12; i++) {
            // Busca o TableLayout pelo ID dinamicamente
            int resId = getResources().getIdentifier("table_grupo_" + i, "id", getPackageName());
            TableLayout table = findViewById(resId);

            if (table != null) {
                preencherTabelaGrupo(table, i);
            }
        }
    }

    private void preencherTabelaGrupo(TableLayout table, int idGrupo) {
        // 1. Limpa a tabela se houver algo e adiciona o cabeçalho
        table.removeAllViews();
        adicionarCabecalho(table);

        // 2. Busca os dados do banco usando o Model (que já faz o JOIN e ORDER BY)
        List<GrupoSelecaoPojo> lista = model.listarClassificacaoPorGrupo(idGrupo);

        // 3. Itera sobre a lista e cria as linhas "na unha"
        for (GrupoSelecaoPojo p : lista) {
            adicionarLinhaSelecao(table, p);
        }
    }

    private void adicionarCabecalho(TableLayout table) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.LTGRAY);

        header.addView(criarTextView("Seleção", true));
        header.addView(criarTextView("P", true));
        header.addView(criarTextView("J", true));
        header.addView(criarTextView("V", true));
        header.addView(criarTextView("E", true));
        header.addView(criarTextView("D", true));
        header.addView(criarTextView("GP", true));
        header.addView(criarTextView("GC", true));
        header.addView(criarTextView("SG", true));

        table.addView(header);
    }

    private void adicionarLinhaSelecao(TableLayout table, GrupoSelecaoPojo p) {
        TableRow row = new TableRow(this);
        row.setPadding(0, 8, 0, 8);

        // Nome da Seleção (ou Sigla)
        row.addView(criarTextView(p.getNomeSelecao(), false));
        // Pontos
        row.addView(criarTextView(String.valueOf(p.getPontos()), false));
        // Jogos
        row.addView(criarTextView(String.valueOf(p.getJogos()), false));
        // Vitórias
        row.addView(criarTextView(String.valueOf(p.getVitorias()), false));
        // Empates
        row.addView(criarTextView(String.valueOf(p.getEmpates()), false));
        // Derrotas
        row.addView(criarTextView(String.valueOf(p.getDerrotas()), false));
        // Gols Pró
        row.addView(criarTextView(String.valueOf(p.getGolsPro()), false));
        // Gols Contra
        row.addView(criarTextView(String.valueOf(p.getGolsContra()), false));
        // Saldo
        row.addView(criarTextView(String.valueOf(p.getSaldoGols()), false));

        table.addView(row);
    }

    // Método utilitário para criar os TextViews das células
    private TextView criarTextView(String texto, boolean isHeader) {
        TextView tv = new TextView(this);
        tv.setText(texto);
        tv.setPadding(10, 5, 10, 5);
        tv.setTextSize(14);

        if (isHeader) {
            tv.setTypeface(null, Typeface.BOLD);
        }

        return tv;
    }
}