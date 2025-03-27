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
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        //полета
    JLabel novPotrebitel = new JLabel(" Име:");
        novPotrebitel.setFont(new Font("SansSerif", Font.PLAIN, 14));
    add(novPotrebitel);

    JTextField Polepisane2 = new JTextField();

    add(Polepisane2);

    JLabel novVernaparola1 = new JLabel("Парола:");
        novVernaparola1.setFont(new Font("SansSerif", Font.PLAIN, 14));
    add(novVernaparola1);
    JPasswordField Poleparola2_1 = new JPasswordField();
    add(Poleparola2_1);
      JLabel novVernaparola2=new JLabel("Повтори паролата:");
      novVernaparola2.setFont(new Font("SansSerif", Font.PLAIN, 14));
      add(novVernaparola2);
      JPasswordField Poleparola2_2 = new JPasswordField();
      add(Poleparola2_2);
        JLabel Create1=new JLabel("Създай");
        Create1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(Create1);

//Бутон parvola
        // Зареждане и мащабиране на нормалната снимка
        ImageIcon originalIcon = new ImageIcon("parjola1.png");
        Image scaledNormal = originalIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

// Зареждане и мащабиране на hover снимката
        ImageIcon originalHover = new ImageIcon("parjla2.png");
        Image scaledHover = originalHover.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon = new ImageIcon(scaledHover);

// Създаване на бутона
        JButton imageButton3 = new JButton(normalIcon);

        imageButton3.setBorderPainted(false);
        imageButton3.setContentAreaFilled(false);
        imageButton3.setFocusPainted(false);
        imageButton3.setRolloverIcon(hoverIcon);

        add(imageButton3);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                novPotrebitel.setBounds(center2 - 150, 180+100, 100, 25);
                Polepisane2.setBounds(center2 - 50, 180+100, 160, 25);
                novVernaparola1.setBounds(center2 - 150, 180+140, 100, 25);
                Poleparola2_1.setBounds(center2 - 50, 180+140, 160, 25);
                novVernaparola2.setBounds(center2 - 180, 180+180, 160, 25);
                Poleparola2_2.setBounds(center2 - 50, 180+180, 160, 25);
                imageLabel1.setBounds(center2-150, -90, 300, 450);
                Create1.setBounds(center2-10, 180+200, 100, 25);
                imageButton3.setBounds(center2-30, 180+210, 80, 80); // позиция и размер
            }
        });
        setVisible(true);




    }
}