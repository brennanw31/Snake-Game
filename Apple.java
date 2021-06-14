import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Apple {
    int x;
    int y;
    private String color;
    int i = 0;
    Color[] rainbowColors = {Color.red, Color.orange, Color.yellow, Color.green,
            Color.blue, new Color(78, 96, 196), new Color(102, 0, 153)};

    Apple(SnakeBody body, ArrayList<Obstacle> obstacles){
        color = "red";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void create(SnakeBody body, ArrayList<Obstacle> obstacles){
        Random rand = new Random();
        do {
            x = (rand.nextInt(GamePanel.SCREEN_WIDTH) / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
            y = (rand.nextInt(GamePanel.SCREEN_HEIGHT) / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
        }
        while(checkSpawnCollision(body, obstacles));
    }

    public boolean checkSpawnCollision(SnakeBody body, ArrayList<Obstacle> obstacles){
        for(int i = 0; i < body.bodyParts; i++){
            if((x == body.x[i]) && (y == body.y[i]))    //Apple spawn is inside snake body
                return true;
        }
        if(obstacles != null) {
            for (int i = 0; i < obstacles.size(); i++) {
                if (obstacles.get(i).checkCollision(x, y))   //Apple spawn is inside obstacle
                    return true;
            }
        }
        return false;
    }

    public boolean checkCollision(int headX, int headY){
        if((headX == x) && (headY == y))
            return true;
        return false;
    }

    public void draw(Graphics g){
        switch (color){
            case "red":
                g.setColor(Color.red);
                break;
            case "green":
                g.setColor(Color.green);
                break;
            case "yellow":
                g.setColor(Color.yellow);
                break;
            case "rainbow":
                g.setColor(rainbowColors[i]);
                i++;    if(i >= 7) i = 0;   //loop through rainbow colors
                break;
            case "random":
                g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
                break;
        }
        g.fillOval(x, y, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
    }
}
