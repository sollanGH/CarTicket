package test1;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PasswordError {

	public PasswordError() {
		JFrame frame = new JFrame("Error!");
		JLabel label = new JLabel("√‹¬Î¥ÌŒÛ£°");
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		// frame.setLayout(new FlowLayout());
		panel.add(label);
		frame.add(panel);
		label.setFont(new Font("ÀŒÃÂ", Font.BOLD, 25));
		frame.setBounds(820, 480, 300, 120);
		frame.setVisible(true);

	}
}
