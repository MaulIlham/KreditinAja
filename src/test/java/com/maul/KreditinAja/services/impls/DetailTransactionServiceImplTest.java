package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.DetailTransaction;
import com.maul.KreditinAja.repositories.DetailTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DetailTransactionServiceImplTest {

    @Autowired
    DetailTransactionRepository detailTransactionRepository;

    @BeforeEach
    public void cleanUp() {
        detailTransactionRepository.deleteAll();
    }

    @Test
    void getAllData_shouldGet1_whenDataInDBIs1() {
        DetailTransaction detailTransaction = new DetailTransaction("uuid","testa",2300.00,"15-02-2021");
        detailTransactionRepository.save(detailTransaction);
        assertEquals(1,detailTransactionRepository.findAll().size());
    }

    @Test
    void getDataById_shouldGetData_whenGivenCorrectId() {
        DetailTransaction detailTransaction = new DetailTransaction("uuid","testa",2300.00,"15-02-2021");
        detailTransactionRepository.save(detailTransaction);
        assertEquals(detailTransaction,detailTransactionRepository.findById(detailTransaction.getId()));
    }

    @Test
    void insertData_shouldAdd1DataInDB_whenSaved() {
        DetailTransaction detailTransaction = new DetailTransaction("uuid","testa",2300.00,"15-02-2021");
        detailTransactionRepository.save(detailTransaction);
        assertEquals(1,detailTransactionRepository.findAll().size());
    }

    @Test
    void updateData_shouldUpdateDataInDB_whenUpdate() {
        DetailTransaction detailTransaction = new DetailTransaction("uuid","testa",2300.00,"15-02-2021");
        detailTransactionRepository.save(detailTransaction);
        detailTransaction.setDatePayment("14-02-2021");
        detailTransactionRepository.update(detailTransaction);
        assertEquals(detailTransaction,detailTransactionRepository.findById(detailTransaction.getId()));
    }

    @Test
    void deleteData_shouldDelete1DataInDB_whenDeleted() {
        DetailTransaction detailTransactionA = new DetailTransaction("uuid1","testa",2300.00,"15-02-2021");
        DetailTransaction detailTransactionB = new DetailTransaction("uuid2","testb",2500.00,"15-02-2021");
        detailTransactionRepository.save(detailTransactionA);
        detailTransactionRepository.save(detailTransactionB);
        detailTransactionRepository.deleteById(detailTransactionA.getId());
        assertEquals(1,detailTransactionRepository.findAll().size());
    }
}