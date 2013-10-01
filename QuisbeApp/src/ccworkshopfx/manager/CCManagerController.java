/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ccworkshopfx.manager;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import utils.ColorUtil;

/**
 *
 * @author Chingo
 */
public class CCManagerController implements Initializable {
    @FXML
    private FlowPane characterContentFlowPane;
    @FXML
    private ScrollPane characterScrollPane;
    @FXML
    private TabPane tabbedPane;

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        initCharacterFlowPane();
    }

    @FXML
    private void handleCollapseAllButton(ActionEvent e) {
        Tab tab = tabbedPane.getSelectionModel().getSelectedItem();
        switch (tab.getText().toLowerCase()) {
            case "characters" : doCollapseChildren(characterContentFlowPane.getChildren());
        }
    }
    
    @FXML
    private void handleExpandAllButton(ActionEvent e) {
        Tab tab = tabbedPane.getSelectionModel().getSelectedItem();
        switch (tab.getText().toLowerCase()) {
            case "characters" : doExpandChildren(characterContentFlowPane.getChildren());
        }
    }
    
    private void doCollapseChildren(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node);
            if(node instanceof TitledPane){
                TitledPane tPane = (TitledPane) node;
                tPane.setExpanded(false);
            }
        }
    }
    
    private void doExpandChildren(List<Node> nodes) {
                for (Node node : nodes) {
            if(node instanceof TitledPane){
                TitledPane tPane = (TitledPane) node;
                tPane.setExpanded(true);
            }
        }
    }

    private void initCharacterFlowPane() {

        ColorUtil picker = new ColorUtil();

        for (int k = 0; k < 10; k++) {
            FlowPane content = new FlowPane();
            TitledPane tPane = new TitledPane();
            tPane.setText("Test_" + k);
            /**
             * Add content *
             */
            for (int i = 0; i < 10; i++) {
                Image image = new Image(getClass().getResourceAsStream("Mario.png"), 150, 200, true, false);
                Button button = new Button("", new ImageView(image));
                content.getChildren().add(button);
               
            }

            content.setHgap(5);
            content.setVgap(5);

            content.setStyle(picker.pickNext());
            content.prefWrapLengthProperty().bind(characterScrollPane.widthProperty());
            tPane.prefWidthProperty().bind(characterScrollPane.widthProperty());
            tPane.setContent(content);
            tPane.setExpanded(false);

            characterContentFlowPane.getChildren().add(tPane);
        }


    }   
}
