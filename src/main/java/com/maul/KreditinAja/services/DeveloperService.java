package com.maul.KreditinAja.services;

import com.maul.KreditinAja.entities.Developer;
import com.maul.KreditinAja.entities.Profile;

public interface DeveloperService extends GenericService<Developer> {
    public Developer getDeveloperByAccountId(String id);
}
