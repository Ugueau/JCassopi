package front_package;

import back_package.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class SheetView extends JPanel implements MouseWheelListener {
    private Sheet currentSheet;
    private Integer zoomOrigin[];
    public final static int X_ORIGIN = 0;
    public final static int Y_ORIGIN = 1;

    public SheetView(Sheet currentSheet){
        this.currentSheet = currentSheet;
        zoomOrigin = new Integer[2];
        zoomOrigin[X_ORIGIN] = 0;
        zoomOrigin[Y_ORIGIN] = 0;
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getSize().width,this.getSize().height);
        for (int i = 0; i < (this.getSize().height/currentSheet.getPixel(0,0).getPixelArea().width); i++) {
            for (int j = 0; j < ((this.getSize().width)/currentSheet.getPixel(0,0).getPixelArea().width); j++) {
                if(/*this.currentSheet.getPixel(0,0).getPixelArea().width > 6*/true) {
                    g.setColor(Color.BLACK);
                    g.drawRect(j*currentSheet.getPixel(i, j).getPixelArea().width,i*currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
                }
                /*g.setColor(currentSheet.getPixel(i+zoomOrigin[X_ORIGIN],j+zoomOrigin[Y_ORIGIN]).getColor());*/
                g.setColor(currentSheet.getPixel(i,j).getColor());
                g.fillRect(j*currentSheet.getPixel(i, j).getPixelArea().width, i*currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
            }
        }
        this.setSize(this.getPreferredSize());
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension dimension = new Dimension((((this.getParent().getParent().getSize().width)/3)*2)-((((this.getParent().getParent().getSize().width)/3)*2)%this.getSheet().getPixel(0,0).getPixelArea().width),this.getParent().getParent().getSize().height);
        return dimension;
    }

    public Sheet getSheet() {
        return currentSheet;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        /*if(e.getWheelRotation() == -1){
            int xNbOfPixelBefore = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            int yNbOfPixelBefore = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            this.currentSheet.growPixel();
            int xNbOfPixelAfter = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            int yNbOfPixelAfter = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            this.zoomOrigin[X_ORIGIN] = ((xNbOfPixelBefore-xNbOfPixelAfter)/2) +  zoomOrigin[X_ORIGIN];
            this.zoomOrigin[Y_ORIGIN] = zoomOrigin[Y_ORIGIN] + ((yNbOfPixelBefore-yNbOfPixelAfter)/2);
            this.repaint();
        }

        if(e.getWheelRotation() == 1 && this.currentSheet.getPixel(0,0).getPixelArea().width > 2){
            int xNbOfPixelBefore = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            int yNbOfPixelBefore = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            this.currentSheet.reducePixel();
            int xNbOfPixelAfter = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            int yNbOfPixelAfter = this.getPreferredSize().width/this.currentSheet.getPixel(0,0).getPixelArea().width;
            this.zoomOrigin[X_ORIGIN] = zoomOrigin[X_ORIGIN] - ((xNbOfPixelAfter-xNbOfPixelBefore)/2);
            this.zoomOrigin[Y_ORIGIN] = zoomOrigin[Y_ORIGIN] - ((yNbOfPixelAfter-yNbOfPixelBefore)/2);
            this.repaint();
        }*/
    }

    public Integer[] getZoomOrigin() {
        return zoomOrigin;
    }

}
