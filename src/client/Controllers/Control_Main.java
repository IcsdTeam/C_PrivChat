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

    private final ObservableList<String> channels =
            FXCollections.observableArrayList("PUC", "PSC", "P2P");

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Start of essential methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox_Channels.setItems(channels);
    }

    public void proceed(){

        if(itemSelected){
            final String selectedChannel = comboBox_Channels.getValue();
            renderView(rootPane,selectedChannel +"_Main");
        }
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End of essential methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Start Customizable UI optional methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void proceedTooltip(){
        final Tooltip tooltip = new Tooltip();
        final Image image;

        if(itemSelected){

            image = fetchViewImage("proceed.png");

            tooltip.setText("You can proceed!");
        }else{

            image = fetchViewImage("warn1.png");

            tooltip.setText("You can't proceed until \nyou select a channel!");

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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Customizable UI optional methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}
