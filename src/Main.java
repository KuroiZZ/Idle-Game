import GUI.SoftvoperMain;
import LOCSystem.LOC;

public class Main {
    public static void main(String[] args)
    {
        SoftvoperMain.CreateUI();

        LOC.UpdateLOC();
    }
}