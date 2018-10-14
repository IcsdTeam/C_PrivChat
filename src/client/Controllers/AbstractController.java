package client.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import java.io.IOException;

public abstract class AbstractController {

    /*Method of rendering new FXML file.
        @param rootPane:VBox variable that contains the root container where all the new GUI children will be hanged on.
        @param view:String variable that contains the convention filename(eg."PUC_Main") of the concrete fxml file.
    */
     protected final void renderView(VBox rootPane,String view) {

            VBox pane = getViewFile(view);

            rootPane.getChildren().setAll(pane);
    }

    /*Method of returning a new Image from the resource ViewImages package.
    *  @param image:String variable that contains the name of the wanted image and its format.
    * */
    protected final Image fetchViewImage(String image){
        return new Image(getClass().getResourceAsStream("../Views/ViewImages/"+image));
    }

    private VBox getViewFile(String view)
    {
        final String selectedViewPath;

        final String items[] = view.split("_");

        //Items[0] has the corresponded channel.
        selectedViewPath = "../Views/Views_"+items[0]+"/";

        try {
            return FXMLLoader.load(getClass().getResource(selectedViewPath + view + ".fxml"));
        }catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("FXML files have name convention.\nThey start with their corresponded channels and underscore.\neg'PUC_Main'");
        }
        return null;
    }
}
