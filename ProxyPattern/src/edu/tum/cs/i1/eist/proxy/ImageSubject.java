package edu.tum.cs.i1.eist.proxy;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public abstract class ImageSubject {

	protected BufferedImage bufferedImage;
	protected String imageTitle;
	
	protected static final String filePath = System.getProperty("user.dir") + "/logo.jpg";

	public abstract ImageSubject request(URL url) throws IOException;

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public String getImageTitle() {
		return imageTitle;
	}


}

