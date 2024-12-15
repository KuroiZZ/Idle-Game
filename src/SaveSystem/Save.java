package SaveSystem;

import LOCSystem.Developers;
import LOCSystem.Supporter;
import SCoinSystem.SProject;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.UUID;

public class Save
{
    public String name;
    public String _id;
    public int loc_count_js;
    public int scoin_count_js;
    public ArrayList<Developers> developers;
    public ArrayList<Supporter> supporter;
    public ArrayList<SProject> project;

    /**
     * This consturctor construct Save object when loading or updating save.
     * @param name
     * @param id
     * @param loc_count
     * @param scoin_count
     * @param developers
     * @param supporter
     * @param project
     */
    public Save(String name,String id,  int loc_count, int scoin_count, ArrayList<Developers> developers, ArrayList<Supporter> supporter, ArrayList<SProject> project)
    {
        this.name = name;
        this._id = id;
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = developers;
        this.supporter = supporter;
        this.project = project;
    }

    /**
     * This consturctor construct Save object when creating new Save.
     * @param name
     * @param developers
     * @param supporter
     * @param project
     */
    public Save(String name, ArrayList<Developers> developers, ArrayList<Supporter> supporter, ArrayList<SProject> project)
    {
        this.name = name;
        this._id = UUID.randomUUID().toString();
        this.loc_count_js = 0;
        this.scoin_count_js = 0;
        this.developers = developers;
        this.supporter = supporter;
        this.project = project;
    }

    /**
     * This constructor, construct Save object when creating object with json string in GUI_Elements.InitializeSaveScreen
     * @param id
     * @param name
     * @param loc_count
     * @param scoin_count
     */
    @JsonCreator
    public Save(@JsonProperty("id") String id, @JsonProperty("name") String name,
                @JsonProperty("loc_count_js") int loc_count, @JsonProperty("scoin_count_js") int scoin_count)
    {
        this.name = name;
        this._id = id;
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = null;
        this.supporter = null;
        this.project = null;
    }

    /**
     * Creates Save objects json string.
     * @return
     * @throws JsonProcessingException
     */
    public String CreateJSON() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);

        return mapper.writeValueAsString(this);
    }
}
