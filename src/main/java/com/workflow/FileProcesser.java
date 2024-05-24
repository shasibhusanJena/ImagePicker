package com.workflow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Class used to generate file and store in the temporary file location to process the file.
 */
public class FileProcesser {
    String urlPath ="";
    String userSelect ="";
    public void downloadAndVerifyFile(String urlPath, String userSelect) throws IOException{
           this.urlPath = urlPath ;
           this.userSelect = userSelect;
        try {
            URL URL = new URL(urlPath);
            BufferedImage img = ImageIO.read(URL);
            File file = new File(userSelect+"_Downloaded.jpg");
            ImageIO.write(img,"jpg",file);


        }catch (Exception e){
            System.out.println("file processing error occured"+e.getStackTrace());
        }

    }
}
