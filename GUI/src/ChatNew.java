import javax.swing.*;
import java.awt.*;

public class Chat {
    public static void main(String[] args) {
        new Chat();
    }

    public Chat() {
        JFrame frame = new JFrame("Чатик");
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        Panel.setBackground(Style.background);

        JScrollPane scroll = new JScrollPane(Panel);
        frame.add(scroll, BorderLayout.CENTER);

        JTextField inputField = new JTextField();
        frame.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(e -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) return;

            JPanel message = new JPanel();
            message.setBackground(Style.message);
            message.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            message.setLayout(new BorderLayout()) ;
            message.setOpaque(true);

            JLabel text_message = new JLabel(text);
            text_message.setForeground(Color.WHITE);
            message.add(text_message, BorderLayout.CENTER);

            message.setBorder(BorderFactory.createLineBorder(Style.message, Style.radius));

            Panel.add(message);
            Panel.add(Box.createVerticalStrut(5));

            inputField.setText("");
            Panel.revalidate();
        });

        frame.setVisible(true);
    }
}