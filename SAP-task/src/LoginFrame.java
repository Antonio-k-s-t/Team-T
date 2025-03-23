
import java.awt.Color;
import javax.swing.*;

    public class LoginFrame extends JFrame {

        public LoginFrame() {
            setTitle("Вход в системата");
            setSize(350, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            getContentPane().setBackground(new Color(230, 240, 255));

            JLabel Potrebitel = new JLabel("Потребител:");
            Potrebitel.setBounds(30, 30, 100, 25);
            add(Potrebitel);

            JTextField Zaguben = new JTextField();
            Zaguben.setBounds(130, 30, 160, 25);
            add(Zaguben);

            JLabel Vernaparola = new JLabel("Парола:");
            Vernaparola.setBounds(30, 70, 100, 25);
            add(Vernaparola);

            JPasswordField Greshnaparola = new JPasswordField();
            Greshnaparola.setBounds(130, 70, 160, 25);
            add(Greshnaparola);

            JButton loginButton = new JButton("Вход");
            loginButton.setBounds(190, 110, 140, 25);

            add(loginButton);
            JButton RegistButton = new JButton("Регистрирайсе");
            RegistButton.setBounds(40, 110, 140, 25);
            add(RegistButton);


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

            RegistButton.addActionListener(e -> {
            new Create();
            });
            setVisible(true);
        }
    }

