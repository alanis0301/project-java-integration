package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> comboLinhas;

    @FXML
    private TreeView<String> treeModelos;

    @FXML
    private TitledPane paneModelos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        paneModelos.setDisable(true);

        comboLinhas.getItems().addAll("Cronos", "Ares");

        comboLinhas.setOnAction(event -> {
            String linha = comboLinhas.getValue();

            if (linha != null) {
                paneModelos.setDisable(false);
                carregarTree(linha);
            }
        });
    }

    private void carregarTree(String linha) {

        TreeItem<String> root = new TreeItem<>("Categorias");
        root.setExpanded(true);

        if (linha.equals("Cronos")) {

            TreeItem<String> cronosOld = new TreeItem<>("Cronos Old");
            cronosOld.getChildren().addAll(
                    new TreeItem<>("Cronos6001-A"),
                    new TreeItem<>("Cronos 6003"),
                    new TreeItem<>("Cronos 7023")
            );

            TreeItem<String> cronosL = new TreeItem<>("Cronos L");
            cronosL.getChildren().addAll(
                    new TreeItem<>("Cronos 6021L"),
                    new TreeItem<>("Cronos 7023L")
            );

            TreeItem<String> cronosNG = new TreeItem<>("Cronos-NG");
            cronosNG.getChildren().addAll(
                    new TreeItem<>("Cronos 6001-NG"),
                    new TreeItem<>("Cronos 6003-NG"),
                    new TreeItem<>("Cronos 6021-NG"),
                    new TreeItem<>("Cronos 6031-NG"),
                    new TreeItem<>("Cronos 7021-NG"),
                    new TreeItem<>("Cronos 7023-NG")
            );

            root.getChildren().addAll(cronosOld, cronosL, cronosNG);
        }


        if (linha.equals("Ares")) {

            TreeItem<String> aresTB = new TreeItem<>("Ares TB");
            aresTB.getChildren().addAll(
                    new TreeItem<>("ARES 7021"),
                    new TreeItem<>("ARES 7031"),
                    new TreeItem<>("ARES 7023")
            );

            TreeItem<String> aresTHS = new TreeItem<>("Ares THS");
            aresTHS.getChildren().addAll(
                    new TreeItem<>("ARES 8023 15"),
                    new TreeItem<>("ARES 8023 200"),
                    new TreeItem<>("ARES 8023 2,5")
            );

            root.getChildren().addAll(aresTB, aresTHS);
        }

        treeModelos.setRoot(root);
    }
}
