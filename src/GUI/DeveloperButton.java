package GUI;

import javax.swing.*;
import java.awt.*;

public class DeveloperButton extends JButton
{
    private JPanel PricePanel;
    private JPanel ButtonContentsPanel;
    private ImageIcon LogoImage;
    private JLabel Logo;
    private JLabel NofDeveloper;
    private JLabel Name;
    private JLabel Price;
    private ImageIcon SCoinImageIcon;
    private Image SCoinImage;
    private JLabel SCoin;

    public DeveloperButton(String price,String name,String nofdeveloper,String LogoImagePath)
    {
        super();
        setButtonContentsPanel(price,name,nofdeveloper,LogoImagePath);
        this.setPreferredSize(new Dimension(200, 50));
        this.add(ButtonContentsPanel);
        this.setBorder(null);
    }

    //Add contents to ButtonContentsPanel for chosen layout
    private void setButtonContentsPanel(String price,String name,String nofdeveloper,String LogoImagePath)
    {
        setButtonContents(price,name,nofdeveloper,LogoImagePath);//contents are initialized here

        PricePanel.add(SCoin);//2 separate content creating 1 content(a panel)
        PricePanel.add(Price);

        GridBagConstraints constraintsLogo = setConstraints(GridBagConstraints.CENTER,2,0,0);
        GridBagConstraints constraintsName = setConstraints(GridBagConstraints.LINE_START,1,1,0);
        GridBagConstraints constraintsPricePanel = setConstraints(GridBagConstraints.LINE_START,1,1,1);
        GridBagConstraints constraintsNofDeveloper = setConstraints(GridBagConstraints.CENTER,2,2,0);

        ButtonContentsPanel.add(this.Logo, constraintsLogo);
        ButtonContentsPanel.add(this.Name, constraintsName);
        ButtonContentsPanel.add(this.PricePanel, constraintsPricePanel);
        ButtonContentsPanel.add(this.NofDeveloper, constraintsNofDeveloper);
    }

    //Initialize every content that will be added in ButtonContentPanel
    private void setButtonContents(String price,String name,String nofdeveloper,String LogoImagePath)
    {
        this.PricePanel = new JPanel(); //Initialize panels
        this.PricePanel.setLayout(new BoxLayout(this.PricePanel, BoxLayout.LINE_AXIS));
        this.ButtonContentsPanel = new JPanel(new GridBagLayout());

        this.LogoImage = new ImageIcon(getClass().getClassLoader().getResource(LogoImagePath));
        this.Logo = new JLabel(LogoImage); //Initialize logo image

        this.SCoinImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        this.SCoinImage = SCoinImageIcon.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        this.SCoin = new JLabel(new ImageIcon(SCoinImage),SwingConstants.CENTER); //Initialize coin image

        this.Price = new JLabel(price); //Initialize price
        this.Name = new JLabel(name); //Initialize name
        this.NofDeveloper = new JLabel(nofdeveloper); //Initialize number of developer
    }

    //sets GridBagLayout's constraints
    private GridBagConstraints setConstraints(int anchor, int gridheight, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = anchor;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.gridheight = gridheight;
        constraints.gridx = gridx;
        constraints.gridy = gridy;

        return constraints;
    }
}
