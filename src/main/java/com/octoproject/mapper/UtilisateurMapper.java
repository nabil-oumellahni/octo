package com.octoproject.mapper;

import com.octoproject.domain.Compte;
import com.octoproject.domain.Utilisateur;
import com.octoproject.dto.CompteDto;
import com.octoproject.dto.UtilisateurDto;

public class UtilisateurMapper {

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        UtilisateurDto dto = new UtilisateurDto();

        dto.setId(utilisateur.getId());
        dto.setUsername(utilisateur.getUsername());
        dto.setFirstname(utilisateur.getFirstname());
        dto.setLastname(utilisateur.getLastname());
        dto.setGender(utilisateur.getGender());
        dto.setBirthdate(utilisateur.getBirthdate());

        return dto;

    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(dto.getId());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setFirstname(dto.getFirstname());
        utilisateur.setLastname(dto.getLastname());
        utilisateur.setGender(dto.getGender());
        utilisateur.setBirthdate(dto.getBirthdate());

        return utilisateur;

    }
}
