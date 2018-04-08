package edu.tum.cs.i1.eist.proxy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kiliant on 11.06.17.
 */
public class RemoteImage extends ImageSubject {
    @Override
    public ImageSubject request(URL url) throws IOException {
        this.bufferedImage = ImageIO.read(url);
        ImageIO.write(bufferedImage, "jpg", new File(filePath));
        return this;
    }
}
