package org.uofpeople.poirot.services;

import org.springframework.stereotype.Service;
import org.uofpeople.poirot.dmos.FBPersonDMO;
import org.uofpeople.poirot.repositories.FBRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FIDAService {
    private FBRepository facebookRepo;

    public FIDAService(FBRepository fbRepo) {
        this.facebookRepo = fbRepo;
    }

    /**
     * Saves a {@link FBPersonDMO}
     *
     * @param fbPersonDMO
     *
     * @return
     */
    public FBPersonDMO create(FBPersonDMO fbPersonDMO) {
        if(fbPersonDMO.getId() == null) {
            fbPersonDMO.setId(UUID.randomUUID().toString());
        }
        return facebookRepo.save(fbPersonDMO);
    }

    /**
     * Gets a list of {@link FBPersonDMO}s
     *
     * @return
     */
    public List<FBPersonDMO> findAll() {
        return facebookRepo.findAll();
    }

    /**
     * Deletes all documents from the collection
     */
    public void deleteAll() {
        facebookRepo.deleteAll();
    }
}
