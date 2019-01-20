
package watch2;

import Presente.WatchPresenter;
import View.WatchDisplay;
import Model.Watch;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class Main extends JFrame{
    public static void main (String [] args) throws IOException{
        new Main().launch();
    }

    private void launch() throws IOException {
        setVisible(true);
    }
    public Main() throws IOException {
        Watch watch = new Watch();
        WatchDisplay watchDisplay = new WatchDisplay(background());
        WatchPresenter watchPresenter = new WatchPresenter(watch, watchDisplay);
        this.init();
        this.add(watchDisplay);
    }
    private Image background() throws IOException {
        return ImageIO.read(new File("src\\watch2\\clocks.jpg"));
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.setLocation(1680,0);
        this.setSize(236,236);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
