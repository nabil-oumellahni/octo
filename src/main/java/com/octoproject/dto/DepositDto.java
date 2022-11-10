package com.octoproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositDto {
    private String nomEmetteur;
    private String rib;
    private String motif;
    private BigDecimal montant;
}
