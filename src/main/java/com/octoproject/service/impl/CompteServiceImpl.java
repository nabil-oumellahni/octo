package com.octoproject.service.impl;

import com.octoproject.domain.Compte;
import com.octoproject.repository.CompteRepository;
import com.octoproject.service.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

        @Override
    public Compte getByNrCompte(String nrCompte) {
        return compteRepository.findByNrCompte(nrCompte);
    }

    @Override
    public Compte getByRib(String rib) {
        return compteRepository.findByRib(rib);
    }

    @Override
    public List<Compte> getAll() {
        return compteRepository.findAll();
    }
}
