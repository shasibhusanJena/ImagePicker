package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class ImageService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    String userName = (String) delegateExecution.getVariable("userName");
    String userChoiceType = (String) delegateExecution.getVariable("userChoiceType");

    System.out.println("userName "+userName+" userChoiceType"+userChoiceType);

    }
}
