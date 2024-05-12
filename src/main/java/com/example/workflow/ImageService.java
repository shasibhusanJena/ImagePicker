package com.example.workflow;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class ImageService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    String userName = (String) delegateExecution.getVariable("userName");
    String userSelect = (String) delegateExecution.getVariable("userSelect");

    if(!userSelect.isEmpty() && !userSelect.isBlank()){
        System.out.println("Hi "+userName+" your selected type is :- "+userSelect+" AND API call started");



    }
    }
}
