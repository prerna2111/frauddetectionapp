package com.Finance.FraudDetection.service;

import com.Finance.FraudDetection.model.customer;
import com.Finance.FraudDetection.model.transaction;
import com.Finance.FraudDetection.repository.CustomerRepository;
import com.Finance.FraudDetection.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FraudDetectionService {
    private ITransactionRepository transactionRepository;
    private CustomerRepository customerRepository;

    public FraudDetectionService(ITransactionRepository transactionRepository, CustomerRepository customerRepository){
        this.transactionRepository=transactionRepository;
        this.customerRepository = customerRepository;
    }

    public List<transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public transaction getTransactionbyID(int id){
        return transactionRepository.findByID(id);
    }

    public transaction processTransaction(transaction t){
        int newGeneratedIdTxn = transactionRepository.save(t);
        t.setId(newGeneratedIdTxn);

        List<String> reasons = new ArrayList<>();

        int riskScore = 0;
        //Fraud detection
        //1. High amount
        //2. Odd hours
        //3. Location mismatch
        if(t.getAmount().compareTo(new BigDecimal(1000000))>0){
            reasons.add("High transaction amount Rs. " + t.getAmount());
            riskScore += 40;
        }

        int hour = t.getTxnTimestamp().getHour();
        if(hour>=0 && hour<5){
            reasons.add("Transaction made using odd hours: " + hour + ":00");
            riskScore += 20;
        }
//        customer c = new CustomerRepository().getCustomerByID(t.getCustomer_id());
//
//        if(c!=null && !c.getRegisteredCountry().equalsIgnoreCase((t.getTxnCountry()))){
//            reasons.add("Customer country mismatched: "+t.getTxnCountry());
//            riskScore += 30;
//        }
//
//        if(!reasons.isEmpty()){
//            // update transaction status as flagged;
//            transactionRepository.updateflag(t.getId(),"FLAGGED");
//        }
//        else{
//            //update transaction status as SUCCESS;
//            transactionRepository.updateflag(t.getId(),"SUCCESS");
//        }
        return t;
    }


}
