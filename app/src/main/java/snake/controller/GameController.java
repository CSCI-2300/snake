package snake.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import snake.model.GameModel;

public class GameController extends KeyAdapter {
    private final GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> model.changeDirection(GameModel.Direction.UP);
            case KeyEvent.VK_DOWN -> model.changeDirection(GameModel.Direction.DOWN);
            case KeyEvent.VK_LEFT -> model.changeDirection(GameModel.Direction.LEFT);
            case KeyEvent.VK_RIGHT -> model.changeDirection(GameModel.Direction.RIGHT);
        }
    }
}

