package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    public void cleanUp() {
        accountRepository.deleteAll();
    }

    @Test
    void getAccountByUsername_shouldGetData_whenGivenCorrectUsername() {
        Account accountA = new Account(UUID.randomUUID().toString(),"test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        Account accountB = accountRepository.findByUsername("test1");
        assertEquals(accountA,accountB);
    }

    @Test
    void getAllData_shouldGet1_whenDataInDBIs1() {
        Account accountA = new Account(UUID.randomUUID().toString(),"test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        assertEquals(1,accountRepository.findAll().size());
    }

    @Test
    void getDataById_shouldGetData_whenGivenCorrectId() {
        Account accountA = new Account("testUuid","test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        Account accountB = accountRepository.findByUsername("test1");
        assertEquals(accountA,accountRepository.findById(accountB.getId()));
    }

    @Test
    void insertData_shouldAdd1DataInDB_whenSaved() {
        Account accountA = new Account("testUuid","test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        assertEquals(1,accountRepository.findAll().size());
    }

    @Test
    void updateData_shouldUpdateDataInDB_whenUpdate() {
        Account accountA = new Account("testUuid","test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        Account accountB = accountRepository.findByUsername("test1");
        accountB.setUsername("updateTest");
        accountRepository.update(accountB);
        assertEquals(new Account("testUuid","updateTest","test1@gmail.com","test1"),accountB);
    }

    @Test
    void deleteData_shouldDelete1DataInDB_whenDeleted() {
        Account accountA = new Account("testUuid1","test1","test1@gmail.com","test1");
        Account accountB = new Account("testUuid2","test2","test2@gmail.com","test2");
        accountRepository.save(accountA);
        accountRepository.save(accountB);
        accountRepository.deleteById(accountA.getId());
        assertEquals(1,accountRepository.findAll().size());
    }
}