package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Profile;

public interface ProfileRepository extends GenericRepository<Profile> {
    Profile findByAccountId(String id);
}
