package com.octoproject.repository;

import com.octoproject.domain.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {
  Optional<Compte> findByNrCompte(String nrCompte);
  Optional<Compte> findByRib(String rib);
}
