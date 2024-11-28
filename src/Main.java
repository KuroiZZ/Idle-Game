import GUI.SoftvoperMain;
import LOCSystem.LOC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args)
    {
        SoftvoperMain UI = new SoftvoperMain();
        UI.CreateUI();

        LOC.UpdateLOC();
    }
}