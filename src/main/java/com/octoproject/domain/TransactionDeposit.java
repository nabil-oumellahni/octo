package com.octoproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionDeposit extends Transaction {
    @Column
    private String nomEmetteur;

    @Column
    private String rib;
}
