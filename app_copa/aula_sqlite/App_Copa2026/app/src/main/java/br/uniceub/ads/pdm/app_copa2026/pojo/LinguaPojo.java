package br.uniceub.ads.pdm.app_copa2026.pojo;

import java.io.Serializable;

public class LinguaPojo implements Serializable {
    private int id;
    private int codigoLinguaEnum;
    private String nome;
    private String mensagemBoasVindas;

    public LinguaPojo() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCodigoLinguaEnum() { return codigoLinguaEnum; }
    public void setCodigoLinguaEnum(int codigoLinguaEnum) { this.codigoLinguaEnum = codigoLinguaEnum; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMensagemBoasVindas() { return mensagemBoasVindas; }
    public void setMensagemBoasVindas(String mensagemBoasVindas) { this.mensagemBoasVindas = mensagemBoasVindas; }
}