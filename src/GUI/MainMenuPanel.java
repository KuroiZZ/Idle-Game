package GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel
{
    private Image backgroundImage;

    public MainMenuPanel()
    {
        super();
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuBackground.png"));
        backgroundImage = backgroundImageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Arka plan resmini çiz
        if (backgroundImage != null)
        {
            g.drawImage(backgroundImage, 0, 0, 1920, 1080, this); // Resmi panelin tamamına çizer
        }
    }
}
