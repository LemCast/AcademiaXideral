package com.luv2code.springboot.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldierServiceImpl implements SoldierService {

    private com.luv2code.springboot.cruddemo.dao.SoldierRepository soldierRepository;

    @Autowired
    public SoldierServiceImpl(com.luv2code.springboot.cruddemo.dao.SoldierRepository theSoldierRepository) {
        soldierRepository = theSoldierRepository;
    }

    @Override
    public List<com.luv2code.springboot.cruddemo.entity.Soldier> findAll() {
        return soldierRepository.findAll();
    }

    @Override
    public com.luv2code.springboot.cruddemo.entity.Soldier findById(int theId) {
        Optional<com.luv2code.springboot.cruddemo.entity.Soldier> result = soldierRepository.findById(theId);

        com.luv2code.springboot.cruddemo.entity.Soldier theSoldier = null;

        if (result.isPresent()) {
            theSoldier = result.get();
        }
        else {
            // we didn't find the soldier
            throw new RuntimeException("Did not find soldier id - " + theId);
        }

        return theSoldier;
    }

    @Override
    public com.luv2code.springboot.cruddemo.entity.Soldier save(com.luv2code.springboot.cruddemo.entity.Soldier theSoldier) {
        return soldierRepository.save(theSoldier);
    }

    @Override
    public void deleteById(int theId) {
        soldierRepository.deleteById(theId);
    }
}






