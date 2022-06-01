package front_package;

import back_package.Sheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class SheetView extends JPanel implements MouseWheelListener, KeyListener {
    private Sheet currentSheet;
    private Integer zoomOrigin[];
    public final static int X_ORIGIN = 0;
    public final static int Y_ORIGIN = 1;

    private Point origin;

    public SheetView(Sheet currentSheet){
        origin = new Point(0,0);
        this.addKeyListener(this);
        this.currentSheet = currentSheet;
        zoomOrigin = new Integer[2];
        zoomOrigin[X_ORIGIN] = 0;
        zoomOrigin[Y_ORIGIN] = 0;
    }



    @Override
    protected void paintComponent(Graphics g) {
        Color gridBarColor = new Color(150,150,150);
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getSize().width,this.getSize().height);
        for (int i = 0; i < (this.getSize().height/currentSheet.getPixel(0,0).getPixelArea().width); i++) {
            for (int j = 0; j < ((this.getSize().width)/currentSheet.getPixel(0,0).getPixelArea().width); j++) {
                if(this.currentSheet.getPixel(0,0).getPixelArea().width > 6) {
                    g.setColor(gridBarColor);
                    g.drawRect(j*currentSheet.getPixel(i, j).getPixelArea().width,i*currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().width, currentSheet.getPixel(i, j).getPixelArea().height);
                }
                g.setColor(currentSheet.getPixel(i+ origin.y,j+ origin.x).getColor());
                /*ne jamais toucher à la ligne suivante MERCI HUGO*/
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

    public Point getOrigin(){
        return origin;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37){// left arrow
            if(origin.x > 0){
                origin.x--;
            }
        }
        if(e.getKeyCode() == 38){// up arrow
            if(origin.y > 0){
                origin.y--;
            }

        }
        if(e.getKeyCode() == 39){// right arrow
            if(origin.x < Sheet.GRID_WIDTH-(this.getSize().width/currentSheet.getPixel(0,0).getPixelArea().width)) {
                origin.x++;
            }
        }
        if(e.getKeyCode() == 40){// down arrow
            if(origin.y < Sheet.GRID_HEIGHT-(this.getSize().width/currentSheet.getPixel(0,0).getPixelArea().width)) {
                origin.y++;
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
