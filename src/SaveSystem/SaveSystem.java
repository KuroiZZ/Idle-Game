package SaveSystem;


import LOCSystem.Developers;
import LOCSystem.LOC;
import SCoinSystem.SCoin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.util.ArrayList;
import java.util.List;

public class SaveSystem
{
    static public Save TakeSave() throws JsonProcessingException {
        int instant_loc_count = LOC.loc_cnt;
        int instant_scoin_count = SCoin.SCoin_count;
        List<Developers> developers = new ArrayList<Developers>(12);
        developers.add(LOC.Beginner_C_Developer);
        developers.add(LOC.Beginner_CSharp_Developer);
        developers.add(LOC.Beginner_Dart_Developer);
        developers.add(LOC.Beginner_Java_Developer);
        developers.add(LOC.Intermediate_C_Developer);
        developers.add(LOC.Intermediate_CSharp_Developer);
        developers.add(LOC.Intermediate_Dart_Developer);
        developers.add(LOC.Intermediate_Java_Developer);
        developers.add(LOC.Advanced_C_Developer);
        developers.add(LOC.Advanced_CSharp_Developer);
        developers.add(LOC.Advanced_Dart_Developer);
        developers.add(LOC.Advanced_Java_Developer);
        return new Save("Araba","1", instant_loc_count, instant_scoin_count, developers);
    }

    static public void SendSave()
    {
        URI url = URI.create("http://localhost:8080/save/insert");
        String save = null;

        try
        {
            save = TakeSave().CreateJSON();
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .POST(HttpRequest.BodyPublishers.ofString(save))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("HTTP Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }

    static public void SendSave(String save)
    {
        URI url = URI.create("http://localhost:8080/save/insert");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .POST(HttpRequest.BodyPublishers.ofString(save))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try
        {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        System.out.println("HTTP Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }

    static public String GetSave()
    {
        String save = "";

        return save;
    }

    static public String[] ParseJsonString(String jsonString)
    {
        String[] Contents = new String[5];
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try
        {
            jsonNode = mapper.readTree(jsonString);
        }
        catch (JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }

        Contents[0] = jsonNode.get("name").asText();
        Contents[1] = jsonNode.get("_id").asText();
        Contents[2] = jsonNode.get("loc_count_js").asText();
        Contents[3] = jsonNode.get("scoin_count_js").asText();

        List<String> Devs = new ArrayList<String>();
        JsonNode DeveloperNode = jsonNode.get("developers");
        for(JsonNode developer : DeveloperNode)
        {
            Devs.add(developer.toString());
        }
        Contents[4] = Devs.toString();

        return Contents;
    }
}
