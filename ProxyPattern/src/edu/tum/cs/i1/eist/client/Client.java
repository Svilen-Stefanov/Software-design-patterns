package edu.tum.cs.i1.eist.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import edu.tum.cs.i1.eist.proxy.ImageSubject;
import edu.tum.cs.i1.eist.proxy.ProxyImage;

public class Client {

	public static void main(String[] args) throws MalformedURLException, IOException {
		ProxyImage proxyImage = new ProxyImage();

		URL invalidURL = new URL("http://THIS URL IS TOTALLY WRONG THEREFORE WE DO A FALLBACK TO A LOCAL IMAGE");
		ImageSubject img1 = proxyImage.request(invalidURL);
		new PictureJFrame(img1);

		URL validURL = new URL("https://www1.in.tum.de/lehrstuhl_1/templates/ordasofttemplate-basetemplate/images/center.jpg");
		ImageSubject img2 = proxyImage.request(validURL);
		new PictureJFrame(img2);

	}

}
