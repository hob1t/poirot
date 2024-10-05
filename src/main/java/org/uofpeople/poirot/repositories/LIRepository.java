package org.uofpeople.poirot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uofpeople.poirot.dmos.LIPersonDMO;

/** Represents CRUD mongo repository */
public interface LIRepository extends MongoRepository<LIPersonDMO, String> {
}
