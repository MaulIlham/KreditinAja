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
//        accountRepository.deleteAll();
    }

    @Test
    void getAccountByUsername() {
    }

    @Test
    void getAllData_shouldGet1_whenDataInDBIs1() {
        Account accountA = new Account(UUID.randomUUID().toString(),"test1","test1@gmail.com","test1");
        accountRepository.save(accountA);
        assertEquals(1,accountRepository.findAll().size());
    }

    @Test
    void getDataById() {
    }

    @Test
    void insertData() {
    }

    @Test
    void updateData() {
    }

    @Test
    void deleteData() {
    }
}