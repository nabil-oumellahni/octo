package com.octoproject.repository;

import com.octoproject.domain.TransactionTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTransferRepository extends JpaRepository<TransactionTransfer, Long> {
}
