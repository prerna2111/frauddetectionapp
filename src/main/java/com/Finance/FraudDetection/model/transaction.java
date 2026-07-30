package com.Finance.FraudDetection.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class transaction {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private BigDecimal amount;
    private String txnCountry;
    private LocalDateTime txnTimestamp;
    private String status;
    private int customer_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }





    public String getTxnCountry() {
        return txnCountry;
    }

    public void setTxnCountry(String txnCountry) {
        this.txnCountry = txnCountry;
    }

    public LocalDateTime getTxnTimestamp() {
        return txnTimestamp;
    }

    public void setTxnTimestamp(LocalDateTime txnTimestamp) {
        this.txnTimestamp = txnTimestamp;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public transaction(int id,BigDecimal amount,String txnCountry,LocalDateTime txnTimestamp, String status, int customer_id){
        this.id=id;
        this.amount = amount;
        this.txnTimestamp = txnTimestamp;
        this.txnCountry = txnCountry;
        this.status = status;
        this.customer_id= customer_id;
    }

}
