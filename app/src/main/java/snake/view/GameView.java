package snake.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import snake.model.GameModel;
import snake.model.Observer;
import snake.model.Position;

public class GameView extends JPanel implements Observer {
    private final GameModel model;
    private final int cellSize = 20;

    public GameView(GameModel model) {
        this.model = model;
        this.setPreferredSize(new Dimension(model.getGridWidth() * cellSize, model.getGridHeight() * cellSize));
        this.setBackground(Color.BLACK);
        model.registerObserver(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!model.isRunning()) {
            g.setColor(Color.RED);
            g.drawString("Game Over!", getWidth() / 2 - 30, getHeight() / 2);
            return;
        }

        // Inside paintComponent(Graphics g)
        g.setColor(Color.GREEN);
        for (Position p : model.getSnake()) {
            g.fillRect(p.x * cellSize, p.y * cellSize, cellSize, cellSize);
        }

        Position apple = model.getApple();
        boolean isOrange = model.isOrangeApple();
        if (isOrange) {
            g.setColor(Color.ORANGE);
        }
        else {
            g.setColor(Color.RED);
        }
        g.fillOval(apple.x * cellSize, apple.y * cellSize, cellSize, cellSize);
    }

    @Override
    public void update() {
        repaint();
    }
}

