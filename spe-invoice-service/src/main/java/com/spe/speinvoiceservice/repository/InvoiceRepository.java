package com.spe.speinvoiceservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spe.speinvoiceservice.model.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, Long> {

	Page<Invoice> findById(Long id, Pageable pageable);

}
