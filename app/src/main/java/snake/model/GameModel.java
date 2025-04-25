package snake.model;

import java.util.*;

public class GameModel {
    private final int width, height;
    private final Snake snake;
    private Position apple;
    private boolean running = true;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public enum Direction { UP, DOWN, LEFT, RIGHT }

    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.snake = new Snake(width / 2, height / 2);
        spawnApple();
    }

    public void update() {
        if (!running) return;

        snake.move();
        Position head = snake.getHead();

        if (head.x < 0 || head.y < 0 || head.x >= width || head.y >= height || isSelfCollision()) {
            running = false;
        } else if (head.equals(apple)) {
            snake.grow();
            spawnApple();
        }

        notifyObservers();
    }

    public void changeDirection(Direction newDirection) {
        snake.setDirection(newDirection);
    }

    private boolean isSelfCollision() {
        List<Position> body = snake.getBody();
        return body.subList(1, body.size()).contains(snake.getHead());
    }

    private void spawnApple() {
        Random rand = new Random();
        do {
            apple = new Position(rand.nextInt(width), rand.nextInt(height));
        } while (snake.contains(apple));
    }

    public List<Position> getSnake() {
        return snake.getBody();
    }

    public Position getApple() {
        return apple;
    }

    public boolean isRunning() {
        return running;
    }

    public int getGridWidth() {
        return width;
    }

    public int getGridHeight() {
        return height;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (Observer o: observers) {
            o.update();
        }
    }
}

