package back_package;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sheet {
    public static int GRID_HEIGHT = 900;
    public static int GRID_WIDTH = 1200;
    public static Color defaultColor = new Color(0,0,0,13);
    private Pixel grid[][];

    public Sheet(){
        grid = new Pixel[GRID_HEIGHT][GRID_WIDTH];
        for(int i = 0; i < GRID_HEIGHT; i++ ){
            for(int j = 0 ; j < GRID_WIDTH; j++){
                grid[i][j] = new Pixel(2);
                grid[i][j].setPixelCoordinate(j*grid[i][j].getPixelArea().width,i*grid[i][j].getPixelArea().width);
            }
        }
    }

    public Sheet(int pixelSize){
        grid = new Pixel[GRID_HEIGHT][GRID_WIDTH];
        for(int i = 0; i < GRID_HEIGHT; i++ ){
            for(int j = 0 ; j < GRID_WIDTH; j++){
                grid[i][j] = new Pixel(pixelSize);
                grid[i][j].setPixelCoordinate(j*grid[i][j].getPixelArea().width,i*grid[i][j].getPixelArea().width);
            }
        }
    }

    public void growPixel(){
        int actualSize = grid[0][0].getPixelArea().width;
        for(int i = 0; i < GRID_HEIGHT; i++ ) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                grid[i][j].setPixelSize(actualSize+1);
                grid[i][j].setPixelCoordinate(j*grid[i][j].getPixelArea().width,i*grid[i][j].getPixelArea().width);
            }
        }
    }

    public void reducePixel(){
        int actualSize = grid[0][0].getPixelArea().width;
        for(int i = 0; i < GRID_HEIGHT; i++ ) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                grid[i][j].setPixelSize(actualSize-1);
                grid[i][j].setPixelCoordinate(j*grid[i][j].getPixelArea().width,i*grid[i][j].getPixelArea().width);
            }
        }
    }

    public void setPixelColor(int x, int y, Color newColor){
        grid[x][y].setColor(newColor);

    }

    public Pixel getPixel(int x, int y){
        return grid[x][y];
    }

    public void resetSheet(){
        for(int i = 0; i < GRID_HEIGHT; i++){
            for(int j = 0 ; j < GRID_WIDTH; j++){
                grid[i][j].setColor(defaultColor);
            }
        }
    }

    public void saveToSVG(String fileName){
        String home = System.getProperty("user.home");
        try {
            FileOutputStream svgSave = new FileOutputStream(home + "/Downloads/" + fileName + ".html");
            try{
                svgSave.write(("<svg width=\""+GRID_WIDTH+"\" height=\""+GRID_HEIGHT+"\">").getBytes(StandardCharsets.UTF_8));
                for (int i =0; i < GRID_HEIGHT; i++){
                    for(int j = 0 ; j < GRID_WIDTH; j++){
                        if(grid[i][j].getColor() != Pixel.defaultColor || grid[i][j].getColor().getAlpha() != 0) {
                            svgSave.write(("<rect x=\"" + grid[i][j].getPixelArea().x + "\" y=\"" + grid[i][j].getPixelArea().y + "\" width=\"" + grid[i][j].getPixelArea().width + "\" height=\"" + grid[i][j].getPixelArea().height + "\" style=\" fill:rgb(" + grid[i][j].getColor().getRed() + "," + grid[i][j].getColor().getGreen() + "," + grid[i][j].getColor().getBlue() + ") \"></rect>\n").getBytes(StandardCharsets.UTF_8)); //<rect x="406" y="834" width="1" height="1" style=" fill:rgb(255,127,0) "></rect>
                        }
                    }
                }
                svgSave.close();
            }catch(IOException ioe){
                System.out.println("Save failed");
            }
        }catch(FileNotFoundException fnfe){
            System.out.println("Error can't save in this file");
        }
    }
}
