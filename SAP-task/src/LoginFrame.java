import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginFrame extends JFrame {

    public LoginFrame() {
       //целя екран
        setTitle("Вход в системата");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Център на екрана
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 243, 202));
       //логото
        ImageIcon imageIcon = new ImageIcon("Trohar Delivar-modified.png"); // път към снимката
        Image scaledImage = imageIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH); // нов размер
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel logo_trohar = new JLabel(resizedIcon);
        logo_trohar.setBounds(100, 10, 200, 300); // същите размери като на scaledInstance
        add(logo_trohar);

        // хедара
        JPanel coloredPanel = new JPanel();
        coloredPanel.setBounds(0, 0, 2800, 264); // позиция и размер
        coloredPanel.setBackground(new Color(246, 214, 165)); // цвят на фона
        add(coloredPanel);
//Ботон вилица
        // Зареждане и мащабиране на нормалната снимка
        ImageIcon originalIcon1 = new ImageIcon("vilica1.png");
        Image scaledNormal = originalIcon1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

// Зареждане и мащабиране на hover снимката
        ImageIcon originalHover1 = new ImageIcon("vilica2.png");
        Image scaledHover = originalHover1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon = new ImageIcon(scaledHover);

// Създаване на бутона
        JButton imageButton1 = new JButton(normalIcon);
        imageButton1.setBorderPainted(false);
        imageButton1.setContentAreaFilled(false);
        imageButton1.setFocusPainted(false);
        imageButton1.setRolloverIcon(hoverIcon);
        add(imageButton1);
//Бутон лажица
        // Зареждане и мащабиране на нормалната снимка
        ImageIcon originalIcon2 = new ImageIcon("lajica1.png");
        Image scaledNormal1 = originalIcon2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon normalIcon1 = new ImageIcon(scaledNormal1);

// Зареждане и мащабиране на hover снимката
        ImageIcon originalHover2 = new ImageIcon("lajica2.png");
        Image scaledHover1 = originalHover2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon1 = new ImageIcon(scaledHover1);

// Създаване на бутона
        JButton imageButton2 = new JButton(normalIcon1);
        imageButton2.setBorderPainted(false);
        imageButton2.setContentAreaFilled(false);
        imageButton2.setFocusPainted(false);
        imageButton2.setRolloverIcon(hoverIcon1);
        add(imageButton2);
//полета
        JLabel Potrebitel = new JLabel("Потребител:");
        Potrebitel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JTextField Polezapisane_n = new JTextField();
        JLabel Vernaparola = new JLabel("Парола:");
        Vernaparola.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JPasswordField Parola_pole = new JPasswordField();
        JLabel Vhod=new JLabel("Вход");
        Vhod.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JLabel Create=new JLabel("Създай");
        Create.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(Create);
        add(Vhod);
        add(Potrebitel);
        add(Polezapisane_n);
        add(Vernaparola);
        add(Parola_pole);


        // Тук е за центриране на всичко
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int centerX = getWidth() / 2;

                Potrebitel.setBounds(centerX - 150, 180+100, 100, 25);
                Polezapisane_n.setBounds(centerX - 50, 180+100, 160, 25);
                Vernaparola.setBounds(centerX - 150, 180+140, 100, 25);
                Parola_pole.setBounds(centerX - 50, 180+140, 160, 25);
                logo_trohar.setBounds(centerX-150, -90, 300, 450);
                imageButton1.setBounds(centerX-160, 180+180, 150, 90); // позиция и размер
                imageButton2.setBounds(centerX, 180+180, 150, 90); // позиция и размер
                Vhod.setBounds(centerX-120, 180+195, 100, 25);
                Create.setBounds(centerX+60, 180+195, 100, 25);
            }
        });

        // Действия на бутоните
        imageButton1.addActionListener(e -> {
            String user = Polezapisane_n.getText();
            String pass = new String(Parola_pole.getPassword());

            if (user.equals("1") && pass.equals("1")) {
               new Begun();
            } else if (user.equals("Алекс") && pass.equals("1")) {
                JOptionPane.showMessageDialog(this, "Успешен вход като служител!");
            } else {
                JOptionPane.showMessageDialog(this, "Грешни данни");
            }
        });

        imageButton2.addActionListener(e -> new Create());

        setVisible(true);
    }
}