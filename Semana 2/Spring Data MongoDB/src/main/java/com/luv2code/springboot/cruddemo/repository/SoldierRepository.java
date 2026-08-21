package com.luv2code.springboot.cruddemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Aquí estaban SoldierDAO y SoldierDAOJpaImpl — unas 70 líneas de código.
 *
 * MongoRepository&lt;Soldier, String&gt; ya trae implementados findAll(),
 * findById(), save() y deleteById(). Spring Data genera la implementación en
 * tiempo de arranque; no hay ninguna clase que escribir.
 *
 * Los dos parámetros son el tipo de la entidad y el tipo de su @Id.
 */
public interface SoldierRepository extends MongoRepository<com.luv2code.springboot.cruddemo.entity.Soldier, String> {

    // Sin cuerpo. Si más adelante necesitas una consulta propia, basta con
    // declarar el método siguiendo la convención de nombres, por ejemplo:
    //
    //     List<Soldier> findByNickname(String nickname);
    //
    // Spring Data la implementa sola a partir del nombre.
}
