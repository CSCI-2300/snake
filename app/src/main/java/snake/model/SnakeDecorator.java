package snake.model;

public abstract class SnakeDecorator implements SnakeInterface {

    protected SnakeInterface snake;

    public SnakeDecorator(SnakeInterface snake) {
        this.snake = snake;
    }

    public GameModel.Direction getDirection() {
        return this.snake.getDirection();
    }

    public void setDirection(GameModel.Direction direction) {
        this.snake.setDirection(direction);
    }
    public abstract void move();
}
