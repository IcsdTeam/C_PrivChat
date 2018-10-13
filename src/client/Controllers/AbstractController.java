package client.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract class AbstractController {
    protected VBox currentPane;           //Gia kremasma twn elements twn FXML grafikwn.
    //protected Authentication authEntity;  //ontothta me leitoyrgies Session

    //Me8odos emfanishs epilegmenoy FXML grafikoy arxeioy,me bash to onoma toy arxeioy FXML kai toy pane poy brisketai ws riza toy FXML.
    protected final void renderView(VBox rootPane,String view) {

            VBox pane = getViewFile(view);

            rootPane.getChildren().setAll(pane);
    }


    //Me8odos emfanishs arxeioy FXML grafikoy View kai perasma sto controller toy FXML aytoy stoixeia gia to Session.
    /*protected final void renderView(VBox rootPane, String view, Session session) {
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
    }*/

    private VBox getViewFile(String view)
    {
        final String channel;
        final String selectedViewPath;

        String items[] = view.split("_");
        channel = items[0];

        switch(channel)
        {
            case "PUC": {
                selectedViewPath = "../Views/Views_PUC/";
                break;
            }
            case "PSC":{
                selectedViewPath = "../Views/Views_PSC/";
                break;
            }
            case "P2P":{
                selectedViewPath = "../Views/Views_P2P/";
                break;
            }
            default:{
                selectedViewPath = "../Views/Views_PUC/";
                break;
            }
        }
        try {
            return FXMLLoader.load(getClass().getResource(selectedViewPath + view + ".fxml"));
        }catch (IOException ex) {
                ex.printStackTrace();
        }
        return null;
    }
}
