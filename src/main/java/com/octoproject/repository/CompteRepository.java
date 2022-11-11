package com.octoproject.repository;

import com.octoproject.domain.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
  Compte findByNrCompte(String nrCompte);
  Compte findByRib(String rib);
}
