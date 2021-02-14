package com.maul.KreditinAja.payload;

import com.maul.KreditinAja.entities.Account;
import com.maul.KreditinAja.entities.Profile;

public class AccountResponse {
    private Account account;
    private Profile profile;

    public AccountResponse() {
    }

    public AccountResponse(Account account, Profile profile) {
        this.account = account;
        this.profile = profile;
    }
}
