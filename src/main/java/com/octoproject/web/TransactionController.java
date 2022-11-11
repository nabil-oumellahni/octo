package com.octoproject.web;

import com.octoproject.dto.DepositDto;
import com.octoproject.dto.TransferDto;
import com.octoproject.exception.CompteNonExistantException;
import com.octoproject.exception.SoldeDisponibleInsuffisantException;
import com.octoproject.exception.TransactionException;
import com.octoproject.mapper.DepositMapper;
import com.octoproject.mapper.TransferMapper;
import com.octoproject.service.IAuditService;
import com.octoproject.service.ITransactionService;
import com.octoproject.web.api.TransactionApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
public class TransactionController implements TransactionApi {

    Logger LOGGER = LoggerFactory.getLogger(CompteController.class);
    @Autowired
    private IAuditService auditService;

    @Autowired
    private ITransactionService transactionService;

    @Override
    public List<TransferDto> listerTranferts() {
        LOGGER.info("Lister toutes les transferts");
        return transactionService.getAllTransfers()
                .stream()
                .map(TransferMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepositDto> listerDeposits() {
        LOGGER.info("Lister toutes les deposits");
        return transactionService.getAllDeposits()
                .stream()
                .map(DepositMapper::map)
                .collect(toList());
    }

    @Override
    public void executerTransfert(@RequestBody TransferDto transferDto)
            throws SoldeDisponibleInsuffisantException, CompteNonExistantException, TransactionException {
        transactionService.doTransfer(transferDto);
        LOGGER.info("Executer le transfert");

        auditService.auditTransfer("Transfer depuis " + transferDto.getNrCompteEmetteur() + " vers " +
                transferDto.getNrCompteBeneficiaire() + " d'un montant de " + transferDto.getMontant().toString());
    }

    @Override
    public void executerDeposit(DepositDto depositDto) throws CompteNonExistantException, TransactionException {
        transactionService.doDeposit(depositDto);
        LOGGER.info("Executer le deposit");

        auditService.auditDeposit("Deposit dans " + depositDto.getRib() + " d'un montant de " +
                depositDto.getMontant().toString());
    }
}
