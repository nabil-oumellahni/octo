package com.octoproject.service;

import com.octoproject.domain.Utilisateur;
import com.octoproject.dto.UtilisateurDto;

import java.util.List;

public interface IUtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto getByUsername(String username);
    List<UtilisateurDto> getAll();

}
