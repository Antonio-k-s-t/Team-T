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

        // Тук е за центриране на всичко
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int centerX = getWidth() / 2;
                logo_trohar.setBounds(centerX-150, -90, 300, 450);

            }
        });
        setVisible(true);









    }
}
