package SaveSystem;

import LOCSystem.Developers;
import LOCSystem.LOC;
import LOCSystem.Supporter;
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
    static public Save instant_save;

    static public ArrayList<Developers> CreateDeveloperList()
    {
        ArrayList<Developers> developers = new ArrayList<Developers>(12);
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

        return developers;
    }

    static public ArrayList<Supporter> CreateSupporterList()
    {
        ArrayList<Supporter> supporters = new ArrayList<>(3);
        supporters.add(LOC.Tester);
        supporters.add(LOC.Architect);
        supporters.add(LOC.ProjectManager);

        return supporters;
    }

    static public void UpdateInstantSave()
    {
        int instant_loc_count = LOC.loc_cnt;
        int instant_scoin_count = SCoin.SCoin_count;

        ArrayList<Developers> developers = CreateDeveloperList();
        ArrayList<Supporter> supporter = CreateSupporterList();

        instant_save = new Save(instant_save.name,instant_save._id, instant_loc_count, instant_scoin_count, developers, supporter);
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

    static public String GetSave(String Id)
    {
        URI url = URI.create("http://localhost:8080/save/get/" + Id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
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

        return response.body();
    }

    static public String GetAllSaves()
    {
        URI url = URI.create("http://localhost:8080/save/getall");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
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

        return response.body();
    }

    static public void ModifySave(String save)
    {
        URI url = URI.create("http://localhost:8080/save/update");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .PUT(HttpRequest.BodyPublishers.ofString(save))
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

    static public String[] ParseJsonStringOneSave(String jsonString)
    {
        String[] Contents = new String[6];
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

        ArrayList<String> Devs = new ArrayList<String>();
        JsonNode DeveloperNode = jsonNode.get("developers");
        for(JsonNode developer : DeveloperNode)
        {
            Devs.add(developer.toString());
        }
        Contents[4] = Devs.toString();

        ArrayList<String> Sups = new ArrayList<String>();
        JsonNode SupporterNode = jsonNode.get("supporter");
        for(JsonNode supporter : SupporterNode)
        {
            Sups.add(supporter.toString());
        }
        Contents[5] = Sups.toString();

        return Contents;
    }

    static public List<String> ParseJsonStringAllSaves(String jsonString)
    {
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

        ArrayList<String> Saves = new ArrayList<String>();
        for(JsonNode save : jsonNode)
        {
            Saves.add(save.toString());
        }

        return Saves;
    }
}