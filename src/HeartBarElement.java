import javax.swing.*;
import java.awt.*;

public class HeartBarElement extends JPanel {
    int radius = 10;
    int radius2 = 20;

    HeartBarElement(int w, int h, int x, int y) {
        setSize(w, h);
        setLocation(x, y);
        setLayout(null);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);

        int x1 = getWidth() / 8;
        int x2 = (getWidth() / 8) * 2;
        int x3 = (getWidth() / 8) * 3;
        int x4 = (getWidth() / 8) * 4;
        int x5 = (getWidth() / 8) * 5;
        int x6 = (getWidth() / 8) * 6;
        int y = getHeight() / 2;

        g.fillOval(x1 - radius, y - radius, radius * 2, radius * 2);
        g.fillOval(x2 - radius, y - radius, radius * 2, radius * 2);
        g.fillOval(x3 - radius, y - radius, radius * 2, radius * 2);
        g.fillOval(x4 - radius, y - radius, radius * 2, radius * 2);
        g.fillOval(x5 - radius, y - radius, radius * 2, radius * 2);
        g.fillOval(x6 - radius, y - radius, radius * 2, radius * 2);

        int[] xPoints = { x1, x2, (x1 + x2) / 2 };
        int[] yPoints = { y + radius2, y + radius2, y + radius2 * 2 };

        int[] xPointsSec = { x3, x4, (x3 + x4) / 2 };
        int[] yPointsSec = { y + radius2, y + radius2, y + radius2 * 2 };

        int[] xPointsThir = { x5, x6, (x5 + x6) / 2 };
        int[] yPointsThir = { y + radius2, y + radius2, y + radius2 * 2 };


        g.fillPolygon(xPoints, yPoints, 3);
        g.fillPolygon(xPointsSec, yPointsSec, 3);
        g.fillPolygon(xPointsThir, yPointsThir, 3);
    }

}