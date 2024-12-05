package GUI;

import javax.swing.*;
import java.awt.*;

public class SAppInformation extends JPanel
{
    private JLabel name;
    private JProgressBar appProgress;
    private JPanel SCoinPanel;
    private JLabel SCoinToEarn;
    private JLabel SCoinImage;
    private Image backgroundImage; // Arka plan resmi için değişken

    public SAppInformation(String Name, int ScoinToEarn, String DeveloperRank)
    {
        super(new GridBagLayout());
        setPanel(Name,ScoinToEarn);

        this.setOpaque(false); // Panelin arka planı şeffaf olacak
        this.setPreferredSize(new Dimension(250, 50));
        this.setBorder(null);

        // Arka planı yükle
        loadBackgroundImage(DeveloperRank);
    }

    // Arka planı yükleyen metot
    private void loadBackgroundImage(String DeveloperRank)
    {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/DeveloperButton/BeginneButton.png")); // Arka plan resmi
        this.backgroundImage = icon.getImage().getScaledInstance(250, 50, Image.SCALE_SMOOTH); // Resmi uygun boyutta ölçekle
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Arka plan resmini çiz
        if (backgroundImage != null)
        {
            g.drawImage(backgroundImage, 0, 0, 250, 50, this); // Resmi panelin tamamına çizer
        }
    }

    private void setPanel(String Name, int ScoinToEarn)
    {
        setContents(Name,ScoinToEarn);

        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1, 1, 0 , 0);
        GridBagConstraints constraintsSCoinToEarn = setConstraints(GridBagConstraints.CENTER, GridBagConstraints.NONE, 1,1,0,1);
        GridBagConstraints constraintsProgressBar = setConstraints(GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, 1,1,0,2);

        this.add(this.name, constraintsName);
        this.add(this.SCoinPanel, constraintsSCoinToEarn);
        this.add(this.appProgress, constraintsProgressBar);
    }

    private void setContents(String Name, int ScoinToEarn)
    {
        this.name = new JLabel(Name);
        this.SCoinToEarn = new JLabel(String.valueOf(ScoinToEarn));

        ImageIcon LocImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image limage = LocImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        this.SCoinImage = new JLabel(new ImageIcon(limage));

        this.appProgress = new JProgressBar(0, 100);
        appProgress.setValue(0);
        appProgress.setOrientation(JProgressBar.HORIZONTAL);

        this.SCoinPanel = new JPanel();
        this.SCoinPanel.add(this.SCoinImage);
        this.SCoinPanel.add(this.SCoinToEarn);
    }

    public void setAppProgressValue(int value)
    {
        this.appProgress.setValue(value);
    }

    private Font get_Font(String fontName)
    {
        Font font;
        switch (fontName)
        {
            case "ITALIC":
                font = new Font(Font.SERIF, Font.ITALIC,  14);
                break;
            case "SMALL":
                font = new Font(Font.SERIF, Font.BOLD,  14);
                break;
            case "BAŞLIK":
                font = new Font(Font.SERIF, Font.BOLD, 16);
                break;
            default:
                font = new Font(Font.SERIF, Font.PLAIN, 15);
                break;
        }
        return font;
    }

    private GridBagConstraints setConstraints(int anchor,int fill,  int gridheight, int gridwidth, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.gridx = gridx;
        constraints.gridy = gridy;

        return constraints;
    }
}