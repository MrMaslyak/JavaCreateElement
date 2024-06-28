import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ScrollBarElement extends JPanel implements MouseMotionListener, ActionListener {
    private int heightLine = 10;
    private int progress = 0;
    private int xLine = getWidth() / 2;
    private JLabel coordinat;

    public void setHeightLine(int heightLine) {
        this.heightLine = heightLine;
    }

    public ScrollBarElement(int w, int h, int x, int y, JLabel coordinat) {
        super();
        setSize(w, h);
        setLocation(x, y);
        setBackground(new Color(221, 221, 221, 120));
        addMouseMotionListener(this);
        setLayout(null);
        setVisible(true);
        this.coordinat = coordinat;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        g.drawLine(getWidth() / 5, getHeight() / 2 + heightLine, getWidth() / 5, getHeight() / 2 - heightLine);
        g.drawLine((getWidth() / 5) * 2, getHeight() / 2 + heightLine, (getWidth() / 5) * 2, getHeight() / 2 - heightLine);
        g.drawLine((getWidth() / 5) * 3, getHeight() / 2 + heightLine, (getWidth() / 5) * 3, getHeight() / 2 - heightLine);
        g.drawLine((getWidth() / 5) * 4, getHeight() / 2 + heightLine, (getWidth() / 5) * 4, getHeight() / 2 - heightLine);

        g.setColor(Color.red);
        g.drawOval(xLine-5, getHeight() / 2 - 5, 10, 10);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (e.getX() > xLine && e.getX() < xLine + 10) {
            xLine = e.getX() - 5;
            coordinat.setText(String.valueOf(xLine) + "%");
            setProgress((int) ((double) xLine / (double) getWidth() * 100));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }


    public void setProgress(int progress) {
        this.progress = Math.min(100, Math.max(0, progress));
        coordinat.setText(this.progress + "%");
        if ( progress < 0){
            xLine = 0;
            coordinat.setText("0%");
        } else if (progress > 100) {
            xLine = getWidth()-15;
            coordinat.setText("100%");
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton) source;
        if (button.getText().equals(">")) {
            xLine += 15;
            setProgress((int) ((double) xLine / (double) getWidth() * 100));
            repaint();
        }else if (button.getText().equals("<")) {
            xLine -= 15;
            setProgress((int) ((double) xLine / (double) getWidth() * 100));
            repaint();
        }
    }
    }

