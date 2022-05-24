package front_package;
import back_package.Palette;
import javax.swing.*;

public class PaletteView extends JPanel {
    private Palette currentPalette;


    public PaletteView(Palette currentPalette){
        this.currentPalette = currentPalette;

    }
}
