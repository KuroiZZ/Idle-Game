package SaveSystem;


import LOCSystem.Developers;
import LOCSystem.LOC;
import SCoinSystem.SCoin;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class SaveSystem
{
    static public String TakeSave() throws JsonProcessingException {
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
        Save new_Save = new Save(instant_loc_count, instant_scoin_count, developers);
        return new_Save.CreateJSON();
    }
}
