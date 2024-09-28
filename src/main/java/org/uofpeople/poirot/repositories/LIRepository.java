package org.uofpeople.poirot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uofpeople.poirot.dmos.PersonDMO;

/**
 * Represents CRUD mongo repository
 */
public interface LIRepository extends MongoRepository<PersonDMO, String> {
}
