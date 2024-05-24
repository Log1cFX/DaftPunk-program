package test;

import java.awt.EventQueue;

public class AudioCuePlayExample {
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable(){
				public void run()
				{	
					DemoFrame frame = new DemoFrame();
					frame.pack;
					frame.setVisible(true);
				}
			});
		}
}