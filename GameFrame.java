import javax.swing.JFrame;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
        this.add(new GamePanel());
        this.setTitle("Brennan's Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.black);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
