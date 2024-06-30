import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LittleNotesElement extends JPanel implements ActionListener, MouseMotionListener {
    JButton button;
    JLabel label;
    JTextField textField;
    LittleNotesElement(int x, int y, int width, int height) {
        setSize(width, height);
        setLocation(x, y);
        setLayout(null);
        setBackground(new Color (225, 225, 225));
        setOpaque(true);
        ui(width);
        setBorder(BorderFactory.createLineBorder(Color.red));
        setVisible(true);
    }
    public void ui(int width) {
        textField =  new JTextField();
       textField.setBounds(0, 0, width-30, 20);
       textField.setBorder(BorderFactory.createLineBorder(Color.blue));
       add(textField);

       button = new JButton("Add");
       button.setBounds(width-30, 0, 30, 20);
       button.setForeground(new Color(76, 7, 7));
       button.setBackground(new Color(234, 228, 228, 255));
       button.setFont(new Font("Arial", Font.ITALIC, 10));
       button.setBorder(BorderFactory.createLineBorder(Color.blue));
       button.addActionListener(this);

       add(button);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label = new JLabel();
            label.setText(textField.getText());
            textField.setText("");
            label.setBounds(10, 40, getWidth() - 20, 20);
            label.setFont(new Font("Arial", Font.ITALIC, 8));
            label.addMouseMotionListener(this);
            add(label);
            revalidate();
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() + label.getX();
        int y = e.getY() + label.getY();
        label.setLocation(x, y);
        repaint();
        revalidate();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}