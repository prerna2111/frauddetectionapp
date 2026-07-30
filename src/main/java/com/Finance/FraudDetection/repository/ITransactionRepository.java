package com.Finance.FraudDetection.repository;

import com.Finance.FraudDetection.model.transaction;

import java.util.List;

public interface ITransactionRepository {
    List<transaction> findAll();

    transaction findByID(int id);

    int save(transaction t);

    void updateflag(int id, String flag);
}
