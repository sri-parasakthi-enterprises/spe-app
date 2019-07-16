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
import com.spe.speinvoiceservice.model.InvoiceItem;
import com.spe.speinvoiceservice.repository.InvoiceItemRepository;
import com.spe.speinvoiceservice.repository.InvoiceRepository;

@RestController
@RequestMapping("/spe-invoice")
public class InvoiceItemController {

	@Autowired
	InvoiceItemRepository invoiceItemRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	@GetMapping(path = "/invoices/{invoiceId}/invoice-items")
	public Page<InvoiceItem> getInvoiceItemsByInvoiceId(@PathVariable(name = "invoiceId") Long invoiceId, 
			Pageable pageable) {

		return invoiceItemRepository.findByInvoiceId(invoiceId, pageable);
	}

	@PostMapping(path = "/invoices/{invoiceId}/invoice-items")
	public InvoiceItem createInvoiceItem(@PathVariable(name = "invoiceId") Long invoiceId, 
			@Valid @RequestBody InvoiceItem invoiceItemRequest) {

		return invoiceRepository.findById(invoiceId).map(invoice -> {
			invoiceItemRequest.setInvoice(invoice);
			return invoiceItemRepository.save(invoiceItemRequest);
		}).orElseThrow(() -> new ResourceNotFoundException("Invoice", "Id", invoiceId));
	}

	@PutMapping(path = "/invoices/{invoiceId}/invoice-items/{itemId}")
	public InvoiceItem updateInvoiceItem(@PathVariable(name = "invoiceId") Long invoiceId, 
			@PathVariable(name = "itemId") Long itemId, 
			@Valid @RequestBody InvoiceItem invoiceItemRequest) {

		if(!invoiceRepository.existsById(invoiceId)) {
			throw new ResourceNotFoundException("Invoice", "Id", invoiceId);
		}

		return invoiceItemRepository.findById(itemId).map(invoiceItem -> {
			invoiceItem.setItemDesc(invoiceItemRequest.getItemDesc());
			invoiceItem.setItemDiscount(invoiceItemRequest.getItemDiscount());
			invoiceItem.setProductId(invoiceItemRequest.getProductId());
			invoiceItem.setQuantity(invoiceItemRequest.getQuantity());
			invoiceItem.setUnitRate(invoiceItemRequest.getUnitRate());

			return invoiceItemRepository.save(invoiceItem);
		}).orElseThrow(()-> new ResourceNotFoundException("InvoiceItem", "Id", itemId));
	}

	@DeleteMapping(path = "/invoices/{invoiceId}/invoice-items/{itemId}")
	public ResponseEntity<?> deleteInvoiceItem(@PathVariable(name = "invoiceId") Long invoiceId, 
			@PathVariable(name = "itemId") Long itemId) {
		return invoiceItemRepository.findByIdAndInvoiceId(itemId, invoiceId).map(invoiceItem -> {
			invoiceItemRepository.delete(invoiceItem);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("InvoiceItem", "Id", itemId));
	}

}
