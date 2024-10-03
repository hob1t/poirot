package org.uofpeople.poirot.services;

import org.springframework.stereotype.Service;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.repositories.LIRepository;

import java.util.List;
import java.util.UUID;

/**
 * Data Access Service for the LI repo
 */
@Service
public class LIDAService {
    private LIRepository liRepository;

    public LIDAService(LIRepository liRepository) {
        this.liRepository = liRepository;
    }

    /**
     * Saves DMO into collection
     *
     * @param personDMO
     *
     * @return
     */
    public LIPersonDMO create(LIPersonDMO personDMO) {
        if(personDMO.getId() == null || personDMO.getId().isEmpty()) {
            personDMO.setId(UUID.randomUUID().toString());
        }

        return liRepository.save(personDMO);
    }

    /**
     * Looks up for {@link LIPersonDMO} by ID
     *
     * @param id - a search key.
     *
     * @return {@link LIPersonDMO} or null
     */
    public LIPersonDMO findById(String id) {
        return liRepository.findById(id).orElse(null);
    }

    /**
     * Gets all saved persons
     *
     * @return
     */
    public List<LIPersonDMO> findAll() {
        return liRepository.findAll();
    }

    /**
     * Deletes all documents from the repository.
     */
    public void deleteAll() {
        liRepository.deleteAll();
    }
}
