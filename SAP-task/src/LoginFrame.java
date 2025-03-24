import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Вход в системата");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Център на екрана
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 243, 202));
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

                Potrebitel.setBounds(centerX - 150, 100, 100, 25);
                Zaguben.setBounds(centerX - 50, 100, 160, 25);
                Vernaparola.setBounds(centerX - 150, 140, 100, 25);
                Greshnaparola.setBounds(centerX - 50, 140, 160, 25);
                loginButton.setBounds(centerX - 100, 190, 90, 25);
                RegistButton.setBounds(centerX + 10, 190, 140, 25);
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