package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Line;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

public class ApiLineService {

    private final OkHttpClient client = new OkHttpClient();

    public List<Line> getLines() throws Exception {

        Request request = new Request.Builder()
                .url("http://localhost:8080/api/lines")
                .build();

        Response response = client.newCall(request).execute();

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(
                response.body().string(),
                new TypeReference<List<Line>>() {}
        );
    }
}