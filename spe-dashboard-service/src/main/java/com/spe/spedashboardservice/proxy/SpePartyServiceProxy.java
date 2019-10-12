package com.spe.spedashboardservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spe.spedashboardservice.model.Party;

@FeignClient(name = "SpePartyService")
public interface SpePartyServiceProxy {

	@RequestMapping("/spe-party/party")
	public Page<Party> getAllParties(Pageable pageable);

	@RequestMapping("/spe-party/party/{id}")
	public Party getPartyById(@PathVariable(value = "id") Long partyId);
	
}
