package main_package;
import back_package.*;
import front_package.MainView;
import front_package.PaletteView;
import front_package.SheetView;

import javax.swing.*;
import java.awt.*;

public class Cassopi {
    public static void main(String[] args){
        System.out.println("Taille de l'écran :" + Toolkit.getDefaultToolkit().getScreenSize().width+" , "+Toolkit.getDefaultToolkit().getScreenSize().height);
        Palette testPalette = new Palette("test");
        Sheet testSheet = new Sheet(25);
        PaletteView testPV = new PaletteView(testPalette);
        SheetView testSV = new SheetView(testSheet);
        MainView mv = new MainView(testPV,testSV);
        System.out.println(testSV.getParent().getParent().getSize());
    }
}
