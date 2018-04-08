package edu.tum.cs.i1.eist;

import java.awt.Dimension;
import java.awt.Toolkit;

import edu.tum.cs.i1.eist.observer.*;
import edu.tum.cs.i1.eist.subject.EmailSystem;

public class Client {

	public static final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EmailSystem emailSystem = new EmailSystem();
		EmailClient emailClient = new EmailClient(emailSystem);
	}

}
