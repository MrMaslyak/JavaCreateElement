import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JLabel coordinat;

    Menu() {
        setTitle("Menu");
        setSize(500, 500);
        setLayout(null);
        ui();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void ui() {
        coordinat = new JLabel("0");
        coordinat.setBounds(250, 270, 100, 30);
        coordinat.setFont(new Font("Arial", Font.ITALIC, 30));
        coordinat.setForeground(Color.red);
        add(coordinat);



        ScrollBarElement scroll = new ScrollBarElement(100, 250, 125, 0, coordinat);
        add(scroll);

    }

}
