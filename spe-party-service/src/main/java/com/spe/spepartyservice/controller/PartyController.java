package com.spe.spepartyservice.controller;

import java.util.Date;

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

	@GetMapping("/party")
	public Page<Party> getAllParties(Pageable pageable) {
		return partyRepository.findAll(pageable);
	}

	@PostMapping("/party")
	public Party createParty(@Valid @RequestBody Party party) {
		return partyRepository.save(party);
	}

	@GetMapping("/party/{id}")
	public Party getPartyById(@PathVariable(value = "id") Long partyId) {
		return partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));
	}

	@PutMapping("/party/{id}")
	public Party updateParty(@PathVariable(value = "id") Long partyId, @Valid @RequestBody Party partyRequest) {
		Party party = partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));
		
		party.setName(partyRequest.getName());
		party.setSalutation(partyRequest.getSalutation());
		party.setType(partyRequest.getType());
		party.setUpdatedAt(new Date());
		party.setAddLine1(partyRequest.getAddLine1());
		party.setAddLine2(partyRequest.getAddLine2());
		party.setAddLine3(partyRequest.getAddLine3());
		party.setCity(partyRequest.getCity());
		party.setState(partyRequest.getState());
		party.setPin(partyRequest.getPin());

		return partyRepository.save(party);
	}

	@DeleteMapping("/party/{id}")
	public ResponseEntity<?> deleteParty(@PathVariable(value = "id") Long partyId) {
		Party party = partyRepository.findById(partyId)
				.orElseThrow(() -> new ResourceNotFoundException("Party", "Id", partyId));

		partyRepository.delete(party);

		return ResponseEntity.ok().build();
	}

}
