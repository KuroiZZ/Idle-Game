package MoneySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class Money
{
    private int money;
    MoneyHandler money_hndler = new MoneyHandler();

    public static void main(String[] args)
    {
        new Money();
    }
    public Money()
    {
        money = 0;
    }
    public class MoneyHandler extends Frame implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String action = event.getActionCommand();

            switch (action)
            {
                case "computer":
                    money++;
                    break;
                case "C Developer":
                    break;
            }
        }
    }
}

