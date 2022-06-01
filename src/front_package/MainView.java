package front_package;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainView extends JFrame implements ActionListener, MouseListener {
    public Color usingColor;
    private PaletteView paletteView ;
    private SheetView sheetView;
    public MainView(PaletteView currentPalette, SheetView currentSheet){
        this.paletteView = currentPalette;
        this.sheetView = currentSheet;
        this.usingColor = new Color(0,0,0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
        this.setTitle("Cassopi");

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = 0;
        constraint.gridx = 0;
        mainPanel.add(currentSheet,constraint);
        constraint.gridy = 0;
        constraint.gridx = 1;
        mainPanel.add(currentPalette,constraint);

        sheetView.addMouseListener(this);
        for(int i = 0 ; i < currentPalette.getPalette().getPaletteSize();i++){
            currentPalette.getPaletteButton().get(i).addActionListener(this);
        }

        this.setVisible(true);
        this.pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height-75);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < paletteView.getPaletteButton().size(); i++){
            if(e.getSource() == paletteView.getPaletteButton().get(i)){
                usingColor = paletteView.getPaletteButton().get(i).getBackground();
                System.out.println(usingColor);
            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == sheetView) {
            sheetView.setFocusable(true);
            sheetView.requestFocus();
            sheetView.getSheet().setPixelColor(
                    (e.getY()/ (sheetView.getSheet().getPixel(0, 0).getPixelArea().width)-(sheetView.getOrigin().y)),
                    (e.getX()) / (sheetView.getSheet().getPixel(0, 0).getPixelArea().width)-(sheetView.getOrigin().x),
                    usingColor);
            sheetView.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
