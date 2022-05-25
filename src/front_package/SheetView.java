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
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getSize().width,this.getSize().height);
        System.out.println("paint");
        for (int i = 0 ; i < (this.getSize().height/currentSheet.getPixel(0,0).getPixelArea().width); i++) {
            for (int j = 0; j < ((this.getSize().width)/currentSheet.getPixel(0,0).getPixelArea().width); j++) {
                g.setColor(Color.BLACK);
                g.drawRect(currentSheet.getPixel(i, j).getPixelArea().x, currentSheet.getPixel(i, j).getPixelArea().y, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
                g.setColor(currentSheet.getPixel(i,j).getColor());
                g.fillRect(currentSheet.getPixel(i,j).getPixelArea().x, currentSheet.getPixel(i, j).getPixelArea().y, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
            }
        }

        this.setSize(this.getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        System.out.println("size");
        Dimension dimension = new Dimension((((this.getParent().getParent().getSize().width)/3)*2)-((((this.getParent().getParent().getSize().width)/3)*2)%this.getSheet().getPixel(0,0).getPixelArea().width),this.getParent().getParent().getSize().height);
        return dimension;
    }

    public Sheet getSheet() {
        return currentSheet;
    }
}
