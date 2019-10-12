package com.spe.spedashboardservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spe.spedashboardservice.model.Party;
import com.spe.spedashboardservice.proxy.SpePartyServiceProxy;

@RefreshScope
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/spe-dashboard")
public class SpePartyController {

	@Autowired
	SpePartyServiceProxy partyServiceProxy;

	@GetMapping("/party")
	public Page<Party> getAllParties(Pageable pageable) {
//		List<Party> partyList = new ArrayList<Party>();

		Page<Party> partyPage = partyServiceProxy.getAllParties(pageable);

		return partyPage;
	}

	@GetMapping("/party/{id}")
	public Party findPartyById(@PathVariable(value = "id") Long id) {
		return partyServiceProxy.getPartyById(id);
	}

}
