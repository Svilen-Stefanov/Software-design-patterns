package edu.tum.cs.i1.eist.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.tum.cs.i1.eist.subject.EmailSystem;

public class EmailClient extends Observer implements ActionListener {

	private EmailSystem emailSystem;

	public EmailClient(EmailSystem emailSystem) {
		super(emailSystem);
		this.emailSystem = emailSystem;
	}

	@Override
	public void update() {
		// Push Update -> Not implemented
	}

	protected void createUI() {
		super.createUI();
		frame.setTitle("EmailClient");
		JButton refreshButton = new JButton("Get Mail");
		refreshButton.addActionListener(this);
		frame.add(refreshButton);
		frame.setBounds(frame.getBounds().x, frame.getBounds().y,
				frame.getBounds().width, frame.getBounds().height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Get Mail")) {
			label.setText(emailSystem.getNumberOfMails()+"");
		}
	}

}
