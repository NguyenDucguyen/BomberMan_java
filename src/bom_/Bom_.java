package bom_;

import javax.swing.*;
import java.awt.*;

public class Bom_ extends JFrame {
    public void makeGUI(String level, int countLevel, int score)
    {
        // Cấu hình cửa sổ
        setSize(800, 560);
        getContentPane().setBackground(Color.ORANGE);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Map map = new Map(level, countLevel, score);
        add(map);

        Thread thread = new Thread(map);
        thread.start();

        // Đảm bảo giao diện chạy trên EDT
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
