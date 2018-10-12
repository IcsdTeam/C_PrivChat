package client.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import client.Entities.Authentication;

import java.io.IOException;

public abstract class AbstractController {
    protected VBox currentPane;           //Gia kremasma twn elements twn FXML grafikwn.
    //protected Authentication authEntity;  //ontothta me leitoyrgies Session

    //Me8odos emfanishs epilegmenoy FXML grafikoy arxeioy,me bash to onoma toy arxeioy FXML kai toy pane poy brisketai ws riza toy FXML.
    protected void renderView(VBox rootPane, String view) {
        try {

            VBox pane = FXMLLoader.load(getClass().getResource("../Views/" + view + ".fxml"));
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Me8odos emfanishs arxeioy FXML grafikoy View kai perasma sto controller toy FXML aytoy stoixeia gia to Session.
    protected void renderViewWithSession(VBox rootPane, String view, Authentication authEntity) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../Views/" + view + ".fxml"));
            VBox pane = loader.load();
            AbstractController controller;
            controller = loader.getController();
           // controller.setAuthEntity(authEntity);

            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
