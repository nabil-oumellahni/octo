package com.octoproject.service.impl;

import com.octoproject.domain.Compte;
import com.octoproject.dto.CompteDto;
import com.octoproject.mapper.CompteMapper;
import com.octoproject.repository.CompteRepository;
import com.octoproject.service.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public CompteDto save(CompteDto dto) {
        return CompteMapper.fromEntity(compteRepository.save(CompteMapper.toEntity(dto)));
    }

    @Override
    public CompteDto getByNrCompte(String nrCompte) {
        return compteRepository.findByNrCompte(nrCompte)
                .map(CompteMapper::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("msg"
                ));
    }

    @Override
    public CompteDto getByRib(String rib) {
        return compteRepository.findByRib(rib)
                .map(CompteMapper::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("msg"
                ));
    }

    @Override
    public List<CompteDto> getAll() {
        return compteRepository.findAll()
                .stream().map(CompteMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
