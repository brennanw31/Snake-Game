import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Start extends Menu{

    Start(){
        isOpen = true;
    }

    public void draw(Graphics g){
        g.setColor((Color.green));
        g.setFont(new Font("Cochin", Font.ITALIC, 75));
        FontMetrics metrics = g.getFontMetrics();
        String string = "My Snake Game";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 80);

        g.setColor(Color.white);
        for(int i = 0; i < 5; i++){
            g.drawLine(0, 100+i, GamePanel.SCREEN_WIDTH, 100+i);
        }

        g.setFont(new Font("Cochin", Font.PLAIN, 30));
        metrics = g.getFontMetrics();
        string = "Press Enter for Game Options";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 200);

        g.setFont(new Font("Cochin", Font.PLAIN, 40));
        metrics = g.getFontMetrics();
        string = "Press Space to Begin";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 650);
    }
}
