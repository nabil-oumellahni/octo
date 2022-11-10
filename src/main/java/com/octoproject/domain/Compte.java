package com.octoproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMPTE")
public class Compte {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 16, unique = true)
  private String nrCompte;

  private String rib;

  @Column(precision = 16, scale = 2)
  private BigDecimal solde;

//  @ManyToOne()
//  @JoinColumn(name = "idUtilisateur")
//  private Utilisateur utilisateur;
}
