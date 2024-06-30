import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CircleScrollElement extends JPanel implements MouseMotionListener {
    private int circleX, circleY;
    private int radius;

    CircleScrollElement(int x, int y, int width, int height) {
        setSize(width, height);
        setLocation(x, y);
        setLayout(null);
        setBackground(new Color(248, 248, 248));
        setOpaque(true);
        setVisible(true);
        radius = width / 2 ;
        addMouseMotionListener(this);
        updateCirclePosition(0);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawOval(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        g.fillOval(circleX, circleY, 10, 10);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int mouseX = e.getX() - getWidth() / 2;
        int mouseY = e.getY() - getHeight() / 2;
        double angle = Math.atan2(mouseY, mouseX);
        updateCirclePosition(angle);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private void updateCirclePosition(double angle) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        circleX = (int) (centerX + radius * Math.cos(angle)) - 9;
        circleY = (int) (centerY + radius * Math.sin(angle)) - 9;
        repaint();
    }
}
