package application;

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
import org.testfx.framework.junit.ApplicationTest;
import services.ApiLineService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest extends ApplicationTest {

    private Controller controller;

    @Before
    public void setUp() {
        controller = spy(Controller.class);

        controller.comboLines = new ComboBox<>();
        controller.treeModels = new TreeView<>();
        controller.paneModels = new TitledPane();
        controller.apiLineService = mock(ApiLineService.class);
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
        controller.paneModels.setDisable(false);

        controller.configureInitialState();

        assertTrue(controller.paneModels.isDisable());
    }

    @Test
    public void testConfigureCombo() throws Exception {
        ModelDTO modelDTO = new ModelDTO(1, "Model1");
        CategoryDTO categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        LineDTO lineDTO = new LineDTO(1, "Line1", Arrays.asList(categoryDTO));
        List<LineDTO> mockedLines = Arrays.asList(lineDTO);

        when(controller.apiLineService.getLines()).thenReturn(mockedLines);

        controller.configureCombo();


        assertEquals(1, controller.comboLines.getItems().size());
        assertEquals( "Line1", controller.comboLines.getItems().get(0).getName());

        verify(controller.apiLineService).getLines();
    }

    @Test
    public void testConfigureComboException() throws Exception {
        when(controller.apiLineService.getLines()).thenThrow(new RuntimeException());

        controller.configureCombo();

        assertNotNull(controller.comboLines.getItems());
        assertEquals(0, controller.comboLines.getItems().size());

        verify(controller.apiLineService).getLines();
    }

    @Test
    public void testConfigureComboEvent() {
        ModelDTO modelDTO = new ModelDTO(1, "Model1");
        CategoryDTO categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        LineDTO lineDTO = new LineDTO(1, "Line1", Arrays.asList(categoryDTO));

        controller.configureComboEvent();

        controller.paneModels.setDisable(true);

        controller.comboLines.getItems().add(lineDTO);
        controller.comboLines.setValue(lineDTO);

        controller.comboLines.getOnAction().handle(new ActionEvent());

        assertFalse(controller.paneModels.isDisable());

        TreeItem<String> root = controller.treeModels.getRoot();
        assertNotNull(root);
        assertEquals("Categorias", root.getValue());

        TreeItem<String> categoryItem = root.getChildren().get(0);
        assertEquals("Category1", categoryItem.getValue());

        TreeItem<String> modelItem = categoryItem.getChildren().get(0);
        assertEquals("Model1", modelItem.getValue());
    }
}