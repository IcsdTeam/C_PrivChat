package client.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class Control_Main extends AbstractController implements Initializable {
    @FXML
    VBox rootPane;

    @FXML
    ComboBox<String> comChannel_ComboBox = new ComboBox<>();

    @FXML
    TextArea channelDescription;

    @FXML
    Button proceedBtn;

    private Boolean itemSelected = false;

    private ObservableList<String> comChannels =
            FXCollections.observableArrayList(
                    "Channel 1",
                    "Channel 2",
                    "Channel 3"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comChannel_ComboBox.setItems(comChannels);

    }

    public void proceed(){

        //System.out.println("Checking...");

        if(itemSelected){
            //System.out.println("Can't proceed");
            String value = comChannel_ComboBox.getValue();
            switch (value) {
                case "Channel 1": {
                    renderView(rootPane,"ViewsChannel_1/Ch1_SignIn");
                    break;
                }
                case "Channel 2": {
                    renderView(rootPane,"ViewsChannel_2/Ch2_SignIn");
                    break;
                }
                case "Channel 3": {
                    //renderView(rootPane,);
                    break;
                }
            }
        }
    }

    //Customizable UI options
    public void proceedTooltip(){
        final Tooltip tooltip = new Tooltip();
        Image image;

        if(itemSelected){
            //System.out.println(getClass());
            image = new Image(
                    getClass().getResourceAsStream("../Views/ViewImages/proceed.png")
            );
            tooltip.setText(
                    "You can proceed!"
            );
        }else{
            //System.out.println(getClass());
            image = new Image(
                    getClass().getResourceAsStream("../Views/ViewImages/warn1.png")
            );
            tooltip.setText(
                    "You can't proceed until \nyou select a channel!"
            );

        }
        tooltip.setFont(Font.font("", 10));
        tooltip.setGraphic(new ImageView(image));

        proceedBtn.setTooltip(tooltip);
    }

    public void potential_DescriptionChange() {

        try {
        String value = comChannel_ComboBox.getValue();
        switch (value)
        {
            case "Channel 1": {
                channelDescription.setText("Public insecure channel with:\nI2P and OAuth2 technologies.");
                itemSelected = true;
                break;
            }
            case "Channel 2": {
                channelDescription.setText("Public channel with:\nI2P,TLS and OAuth2 technologies.");
                itemSelected = true;
                break;
            }
            case "Channel 3": {
                channelDescription.setText("Peer to Peer channel.");
                itemSelected = true;
                break;
            }
            default:{
                channelDescription.setText("Select a channel.");
                itemSelected = false;
                break;
            }

        }
        }catch (NullPointerException ex){
            channelDescription.setText("You have to select a channel to proceed.");
        }

    }




}
