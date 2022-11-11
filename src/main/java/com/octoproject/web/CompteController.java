package com.octoproject.web;

import com.octoproject.dto.CompteDto;
import com.octoproject.mapper.CompteMapper;
import com.octoproject.service.ICompteService;
import com.octoproject.web.api.CompteApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompteController implements CompteApi {

    Logger LOGGER = LoggerFactory.getLogger(CompteController.class);
    @Autowired
    private ICompteService compteService;


    @Override
    public CompteDto save(CompteDto dto) {
        LOGGER.info("Enregistrer le compte");
        compteService.save(CompteMapper.toEntity(dto));
        return dto;
    }

    @Override
    public CompteDto getByNrCompte(String nrCompte) {
        LOGGER.info("Afficher le compte par leur Numero");
        return CompteMapper.fromEntity(compteService.getByNrCompte(nrCompte));
    }

    @Override
    public CompteDto getByRib(String rib) {
        LOGGER.info("Afficher le compte par leur Rib");
        return CompteMapper.fromEntity(compteService.getByRib(rib));
    }

    @Override
    public List<CompteDto> getAll() {
        LOGGER.info("Lister des comptes");
        return compteService.getAll()
                .stream().map(CompteMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
