package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SoldierRestController {

    private com.luv2code.springboot.cruddemo.service.SoldierService soldierService;

    private JsonMapper jsonMapper;

    @Autowired
    public SoldierRestController(com.luv2code.springboot.cruddemo.service.SoldierService theSoldierService, JsonMapper theJsonMapper) {
        soldierService = theSoldierService;
        jsonMapper = theJsonMapper;
    }

    // expose "/soldiers" and return a list of soldiers
    @GetMapping("/soldier")
    public List<com.luv2code.springboot.cruddemo.entity.Soldier> findAll() {
        return soldierService.findAll();
    }

    // add mapping for GET /soldiers/{soldierId}
    //
    // El soldierId ahora es String: un ObjectId de MongoDB, no un entero.

    @GetMapping("/soldiers/{soldiersId}")
    public com.luv2code.springboot.cruddemo.entity.Soldier getSoldier(@PathVariable String soldierId) {

        com.luv2code.springboot.cruddemo.entity.Soldier theSoldier = soldierService.findById(soldierId);

        if (theSoldier == null) {
            throw new RuntimeException("Soldier id not found - " + soldierId);
        }

        return theSoldier;
    }

    // add mapping for POST /soldiers - add new soldiers

    @PostMapping("/soldiers")
    public com.luv2code.springboot.cruddemo.entity.Soldier addSoldier(@RequestBody com.luv2code.springboot.cruddemo.entity.Soldier theSoldier) {

        // also just in case they pass an id in JSON ... set id to null
        // this is to force a save of new item ... instead of update
        //
        // En JPA esto era setId(0). En MongoDB el equivalente es null: si el id
        // viene nulo se inserta un documento nuevo, y si viene con valor se
        // REEMPLAZA el documento que ya existía con ese id.

        theSoldier.setId(null);

        com.luv2code.springboot.cruddemo.entity.Soldier dbSoldier = soldierService.save(theSoldier);

        return dbSoldier;
    }

    // add mapping for PUT /soldier - update existing soldier

    @PutMapping("/soldier")
    public com.luv2code.springboot.cruddemo.entity.Soldier updateSoldier(@RequestBody com.luv2code.springboot.cruddemo.entity.Soldier theSoldier) {

        com.luv2code.springboot.cruddemo.entity.Soldier dbSoldier = soldierService.save(theSoldier);

        return dbSoldier;
    }

    // add mapping for PATCH /soldier/{soldierId} - patch soldier ... partial
    // update

    @PatchMapping("/soldiers/{soldierId}")
    public com.luv2code.springboot.cruddemo.entity.Soldier patchSoldier(@PathVariable String soldierId,
                                                                        @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing soldier from database
        com.luv2code.springboot.cruddemo.entity.Soldier tempSoldier = soldierService.findById(soldierId);

        if (tempSoldier == null) {
            throw new RuntimeException("Soldier id not found - " + soldierId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Soldier id cannot be modified. Remove 'id' from request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW soldier object with the updates applied
        com.luv2code.springboot.cruddemo.entity.Soldier patchedSoldier = jsonMapper.updateValue(tempSoldier, patchPayload);

        // Step 4: Save the updated soldier to database and return it
        com.luv2code.springboot.cruddemo.entity.Soldier dbSoldier = soldierService.save(patchedSoldier);

        return dbSoldier;
    }

    // add mapping for DELETE /soldier/{soldierId} - delete soldier

    @DeleteMapping("/soldiers/{soldierId}")
    public String deleteSoldier(@PathVariable String soldierId) {

        com.luv2code.springboot.cruddemo.entity.Soldier tempSoldier = soldierService.findById(soldierId);

        // throw exception if null

        if (tempSoldier == null) {
            throw new RuntimeException("Soldier id not found - " + soldierId);
        }

        soldierService.deleteById(soldierId);

        return "Deleted soldier id - " + soldierId;
    }

}
