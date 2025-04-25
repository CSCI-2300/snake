package snake.model;

import java.util.Collections;

public class ConfusedSnake extends SnakeDecorator {

    public ConfusedSnake(SnakeInterface snake) {
        super(snake);
    }

    public void move() {
        GameModel.Direction direction = this.snake.getDirection();
        GameModel.Direction newDirection = direction;
        switch (direction){
            case GameModel.Direction.UP:
                newDirection = GameModel.Direction.RIGHT;
                break;
            case GameModel.Direction.DOWN:
                newDirection = GameModel.Direction.LEFT;
                break;
            case GameModel.Direction.LEFT:
                newDirection = GameModel.Direction.UP;
                break;
            case GameModel.Direction.RIGHT:
                newDirection = GameModel.Direction.DOWN;
                break;
        }
        this.snake.setDirection(newDirection);
        this.snake.move(); 
    }
}
