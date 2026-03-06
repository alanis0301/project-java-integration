package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TitledPane;

import models.Line;
import models.Category;
import models.Model;
import controllers.BackEndController;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<Line> comboLines;

    @FXML
    private TreeView<String> treeModels;

    @FXML
    private TitledPane paneModels;

    private BackEndController backEndController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backEndController = new BackEndController();

        configureInitialState();
        configureCombo();
    }

    private void configureInitialState() {
        paneModels.setDisable(true);
    }

    private void configureCombo() {
        List<Line> lines = backEndController.getLines();

        comboLines.getItems().addAll(lines);
    }

    @FXML
    private void onLineSelect() {
        Line line = comboLines.getValue();

        if (line != null) {
            paneModels.setDisable(false);
            loadTree(line);
        }
    }

    private void loadTree(Line line) {
        TreeItem<String> root = new TreeItem<>("Categorias");
        root.setExpanded(true);

        for (Category category : line.getCategories()) {
            TreeItem<String> categoryItem =
                    new TreeItem<>(category.getName());

            for (Model model : category.getModels()) {
                categoryItem.getChildren()
                        .add(new TreeItem<>(model.getName()));
            }
            root.getChildren().add(categoryItem);
        }
        treeModels.setRoot(root);
    }
}