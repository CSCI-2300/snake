package snake.model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private final LinkedList<Position> body = new LinkedList<>();
    private GameModel.Direction direction = GameModel.Direction.RIGHT;
    private boolean grow = false;

    public Snake(int startX, int startY) {
        body.add(new Position(startX, startY));
    }

    public void move() {
        Position head = body.getFirst().move(direction);
        body.addFirst(head);
        if (!grow) {
            body.removeLast();
        } else {
            grow = false;
        }
    }

    public void setDirection(GameModel.Direction newDir) {
        // Prevent reversal
        if ((direction == GameModel.Direction.UP && newDir != GameModel.Direction.DOWN) ||
            (direction == GameModel.Direction.DOWN && newDir != GameModel.Direction.UP) ||
            (direction == GameModel.Direction.LEFT && newDir != GameModel.Direction.RIGHT) ||
            (direction == GameModel.Direction.RIGHT && newDir != GameModel.Direction.LEFT)) {
            direction = newDir;
        }
    }

    public GameModel.Direction getDirection() {
        return direction;
    }

    public Position getHead() {
        return body.getFirst();
    }

    public List<Position> getBody() {
        return new LinkedList<>(body);
    }

    public boolean contains(Position p) {
        return body.contains(p);
    }

    public void grow() {
        grow = true;
    }
}

