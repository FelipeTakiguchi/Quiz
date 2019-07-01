package sample.model;

import java.util.ArrayList;

public class Pergunta {
    private String enunciado;
    private ArrayList<String> opcoes;
    private int correta;

    public Pergunta(String enunciado, ArrayList<String> opcoes, int correta) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.correta = correta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public ArrayList<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    public int getCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    @Override
    public String toString() {
        return "Pergunta{" +
                "enunciado='" + enunciado + '\'' +
                ", opcoes=" + opcoes +
                ", correta=" + correta +
                '}';
    }
}
