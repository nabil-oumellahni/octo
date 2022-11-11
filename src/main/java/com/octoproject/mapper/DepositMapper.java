package com.octoproject.mapper;

import com.octoproject.domain.TransactionDeposit;
import com.octoproject.dto.DepositDto;

public class DepositMapper {

    public static DepositDto map(TransactionDeposit deposit) {
        DepositDto depositDto = new DepositDto();

        depositDto.setRib(deposit.getRib());
        depositDto.setNomEmetteur(deposit.getNomEmetteur());
        depositDto.setMotif(deposit.getMotif());
        depositDto.setMontant(deposit.getMontant());

        return depositDto;

    }
}
