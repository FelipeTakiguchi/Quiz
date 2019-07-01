package sample.control;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sample.NavegadorJanelas;
import sample.model.Jogador;
import sample.model.Jogo;
import sample.model.Pergunta;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Menu extends Notifications {

    @FXML
    private ComboBox cbDificuldade;

    @FXML
    private Label lbUltimaJogada;

    @FXML
    private ListView<Jogador> ltvRanking;


    public void initialize(){
        ObservableList<Pergunta> perguntas = Jogo.getInstance().getPerguntas();

        DateFormat ultimaJogada = new SimpleDateFormat("dd/MM/yyyy");
        Date data = Jogo.getInstance().getJogadorLogado().getUltimaJogada();

        if(data == null){
            lbUltimaJogada.setText("00/00/0000");
        }
        else{
            lbUltimaJogada.setText(ultimaJogada.format(data));
        }

        ObservableList<Jogador> jogadores = Jogo.getInstance().getJogador();

        ltvRanking.getItems().addAll(Jogo.getInstance().getJogador());
    }

    @FXML
    private void acaoDeslogar() throws IOException{
        Jogo.getInstance().salvarJogadores();
        NavegadorJanelas.loadJanela(NavegadorJanelas.INICIO);
    }

    @FXML
    public void acaoJogar(ActionEvent actionEvent) {
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }
}