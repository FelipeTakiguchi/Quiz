package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import sample.control.JanelaBase;

import java.io.IOException;

public class NavegadorJanelas {

    public static final String BASE    = "/sample/view/base.fxml";
    public static final String INICIO    = "/sample/view/inicio.fxml";
    public static final String PRINCIPAL    = "/sample/view/quiz.fxml";
    public static final String JANELA_MENU = "/sample/view/menu.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        NavegadorJanelas.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela(
                    (Node) FXMLLoader.load(
                            NavegadorJanelas.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
