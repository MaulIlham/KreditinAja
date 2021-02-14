package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.DetailTransaction;
import com.maul.KreditinAja.repositories.DetailTransactionRepository;
import com.maul.KreditinAja.services.DetailTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class DetailTransactionServiceImpl implements DetailTransactionService {
    @Autowired
    DetailTransactionRepository detailTransactionRepository;

    @Override
    public List<DetailTransaction> getAllData() {
        return detailTransactionRepository.findAll();
    }

    @Override
    public DetailTransaction getDataById(String id) {
        return detailTransactionRepository.findById(id);
    }

    @Override
    public void insertData(DetailTransaction data) {
        data.setId(UUID.randomUUID().toString());
        data.setDatePayment(LocalDate.now().toString());
        detailTransactionRepository.save(data);
    }

    @Override
    public void updateData(DetailTransaction data) {
        detailTransactionRepository.update(data);
    }

    @Override
    public void deleteData(String id) {
        detailTransactionRepository.deleteById(id);
    }
}
