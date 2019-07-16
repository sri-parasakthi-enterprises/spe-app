package com.spe.speinvoiceservice.controller;

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
import com.spe.speinvoiceservice.model.Invoice;
import com.spe.speinvoiceservice.repository.InvoiceRepository;

@RestController
@RequestMapping("/spe-invoice")
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@GetMapping(path = "/invoices")
	public Page<Invoice> getAllInvoices(Pageable pageable) {
		return invoiceRepository.findAll(pageable);
	}

	@PostMapping(path = "/invoices")
	public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	@PutMapping(path = "/invoices/{invoiceId}")
	public Invoice updateInvoice(@PathVariable Long invoiceId, @Valid @RequestBody Invoice invoiceRequest) {

		return invoiceRepository.findById(invoiceId).map(invoice -> {
			invoice.setDiscount(invoiceRequest.getDiscount());
			invoice.setRemarks(invoiceRequest.getRemarks());
			invoice.setShipToAddLine1(invoiceRequest.getShipToAddLine1());
			invoice.setShipToAddLine2(invoiceRequest.getShipToAddLine2());
			invoice.setShipToAddLine3(invoiceRequest.getShipToAddLine3());
			invoice.setShipToCity(invoiceRequest.getShipToCity());
			invoice.setShipToPin(invoiceRequest.getShipToPin());
			invoice.setShipToState(invoiceRequest.getShipToState());

			return invoiceRepository.save(invoice);
		}).orElseThrow(() -> new ResourceNotFoundException("Invoice", "Id", invoiceId));
	}

	/**
	 * Delete a generated invoice
	 * *** USE WITH CAUTION ***
	 * @param invoiceId
	 * @return
	 */
	@DeleteMapping(path = "/invoices/{invoiceId}")
	public ResponseEntity<?> deleteInvoice(@PathVariable Long invoiceId) {
		return invoiceRepository.findById(invoiceId).map(invoice -> {
			invoiceRepository.delete(invoice);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Invoice", "Id", invoiceId));
	}

}
