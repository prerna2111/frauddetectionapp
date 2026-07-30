package com.Finance.FraudDetection.controllers;

import com.Finance.FraudDetection.model.transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/fraud-alerts")
public class FraudAlertController {
    @GetMapping
    public String getAll(){
        return "Returning all fraud alerts";
    }

    @GetMapping ("/open")
    public String getOpenAlerts(){
          return "Returning all Open Alerts";
    }

    @PutMapping ("/{id}/status")
    public String updateStatus(){
        return "Checking for status";
    }


}
