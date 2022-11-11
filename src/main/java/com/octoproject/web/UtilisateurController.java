package com.octoproject.web;

import com.octoproject.dto.UtilisateurDto;
import com.octoproject.mapper.UtilisateurMapper;
import com.octoproject.service.IUtilisateurService;
import com.octoproject.web.api.UtilisateurApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UtilisateurController implements UtilisateurApi {

    Logger LOGGER = LoggerFactory.getLogger(UtilisateurController.class);
    @Autowired
    private IUtilisateurService utilisateurService;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        LOGGER.info("Enregistrer l'utilisateur");
        utilisateurService.save(UtilisateurMapper.toEntity(dto));
        return dto;
    }

    @Override
    public UtilisateurDto getByUsername(String username) {
        LOGGER.info("Afficher l'utilisateur par leur username");
        return UtilisateurMapper.fromEntity(utilisateurService.getByUsername(username));
    }

    @Override
    public List<UtilisateurDto> getAll() {
        LOGGER.info("Lister les utilisateurs");
        return utilisateurService.getAll()
                .stream().map(UtilisateurMapper::fromEntity)
                .collect(Collectors.toList());
    }
}
