import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
public class Begun extends JFrame {
    public Begun() {
        setTitle("Trohar delivary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Център на екрана
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
//бутони за менюто-основни
        ImageIcon originalIcon1 = new ImageIcon("Osnovni1.png");
        Image scaledNormal = originalIcon1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

        ImageIcon originalHover1 = new ImageIcon("Osnovni2.png");
        Image scaledHover = originalHover1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon = new ImageIcon(scaledHover);

        JButton imageButtonbegun1 = new JButton(normalIcon);
        imageButtonbegun1.setBorderPainted(false);
        imageButtonbegun1.setContentAreaFilled(false);
        imageButtonbegun1.setFocusPainted(false);
        imageButtonbegun1.setRolloverIcon(hoverIcon);
        add(imageButtonbegun1);
 //бутони за менюто-салати
        ImageIcon originalIcon2 = new ImageIcon("Salati1.png");
        Image scaledNormal2 = originalIcon2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon normalIcon2 = new ImageIcon(scaledNormal2);

        ImageIcon originalHover2 = new ImageIcon("Salati2.png");
        Image scaledHover2 = originalHover2.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon2 = new ImageIcon(scaledHover2);

        JButton imageButtonbegun2 = new JButton(normalIcon2);
        imageButtonbegun2.setBorderPainted(false);
        imageButtonbegun2.setContentAreaFilled(false);
        imageButtonbegun2.setFocusPainted(false);
        imageButtonbegun2.setRolloverIcon(hoverIcon2);
        add(imageButtonbegun2);
//бутони за менюто-десерти
        ImageIcon originalIcon3 = new ImageIcon("Desert1.png");
        Image scaledNormal3 = originalIcon3.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon normalIcon3 = new ImageIcon(scaledNormal3);

        ImageIcon originalHover3 = new ImageIcon("Desert2.png");
        Image scaledHover3 = originalHover3.getImage().getScaledInstance(400, 291, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon3 = new ImageIcon(scaledHover3);

        JButton imageButtonbegun3 = new JButton(normalIcon3);
        imageButtonbegun3.setBorderPainted(false);
        imageButtonbegun3.setContentAreaFilled(false);
        imageButtonbegun3.setFocusPainted(false);
        imageButtonbegun3.setRolloverIcon(hoverIcon3);
        add(imageButtonbegun3);
//бутони за менюто-напитки
        ImageIcon originalIcon4 = new ImageIcon("Napitka1.png");
        Image scaledNormal4 = originalIcon4.getImage().getScaledInstance(400, 311, Image.SCALE_SMOOTH);
        ImageIcon normalIcon4 = new ImageIcon(scaledNormal4);

        ImageIcon originalHover4 = new ImageIcon("Napitka2.png");
        Image scaledHover4 = originalHover4.getImage().getScaledInstance(400, 311, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon4 = new ImageIcon(scaledHover4);

        JButton imageButtonbegun4 = new JButton(normalIcon4);
        imageButtonbegun4.setBorderPainted(false);
        imageButtonbegun4.setContentAreaFilled(false);
        imageButtonbegun4.setFocusPainted(false);
        imageButtonbegun4.setRolloverIcon(hoverIcon4);
        add(imageButtonbegun4);

        // Тук е за центриране на всичко
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                logo_trohar.setBounds(center2-150, -90, 300, 450);
                imageButtonbegun1.setBounds(center2-870+300, 193, 300, 200);
                imageButtonbegun2.setBounds(center2-585+300, 193, 300, 200);
                imageButtonbegun3.setBounds(center2-299+300, 193, 300, 200);
                imageButtonbegun4.setBounds(center2-42+300, 193, 300, 200);

            }
        });
        setVisible(true);









    }
}
