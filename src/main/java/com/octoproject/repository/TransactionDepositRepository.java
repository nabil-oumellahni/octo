package com.octoproject.repository;

import com.octoproject.domain.TransactionDeposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDepositRepository extends JpaRepository<TransactionDeposit, Long> {
}