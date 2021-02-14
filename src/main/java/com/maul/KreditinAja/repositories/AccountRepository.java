package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Account;

public interface AccountRepository extends GenericRepository<Account> {
    Account findByUsername(String username);
}
