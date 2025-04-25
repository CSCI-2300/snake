package snake.model;

public interface SnakeInterface {
    public void move();
    public GameModel.Direction getDirection();
    public void setDirection(GameModel.Direction direction);
}
