package back_package;

import java.awt.*;

public class Pixel {
    private Color color;
    private Rectangle pixelArea;

    public static Color defaultColor = new Color(255,255,255,0);
    public Pixel() {
    }

    public Pixel(int size){
        this.pixelArea = new Rectangle(size,size);
        color = defaultColor/*new Color((int)(Math.random()*1000%256),(int)(Math.random()*1000%256),(int)(Math.random()*1000%256))*/;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getPixelArea() {
        return pixelArea;
    }

    public void setPixelCoordinate(int x, int y) {
        this.pixelArea.x = x;
        this.pixelArea.y = y;
    }

    public void setPixelSize(int size){
        this.pixelArea.width = size;
        this.pixelArea.height = size;
    }
}
