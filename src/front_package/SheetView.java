package front_package;

import back_package.Sheet;

import javax.swing.*;
import java.awt.*;

public class SheetView extends JPanel {
    private Sheet currentSheet;


    public SheetView(Sheet currentSheet){
        this.currentSheet = currentSheet;
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0 ; i < ((this.getParent().getParent().getSize().height)/currentSheet.getPixel(0,0).getPixelArea().width); i++) {
            for (int j = 0; j < (((this.getParent().getParent().getSize().width)/3)*2)/currentSheet.getPixel(0,0).getPixelArea().width; j++) {
                g.drawRect(currentSheet.getPixel(i, j).getPixelArea().x, currentSheet.getPixel(i, j).getPixelArea().y, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
            }
        }
        this.setSize(this.getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = new Dimension(((this.getParent().getParent().getSize().width)/3)*2,this.getParent().getParent().getSize().height);
        return dimension;
    }
}
