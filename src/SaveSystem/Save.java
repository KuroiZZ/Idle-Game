package SaveSystem;

import LOCSystem.Developers;
import LOCSystem.Supporter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    public Save(String name,String id,  int loc_count, int scoin_count, ArrayList<Developers> developers, ArrayList<Supporter> supporter)
    {
        this.name = name;
        this._id = id;
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = developers;
        this.supporter = supporter;
    }

    public Save(String name, ArrayList<Developers> developers, ArrayList<Supporter> supporter)
    {
        this.name = name;
        this._id = UUID.randomUUID().toString();
        this.loc_count_js = 0;
        this.scoin_count_js = 0;
        this.developers = developers;
        this.supporter = supporter;
    }

    @JsonCreator
    public Save(@JsonProperty("id") String id, @JsonProperty("name") String name,
                @JsonProperty("loc_count_js") int loc_count, @JsonProperty("scoin_count_js") int scoin_count)
    {
        this.name = name;
        this._id = id;
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = null;
    }

    public String CreateJSON() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }
}
