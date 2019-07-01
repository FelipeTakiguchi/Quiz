package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.control.JanelaBase;
import sample.model.Jogo;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws Exception {

        Pane root = loadMainPane();
        stage.setScene(new Scene(root, 1000, 551));

        stage.setTitle("Quiz de matemática");
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        NavegadorJanelas.BASE
                )
        );

        JanelaBase controller = loader.getController();

        NavegadorJanelas.setControlador(controller);
        NavegadorJanelas.loadJanela(NavegadorJanelas.INICIO);

        return mainPane;
    }

    @Override
    public void init() throws Exception {
        super.init();
        try{
            Jogo.getInstance().carregaJogadores();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}