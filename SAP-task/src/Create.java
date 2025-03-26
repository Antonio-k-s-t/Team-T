import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;

public class Create extends JFrame{
    public Create(){
    setTitle("Създай потребител ");
        setSize(650, 500);
        getContentPane().setBackground(new Color(255, 243, 202));
        setLocationRelativeTo(null); // Центрира прозореца на екрана
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    JLabel novPotrebitel = new JLabel(" Нов Потребител:");
        novPotrebitel.setFont(new Font("SansSerif", Font.PLAIN, 14));
    add(novPotrebitel);

    JTextField novZaguben = new JTextField();

    add(novZaguben);

    JLabel novVernaparola = new JLabel(" Нова Парола:");
        novVernaparola.setFont(new Font("SansSerif", Font.PLAIN, 14));
    add(novVernaparola);
    JPasswordField novGreshnaparola = new JPasswordField();
    add(novGreshnaparola);
        JButton CreatButton=new JButton("Създай");
        add(CreatButton);

        ImageIcon normalIcon = new ImageIcon("ChatGPT Image Mar 26, 2025, 03_03_40 PM.png");     // стандартна снимка
        ImageIcon hoverIcon = new ImageIcon("ChatGPT Image Mar 26, 2025, 03_03_44 PM.png");       // снимка при hover

        JButton imageButton = new JButton(normalIcon);

        imageButton.setBorderPainted(false);
        imageButton.setContentAreaFilled(false);
        imageButton.setFocusPainted(false);
        imageButton.setRolloverIcon(hoverIcon); // снимка при hover

        add(imageButton);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                novPotrebitel.setBounds(center2 - 150, 100, 100, 25);
                novZaguben.setBounds(center2 - 50, 100, 160, 25);
                novVernaparola.setBounds(center2 - 150, 140, 100, 25);
                novGreshnaparola.setBounds(center2 - 50, 140, 160, 25);
                CreatButton.setBounds(center2 -50, 190, 140, 25);
                imageButton.setBounds(center2-50, 50, normalIcon.getIconWidth(), normalIcon.getIconHeight());
            }
        });
        setVisible(true);




    }
}