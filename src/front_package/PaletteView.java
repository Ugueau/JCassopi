package front_package;
import back_package.Palette;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaletteView extends JPanel {
    private Palette currentPalette;
    private ArrayList<JButton> paletteButton;


    public PaletteView(Palette currentPalette){
        this.currentPalette = currentPalette;
        paletteButton = new ArrayList();
        for (int i = 0; i < currentPalette.getPaletteSize(); i++) {
            paletteButton.add(new JButton());
            paletteButton.get(i).setBackground(currentPalette.getColorAt(i));
        }
        this.placeButton();
    }
    public void placeButton(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < currentPalette.getPaletteSize(); i++){
            constraint.gridx = i % 14;
            constraint.gridy = (i / 14);
            this.add(paletteButton.get(i),constraint);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0,0,this.getPreferredSize().width,this.getPreferredSize().height);
    }

    @Override
    public Dimension getPreferredSize() {
        for (int i = 0; i < paletteButton.size(); i++){
            paletteButton.get(i).setSize(new Dimension((paletteButton.get(i).getParent().getSize().width/14), (paletteButton.get(i).getParent().getSize().width/14)));

        }
        Dimension dimension = new Dimension((this.getParent().getParent().getSize().width)/3, (this.getParent().getParent().getSize().height));
        return dimension;
    }
}
