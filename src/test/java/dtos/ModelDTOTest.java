package dtos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class ModelDTOTest {
    private ModelDTO modelDTO;

    @Test
    void modelDTOTest(){
        modelDTO = new ModelDTO();
        modelDTO.setId(1);
        modelDTO.setName("Model1");

        assertEquals(1, modelDTO.getId());
        assertEquals("Model1", modelDTO.getName());

    }
}