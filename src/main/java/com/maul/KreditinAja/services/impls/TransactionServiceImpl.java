package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Transaction;
import com.maul.KreditinAja.repositories.TransactionRepository;
import com.maul.KreditinAja.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllData() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getDataById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void insertData(Transaction data) {
        data.setId(UUID.randomUUID().toString());
        data.setDateTransaction(LocalDate.now().toString());
        transactionRepository.save(data);
    }

    @Override
    public void updateData(Transaction data) {
        transactionRepository.update(data);
    }

    @Override
    public void deleteData(String id) {
        transactionRepository.deleteById(id);
    }
}
