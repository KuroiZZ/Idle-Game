package SCoinSystem;

import GUI.SoftvoperMain;
import LOCSystem.LOC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SCoin
{
    static public int SCoin_count = 0;
    static public SCoinHandler SCoin_hndler = new SCoinHandler();
    public static class SCoinHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();
            switch (action)
            {
                case "Beginner_C":
                    SCoin_count -= LOC.Beginner_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_CSharp":
                    SCoin_count -= LOC.Beginner_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_Dart":
                    SCoin_count -= LOC.Beginner_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Beginner_Java":
                    SCoin_count -= LOC.Beginner_Java.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_C":
                    SCoin_count -= LOC.Intermediate_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_CSharp":
                    SCoin_count -= LOC.Intermediate_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Intermediate_Dart":
                    SCoin_count -= LOC.Intermediate_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_C":
                    SCoin_count -= LOC.Advanced_C.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_CSharp":
                    SCoin_count -= LOC.Advanced_CSharp.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_Dart":
                    SCoin_count -= LOC.Advanced_Dart.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Advanced_Java":
                    SCoin_count -= LOC.Advanced_Java.getPrice()*LOC.buy_amount;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
                case "Temporary_Money":
                    SCoin_count += 10;
                    SoftvoperMain.SCoinLabel.setText("Number of Coin: "+ SCoin_count);
                    break;
            }
        }
    }

    public static void ControlPrice()
    {

    }
}
