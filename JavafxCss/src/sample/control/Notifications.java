package sample.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Notifications {

    protected void avisoAcerto(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Correto!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void avisoErro(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Errado!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void alertaFimDeJogo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"FIM DE JOGO");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }


    protected void avisoPulos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Não é possível pular novamente!");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void avisoSelecionarResposta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Escolha alguma opção");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }
}
