package ventanas;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    private int duration;

    public SplashScreen(int duration) {
        this.duration = duration;
    }

    public void showSplash() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Color.white);

        // Set the window's bounds, centering the window
        int width = 900;
        int height = 700;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("/resources/background_image.jpg")));
        JLabel loadingGif = new JLabel(new ImageIcon(getClass().getResource("/resources/loading.gif")));
        content.add(label, BorderLayout.CENTER);
        content.add(loadingGif, BorderLayout.SOUTH);

        // Customize the panel
        Color customColor = new Color(0, 0, 0, 0); // Transparent
        content.setBorder(BorderFactory.createLineBorder(customColor, 10));

        // Set the window's content and make it visible
        setContentPane(content);
        setVisible(true);

        // Wait a little while, maybe while loading resources
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
    }

    public void showSplashAndExit() {
        showSplash();
        dispose();
    }
}
