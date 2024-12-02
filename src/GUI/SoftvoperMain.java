package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import LOCSystem.Beginner;
import LOCSystem.LOC;
import SCoinSystem.SCoin;

public class SoftvoperMain
{
    public void CreateUI()
    {
        GUI_Elements.InitializeMainScreen();
        GUI_Elements.InitializeCoderPanel();
        GUI_Elements.InitializeStorePanel();
        GUI_Elements.InitializeAppPanel();

        GUI_Elements.window.add(GUI_Elements.CoderPanel, BorderLayout.WEST);
        GUI_Elements.window.add(GUI_Elements.StorePanel, BorderLayout.EAST);

        GUI_Elements.window.setVisible(true);

        ControlButtons();
        ControlProjects();
    }

    public void ControlButtons()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean Beginner_CB = (LOC.Beginner_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_CSharpB = (LOC.Beginner_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_DartB = (LOC.Beginner_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Beginner_JavaB = (LOC.Beginner_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_CB = (LOC.Intermediate_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_CSharpB = (LOC.Intermediate_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_DartB = (LOC.Intermediate_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Intermediate_JavaB = (LOC.Intermediate_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_CB = (LOC.Advanced_C.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_CSharpB = (LOC.Advanced_CSharp.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_DartB = (LOC.Advanced_Dart.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;
                boolean Advanced_JavaB = (LOC.Advanced_Java.getPrice()*LOC.buy_amount <= SCoin.SCoin_count) ? true :  false;

                GUI_Elements.Beginner_C.setEnabled(Beginner_CB);
                GUI_Elements.Beginner_CSharp.setEnabled(Beginner_CSharpB);
                GUI_Elements.Beginner_Dart.setEnabled(Beginner_DartB);
                GUI_Elements.Beginner_Java.setEnabled(Beginner_JavaB);
                GUI_Elements.Intermediate_C.setEnabled(Intermediate_CB);
                GUI_Elements.Intermediate_CSharp.setEnabled(Intermediate_CSharpB);
                GUI_Elements.Intermediate_Dart.setEnabled(Intermediate_DartB);
                GUI_Elements.Intermediate_Java.setEnabled(Intermediate_JavaB);
                GUI_Elements.Advanced_C.setEnabled(Advanced_CB);
                GUI_Elements.Advanced_CSharp.setEnabled(Advanced_CSharpB);
                GUI_Elements.Advanced_Dart.setEnabled(Advanced_DartB);
                GUI_Elements.Advanced_Java.setEnabled(Advanced_JavaB);
            }
        });
        timer.start();
    }

    public void ControlProjects()
    {
        Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                boolean Beginner_C_ProjectB = SCoin.Beginner_C_Project.getNecessaryLOC() <= LOC.loc_cnt &&
                        SCoin.Beginner_C_Project.getNecessaryDeveloperCount() <= LOC.Beginner_C.getNofNonProjectEmp();


                GUI_Elements.Beginner_C_Project.setEnabled(Beginner_C_ProjectB);

            }
        });
        timer.start();
    }
}
