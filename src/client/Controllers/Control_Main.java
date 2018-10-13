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
    ComboBox<String> comboBox_Channels = new ComboBox<>();

    @FXML
    TextArea txtArea_ChannelDescription;

    @FXML
    Button btn_Proceed;

    private Boolean itemSelected = false;

    private ObservableList<String> channels =
            FXCollections.observableArrayList(
                    "PUC",
                    "PSC",
                    "P2P"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox_Channels.setItems(channels);

    }

    public void proceed(){

        if(itemSelected){

            String value = comboBox_Channels.getValue();
            switch (value) {
                case "PUC": {
                    renderView(rootPane,"PUC_Main");
                    break;
                }
                case "PSC": {
                    renderView(rootPane,"PSC_Main");
                    break;
                }
                case "P2P": {
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

        btn_Proceed.setTooltip(tooltip);
    }

    public void potential_DescriptionChange() {

        try {
        String value = comboBox_Channels.getValue();
        switch (value)
        {
            case "PUC": {
                txtArea_ChannelDescription.setText("Public Insecure Channel with:\nI2P and OAuth2 technologies.");
                itemSelected = true;
                break;
            }
            case "PSC": {
                txtArea_ChannelDescription.setText("Public Secure Channel with:\nI2P,TLS and OAuth2 technologies.");
                itemSelected = true;
                break;
            }
            case "P2P": {
                txtArea_ChannelDescription.setText("Private Channel:\nPeer to Peer");
                itemSelected = true;
                break;
            }
            default:{
                txtArea_ChannelDescription.setText("Select a channel.");
                itemSelected = false;
                break;
            }

        }
        }catch (NullPointerException ex){
            txtArea_ChannelDescription.setText("You have to select a channel to proceed.");
        }

    }




}
