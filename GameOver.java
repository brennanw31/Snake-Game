import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GameOver extends Menu{

    int applesEaten = 0;
    int highScore = 0;

    GameOver(){
        isOpen = false;
    }

    public void draw(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Cochin", Font.PLAIN, 75));
        FontMetrics metrics = g.getFontMetrics();
        g.drawString("Game Over", (GamePanel.SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2,
                (GamePanel.SCREEN_HEIGHT / 2) - (3 * GamePanel.UNIT_SIZE));

        if(applesEaten > highScore)
            highScore = applesEaten;
        String score =  "Score: " + applesEaten;
        String highScore = "High Score: " + this.highScore;
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 40));
        FontMetrics metrics1 = g.getFontMetrics();
        g.drawString(highScore, (GamePanel.SCREEN_WIDTH - metrics1.stringWidth(highScore)) / 2,
                (GamePanel.SCREEN_HEIGHT / 2));
        g.drawString(score, (GamePanel.SCREEN_WIDTH - metrics1.stringWidth(score)) / 2,
                (GamePanel.SCREEN_HEIGHT / 2) + (3 * GamePanel.UNIT_SIZE));
        g.drawString("Press R to restart", (GamePanel.SCREEN_WIDTH - metrics1.stringWidth("Press R to restart")) / 2,
                (GamePanel.SCREEN_HEIGHT / 2) + (6 * GamePanel.UNIT_SIZE));
    }
}
