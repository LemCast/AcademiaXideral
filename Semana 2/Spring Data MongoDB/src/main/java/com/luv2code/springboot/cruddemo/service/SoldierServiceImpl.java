package com.luv2code.springboot.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldierServiceImpl implements SoldierService {

    // Antes se inyectaba SoldierDAO. Ahora es el repositorio de Spring Data,
    // que no tiene implementación escrita a mano.
    private com.luv2code.springboot.cruddemo.repository.SoldierRepository soldierRepository;

    @Autowired
    public SoldierServiceImpl(com.luv2code.springboot.cruddemo.repository.SoldierRepository theSoldierRepository) {
        soldierRepository = theSoldierRepository;
    }

    @Override
    public List<com.luv2code.springboot.cruddemo.entity.Soldier> findAll() {
        return soldierRepository.findAll();
    }

    @Override
    public com.luv2code.springboot.cruddemo.entity.Soldier findById(String theId) {

        // findById() devuelve Optional<Soldier>. Lo convertimos a null para
        // conservar el mismo contrato que tenía la versión con JPA: el
        // controlador sigue comprobando "if (tempSoldier == null)".
        return soldierRepository.findById(theId).orElse(null);
    }

    // Ojo: aquí ya no hay @Transactional.
    //
    // MongoDB en modo standalone (un contenedor suelto, sin replica set) no
    // soporta transacciones multi-documento. Y no hacen falta: cada operación
    // toca un solo documento, y MongoDB garantiza atomicidad por documento.
    @Override
    public com.luv2code.springboot.cruddemo.entity.Soldier save(com.luv2code.springboot.cruddemo.entity.Soldier theSoldier) {
        return soldierRepository.save(theSoldier);
    }

    @Override
    public void deleteById(String theId) {
        soldierRepository.deleteById(theId);
    }
}
