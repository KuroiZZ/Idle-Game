package SaveSystem;

import LOCSystem.Developers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.UUID;

public class Save
{
    public String name;
    public String _id;
    public int loc_count_js;
    public int scoin_count_js;
    public List<Developers> developers;

    public Save(String name, int loc_count, int scoin_count, List<Developers> developers, String id)
    {
        this.name = name;
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = developers;
        this._id = id;
    }

    public Save(String name, List<Developers> developers)
    {
        this.name = name;
        this._id = UUID.randomUUID().toString();
        this.loc_count_js = 0;
        this.scoin_count_js = 0;
        this.developers = developers;
    }

    public String CreateJSON() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }
}
