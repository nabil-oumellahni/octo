package com.octoproject.service.impl;

import com.octoproject.domain.Utilisateur;
import com.octoproject.dto.UtilisateurDto;
import com.octoproject.mapper.CompteMapper;
import com.octoproject.mapper.UtilisateurMapper;
import com.octoproject.repository.UtilisateurRepository;
import com.octoproject.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return UtilisateurMapper.fromEntity(utilisateurRepository.save(UtilisateurMapper.toEntity(dto)));
    }

    @Override
    public UtilisateurDto getByUsername(String username) {
        return utilisateurRepository.findByUsername(username)
                .map(UtilisateurMapper::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("msg"
                ));
    }

    @Override
    public List<UtilisateurDto> getAll() {
        return utilisateurRepository.findAll()
                .stream().map(UtilisateurMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
