package com.maul.KreditinAja.services;

import com.maul.KreditinAja.entities.Account;

public interface AccountService extends GenericService<Account> {
    Account getAccountByUsername(String username);
}
