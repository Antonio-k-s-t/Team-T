import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class Potatoes extends JFrame {
    public Potatoes() {
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
//бУТОН ЗА ВРЪЩАНЕ В НАЧАЛОТО
        ImageIcon originalIcon1_1 = new ImageIcon("Backrest1.png");
        Image scaledNormal1_1 = originalIcon1_1.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
        ImageIcon normalIcon1_1 = new ImageIcon(scaledNormal1_1);

        ImageIcon originalHover1_1 = new ImageIcon("Backrest2.png");
        Image scaledHover1_1 = originalHover1_1.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon1_1 = new ImageIcon(scaledHover1_1);

        JButton imageButtonbegun1_1 = new JButton(normalIcon1_1);
        imageButtonbegun1_1.setBorderPainted(false);
        imageButtonbegun1_1.setContentAreaFilled(false);
        imageButtonbegun1_1.setFocusPainted(false);
        imageButtonbegun1_1.setRolloverIcon(hoverIcon1_1);
        add(imageButtonbegun1_1);
        //hedar
        JPanel coloredPanel1 = new JPanel();
        coloredPanel1.setBounds(0, 0, 2800, 264); // позиция и размер
        coloredPanel1.setBackground(new Color(246, 214, 165)); // цвят на фона
        add(coloredPanel1);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                imageLabel1.setBounds(center2-150, -90, 300, 450);
                imageButtonbegun1_1.setBounds(center2-870, -25, 180, 130);
            }
        });
        imageButtonbegun1_1.addActionListener(e->{
            new Begun();
            SwingUtilities.getWindowAncestor(imageButtonbegun1_1).dispose();
        });
        setVisible(true);
    }
}
