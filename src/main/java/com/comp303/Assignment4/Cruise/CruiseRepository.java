package com.comp303.Assignment4.Cruise;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CruiseRepository extends MongoRepository<Cruise, String> {
    
}
