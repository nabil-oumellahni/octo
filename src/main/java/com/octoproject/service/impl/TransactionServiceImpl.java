package com.octoproject.service.impl;

import com.octoproject.domain.Compte;
import com.octoproject.domain.TransactionDeposit;
import com.octoproject.domain.TransactionTransfer;
import com.octoproject.dto.DepositDto;
import com.octoproject.dto.TransferDto;
import com.octoproject.exception.CompteNonExistantException;
import com.octoproject.exception.SoldeDisponibleInsuffisantException;
import com.octoproject.exception.TransactionException;
import com.octoproject.repository.CompteRepository;
import com.octoproject.repository.TransactionDepositRepository;
import com.octoproject.repository.TransactionTransferRepository;
import com.octoproject.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {

    public static final int MONTANT_MAXIMAL = 10000;

    Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);

    @Autowired
    private TransactionDepositRepository depositRepository;
    @Autowired
    private TransactionTransferRepository transferRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public void doTransfer(TransferDto transferDto) throws CompteNonExistantException, TransactionException, SoldeDisponibleInsuffisantException {
        Compte compteEmetteur = compteRepository.findByNrCompte(transferDto.getNrCompteEmetteur());
        Compte compteBeneficiaire = compteRepository.findByNrCompte(transferDto.getNrCompteBeneficiaire());

        if (compteEmetteur == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (compteBeneficiaire == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (transferDto.getMontant() == null || transferDto.getMontant().intValue() == 0) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (transferDto.getMontant().intValue() < 10) {
            System.out.println("Montant minimal de transfer non atteint");
            throw new TransactionException("Montant minimal de transfer non atteint");
        } else if (transferDto.getMontant().intValue() > MONTANT_MAXIMAL) {
            System.out.println("Montant maximal de transfer dépassé");
            throw new TransactionException("Montant maximal de transfer dépassé");
        }

        if (transferDto.getMotif() == null || transferDto.getMotif().isBlank()) {
            System.out.println("Motif vide");
            throw new TransactionException("Motif vide");
        }

        if (compteEmetteur.getSolde().intValue() - transferDto.getMontant().intValue() < 0) {
            LOGGER.error("Solde insuffisant pour l'utilisateur");
            throw new SoldeDisponibleInsuffisantException();
        }

        compteEmetteur.setSolde(
                compteEmetteur.getSolde().subtract(transferDto.getMontant())
        );
        compteRepository.save(compteEmetteur);

        compteBeneficiaire.setSolde(
                new BigDecimal(compteBeneficiaire.getSolde().intValue() + transferDto.getMontant().intValue())
        );
        compteRepository.save(compteBeneficiaire);

        TransactionTransfer transfer = new TransactionTransfer();
        transfer.setDateExecution(new Date());
        transfer.setCompteBeneficiaire(compteBeneficiaire);
        transfer.setCompteEmetteur(compteEmetteur);
        transfer.setMontant(transferDto.getMontant());
        transfer.setMotif(transferDto.getMotif());
        transferRepository.save(transfer);
    }

    @Override
    public void doDeposit(DepositDto depositDto) throws CompteNonExistantException, TransactionException {
        Compte compteBeneficiaire = compteRepository.findByRib(depositDto.getRib());

        if (compteBeneficiaire == null) {
            System.out.println("Compte Non existant");
            throw new CompteNonExistantException("Compte Non existant");
        }

        if (depositDto.getMontant() == null || depositDto.getMontant().intValue() == 0) {
            System.out.println("Montant vide");
            throw new TransactionException("Montant vide");
        } else if (depositDto.getMontant().intValue() < 10) {
            System.out.println("Montant minimal de deposit non atteint");
            throw new TransactionException("Montant minimal de deposit non atteint");
        } else if (depositDto.getMontant().intValue() > MONTANT_MAXIMAL) {
            System.out.println("Montant maximal de transfer dépassé");
            throw new TransactionException("Montant maximal de transfer dépassé");
        }

        if (depositDto.getMotif() == null || depositDto.getMotif().isBlank()) {
            System.out.println("Motif vide");
            throw new TransactionException("Motif vide");
        }

        compteBeneficiaire.setSolde(
                compteBeneficiaire.getSolde().add(depositDto.getMontant())
        );
        compteRepository.save(compteBeneficiaire);

        TransactionDeposit deposit = new TransactionDeposit();
        deposit.setDateExecution(new Date());
        deposit.setNomEmetteur(depositDto.getNomEmetteur());
        deposit.setMontant(depositDto.getMontant());
        deposit.setRib(depositDto.getRib());
        deposit.setCompteBeneficiaire(compteBeneficiaire);
        deposit.setMotif(depositDto.getMotif());
        depositRepository.save(deposit);
    }

    @Override
    public List<TransactionTransfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public List<TransactionDeposit> getAllDeposits() {
        return depositRepository.findAll();
    }

}
