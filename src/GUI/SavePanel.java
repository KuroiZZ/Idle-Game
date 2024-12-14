package GUI;

import SaveSystem.Save;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavePanel extends JButton
{
    private JPanel ContentPanel;
    private Save save;

    private JLabel Title;

    private JPanel LOC_Panel;
    private JLabel LOC_Image;
    private JLabel LOC_Count;

    private JPanel SCoin_Panel;
    private JLabel SCoin_Image;
    private JLabel SCoin_Count;

    public SavePanel(Save save)
    {
        this.save = save;
        setContentPanel(this.save.name, String.valueOf(this.save.loc_count_js), String.valueOf(this.save.scoin_count_js));

        this.setOpaque(true);
        this.setPreferredSize(new Dimension(350, 810));
        this.add(ContentPanel);
        this.setBorder(null);
    }

    public void setContentPanel(String title, String loc_count, String scoin_count)
    {
        setContents(title, loc_count, scoin_count);

        GridBagConstraints constraintsTitle = setConstraints(GridBagConstraints.CENTER,1,1, 0,0);
        GridBagConstraints constraintsLOC = setConstraints(GridBagConstraints.CENTER,1,1, 0, 1);
        GridBagConstraints constraintsSCoin = setConstraints(GridBagConstraints.CENTER,1,1, 0, 2);

        ContentPanel.add(this.Title, constraintsTitle);
        ContentPanel.add(this.LOC_Panel, constraintsLOC);
        ContentPanel.add(this.SCoin_Panel, constraintsSCoin);

        this.setActionCommand("CreateGame_Old");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                GUI_Elements.GUI_handler.setCurrentSave(save);

                GUI_Elements.GUI_handler.actionPerformed(e);
            }
        });
    }

    public void setContents(String title, String loc_count, String scoin_count)
    {
        this.ContentPanel = new JPanel(new GridBagLayout());
        this.ContentPanel.setBackground(Color.GRAY);

        this.Title = new JLabel(title);
        this.Title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.LOC_Panel = new JPanel();
        this.LOC_Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.LOC_Panel.setBackground(Color.getHSBColor(0,0,0.25f));
        this.LOC_Panel.setOpaque(false);

        ImageIcon LOCImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/LOC.png"));
        Image LOCScaledImage = LOCImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.LOC_Image = new JLabel(new ImageIcon(LOCScaledImage),SwingConstants.CENTER);

        this.LOC_Count = new JLabel(String.valueOf(loc_count));
        this.LOC_Count.setForeground(Color.white);
        this.LOC_Count.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.LOC_Panel.add(this.LOC_Image);
        this.LOC_Panel.add(this.LOC_Count);

        this.SCoin_Panel = new JPanel();
        this.SCoin_Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.SCoin_Panel.setBackground(Color.getHSBColor(0,0,0.25f));
        this.SCoin_Panel.setOpaque(false);

        ImageIcon SCoinImageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/SCoin.png"));
        Image SCoinScaledImage = SCoinImageIcon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        this.SCoin_Image = new JLabel(new ImageIcon(SCoinScaledImage),SwingConstants.CENTER);

        this.SCoin_Count = new JLabel(String.valueOf(scoin_count));
        this.SCoin_Count.setForeground(Color.white);
        this.SCoin_Count.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        this.SCoin_Panel.add(this.SCoin_Image);
        this.SCoin_Panel.add(this.SCoin_Count);
    }

    private GridBagConstraints setConstraints(int anchor,  int gridheight, int gridwidth, int gridx, int gridy)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.NONE;
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
