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
//Бутон вилица
        // Зареждане и мащабиране на нормалната снимка
        ImageIcon originalIcon = new ImageIcon("vilica1.png");
        Image scaledNormal = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

// Зареждане и мащабиране на hover снимката
        ImageIcon originalHover = new ImageIcon("vilica2.png");
        Image scaledHover = originalHover.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
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
                novPotrebitel.setBounds(center2 - 150, 100, 100, 25);
                novZaguben.setBounds(center2 - 50, 100, 160, 25);
                novVernaparola.setBounds(center2 - 150, 140, 100, 25);
                novGreshnaparola.setBounds(center2 - 50, 140, 160, 25);
                CreatButton.setBounds(center2 -50, 190, 140, 25);
                imageButton.setBounds(center2-50, 210, 150, 150); // позиция и размер
            }
        });
        setVisible(true);




    }
}