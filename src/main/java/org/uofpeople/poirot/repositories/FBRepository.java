package org.uofpeople.poirot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uofpeople.poirot.dmos.FBPersonDMO;

/**
 * Represents CRUD mongo repository
 */
public interface FBRepository extends MongoRepository<FBPersonDMO, String> {
}
