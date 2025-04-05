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
        ImageIcon originalIcon2 = new ImageIcon("Garnituri1.png");
        Image scaledNormal2 = originalIcon2.getImage().getScaledInstance(400, 225, Image.SCALE_SMOOTH);
        ImageIcon normalIcon2 = new ImageIcon(scaledNormal2);

        ImageIcon originalHover2 = new ImageIcon("Garnituri2.png");
        Image scaledHover2 = originalHover2.getImage().getScaledInstance(400, 225, Image.SCALE_SMOOTH);
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
        ramka1.setBackground(new Color(244, 200, 152)); // цвят на фона
        ramka1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(ramka1);

        JPanel ramka2 = new JPanel();
        ramka2.setBackground(new Color(244, 200, 152)); // цвят на фона
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
        //Основни
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
            pole1.setBounds(center2_1-870+300, 220, 294, 200); // позиция и размер
            imageButtonbegun6.setBounds(center2_1-870+370, 410, 180, 130);
            pole2.setBounds(center2_1-870+300, 340, 294, 200); // позиция и размер
            imageButtonbegun7.setBounds(center2_1-870+370, 510, 180, 130);
            pole3.setBounds(center2_1-870+300, 440, 294, 200); // позиция и размер
            repaint();
            //това спира бутона за основните
            imageButtonbegun1.setRolloverIcon(null); // премахва hover иконата
            imageButtonbegun1.setIcon(normalIcon);   // връща нормалната икона
            imageButtonbegun5.addActionListener(e1 -> new Burgar());
            imageButtonbegun6.addActionListener(e1 -> new Pizza());
            imageButtonbegun7.addActionListener(e1 -> new Dishes());
        });
        //Гарнитури
        imageButtonbegun2.addActionListener(e -> {
           //бутон за салатите
            ImageIcon originalIcon8 = new ImageIcon("Salata1.png");
            Image scaledNormal8 = originalIcon8.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon8 = new ImageIcon(scaledNormal8);

            ImageIcon originalHover8 = new ImageIcon("Salata2.png");
            Image scaledHover8 = originalHover8.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon8 = new ImageIcon(scaledHover8);

            JButton imageButtonbegun8 = new JButton(normalIcon8);
            imageButtonbegun8.setBorderPainted(false);
            imageButtonbegun8.setContentAreaFilled(false);
            imageButtonbegun8.setFocusPainted(false);
            imageButtonbegun8.setRolloverIcon(hoverIcon8);
            add(imageButtonbegun8);
//поле на бънта за салатите
            JPanel pole4 = new JPanel();
            pole4.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole4);

            //бутон карофки
            ImageIcon originalIcon9 = new ImageIcon("kartofi1.png");
            Image scaledNormal9 = originalIcon9.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon9 = new ImageIcon(scaledNormal9);

            ImageIcon originalHover9 = new ImageIcon("Kartofi2.png");
            Image scaledHover9 = originalHover9.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon9 = new ImageIcon(scaledHover9);

            JButton imageButtonbegun9 = new JButton(normalIcon9);
            imageButtonbegun9.setBorderPainted(false);
            imageButtonbegun9.setContentAreaFilled(false);
            imageButtonbegun9.setFocusPainted(false);
            imageButtonbegun9.setRolloverIcon(hoverIcon9);
            add(imageButtonbegun9);

//поле на бънта за kartofki
            JPanel pole5 = new JPanel();
            pole5.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole5);
            //размеряване
            int center2_2 = getWidth() / 2;
            imageButtonbegun8.setBounds(center2_2-870+650, 290, 180, 130);
            pole4.setBounds(center2_2-870+594, 220, 290, 200); // позиция и размер
            imageButtonbegun9.setBounds(center2_2-870+650, 410, 180, 130);
            pole5.setBounds(center2_2-870+594, 340, 290, 200); // позиция и размер
            repaint();
           //това спира бутона за основните
            imageButtonbegun2.setRolloverIcon(null); // премахва hover иконата
            imageButtonbegun2.setIcon(normalIcon2);   // връща нормалната икона
            imageButtonbegun8.addActionListener(e1 -> new Salat());
            imageButtonbegun9.addActionListener(e1 -> new Potatoes());
        });
        //Десерти
        imageButtonbegun3.addActionListener(e -> {
            //бутон торта
            ImageIcon originalIcon10 = new ImageIcon("Torta1.png");
            Image scaledNormal10 = originalIcon10.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon10 = new ImageIcon(scaledNormal10);

            ImageIcon originalHover10 = new ImageIcon("Torta2.png");
            Image scaledHover10 = originalHover10.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon10 = new ImageIcon(scaledHover10);

            JButton imageButtonbegun10 = new JButton(normalIcon10);
            imageButtonbegun10.setBorderPainted(false);
            imageButtonbegun10.setContentAreaFilled(false);
            imageButtonbegun10.setFocusPainted(false);
            imageButtonbegun10.setRolloverIcon(hoverIcon10);
            add(imageButtonbegun10);
            //панел на битона торта
            JPanel pole6 = new JPanel();
            pole6.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole6.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole6);
            //бутон сладолед
            ImageIcon originalIcon11 = new ImageIcon("sladoled1.png");
            Image scaledNormal11 = originalIcon11.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon11 = new ImageIcon(scaledNormal11);

            ImageIcon originalHover11 = new ImageIcon("Sladoled2.png");
            Image scaledHover11 = originalHover11.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon11 = new ImageIcon(scaledHover11);

            JButton imageButtonbegun11 = new JButton(normalIcon11);
            imageButtonbegun11.setBorderPainted(false);
            imageButtonbegun11.setContentAreaFilled(false);
            imageButtonbegun11.setFocusPainted(false);
            imageButtonbegun11.setRolloverIcon(hoverIcon11);
            add(imageButtonbegun11);
            //панел на битона торта
            JPanel pole7 = new JPanel();
            pole7.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole7);
            //размеряване
            int center2_2 = getWidth() / 2;
            imageButtonbegun10.setBounds(center2_2-870+930, 290, 180, 130);
            pole6.setBounds(center2_2-870+883, 220, 260, 200); // позиция и размер
            imageButtonbegun11.setBounds(center2_2-870+930, 410, 180, 130);
            pole7.setBounds(center2_2-870+883, 340, 260, 200); // позиция и размер
            repaint();
            //това спира бутона за основните
            imageButtonbegun3.setRolloverIcon(null); // премахва hover иконата
            imageButtonbegun3.setIcon(normalIcon3);   // връща нормалната икона
            imageButtonbegun10.addActionListener(e1 -> new Cakes());
            imageButtonbegun11.addActionListener(e1 -> new Icecream());
        });
        //Напитки
        imageButtonbegun4.addActionListener(e -> {
            //бутон без алккохолни напитки  напитки
            ImageIcon originalIcon12 = new ImageIcon("Sok1.png");
            Image scaledNormal12 = originalIcon12.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon12 = new ImageIcon(scaledNormal12);

            ImageIcon originalHover12 = new ImageIcon("Sok2.png");
            Image scaledHover12 = originalHover12.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon12 = new ImageIcon(scaledHover12);

            JButton imageButtonbegun12 = new JButton(normalIcon12);
            imageButtonbegun12.setBorderPainted(false);
            imageButtonbegun12.setContentAreaFilled(false);
            imageButtonbegun12.setFocusPainted(false);
            imageButtonbegun12.setRolloverIcon(hoverIcon12);
            add(imageButtonbegun12);
            //панел на битона торта
            JPanel pole8 = new JPanel();
            pole8.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole8.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole8);
            //бутон алкохол
            ImageIcon originalIcon13 = new ImageIcon("alcko1.png");
            Image scaledNormal13 = originalIcon13.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon normalIcon13 = new ImageIcon(scaledNormal13);

            ImageIcon originalHover13 = new ImageIcon("alcko2.png");
            Image scaledHover13 = originalHover13.getImage().getScaledInstance(160, 111, Image.SCALE_SMOOTH);
            ImageIcon hoverIcon13 = new ImageIcon(scaledHover13);

            JButton imageButtonbegun13 = new JButton(normalIcon13);
            imageButtonbegun13.setBorderPainted(false);
            imageButtonbegun13.setContentAreaFilled(false);
            imageButtonbegun13.setFocusPainted(false);
            imageButtonbegun13.setRolloverIcon(hoverIcon13);
            add(imageButtonbegun13);
            //панел на битона торта
            JPanel pole9 = new JPanel();
            pole9.setBackground(new Color(255, 170, 84)); // цвят на фона
            pole9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            add(pole9);
            //размеряване
            int center2_2 = getWidth() / 2;
            imageButtonbegun12.setBounds(center2_2-870+1185, 290, 180, 130);
            pole8.setBounds(center2_2-870+1142, 220, 270, 200); // позиция и размер
            imageButtonbegun13.setBounds(center2_2-870+1185, 410, 180, 130);
            pole9.setBounds(center2_2-870+1142, 340, 270, 200); // позиция и размер
            repaint();
            //това спира бутона за основните
            imageButtonbegun4.setRolloverIcon(null); // премахва hover иконата
            imageButtonbegun4.setIcon(normalIcon4);   // връща нормалната икона
            imageButtonbegun12.addActionListener(e1 -> new Drinks());
            imageButtonbegun13.addActionListener(e1 -> new Alcohol());
        });
        setVisible(true);









    }
}
