import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Options extends Menu{

    int obstacleCount = 0;

    public Options() {
        isOpen = false;
    }

    public void draw(Graphics g, SnakeBody snake, Apple apple, ArrayList<Obstacle> obstacles){
        //Snake Color Choice
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 30));
        FontMetrics metrics = g.getFontMetrics();
        String string = "Choose Snake Color:";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 100);

        string = "0 for Green";
        if(snake.getColor() == "green")
            g.setColor(Color.red);
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 4, 150);
        g.setColor(Color.white);
        if(snake.getColor() == "blue")
            g.setColor(Color.red);
        string = "1 for Blue";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3) / 4, 150);
        g.setColor(Color.white);
        if(snake.getColor() == "white")
            g.setColor(Color.red);
        string = "2 for White";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 4, 200);
        g.setColor(Color.white);
        if(snake.getColor() == "rainbow")
            g.setColor(Color.red);
        string = "3 for Rainbow";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3 ) / 4, 200);
        g.setColor(Color.white);
        if(snake.getColor() == "random")
            g.setColor(Color.red);
        string = "4 for Random";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 250);

        //Apple Color Choice
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 30));
        metrics = g.getFontMetrics();
        string = "Choose Apple Color:";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 350);

        string = "5 for Red";
        if(apple.getColor() == "red")
            g.setColor(Color.red);
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 4, 400);
        g.setColor(Color.white);
        if(apple.getColor() == "green")
            g.setColor(Color.red);
        string = "6 for Green";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3) / 4, 400);
        g.setColor(Color.white);
        if(apple.getColor() == "yellow")
            g.setColor(Color.red);
        string = "7 for Yellow";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 4, 450);
        g.setColor(Color.white);
        if(apple.getColor() == "rainbow")
            g.setColor(Color.red);
        string = "8 for Rainbow";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3 ) / 4, 450);
        g.setColor(Color.white);
        if(apple.getColor() == "random")
            g.setColor(Color.red);
        string = "9 for Random";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 500);

        //Game Speed Choice
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 30));
        metrics = g.getFontMetrics();
        string = "Choose Game Speed:";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 5, 600);

        g.setFont(new Font("Cochin", Font.PLAIN, 20));
        metrics = g.getFontMetrics();
        if(GamePanel.TICKS == 12.0)
            g.setColor(Color.red);
        string = "Q for Slow";
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 5, 650);
        g.setColor(Color.white);
        if(GamePanel.TICKS == 15.0)
            g.setColor(Color.red);
        string = "W for Normal";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 2)/ 5, 650);
        g.setColor(Color.white);
        if(GamePanel.TICKS == 20.0)
            g.setColor(Color.red);
        string = "E for Fast";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3) / 10, 700);

        //Obstacles On or Off
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 30));
        metrics = g.getFontMetrics();
        string = "Obstacles?";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 4) / 5, 600);

        g.setFont(new Font("Cochin", Font.PLAIN, 20));
        metrics = g.getFontMetrics();

        if(obstacleCount != 0)
            g.setColor(Color.red);
        string = "U for Yes";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3) / 5 + 40, 650);
        g.setColor(Color.white);
        if(obstacleCount == 0)
            g.setColor(Color.red);
        string = "I for No";
        g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 4) / 5 + 30, 650);
        g.setColor(Color.white);

        //Number of Obstacles
        if(obstacleCount != 0){
            g.setFont(new Font("Cochin", Font.PLAIN, 15));
            metrics = g.getFontMetrics();
            if(obstacleCount == 1)
                g.setColor(Color.red);
            string = "J for 1";
            g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 3) / 5 + 40, 690);
            g.setColor(Color.white);
            if(obstacleCount == 2)
                g.setColor(Color.red);
            string = "K for 2";
            g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 4) /  5 + 30, 690);
            g.setColor(Color.white);
            if(obstacleCount == 3)
                g.setColor(Color.red);
            string = "L for 3";
            g.drawString(string, ((GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) * 7) / 10 + 35, 720);
        }

        //Back to Start Menu Command
        g.setColor(Color.green);
        g.setFont(new Font("Cochin", Font.PLAIN, 25));
        string = "Press Enter to Return to Start Menu";
        metrics = g.getFontMetrics();
        g.drawString(string, (GamePanel.SCREEN_WIDTH - metrics.stringWidth(string)) / 2, 50);
    }
}
