import GUI.GUI_Elements;
import GUI.SoftvoperMain;
import LOCSystem.LOC;

public class Main {
    public static void main(String[] args)
    {
        GUI_Elements.window.setVisible(true);

        SoftvoperMain.CreateMainMenu();

        LOC.UpdateLOC();
    }
}