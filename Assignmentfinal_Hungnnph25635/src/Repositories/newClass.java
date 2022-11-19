
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class newClass {

    public static void main(String[] agrs) {
        JFrame mainFrame = new JFrame("JtextField Exampke");

        mainFrame.setSize(400, 150);
        JPanel panel = new JPanel();
        JTextField jTextField = new JTextField(10);
        jTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent event) {
                System.out.println("key typed");
            }

            @Override
            public void keyReleased(KeyEvent event) {
                System.out.println("key released");
            }

            @Override
            public void keyPressed(KeyEvent event) {
                System.out.println("key pressed");
            }
        });
        panel.add(jTextField);
        jTextField.requestFocusInWindow();
        mainFrame.add(panel);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }
}
