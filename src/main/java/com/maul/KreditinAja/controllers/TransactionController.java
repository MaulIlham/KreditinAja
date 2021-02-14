package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.DetailTransaction;
import com.maul.KreditinAja.entities.Transaction;
import com.maul.KreditinAja.services.DetailTransactionService;
import com.maul.KreditinAja.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    DetailTransactionService detailTransactionService;

    @GetMapping()
    public List<Transaction> getAllDataTransaction(){
        List<Transaction> transactions = transactionService.getAllData().stream()
                .map(item -> {
                    List<DetailTransaction> detailTransactions = detailTransactionService.getAllData().stream()
                            .filter(detailTransaction -> detailTransaction.getTransactionId().equals(item.getId())).collect(Collectors.toList());
                    item.setDetailTransactions(detailTransactions);
                    return item;
                }).collect(Collectors.toList());
        return transactions;
    }

    @GetMapping("/{id}")
    public Transaction getDataTransactionById(@PathVariable String id){
        List<DetailTransaction> detailTransactions = detailTransactionService.getAllData().stream()
                .filter(detailTransaction -> detailTransaction.getTransactionId().equals(id)).collect(Collectors.toList());
        Transaction transaction = transactionService.getDataById(id);
        transaction.setDetailTransactions(detailTransactions);
        return transaction;
    }

    @PostMapping()
    public ResponseEntity<String> saveDataTransaction(@RequestBody Transaction transaction){
        transactionService.insertData(transaction);
        return ResponseEntity.ok("Save Data Transaction Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataTransaction(@RequestBody Transaction transaction){
        transactionService.updateData(transaction);
        return ResponseEntity.ok("Update Data Transaction Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataTransaction(@PathVariable String id){
        transactionService.deleteData(id);
        return ResponseEntity.ok("Delete Data Account Success");
    }
}
