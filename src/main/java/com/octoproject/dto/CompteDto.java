package com.octoproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CompteDto {

    private Long id;

    private String nrCompte;

    private String rib;

    private BigDecimal solde;
}
