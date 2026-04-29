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
import services.ApiLineService;

import java.util.List;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<Line> comboLinhas;

    @FXML
    private TreeView<String> treeModelos;

    @FXML
    private TitledPane paneModelos;

    private ApiLineService apiLineService = new ApiLineService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        paneModelos.setDisable(true);

        try {
            List<Line> lines = apiLineService.getLines();
            comboLinhas.getItems().addAll(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }

        comboLinhas.setOnAction(event -> {
            Line linha = comboLinhas.getValue();
            if (linha != null) {
                paneModelos.setDisable(false);
                carregarTree(linha);
            }
        });
    }

    private void carregarTree(Line linha) {
        TreeItem<String> root = new TreeItem<>("Categorias");
        root.setExpanded(true);

        for (Category category : linha.getCategories()) {
            TreeItem<String> categoryItem =
                    new TreeItem<>(category.getName());

            for (Model model : category.getModels()) {
                categoryItem.getChildren()
                        .add(new TreeItem<>(model.getName()));
            }
            root.getChildren().add(categoryItem);
        }
        treeModelos.setRoot(root);
    }
}
