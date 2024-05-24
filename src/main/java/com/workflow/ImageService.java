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
    String responseImagePath="";
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
        responseImagePath = new ImageService().downloadAndVerifyFile(URL,userSelect);
    }
        System.out.println("image path is :- "+responseImagePath);
        delegateExecution.setVariable("imagePath",responseImagePath);
    }
    public String downloadAndVerifyFile(String pathUrl,String userSelect) throws IOException  {
        URL url = new URL(pathUrl);
        BufferedImage img = ImageIO.read(url);
        File file = new File("images/"+userSelect+"_downloaded.jpg");
        ImageIO.write(img, "jpg", file);
        return file.toString();
    }
}
