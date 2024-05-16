package Screen;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class imagePanel extends JPanel {
	imagePanel(){
		this.setBackground(Color.black);
		ImageIcon imageIcon = new ImageIcon("ressources/daft_punk.jpg");
        JLabel label = new JLabel(imageIcon);
		label.setVisible(true);
		this.add(label);
	}
}
