package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.Transaction;
import com.maul.KreditinAja.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllDataTransaction(){
        return transactionService.getAllData();
    }

    @GetMapping("/{id}")
    public Transaction getDataTransactionById(@PathVariable String id){
        return transactionService.getDataById(id);
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
