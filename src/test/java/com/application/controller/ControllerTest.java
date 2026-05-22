package com.application.controller;

import application.Controller;
import dtos.CategoryDTO;
import dtos.LineDTO;
import dtos.ModelDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.testfx.framework.junit.ApplicationTest;
import services.ApiLineService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest extends ApplicationTest {

    private Controller controller;
    private ApiLineService apiLineService;

    private ComboBox<LineDTO> comboLines;
    private TreeView<String> treeModels;
    private TitledPane paneModels;

    @Before
    public void setUp() {
        comboLines = new ComboBox<>();
        treeModels = new TreeView<>();
        paneModels = new TitledPane();

        apiLineService = mock(ApiLineService.class);

        Controller realController = new Controller();

        ReflectionTestUtils.setField(realController, "comboLines", comboLines); //pega o controller, invade os componentes do controller (privados) e coloca os componentes criados nesse teste lá dentro
        ReflectionTestUtils.setField(realController, "treeModels", treeModels);
        ReflectionTestUtils.setField(realController, "paneModels", paneModels);
        ReflectionTestUtils.setField(realController, "apiLineService", apiLineService);

        controller = spy(realController);
    }

    @Test
    public void testInitialize() {
        doNothing().when(controller).configureInitialState();
        doNothing().when(controller).configureCombo();
        doNothing().when(controller).configureComboEvent();

        controller.initialize(null, null);

        verify(controller).configureInitialState();
        verify(controller).configureCombo();
        verify(controller).configureComboEvent();
    }

    @Test
    public void testConfigureInitialState() {
        paneModels.setDisable(false);

        controller.configureInitialState();

        assertTrue(paneModels.isDisable());
    }

    @Test
    public void testConfigureCombo() throws Exception {
        ModelDTO modelDTO = new ModelDTO(1, "Model1");
        CategoryDTO categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        LineDTO lineDTO = new LineDTO(1, "Line1", Arrays.asList(categoryDTO));
        List<LineDTO> mockedLines = Arrays.asList(lineDTO);

        when(apiLineService.getLines()).thenReturn(mockedLines);

        controller.configureCombo();

        assertEquals(1, comboLines.getItems().size());
        assertEquals( "Line1", comboLines.getItems().get(0).getName());

        verify(apiLineService).getLines();
    }

    @Test
    public void testConfigureComboException() throws Exception {
        when(apiLineService.getLines()).thenThrow(new RuntimeException());

        controller.configureCombo();

        assertNotNull(comboLines.getItems());
        assertEquals(0, comboLines.getItems().size());

        verify(apiLineService).getLines();
    }

    @Test
    public void testConfigureComboEvent() {
        ModelDTO modelDTO = new ModelDTO(1, "Model1");
        CategoryDTO categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        LineDTO lineDTO = new LineDTO(1, "Line1", Arrays.asList(categoryDTO));

        controller.configureComboEvent();

        paneModels.setDisable(true);

        comboLines.getItems().add(lineDTO);
        comboLines.setValue(lineDTO);

        comboLines.getOnAction().handle(new ActionEvent());

        assertFalse(paneModels.isDisable());

        TreeItem<String> root = treeModels.getRoot();
        assertNotNull(root);
        assertEquals("Categorias", root.getValue());

        TreeItem<String> categoryItem = root.getChildren().get(0);
        assertEquals("Category1", categoryItem.getValue());

        TreeItem<String> modelItem = categoryItem.getChildren().get(0);
        assertEquals("Model1", modelItem.getValue());
    }
}