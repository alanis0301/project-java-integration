package services;

import dtos.LineDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiLineService {

    protected RestTemplate restTemplate = new RestTemplate();
    protected final String BASE_URL = "http://localhost:8080/api/lines";

    public List<LineDTO> getLines(){
        ResponseEntity<List<LineDTO>> response = restTemplate.exchange(BASE_URL, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<LineDTO>>() {});
        return response.getBody();
    }

}