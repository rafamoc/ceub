package br.uniceub.ads.pdm.app_copa2026.pojo;

import java.io.Serializable;

public class GrupoPojo implements Serializable {
    private int id;
    private String nome;

    public GrupoPojo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome; // Útil para exibir em Spinners futuramente
    }
}