package edu.tum.cs.i1.eist.observer;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.tum.cs.i1.eist.Client;
import edu.tum.cs.i1.eist.subject.Subject;

public abstract class Observer {
	protected JLabel label;
	protected JFrame frame;

	
	public Observer(Subject subject) {
		subject.subscribe(this);
		createUI();
	}
	
	public abstract void update();
	
	protected void createUI() {
		frame = new JFrame("Observer #1 : (PushNotification)");
		label = new JLabel("0",SwingConstants.CENTER);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.setSize(350, 60);
		frame.setLocation(Client.dimension.width/2-frame.getSize().width/2, (Client.dimension.height/2-frame.getSize().height/2));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
