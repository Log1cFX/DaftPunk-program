package Screen;

import java.awt.Rectangle;

import javax.swing.JButton;

public class CustomButton extends JButton {
	CustomButton(Rectangle bounds, String text){
		this.setBounds(bounds);
		this.setText(text);
		this.addActionListener(actionListener);
	}
}
