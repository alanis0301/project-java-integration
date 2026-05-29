package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TitledPane;

import dtos.LineDTO;
import dtos.ModelDTO;
import dtos.CategoryDTO;

import services.ApiLineService;

import java.util.List;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    protected ComboBox<LineDTO> comboLines;

    @FXML
    protected TreeView<String> treeModels;

    @FXML
    protected TitledPane paneModels;

    protected ApiLineService apiLineService = new ApiLineService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configureInitialState();
        configureCombo();
        configureComboEvent();
    }

    public void configureInitialState(){
        paneModels.setDisable(true);
    }

    public void configureCombo(){
        try {
            List<LineDTO> linesDTO = apiLineService.getLines();
            comboLines.getItems().addAll(linesDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void configureComboEvent(){
        comboLines.setOnAction(event -> {

        LineDTO line = comboLines.getValue();

        if (line != null) {
            paneModels.setDisable(false);
            loadTree(line);
        }
    });
    }

    public void loadTree(LineDTO line) {

        TreeItem<String> root = new TreeItem<>("Categorias");
        root.setExpanded(true);

        for (CategoryDTO category : line.getCategories()) {
            TreeItem<String> categoryItem =
                    new TreeItem<>(category.getName());
            for (ModelDTO model : category.getModels()) {
                categoryItem.getChildren()
                        .add(new TreeItem<>(model.getName()));
            }
            root.getChildren().add(categoryItem);
        }

        treeModels.setRoot(root);
    }
}