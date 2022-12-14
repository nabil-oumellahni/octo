package com.octoproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(precision = 16, scale = 2, nullable = false)
    private BigDecimal montant;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExecution;

    @ManyToOne
    private Compte compteBeneficiaire;

    @Column(length = 200)
    private String motif;
}
