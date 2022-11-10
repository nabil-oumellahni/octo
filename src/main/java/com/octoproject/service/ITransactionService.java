package com.octoproject.service;

import com.octoproject.domain.TransactionDeposit;
import com.octoproject.domain.TransactionTransfer;
import com.octoproject.dto.DepositDto;
import com.octoproject.dto.TransferDto;
import com.octoproject.exception.CompteNonExistantException;
import com.octoproject.exception.SoldeDisponibleInsuffisantException;
import com.octoproject.exception.TransactionException;

import java.util.List;

public interface ITransactionService {

    void doTransfer(TransferDto transferDto) throws CompteNonExistantException, TransactionException, SoldeDisponibleInsuffisantException;

    void doDeposit(DepositDto depositDto) throws CompteNonExistantException, TransactionException;

    List<TransactionTransfer> getAllTransfers();

    List<TransactionDeposit> getAllDeposits();

}
