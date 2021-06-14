import java.awt.*;
import java.util.Random;

public class SnakeBody {
    int[] x;
    int[] y;
    int thickness;
    char direction;
    int bodyParts;
    private String color;
    int i = 0;
    Color[] rainbowColors = {Color.red, Color.orange, Color.yellow, Color.green,
            Color.blue, new Color(78, 96, 196), new Color(102, 0, 153)};

    SnakeBody(){
        int GAME_UNITS = (GamePanel.SCREEN_WIDTH * GamePanel.SCREEN_HEIGHT) / GamePanel.UNIT_SIZE;
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];
        thickness = GamePanel.UNIT_SIZE;
        direction = 'R';
        bodyParts = 6;
        color = "green";
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void create(){
        bodyParts = 6;
        direction = 'R';
        for(int i = 0; i < bodyParts; i++){
            x[i] = (8 - i) * GamePanel.UNIT_SIZE;
            y[i] = 8 * GamePanel.UNIT_SIZE;
        }
    }

    public void move(){
        for(int i = bodyParts; i > 0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction){
            case 'U':
                y[0] -= GamePanel.UNIT_SIZE;
                break;
            case 'D':
                y[0] += GamePanel.UNIT_SIZE;
                break;
            case 'L':
                x[0] -= GamePanel.UNIT_SIZE;
                break;
            case 'R':
                x[0] += GamePanel.UNIT_SIZE;
                break;
        }
    }

    public boolean checkCollision(){
        if((x[0] < 0) || (x[0] >= GamePanel.SCREEN_WIDTH))
            return true;
        if((y[0] < 0) || (y[0] >= GamePanel.SCREEN_HEIGHT))
            return true;
        for(int i = bodyParts; i > 0; i--)
            if((x[0] == x[i]) && (y[0] == y[i]))
                return true;
        return false;
    }

    public void draw(Graphics g){
        switch (color){
            case "green":
                g.setColor(Color.green);
                break;
            case "blue":
                g.setColor(Color.blue);
                break;
            case "white":
                g.setColor(Color.white);
                break;
            case "rainbow":
                g.setColor(rainbowColors[i]);
                i++;    if(i >= 7) i = 0;   //loop through rainbow colors
                break;
            case "random":
                g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
                break;
        }
        for(int i = 0; i < bodyParts; i++){
            g.fillRect(x[i], y[i], thickness, thickness);
        }
    }
}














