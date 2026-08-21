package com.luv2code.springboot.cruddemo.service;

import java.util.List;

public interface SoldierService {

    List<com.luv2code.springboot.cruddemo.entity.Soldier> findAll();

    com.luv2code.springboot.cruddemo.entity.Soldier findById(int theId);

    com.luv2code.springboot.cruddemo.entity.Soldier save(com.luv2code.springboot.cruddemo.entity.Soldier theSoldier);

    void deleteById(int theId);

}
