package com.octoproject.service;

import com.octoproject.domain.Compte;

import java.util.List;

public interface ICompteService {

    Compte save(Compte compte);

    Compte getByNrCompte(String nrCompte);

    Compte getByRib(String rib);

    List<Compte> getAll();

}
