package SaveSystem;

import LOCSystem.Developers;
import LOCSystem.Supporter;
import SCoinSystem.SProject;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a game save that contains all necessary data to restore the game state.
 * The save object includes player progress such as the current amount of LOC (Lines of Code),
 * SCoin, the list of developers, supporters, and active projects. This class provides functionality
 * for both creating and parsing save data in JSON format, allowing saves to be loaded, updated, and
 * sent to external systems or databases.
 */
public class Save
{
    /**
     * The name of the save.
     */
    public String name;

    /**
     * Unique identifier for the save, used for differentiating between different save states.
     */
    public String _id;

    /**
     * The total amount of Lines of Code (LOC) the player has written in this save state.
     */
    public float loc_count_js;

    /**
     * The total amount of SCoin the player has earned in this save state.
     */
    public float scoin_count_js;

    /**
     * List of developers currently available in the save.
     */
    public ArrayList<Developers> developers;

    /**
     * List of supporters currently available in the save.
     */
    public ArrayList<Supporter> supporter;

    /**
     * List of projects the player is working on.
     */
    public ArrayList<SProject> project;

    /**
     * Constructs a Save object when loading or updating an existing save.
     * This constructor is used to load the game state from persistent storage and
     * Updating save data
     *
     * @param name
     * @param id
     * @param loc_count
     * @param scoin_count
     * @param developers
     * @param supporter
     * @param project
     */
    public Save(String name,String id,  float loc_count, float scoin_count, ArrayList<Developers> developers, ArrayList<Supporter> supporter, ArrayList<SProject> project)
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
     * Constructs a Save object when creating a new save from scratch.
     * This constructor is used when initializing a new game or creating a new save file.
     *
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
     * Constructs a Save object when creating an object with a JSON string in the InitializeSaveScreen method.
     *
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
     * Converts the Save object into a JSON string representation.
     * This method is useful for serializing the save data to be sent to a server or saved to a file.
     *
     * @return The JSON string representing the Save object.
     * @throws JsonProcessingException if the object cannot be serialized to JSON.
     */
    public String CreateJSON() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);

        return mapper.writeValueAsString(this);
    }
}
