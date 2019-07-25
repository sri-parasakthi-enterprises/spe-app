package com.spe.spepartyservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spe.spepartyservice.model.Party;

public interface PartyRepository extends MongoRepository<Party, Long> {

	@Query("{name: { $regex: ?0 } })")
    List<Party> findPartyByRegExName(String name);
}
