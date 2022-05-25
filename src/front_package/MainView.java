package front_package;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    public MainView(PaletteView currentPalette, SheetView currentSheet){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = 0;
        constraint.gridx = 0;
        mainPanel.add(currentSheet,constraint);
        constraint.gridy = 0;
        constraint.gridx = 1;
        mainPanel.add(currentPalette,constraint);
        this.setVisible(true);
        this.pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-75);
    }
}
