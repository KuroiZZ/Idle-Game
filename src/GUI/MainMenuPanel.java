package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * MainMenuPanel is a custom JPanel class that displays the main menu of the application.
 * It loads and displays a background image to create a visual interface for the main menu.
 */
public class MainMenuPanel extends JPanel
{
    /**
     * The background image to be displayed on the main menu.
     */
    private Image backgroundImage;

    /**
     * Constructor that initializes the MainMenuPanel and loads the background image.
     * The background image is loaded from the resources folder.
     */
    public MainMenuPanel()
    {
        super();
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/MainMenuBackground.png"));
        backgroundImage = backgroundImageIcon.getImage();
    }

    /**
     * Paints the panel by drawing the background image.
     * This method overrides the default paintComponent method to customize the drawing behavior.
     * @param g The Graphics object used for drawing on the panel.
     */
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
