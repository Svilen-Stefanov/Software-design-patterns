package edu.tum.cs.i1.eist.proxy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ProxyImage extends ImageSubject {
    @Override
    public ImageSubject request(URL url) throws IOException {
        try {
            BufferedImage image = ImageIO.read(url);
            RemoteImage remote = new RemoteImage();
            remote.imageTitle = "RealPicture";
            return remote.request(url);
        } catch (IOException e) {
            this.imageTitle = "Default Image";
            this.bufferedImage = ImageIO.read(new File(filePath));
            return this;
        }
    }
}
