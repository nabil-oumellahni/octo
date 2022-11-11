package com.octoproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferDto {

    private String nrCompteEmetteur;
    private String nrCompteBeneficiaire;
    private String motif;
    private BigDecimal montant;

}
