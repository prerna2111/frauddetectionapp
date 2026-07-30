package com.Finance.FraudDetection.controllers;

import com.Finance.FraudDetection.model.transaction;
import com.Finance.FraudDetection.service.FraudDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/transactions")

public class TransactionController {
    private FraudDetectionService fraudDetectionService;
    public TransactionController(FraudDetectionService fraudDetectionService){
        this.fraudDetectionService=fraudDetectionService;
    }
    @GetMapping
    public List<transaction> getAll(){
        return fraudDetectionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public transaction getByID(@PathVariable int id){
        return fraudDetectionService.getTransactionbyID(id);
    }

    @PostMapping
    public transaction createTransaction(@RequestBody transaction t){
     return fraudDetectionService.processTransaction(t);
    }



}
