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
    //logo
        ImageIcon imageIcon = new ImageIcon("Trohar Delivar-modified.png"); // път към снимката
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH); // нов размер
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel1 = new JLabel(resizedIcon);
        imageLabel1.setBounds(100, 10, 200, 300); // същите размери като на scaledInstance
        add(imageLabel1);

    //hedar
        JPanel coloredPanel1 = new JPanel();
        coloredPanel1.setBounds(0, 0, 2800, 264); // позиция и размер
        coloredPanel1.setBackground(new Color(246, 214, 165)); // цвят на фона
        add(coloredPanel1);
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

//Бутон parvola
        // Зареждане и мащабиране на нормалната снимка
        ImageIcon originalIcon = new ImageIcon("parjola1.png");
        Image scaledNormal = originalIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

// Зареждане и мащабиране на hover снимката
        ImageIcon originalHover = new ImageIcon("parjla2.png");
        Image scaledHover = originalHover.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon = new ImageIcon(scaledHover);

// Създаване на бутона
        JButton imageButton = new JButton(normalIcon);

        imageButton.setBorderPainted(false);
        imageButton.setContentAreaFilled(false);
        imageButton.setFocusPainted(false);
        imageButton.setRolloverIcon(hoverIcon);

        add(imageButton);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                novPotrebitel.setBounds(center2 - 150, 180+100, 100, 25);
                novZaguben.setBounds(center2 - 50, 180+100, 160, 25);
                novVernaparola.setBounds(center2 - 150, 180+140, 100, 25);
                novGreshnaparola.setBounds(center2 - 50, 180+140, 160, 25);
                imageLabel1.setBounds(center2-150, -90, 300, 450);
                imageButton.setBounds(center2-50, 180+180, 120, 100); // позиция и размер
            }
        });
        setVisible(true);




    }
}