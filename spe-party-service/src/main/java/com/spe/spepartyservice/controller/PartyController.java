package com.spe.spepartyservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.rest.service.exception.ResourceNotFoundException;
import com.spe.spepartyservice.model.Party;
import com.spe.spepartyservice.repository.PartyRepository;

@RestController
@RequestMapping("/spe-party")
public class PartyController {

	@Autowired
	PartyRepository partyRepository;

	/*	 
	 * Get all parties
	 * TODO - implement a pageable fetch method
	*/
	@GetMapping("/party")
	public Page<Party> getAllParties(Pageable pageable) {
		return partyRepository.findAll(pageable);
	}

	/*
	 * Create a party
	 */
	@PostMapping("/party")
	public Party createParty(@Valid @RequestBody Party party) {
		return partyRepository.save(party);
	}

	/*
	 * Get a single party by Id
	 */
	@GetMapping("/party/{id}")
	public Party getPartyById(@PathVariable(value = "id") Long partyId) {
		return partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));
	}

	/*
	 * Update party
	 */
	@PutMapping("/party/{id}")
	public Party updateParty(@PathVariable(value = "id") Long partyId, @Valid @RequestBody Party partyRequest) {
		Party party = partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));
		
		party.setName(partyRequest.getName());
		party.setSalutation(partyRequest.getSalutation());
		party.setType(partyRequest.getType());

		return partyRepository.save(party);
	}

	/*
	 * Delete party
	 */
	@DeleteMapping("/party/{id}")
	public ResponseEntity<?> deleteParty(@PathVariable(value = "id") Long partyId) {
		Party party = partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));

		partyRepository.delete(party);

		return ResponseEntity.ok().build();
	}

}
