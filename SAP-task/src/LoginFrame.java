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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 243, 202));
       //логото
        ImageIcon imageIcon = new ImageIcon("Trohar Delivar-modified.png"); // път към снимката
        Image scaledImage = imageIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH); // нов размер
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(100, 10, 200, 300); // същите размери като на scaledInstance
        add(imageLabel);

        // хедара
        JPanel coloredPanel = new JPanel();
        coloredPanel.setBounds(0, 0, 2000, 180); // позиция и размер
        coloredPanel.setBackground(new Color(246, 214, 165)); // цвят на фона
        add(coloredPanel);




        JLabel Potrebitel = new JLabel("Потребител:");
        Potrebitel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JTextField Zaguben = new JTextField();
        JLabel Vernaparola = new JLabel("Парола:");
        Vernaparola.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JPasswordField Greshnaparola = new JPasswordField();
        JButton loginButton = new JButton("Вход");
        JButton RegistButton = new JButton("Регистрирай се");

        add(Potrebitel);
        add(Zaguben);
        add(Vernaparola);
        add(Greshnaparola);
        add(loginButton);
        add(RegistButton);

        // Компонент лиснър – когато прозорецът се преоразмери
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int centerX = getWidth() / 2;

                Potrebitel.setBounds(centerX - 150, 80+100, 100, 25);
                Zaguben.setBounds(centerX - 50, 80+100, 160, 25);
                Vernaparola.setBounds(centerX - 150, 80+140, 100, 25);
                Greshnaparola.setBounds(centerX - 50, 80+140, 160, 25);
                loginButton.setBounds(centerX - 100, 80+190, 90, 25);
                RegistButton.setBounds(centerX + 10, 80+190, 140, 25);
                imageLabel.setBounds(centerX-90, 0, 200, 150);
            }
        });

        // Действия на бутоните
        loginButton.addActionListener(e -> {
            String user = Zaguben.getText();
            String pass = new String(Greshnaparola.getPassword());

            if (user.equals("Крис") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Успешен вход като клиент!");
            } else if (user.equals("Алекс") && pass.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Успешен вход като служител!");
            } else {
                JOptionPane.showMessageDialog(this, "Грешни данни");
            }
        });

        RegistButton.addActionListener(e -> new Create());

        setVisible(true);
    }
}