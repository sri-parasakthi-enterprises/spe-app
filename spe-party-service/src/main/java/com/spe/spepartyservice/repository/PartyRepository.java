package com.spe.spepartyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.spepartyservice.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

}
