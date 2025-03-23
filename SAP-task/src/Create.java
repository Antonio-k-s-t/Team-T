import java.awt.Color;
import javax.swing.*;
public class Create extends JFrame{
    public Create(){
    setTitle("Създай потребител ");
    setSize(350, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLayout(null);
    JLabel novPotrebitel = new JLabel(" Нов Потребител:");
                novPotrebitel.setBounds(30, 30, 100, 25);
    add(novPotrebitel);

    JTextField novZaguben = new JTextField();
                novZaguben.setBounds(130, 30, 160, 25);
    add(novZaguben);

    JLabel novVernaparola = new JLabel(" Нова Парола:");
                novVernaparola.setBounds(30, 70, 100, 25);
    add(novVernaparola);

    JPasswordField novGreshnaparola = new JPasswordField();
                novGreshnaparola.setBounds(130, 70, 160, 25);
    add(novGreshnaparola);
    JButton CreatButton=new JButton("Създай");
                CreatButton.setBounds(190, 110, 140, 25);
    add(CreatButton);
        setVisible(true);

    }
}