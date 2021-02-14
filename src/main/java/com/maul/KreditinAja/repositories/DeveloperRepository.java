package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Developer;

public interface DeveloperRepository extends GenericRepository<Developer> {
    Developer findByAccountId(String id);
}
