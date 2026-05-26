package services;

import dtos.CategoryDTO;
import dtos.LineDTO;
import dtos.ModelDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ApiLineServiceTest {

    private ApiLineService apiLineService;
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        apiLineService = spy(ApiLineService.class);
        apiLineService.restTemplate = mock(RestTemplate.class);
    }

    @Test
    public void testGetLinesSuccess() {
        ModelDTO modelDTO = new ModelDTO(1, "Model1");
        CategoryDTO categoryDTO = new CategoryDTO(1, "Category1", Arrays.asList(modelDTO));
        List<LineDTO> mockedLines = Arrays.asList(
                new LineDTO(1, "Line2", Arrays.asList(categoryDTO)),
                new LineDTO(1, "Line1", Arrays.asList(categoryDTO))
        );

        ResponseEntity<List<LineDTO>> mockedResponseEntity = new ResponseEntity<>(mockedLines, HttpStatus.OK);

        when(apiLineService.restTemplate.exchange(
                eq("http://localhost:8080/api/lines"),
                eq(HttpMethod.GET),
                isNull(),
                any(ParameterizedTypeReference.class)
        )).thenReturn(mockedResponseEntity);

        List<LineDTO> resultLines = apiLineService.getLines();

        assertNotNull(resultLines);
        assertEquals(2, resultLines.size());

        assertEquals(1, resultLines.get(0).getId());
        assertEquals("Line2", resultLines.get(0).getName());

        verify(apiLineService.restTemplate).exchange(
                eq("http://localhost:8080/api/lines"),
                eq(HttpMethod.GET),
                isNull(),
                any(ParameterizedTypeReference.class)
        );
    }
}