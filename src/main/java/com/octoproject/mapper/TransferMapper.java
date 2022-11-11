package com.octoproject.mapper;

import com.octoproject.domain.TransactionTransfer;
import com.octoproject.dto.TransferDto;

public class TransferMapper {

    public static TransferDto map(TransactionTransfer transfer) {
        TransferDto transferDto = new TransferDto();

        transferDto.setNrCompteEmetteur(transfer.getCompteEmetteur().getNrCompte());
        transferDto.setNrCompteBeneficiaire(transferDto.getNrCompteBeneficiaire());
        transferDto.setMotif(transfer.getMotif());
        transferDto.setMontant(transfer.getMontant());

        return transferDto;

    }
}
