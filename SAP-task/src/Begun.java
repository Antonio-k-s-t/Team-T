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
        setSize(1800, 1700);
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
        Image scaledNormal = originalIcon1.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon normalIcon = new ImageIcon(scaledNormal);

        ImageIcon originalHover1 = new ImageIcon("Osnovni2.png");
        Image scaledHover = originalHover1.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon = new ImageIcon(scaledHover);

        JButton imageButtonbegun1 = new JButton(normalIcon);
        imageButtonbegun1.setBorderPainted(false);
        imageButtonbegun1.setContentAreaFilled(false);
        imageButtonbegun1.setFocusPainted(false);
        imageButtonbegun1.setRolloverIcon(hoverIcon);
        add(imageButtonbegun1);
 //бутони за менюто-салати
        ImageIcon originalIcon2 = new ImageIcon("Salati1.png");
        Image scaledNormal2 = originalIcon2.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon normalIcon2 = new ImageIcon(scaledNormal2);

        ImageIcon originalHover2 = new ImageIcon("Salati2.png");
        Image scaledHover2 = originalHover2.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon2 = new ImageIcon(scaledHover2);

        JButton imageButtonbegun2 = new JButton(normalIcon2);
        imageButtonbegun2.setBorderPainted(false);
        imageButtonbegun2.setContentAreaFilled(false);
        imageButtonbegun2.setFocusPainted(false);
        imageButtonbegun2.setRolloverIcon(hoverIcon2);
        add(imageButtonbegun2);
//бутони за менюто-десерти
        ImageIcon originalIcon3 = new ImageIcon("Desert1.png");
        Image scaledNormal3 = originalIcon3.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon normalIcon3 = new ImageIcon(scaledNormal3);

        ImageIcon originalHover3 = new ImageIcon("Desert2.png");
        Image scaledHover3 = originalHover3.getImage().getScaledInstance(400, 191, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon3 = new ImageIcon(scaledHover3);

        JButton imageButtonbegun3 = new JButton(normalIcon3);
        imageButtonbegun3.setBorderPainted(false);
        imageButtonbegun3.setContentAreaFilled(false);
        imageButtonbegun3.setFocusPainted(false);
        imageButtonbegun3.setRolloverIcon(hoverIcon3);
        add(imageButtonbegun3);
//бутони за менюто-напитки
        ImageIcon originalIcon4 = new ImageIcon("Napitka1.png");
        Image scaledNormal4 = originalIcon4.getImage().getScaledInstance(400, 211, Image.SCALE_SMOOTH);
        ImageIcon normalIcon4 = new ImageIcon(scaledNormal4);

        ImageIcon originalHover4 = new ImageIcon("Napitka2.png");
        Image scaledHover4 = originalHover4.getImage().getScaledInstance(400, 211, Image.SCALE_SMOOTH);
        ImageIcon hoverIcon4 = new ImageIcon(scaledHover4);

        JButton imageButtonbegun4 = new JButton(normalIcon4);
        imageButtonbegun4.setBorderPainted(false);
        imageButtonbegun4.setContentAreaFilled(false);
        imageButtonbegun4.setFocusPainted(false);
        imageButtonbegun4.setRolloverIcon(hoverIcon4);
        add(imageButtonbegun4);
//странички рамки
        JPanel ramka1 = new JPanel();
        ramka1.setBackground(new Color(255, 170, 84)); // цвят на фона
        ramka1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(ramka1);

        JPanel ramka2 = new JPanel();
        ramka2.setBackground(new Color(255, 170, 84)); // цвят на фона
        ramka2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(ramka2);
        // Тук е за центриране на всичко
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int center2 = getWidth() / 2;
                logo_trohar.setBounds(center2-150, -90, 300, 450);
                imageButtonbegun1.setBounds(center2-870+300, 180, 300, 200);
                imageButtonbegun2.setBounds(center2-585+300, 180, 300, 200);
                imageButtonbegun3.setBounds(center2-299+300, 180, 300, 200);
                imageButtonbegun4.setBounds(center2-43+300, 180, 300, 200);
                ramka1.setBounds(center2-900, 100, 337, 26400); // позиция и размер
                ramka2.setBounds(center2+542, 100, 337, 26400); // позиция и размер
            }

        });
        imageButtonbegun1.addActionListener(e -> {
            // това е за бутона бургер
            ImageIcon originalIcon5 = new ImageIcon("Burger1.png");
            Image scaledNormal5 = originalIcon5.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon5 = new ImageIcon(scaledNormal5);

            ImageIcon originalHover5 = new ImageIcon("Burger2.png");
            Image scaledHover5 = originalHover5.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon5 = new ImageIcon(scaledHover5);

            JButton imageButtonbegun5 = new JButton(normalIcon5);
            imageButtonbegun5.setBorderPainted(false);
            imageButtonbegun5.setContentAreaFilled(false);
            imageButtonbegun5.setFocusPainted(false);
            imageButtonbegun5.setRolloverIcon(hoverIcon5);
            add(imageButtonbegun5);

            //поле на основните
            JPanel pole1 = new JPanel();
            pole1.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole1);




            // това е за бутона пица
            ImageIcon originalIcon6 = new ImageIcon("pizza1.png");
            Image scaledNormal6 = originalIcon6.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon6 = new ImageIcon(scaledNormal6);

            ImageIcon originalHover6 = new ImageIcon("pizza2.png");
            Image scaledHover6 = originalHover6.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon6 = new ImageIcon(scaledHover6);

            JButton imageButtonbegun6 = new JButton(normalIcon6);
            imageButtonbegun6.setBorderPainted(false);
            imageButtonbegun6.setContentAreaFilled(false);
            imageButtonbegun6.setFocusPainted(false);
            imageButtonbegun6.setRolloverIcon(hoverIcon6);
            add(imageButtonbegun6);
            JPanel pole2 = new JPanel();
            pole2.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole2);
            // бутон за други ястия
            ImageIcon originalIcon7 = new ImageIcon("Hrana1.png");
            Image scaledNormal7 = originalIcon7.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon7 = new ImageIcon(scaledNormal7);

            ImageIcon originalHover7 = new ImageIcon("Hrana2.png");
            Image scaledHover7 = originalHover7.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon7 = new ImageIcon(scaledHover7);

            JButton imageButtonbegun7 = new JButton(normalIcon7);
            imageButtonbegun7.setBorderPainted(false);
            imageButtonbegun7.setContentAreaFilled(false);
            imageButtonbegun7.setFocusPainted(false);
            imageButtonbegun7.setRolloverIcon(hoverIcon7);
            add(imageButtonbegun7);
            JPanel pole3 = new JPanel();
            pole3.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole3);
            //размеряване
            int center2_1 = getWidth() / 2;
            imageButtonbegun5.setBounds(center2_1-870+370, 290, 180, 130);
            pole1.setBounds(center2_1-870+300, 220, 300, 200); // позиция и размер
            imageButtonbegun6.setBounds(center2_1-870+370, 410, 180, 130);
            pole2.setBounds(center2_1-870+300, 340, 300, 200); // позиция и размер
            imageButtonbegun7.setBounds(center2_1-870+370, 510, 180, 130);
            pole3.setBounds(center2_1-870+300, 440, 300, 200); // позиция и размер
            repaint();
            //това спира бутона за основните
            imageButtonbegun1.setRolloverIcon(null); // премахва hover иконата
            imageButtonbegun1.setIcon(normalIcon);   // връща нормалната икона

        });
        setVisible(true);









    }
}
