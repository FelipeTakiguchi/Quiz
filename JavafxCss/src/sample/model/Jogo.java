package sample.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.control.Notifications;

import java.io.*;
import java.util.ArrayList;

public class Jogo extends Notifications {

    private static String FILE_JOGADORES="C:\\Users\\felip\\IdeaProjects\\TrabQuiz\\jogadores.bin";
    private static String FILE_PERGUNTAS="C:\\Users\\felip\\IdeaProjects\\TrabQuiz\\perguntas.txt";

    private ObservableList<Jogador> jogadores;
    private ObservableList<Pergunta> perguntas;
    private Jogador jogadorLogado;
    private int pontuacao = 0;


    private static Jogo instance = new Jogo();

    public void ordenarJogadores(){

        Jogador temp;
        Jogador pos;

        System.out.println(jogadores.size());

        for(int i = 0; i < jogadores.size(); i++)
        {
            if(i > 0) {
                temp = jogadores.get(i - 1);
                pos = jogadores.get(i);

                if (temp.getMaiorPontuacao() < jogadores.get(i).getMaiorPontuacao()) {
                    jogadores.remove(i);
                    jogadores.remove(temp);
                    jogadores.add(i-1, pos);
                    jogadores.add(i, temp);
                    i = -1;
                }
            }
        }
    }

    public void  encerraJogada() throws IOException{

        if(jogadorLogado.getMaiorPontuacao() < pontuacao){
            jogadorLogado.setMaiorPontuacao(pontuacao);
        }

        DateFormat ultimaJogada = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date();

        ultimaJogada.format(data);

        for (Jogador j:jogadores) {
            if(j.equals(jogadorLogado)){
                j.setUltimaJogada(data);
            }
        }

        jogadorLogado.setUltimaJogada(data);
        pontuacao = 0;

        salvarJogadores();

    }

    public ObservableList<Pergunta> getPerguntas() {
        carregaPerguntas();
        System.out.println("perguntas:"+ perguntas);
        return perguntas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Jogador getJogadorLogado() {
        return jogadorLogado;
    }

    public void setJogadorLogado(Jogador jogadorLogado) {
        this.jogadorLogado = jogadorLogado;
    }

    private Jogo(){
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();

    }

    public static Jogo getInstance(){
        return instance;
    }

    public void cadastrarJogador(Jogador j){

        jogadorLogado = j;
        jogadores.add(j);
    }

    public void carregaPerguntas(){
        ArrayList<Pergunta> aux = new ArrayList<>();

        Random random = new Random();

        String enunciado;


        int correta;

        int numPerguntas, rand, numOpcoes;

        try(FileReader f = new FileReader(FILE_PERGUNTAS);
            BufferedReader br = new BufferedReader(f)){

            numPerguntas = Integer.valueOf(br.readLine());
            numOpcoes= Integer.valueOf(br.readLine());

            for(int i =0; i<numPerguntas;i++){
                ArrayList<String> opcoes = new ArrayList<>();

                enunciado = br.readLine();
                for(int j = 0; j<numOpcoes; j++){
                    opcoes.add(br.readLine());
                }

                correta = Integer.valueOf(br.readLine());

                Pergunta p = new Pergunta(enunciado, opcoes,correta);

                aux.add(p);
            }

            do{
                for(int j=0; j<numPerguntas; j++){
                    rand = random.nextInt(numPerguntas);
                    if(j == rand){
                        if(!perguntas.contains(aux.get(j))){
                            perguntas.add(aux.get(j));

                        }
                    }
                }


            }while(perguntas.size()<10);
        }
        catch (IOException e){
            System.out.println(e);
        }

    }


    public void carregaJogadores() throws IOException, ClassNotFoundException{
        jogadores.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(FILE_JOGADORES)
                )
        );

        ArrayList<Jogador> temp = (ArrayList)ois.readObject();

        jogadores.addAll(temp);

        ois.close();
    }

    public void salvarJogadores() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(FILE_JOGADORES))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();
    }

    public void marcaPontos(int confirma){
        if(confirma == 1){
            pontuacao = pontuacao+3;

        }
        else if(confirma == 2){
            pontuacao = pontuacao-1;

        }
    }

    public boolean verificaJogadores(String nome){
        for(Jogador j: jogadores)
        {
            if(j.getNome().equals(nome))
            {
                jogadorLogado = j;
                return true;
            }
        }

        return false;
    }


    public ObservableList<Jogador> getJogador()
    {
        ordenarJogadores();
        return jogadores;
    }
}
