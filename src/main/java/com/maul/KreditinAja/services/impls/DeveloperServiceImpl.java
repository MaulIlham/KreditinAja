package com.maul.KreditinAja.services.impls;

import com.maul.KreditinAja.entities.Developer;
import com.maul.KreditinAja.repositories.DeveloperRepository;
import com.maul.KreditinAja.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    DeveloperRepository developerRepository;

    @Override
    public List<Developer> getAllData() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDataById(String id) {
        return developerRepository.findById(id);
    }

    @Override
    public void insertData(Developer data) {
        data.setId(UUID.randomUUID().toString());
        developerRepository.save(data);
    }

    @Override
    public void updateData(Developer data) {
        developerRepository.update(data);
    }

    @Override
    public void deleteData(String id) {
        developerRepository.deleteById(id);
    }
}
