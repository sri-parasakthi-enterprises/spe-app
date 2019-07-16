package com.spe.speinvoiceservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.speinvoiceservice.model.InvoiceItem;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

	Page<InvoiceItem> findByInvoiceId(Long invoiceId, Pageable pageable);

	Optional<InvoiceItem> findByIdAndInvoiceId(Long id, Long invoiceId);

}
