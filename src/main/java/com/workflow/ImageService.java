package com.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class ImageService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    String userName = (String) delegateExecution.getVariable("userName");
    String userSelect = (String) delegateExecution.getVariable("userSelect");

    if(!userSelect.isEmpty() && !userSelect.isBlank()){
        System.out.println("Hi "+userName+" your selected type is :- "+userSelect+" AND API call started");
        String URL = "";
        if(userSelect.equals("Dog")){
            URL = "https://place.dog/300/200";
        }
        else if (userSelect.equals("Cat")){
            URL = "";
        }
        else if (userSelect.equals("Bear")){
            URL = "https://placebear.com/200/300";
        }
        else{
            URL = "NA";
        }
        new ImageService().downloadAndVerifyFile(URL,userSelect);
    }
    }
    public void downloadAndVerifyFile(String pathUrl,String userSelect) throws IOException  {
        URL url = new URL(pathUrl);
        BufferedImage img = ImageIO.read(url);
        File file = new File("images/"+userSelect+"_downloaded.jpg");
        ImageIO.write(img, "jpg", file);
    }
}
