package com.octoproject.service;

import com.octoproject.domain.Compte;
import com.octoproject.dto.CompteDto;

import java.util.List;

public interface ICompteService {

    CompteDto save(CompteDto dto);

    CompteDto getByNrCompte(String nrCompte);

    CompteDto getByRib(String rib);

    List<CompteDto> getAll();

}
