import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JLabel coordinat;

    Menu() {
        setTitle("Menu");
        setSize(315, 400);
        setLayout(null);
        ui();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void ui() {
        coordinat = new JLabel("0 %");
        coordinat.setBounds(120, 150, 100, 30);
        coordinat.setFont(new Font("Arial", Font.ITALIC, 30));
        coordinat.setForeground(Color.red);
        add(coordinat);

        ScrollBarElement scroll = new ScrollBarElement(300, 150, 0, 0, coordinat);
        add(scroll);

        JButton  buttonM = new JButton("<");
        buttonM.setBounds(3, 150, 40, 35);
        buttonM.setFont(new Font("Arial", Font.ITALIC, 10));
        buttonM.setForeground(new Color(76, 7, 7));
        buttonM.setBackground(new Color(234, 228, 228, 255));
        buttonM.addActionListener(scroll);
        add(buttonM);

        JButton  buttonP = new JButton(">");
        buttonP.setBounds(257, 150, 40, 35);
        buttonP.setFont(new Font("Arial", Font.ITALIC, 10));
        buttonP.setForeground(new Color(76, 7, 7));
        buttonP.setBackground(new Color(234, 228, 228, 255));
        buttonP.addActionListener(scroll);
        add(buttonP);

        HeartBarElement heart = new HeartBarElement(150, 100, 80, 160);
        add(heart);

        LittleNotesElement notes = new LittleNotesElement(100, 260, 80, 100);
        add(notes);


    }


}
