package sample.control;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import sample.NavegadorJanelas;
import sample.model.Jogo;
import sample.model.Pergunta;

import java.io.IOException;


public class Controller  extends Notifications {

    private ObservableList<Pergunta> perguntas = Jogo.getInstance().getPerguntas();

    private int cont = 0;
    private int questoesRespondidas =0;
    private int qtdPulos;

    @FXML
    private Label lbPergunta;

    @FXML
    private RadioButton btA;

    @FXML
    private RadioButton btB;

    @FXML
    private RadioButton btC;

    @FXML
    private RadioButton btD;


    public void initialize(){
        try{
            Jogo.getInstance().carregaPerguntas();

        }catch(Exception e){
            e.printStackTrace();
        }

        qtdPulos = 3;
        carregaTela(perguntas.get(cont));
    }

    private void carregaTela(Pergunta p) {

        lbPergunta.setText(p.getEnunciado());
        btA.setText(p.getOpcoes().get(0));
        btB.setText(p.getOpcoes().get(1));
        btC.setText(p.getOpcoes().get(2));
        btD.setText(p.getOpcoes().get(3));
    }

    private int selecionaResposta(){
        if(btA.isSelected()){
            return 1;
        }
        else if(btB.isSelected()){
            return 2;
        }
        else if(btC.isSelected()){
            return 3;
        }
        else if(btD.isSelected()){
            return 4;
        }

        return 0;
    }

    @FXML
    public void acaoDesistir(ActionEvent actionEvent){
        NavegadorJanelas.loadJanela(NavegadorJanelas.JANELA_MENU);
    }

    @FXML
    public void acaoPular(ActionEvent actionEvent) {

        if(qtdPulos > 0){
            cont++;
            qtdPulos--;
            carregaTela(perguntas.get(cont));
        }
        else{
            avisoPulos();
        }
    }

    @FXML
    public void acaoConfirmar(ActionEvent actionEvent) throws IOException{

        if(btA.isSelected() || btB.isSelected()|| btC.isSelected() || btD.isSelected()){
            if(selecionaResposta() == perguntas.get(cont).getCorreta()){
                Jogo.getInstance().marcaPontos(1);
                avisoAcerto();
            }
            else if(selecionaResposta() != perguntas.get(cont).getCorreta()){
                Jogo.getInstance().marcaPontos(2);
                avisoErro();
            }
            cont++;
            questoesRespondidas++;

            if(questoesRespondidas <5){
                carregaTela(perguntas.get(cont));
            }
            else{
                Jogo.getInstance().encerraJogada();
                alertaFimDeJogo();
                NavegadorJanelas.loadJanela(NavegadorJanelas.JANELA_MENU);
            }
        }
        else{
            avisoSelecionarResposta();
        }

        btA.setSelected(false);
        btB.setSelected(false);
        btC.setSelected(false);
        btD.setSelected(false);
    }
}
