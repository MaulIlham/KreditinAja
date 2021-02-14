package com.maul.KreditinAja.controllers;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.DetailTransaction;
import com.maul.KreditinAja.services.DetailTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detailtransaction")
public class DetailTransactionController {
    @Autowired
    DetailTransactionService detailTransactionService;

    @GetMapping()
    public List<DetailTransaction> getAllDataDetailTransaction(){
        return detailTransactionService.getAllData();
    }

    @GetMapping("/{id}")
    public DetailTransaction getDataDetailTransactionById(@PathVariable String id){
        return detailTransactionService.getDataById(id);
    }

    @PostMapping()
    public ResponseEntity<String> saveDataDetailTransaction(@RequestBody DetailTransaction detailTransaction){
        detailTransactionService.insertData(detailTransaction);
        return ResponseEntity.ok("Save Data Detial Transaction Success");
    }

    @PutMapping()
    public ResponseEntity<String> updateDataDetailTransaction(@RequestBody DetailTransaction detailTransaction){
        detailTransactionService.updateData(detailTransaction);
        return ResponseEntity.ok("Update Data Detail Transaction Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDataDetailTransaction(@PathVariable String id){
        detailTransactionService.deleteData(id);
        return ResponseEntity.ok("Delete Data Detail Transaction Success");
    }
}
