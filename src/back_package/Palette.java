package back_package;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Palette {
    ArrayList<Color> palette;
    int paletteSize; //ne sert que dans le constructeur
    public Palette() {
        palette = new ArrayList();
        File file = new File(".\\file\\default_color.txt");
        try {
            Scanner scan = new Scanner(file);
            System.out.println("Palette Successfully imported");
            paletteSize = Integer.parseInt(scan.nextLine());
            int loadR;
            int loadG;
            int loadB;
            for (int i = 0; i < paletteSize; i++){
                loadR = Integer.parseInt(scan.next());
                loadG = Integer.parseInt(scan.next());
                loadB = Integer.parseInt(scan.next());
                palette.add(new Color(loadR, loadG, loadB));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        }
    }
    public Palette(String accessPath) {
        palette = new ArrayList();
        File file = new File(accessPath);
        try {
            Scanner scan = new Scanner(file);
            System.out.println("Palette Successfully imported");
            paletteSize = Integer.parseInt(scan.nextLine());
            int loadR;
            int loadG;
            int loadB;
            for (int i = 0; i < paletteSize; i++){
                loadR = Integer.parseInt(scan.next());
                loadG = Integer.parseInt(scan.next());
                loadB = Integer.parseInt(scan.next());
                palette.add(new Color(loadR, loadG, loadB));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void savePalette(String fileName){
         String accessPath = ".\\file\\"+fileName+".txt";
        try {
            FileOutputStream newSave = new FileOutputStream(accessPath);
            try{
                String saveSchema = (int)palette.size() +" ";
                saveSchema += "\n";
                for (int i = 0; i < palette.size(); i++){
                    saveSchema += palette.get(i).getRed();
                    saveSchema += " ";
                    saveSchema += palette.get(i).getGreen();
                    saveSchema += " ";
                    saveSchema += palette.get(i).getBlue();
                    saveSchema += "\n";
                }
                newSave.write(saveSchema.getBytes(StandardCharsets.UTF_8));
            }catch(IOException ioe){
                System.out.println("Save failed");
            }

        }catch(FileNotFoundException fnfe){
            System.out.println("Error can't save in this file");
        }

    }

    public void setNewColor(int r, int g, int b){
        if(r > 0 && r < 255 && g > 0 && b < 255 && b > 0 && b < 255) {
            palette.add(new Color(r, g, b));
        }
        else{
            System.out.println("La couleur n'est pas valide");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0 ; i < palette.size() ; i++){
            result += palette.get(i).toString();
            result += "\n";
        }
        return result;
    }


}
