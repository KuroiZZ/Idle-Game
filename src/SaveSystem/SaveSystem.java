package SaveSystem;

import LOCSystem.Developers;
import LOCSystem.LOC;
import LOCSystem.Supporter;
import SCoinSystem.SCoin;
import SCoinSystem.SProject;
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
    //Creates instant_save variable for game to know which save is using right now.
    static public Save instant_save;

    /**
     * Creates developers list that the game currently has
     * @return
     */
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

    /**
     * Creates supporters list that the game currently has
     * @return
     */
    static public ArrayList<Supporter> CreateSupporterList()
    {
        ArrayList<Supporter> supporters = new ArrayList<>(3);
        supporters.add(LOC.Tester);
        supporters.add(LOC.Architect);
        supporters.add(LOC.ProjectManager);

        return supporters;
    }

    /**
     * Creates projects list that the game currently has
     * @return
     */
    static public ArrayList<SProject> CreateProjectList()
    {
        ArrayList<SProject> project = new ArrayList<>(5);
        for (int i = 0; i<SCoin.ActiveProject.size(); i++)
        {
            project.add(new SProject(SCoin.ActiveProject.get(i), SCoin.ActiveProjectInformations.get(i).appProgress.getValue()));
        }

        return project;
    }

    /**
     * Updates instant save that game currently has
     */
    static public void UpdateInstantSave()
    {
        float instant_loc_count = LOC.loc_cnt;
        float instant_scoin_count = SCoin.SCoin_count;

        ArrayList<Developers> developers = CreateDeveloperList();
        ArrayList<Supporter> supporter = CreateSupporterList();
        ArrayList<SProject> project = CreateProjectList();

        instant_save = new Save(instant_save.name,instant_save._id, instant_loc_count, instant_scoin_count, developers, supporter, project);
    }

    /**
     * Send save data to API
     * @param save
     */
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

    /**
     * Get save from API with desired id
     * @param Id
     * @return
     */
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

        return response.body();
    }

    /**
     * Get all saves from API
     * @return
     */
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

        return response.body();
    }

    /**
     * Modify save with API
     * @param save
     */
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

    }

    /**
     * Delete saves from database with desired id
     * @param id
     */
    static public void DeleteSave(String id) {
        URI url = URI.create("http://localhost:8080/save/delete/" + id);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .DELETE()
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parse save json String coming from API
     * @param jsonString
     * @return
     */
    static public String[] ParseJsonStringOneSave(String jsonString)
    {
        String[] Contents = new String[7];
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
        JsonNode DeveloperNode = jsonNode.get("developers").deepCopy();
        for(JsonNode developer : DeveloperNode)
        {
            Devs.add(developer.toString());
        }
        Contents[4] = Devs.toString();

        ArrayList<String> Sups = new ArrayList<String>();
        JsonNode SupporterNode = jsonNode.get("supporter").deepCopy();
        for(JsonNode supporter : SupporterNode)
        {
            Sups.add(supporter.toString());
        }
        Contents[5] = Sups.toString();

        ArrayList<String> projects = new ArrayList<String>();
        JsonNode ProjectNode = jsonNode.get("project").deepCopy();
        for (JsonNode project : ProjectNode)
        {
            projects.add(project.toString());
        }
        Contents[6] = projects.toString();

        return Contents;
    }

    /**
     * Parse allSaves json String coming from API
     * @param jsonString
     * @return
     */
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
