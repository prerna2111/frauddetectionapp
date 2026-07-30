package com.Finance.FraudDetection.repository;

import com.Finance.FraudDetection.model.transaction;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Profile("memory")
public class InMemoryTransactionRepository implements ITransactionRepository {
    private List<transaction> transactions = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public List<transaction> findAll(){
        return transactions;
    }

    @Override
    public transaction findByID(int id){
        for (transaction t:transactions){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    @Override
    public int save(transaction t){
        int newId = idCounter.getAndIncrement();
        t.setId(newId);
        transactions.add(t);
        return newId;
    }

    @Override
    public void updateflag(int id, String flag){
        transaction t = findByID(id);
        if(t!=null){
            t.setStatus(flag);
        }
    }
}
