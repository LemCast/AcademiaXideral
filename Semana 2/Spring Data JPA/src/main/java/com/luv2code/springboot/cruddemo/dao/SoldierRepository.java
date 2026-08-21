package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<com.luv2code.springboot.cruddemo.entity.Soldier, Integer> {

    // that's it ... no need to write any code LOL!

}
