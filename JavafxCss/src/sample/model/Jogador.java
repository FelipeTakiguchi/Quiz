package sample.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Jogador implements Serializable {
    private int codigo;
    private String nome;
    private int maiorPontuacao;
    private Date ultimaJogada;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Jogador(int codigo, String nome, int maiorPontuacao, Date ultimaJogada) {
        this.codigo = codigo;
        this.nome = nome;
        this.maiorPontuacao = maiorPontuacao;
        this.ultimaJogada = ultimaJogada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaiorPontuacao() {
        return maiorPontuacao;
    }

    public void setMaiorPontuacao(int maiorPontuacao) {
        this.maiorPontuacao = maiorPontuacao;
    }

    public Date getUltimaJogada() {
        return ultimaJogada;
    }

    public void setUltimaJogada(Date ultimaJogada) {

        this.ultimaJogada = ultimaJogada;
    }

    @Override
    public String toString() {
        return nome +"\t\t"+
                maiorPontuacao;
    }


}
