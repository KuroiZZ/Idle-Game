package SaveSystem;

import LOCSystem.Developers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Save
{
    public String _id;
    public int loc_count_js;
    public int scoin_count_js;
    public List<Developers> developers;

    public Save(int loc_count, int scoin_count, List<Developers> developers)
    {
        this.loc_count_js = loc_count;
        this.scoin_count_js = scoin_count;
        this.developers = developers;
    }

    public String CreateJSON() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(this);
    }
}
