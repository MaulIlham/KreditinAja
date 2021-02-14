package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Profile;
import com.maul.KreditinAja.repositories.AccountRepository;
import com.maul.KreditinAja.services.AccountService;
import com.maul.KreditinAja.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ProfileService profileService;

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAllData() {
        return accountRepository.findAll();
    }

    @Override
    public Account getDataById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public void insertData(Account data) {
        Profile profile = new Profile();
        data.setId(UUID.randomUUID().toString());
        profile.setAccountId(data.getId());
        accountRepository.save(data);
        profileService.insertData(profile);
    }

    @Override
    public void updateData(Account data) {
        accountRepository.update(data);
    }

    @Override
    public void deleteData(String id) {
        Profile profile = profileService.getProfileByAccountId(id);
        profileService.deleteData(profile.getId());
        accountRepository.deleteById(id);
    }
}
