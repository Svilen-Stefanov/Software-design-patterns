package edu.tum.cs.i1.eist.subject;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.tum.cs.i1.eist.Client;

public class EmailSystem extends Subject {

	int numberOfMails = 0;
	
	JButton button;
	JFrame frame;
	JLabel label;
	
	public EmailSystem() {
		createUI();
	}
	
	public int getNumberOfMails() {
		return numberOfMails;
	}
	
	public void addEmail() {
		this.numberOfMails++;
	}

	private void createUI() {
		frame = new JFrame("EmailSystem");
		frame.setLayout(new FlowLayout());
		button = new JButton("New Mail");
		label = new JLabel(numberOfMails+"");
		frame.add(button);
		frame.add(label);
		frame.setSize(200, 60);
		frame.setLocation((Client.dimension.width/2-frame.getSize().width/2)-300, Client.dimension.height/2-frame.getSize().height/2 );
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numberOfMails++;
				label.setText(numberOfMails+"");
				notifyObservers();
				System.out.println("Button pressed counter updated: " + numberOfMails);
			}
		});
	}
	
}
