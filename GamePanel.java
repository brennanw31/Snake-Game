import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    static final int SCREEN_WIDTH = 750;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 25;
    static double TICKS = 15.0;
    Start startMenu;
    Options optionsMenu = null;
    GameOver gameOver;
    SnakeBody snake;
    Apple apple;
    ArrayList<Obstacle> obstacles;
    boolean running = false;
    Thread gameThread;
    Image image;
    Graphics graphics;
    //Timer timer;

    public GamePanel(){
        startMenu = new Start();
        optionsMenu = new Options();
        gameOver = new GameOver();
        snake = new SnakeBody();
        apple = new Apple(snake, null);
        obstacles = null;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void startGame(){
        gameOver.applesEaten = 0;
        //timer = new Timer(DELAY, this);
        if(optionsMenu.obstacleCount != 0){
            obstacles = new ArrayList<Obstacle>();
            for(int i = 0; i < optionsMenu.obstacleCount; i++)
                obstacles.add(new Obstacle());
        }
        snake.create();
        apple.create(snake, obstacles);
        //timer.start();
    }

    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g){
        if(running) {
            drawGrid(g);
            drawScore(g);
            snake.draw(g);
            apple.draw(g);
            for (int i = 0; i < optionsMenu.obstacleCount; i++) {
                obstacles.get(i).draw(g);
            }
        }
        else {
            if (optionsMenu.isOpen)
                optionsMenu.draw(g, snake, apple, obstacles);
            if (startMenu.isOpen)
                startMenu.draw(g);
            if (gameOver.isOpen)
                gameOver.draw(g);
        }
    }

    public void drawGrid(Graphics g){
        g.setColor(Color.darkGray);
        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
    }

    public void drawScore(Graphics g){
        String score = Integer.toString(gameOver.applesEaten);
        g.setColor(Color.white);
        g.setFont(new Font("Cochin", Font.PLAIN, 26));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(score, (SCREEN_WIDTH - metrics.stringWidth(score) - 4), g.getFont().getSize() - 4);
    }

    public boolean checkFailCollisions(){
        if(snake.checkCollision())
            return true;
        if(optionsMenu.obstacleCount != 0)
            for (Obstacle obstacle : obstacles)
                if (obstacle.checkCollision(snake.x[0], snake.y[0]))
                    return true;
        return false;
    }

    @Override
    public void run() {
        //startGame();
        long t = System.nanoTime();
        double ns = 1000000000.0 / TICKS;
        double delta = 0;
        while(true){
            long dt = System.nanoTime();
            delta += (dt - t) / ns;
            t = dt;
            if(delta >= 1) {
                if (running) {
                    snake.move();
                    if (checkFailCollisions()) {
                        running = false;
                        gameOver.isOpen = true;
                    }
                    if (apple.checkCollision(snake.x[0], snake.y[0])) {
                        apple.create(snake, obstacles);
                        gameOver.applesEaten++;
                        snake.bodyParts++;
                    }
                    repaint();
                }
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(snake.direction != 'R'){
                        snake.direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(snake.direction != 'L'){
                        snake.direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(snake.direction != 'D'){
                        snake.direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(snake.direction != 'U'){
                        snake.direction = 'D';
                    }
                    break;
                case KeyEvent.VK_R:
                    if(!running){
                        startMenu.isOpen = true;
                        gameOver.isOpen = false;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if(startMenu.isOpen){
                        startMenu.isOpen = false;
                        running = true;
                        startGame();
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if(startMenu.isOpen){
                        startMenu.isOpen = false;
                        optionsMenu.isOpen = true;
                        repaint();
                        break;
                    }
                    if(optionsMenu.isOpen){
                        startMenu.isOpen = true;
                        optionsMenu.isOpen = false;
                        repaint();
                        break;
                    }
                case KeyEvent.VK_0:
                    if(optionsMenu.isOpen){
                        snake.setColor("green");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_1:
                    if(optionsMenu.isOpen){
                        snake.setColor("blue");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_2:
                    if(optionsMenu.isOpen){
                        snake.setColor("white");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_3:
                    if(optionsMenu.isOpen){
                        snake.setColor("rainbow");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_4:
                    if(optionsMenu.isOpen){
                        snake.setColor("random");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_5:
                    if(optionsMenu.isOpen){
                        apple.setColor("red");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_6:
                    if(optionsMenu.isOpen){
                        apple.setColor("green");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_7:
                    if(optionsMenu.isOpen){
                        apple.setColor("yellow");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_8:
                    if(optionsMenu.isOpen){
                        apple.setColor("rainbow");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_9:
                    if(optionsMenu.isOpen){
                        apple.setColor("random");
                        repaint();
                    }
                    break;
                case KeyEvent.VK_Q:
                    if(optionsMenu.isOpen){
                        TICKS = 12.0;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_W:
                    if(optionsMenu.isOpen){
                        TICKS = 15.0;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_E:
                    if(optionsMenu.isOpen){
                        TICKS = 20.0;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_I:
                    if(optionsMenu.isOpen){
                        optionsMenu.obstacleCount = 0;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_U:
                    if(optionsMenu.isOpen){
                        optionsMenu.obstacleCount = 1;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_J:
                    if(optionsMenu.isOpen && optionsMenu.obstacleCount != 0){
                        optionsMenu.obstacleCount = 1;
                        repaint();
                    }
                    break;
                case KeyEvent.VK_K:
                    if(optionsMenu.isOpen && optionsMenu.obstacleCount != 0){
                        optionsMenu.obstacleCount = 2;
                        repaint();
                    }
                    break;
                    case KeyEvent.VK_L:
                    if(optionsMenu.isOpen && optionsMenu.obstacleCount != 0){
                        optionsMenu.obstacleCount = 3;
                        repaint();
                    }
                    break;
            }
        }
    }
}