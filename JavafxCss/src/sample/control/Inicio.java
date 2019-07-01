package sample.control;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.NavegadorJanelas;
import sample.NavegadorJanelas;
import sample.model.Jogador;
import javafx.scene.control.TextField;
import sample.model.Jogo;

import java.io.IOException;
import java.util.Date;

public class Inicio {
    @FXML
    private TextField tfNome;

    @FXML
    private Button btFechar;

    @FXML
    private void acaoCadastrar() throws IOException{
        String nome = tfNome.getText();

        if(nome.length() > 0 ){

            if(!Jogo.getInstance().verificaJogadores(nome)){

                Jogador jogador = new Jogador(0, nome, 0, null);
                Jogo.getInstance().cadastrarJogador(jogador);
                Jogo.getInstance().salvarJogadores();

                NavegadorJanelas.loadJanela(NavegadorJanelas.JANELA_MENU);
            }
            else{
                NavegadorJanelas.loadJanela(NavegadorJanelas.JANELA_MENU);
            }

        }
        else{
            Jogo.getInstance().salvarJogadores();
            NavegadorJanelas.loadJanela(NavegadorJanelas.INICIO);
        }
    }

    public void sair(ActionEvent actionEvent) {
        Stage stage = (Stage) btFechar.getScene().getWindow();
        stage.close();
    }
}
