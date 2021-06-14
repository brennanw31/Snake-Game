import java.awt.*;
import java.util.Random;

public class Obstacle {
    int x;
    int width;
    int y;
    int height;

    Obstacle(){
        create();
    }

    public void create(){
        Random rand = new Random();
        int orientation = rand.nextInt(2);
        x = (rand.nextInt(GamePanel.SCREEN_WIDTH) / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
        y = (rand.nextInt(GamePanel.SCREEN_HEIGHT) / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
        if(orientation > 0) { //obstacle will be oriented horizontally
            height = GamePanel.UNIT_SIZE;
            width = (rand.nextInt((8 - 4) + 1) + 4) * GamePanel.UNIT_SIZE;  //random int between 6 and 3, inclusive
        } else { //obstacle will be oriented vertically
            width = GamePanel.UNIT_SIZE;
            height = (rand.nextInt((8 - 4) + 1) + 4) * GamePanel.UNIT_SIZE; //random int between 6 and 3, inclusive
        }
    }

    public boolean checkCollision(int headX, int headY){
        if(height == GamePanel.UNIT_SIZE){    //obstacle is horizontal
            if(headY == y)
                if((headX >= x) && (headX <= x + width))    //collision detected
                    return true;
        } else {    //obstacle is vertical
            if(headX == x)
                if((headY >= y) & (headY <= y + height))    //collision detected
                    return true;
        }
        return false;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        if(height == GamePanel.UNIT_SIZE)   //Object is horizontal
            g.fillRect(x, y, width + GamePanel.UNIT_SIZE, height);
        else                                //Object is vertical
            g.fillRect(x, y, width, height + GamePanel.UNIT_SIZE);
    }

}

















