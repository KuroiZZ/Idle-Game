package MoneySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.SoftvoperMain;

public class Money
{
    public int money_cnt;
    public MoneyHandler money_hndler = new MoneyHandler();

    public static void main(String[] args)
    {
        new Money();
    }
    public Money()
    {
        money_cnt = 0;
    }
    public class MoneyHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();

            switch (action)
            {
                case "computer":
                    money_cnt++;
                    SoftvoperMain.moneyLabel.setText("Money: "+money_cnt);
                    break;
                case "C Developer":
                    break;
            }
        }
    }
}

